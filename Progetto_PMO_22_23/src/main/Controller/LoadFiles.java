package main.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import main.Model.Lavoro.Coachbuilder;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Mechanic;
import main.Model.Lavoro.Quotation;
import main.Model.Lavoro.TyreDealer;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Car;
import main.Model.Veicolo.Motorbike;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.Model.Veicolo.Interfaces.TyreType;

/**
 * * Questa classe startera ad ogni avvio dell'applicazione 
 * * e caricherà nelle apposite Collections i dati presenti nei file csv
 * * sara' inoltre responsabile di salvare i dati in caso di chiusura dell'applicazione
 */

public class LoadFiles {

    private List<SpecificVehicle> vehicles = new ArrayList<SpecificVehicle>();
    private List<BaseWorker> workers = new ArrayList<BaseWorker>();
    private List<VehicleBox> boxes = new ArrayList<VehicleBox>();
    private List<Issue> issues = new ArrayList<Issue>();
    private Set<Tyre> tyres = new HashSet<Tyre>();
    private Queue<SpecificVehicle> queue = new LinkedList<SpecificVehicle>();
    private List<WorksDone> worksDone = new ArrayList<WorksDone>();

    /*
     * Questo metodo carica i dati dei veicoli dal file csv
     */
    public List<SpecificVehicle> loadVehicles(String path) {

        List<String[]> vehiclesData = null;
        Optional<Issue> issue = null;
        Set<Tyre> tyres = null;

        try {

            vehiclesData = FileManager.readFromFile(path);
            
            for (String[] vehicle : vehiclesData) {
                
                if(!vehicle[6].isEmpty()){
                    issue = this.issues.stream().
                            filter(i -> i.getIssueId() == Integer.parseInt(vehicle[6])).
                            findFirst();

                    tyres = this.tyres.stream()
                                    .filter(t -> t.getPlateNumber().equals(vehicle[0]))
                                    .collect(Collectors.toSet());

                }else
                    issue = Optional.empty();

                if(vehicle[1].equals("Macchina")){
                    Car car = new Car(  vehicle[0], 
                                        vehicle[1], 
                                        vehicle[2], 
                                        vehicle[3],
                                        vehicle[4],
                                        Integer.parseInt(vehicle[5]),
                                        issue,
                                        vehicle[7]);

                    vehicles.add(car);
                    
                    if(!vehicle[6].isEmpty())
                        car.setTyres(tyres);
                    
                }else{
                    Motorbike moto = new Motorbike( vehicle[0], 
                                                vehicle[1], 
                                                vehicle[2], 
                                                vehicle[3],
                                                vehicle[4],
                                                Integer.parseInt(vehicle[5]),
                                                issue,
                                                vehicle[7]);

                    vehicles.add(moto);

                    if(!vehicle[6].isEmpty())
                        moto.setTyres(tyres);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    /*
     * Questo metodo carica i dati dei lavoratori dal file csv
     */
    public List<BaseWorker> loadWorkers( String path) {

        List<String[]> workersData = null;

        try {
            workersData = FileManager.readFromFile(path);

            for(String[] worker : workersData) {
                if(!worker[0].isEmpty()){
                    if(WorkerType.valueOf(worker[1]).equals(WorkerType.COACHBUILDER)){
                        workers.add(new Coachbuilder(Integer.parseInt(worker[0]), 
                                                    WorkerType.valueOf(worker[1]), 
                                                    worker[2], 
                                                    worker[3]));

                    }else if(WorkerType.valueOf(worker[1]).equals(WorkerType.MECHANIC)){
                        workers.add(new Mechanic(Integer.parseInt(worker[0]), 
                                                    WorkerType.valueOf(worker[1]), 
                                                    worker[2], 
                                                    worker[3]));

                    }else if(WorkerType.valueOf(worker[1]).equals(WorkerType.TYREDEALER)){
                        workers.add(new TyreDealer(Integer.parseInt(worker[0]), 
                                                    WorkerType.valueOf(worker[1]), 
                                                    worker[2], 
                                                    worker[3]));
                    }
                }  
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return workers; 
    }

    /*
     * Questo metodo carica i dati dei box dal file csv
     */
    public List<VehicleBox> loadBoxes(String path) {
        
        List<String[]> boxesData = null;  
        WorkerType workType = null;

        try {
            
            boxesData = FileManager.readFromFile(path);

            for(String[] box : boxesData) {

                Optional<Integer> workerId = Optional.empty();
                Optional<SpecificVehicle> vehicle;
                Optional<LocalDateTime> dateTime = null;


                if(!box[1].isEmpty()){
                    workType = WorkerType.valueOf(box[1]);
                }
                if (!box[2].isEmpty()) {
                    dateTime = Optional.of(LocalDateTime.parse(box[2], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                }
                if (!box[4].isEmpty()) {
                    workerId = Optional.of(Integer.parseInt(box[4]));
                }
                
                vehicle = vehicles.stream()
                                    .filter(v -> v.getPlateNumber().equals(box[3]))
                                    .findFirst();

                if(vehicle.isPresent()){
                    boxes.add(new VehicleBox(Integer.parseInt(box[0]), 
                                                workType, 
                                                dateTime, 
                                                vehicle, 
                                                workerId
                                                ));
                }else{
                    boxes.add(new VehicleBox(Integer.parseInt(box[0]), 
                                                workType, 
                                                dateTime, 
                                                Optional.empty(), 
                                                workerId
                                                ));
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
        return boxes;
    }

    /*
     * Questo metodo carica i dati dei pneumatici dal file csv
     */
    public Set<Tyre> loadTyres(String path) {

        List<String[]> tyresData = null;
        TyreType tyreType = null;

        try {
            tyresData = FileManager.readFromFile(path);

            for (String[] stringArray : tyresData) {

                if(stringArray[2].equals("SUMMER")){
                    tyreType = TyreType.SUMMER;
                }else if(stringArray[2].equals("WINTER")){
                    tyreType = TyreType.WINTER;
                }else if(stringArray[2].equals("ALLSEASON")){
                    tyreType = TyreType.ALLSEASON;
                }

                tyres.add(new Tyre(Integer.parseInt(stringArray[0]), 
                                                    stringArray[1], 
                                                    tyreType, 
                                                    stringArray[3],
                                                    Double.parseDouble(stringArray[4]), 
                                                    Double.parseDouble(stringArray[5])));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tyres;
    }

    /*
     * Questo metodo carica i dati dei problemi dal file csv
     */
    public List<Issue> loadIssues(String path) {

        List<String[]> issuesData = null;
        WorkerType workType = null;

        try {
            issuesData = FileManager.readFromFile(path);

            for (String[] issue : issuesData) {

                if(issue[1].equals("MECHANIC")){
                    workType = WorkerType.MECHANIC;
                }else if(issue[1].equals("COACHBUILDER")){
                    workType = WorkerType.COACHBUILDER;
                }else if(issue[1].equals("TYREDEALER"))
                    workType = WorkerType.TYREDEALER;

                issues.add(new Issue(  Integer.parseInt(issue[0]), 
                                        workType, 
                                        issue[2], 
                                        Optional.ofNullable(LocalDateTime.parse(issue[3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))),
                                        Double.parseDouble(issue[5])
                ));
            
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return issues;
    }

    /*
     * Questo metodo carica i dati della coda dal file csv
     */
    public Queue<SpecificVehicle> loadQueue(String path) {

        List<String[]> readfile;
        Optional<Issue> issue;
        SpecificVehicle vehicle = null;

        try {
            readfile = FileManager.readFromFile(path); 

            for(String[] line : readfile){
                
                issue = issues.stream().
                        filter(i -> i.getIssueId() == Integer.parseInt(line[6])).
                        findFirst();

                if(line[1].equals("Macchina"))
                        vehicle = new Car(
                                line[0], 
                                line[1],
                                line[2], 
                                line[3],
                                line[4],
                                Integer.parseInt(line[5]),
                                issue,
                                line[7]);
                else
                    vehicle = new Motorbike(
                                line[0], 
                                line[1],
                                line[2], 
                                line[3],
                                line[4],
                                Integer.parseInt(line[5]),
                                issue,
                                line[7]);
                                
                queue.add(vehicle);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return queue;
    }

    public List<WorksDone> loadWorksDone(String path) {

        
        List<String[]> readfile;
        WorksDone work = null;

        try{

            readfile = FileManager.readFromFile(path);

            for(String[] line : readfile){

                Optional<Issue> issue = issues.stream().
                filter(i -> i.getIssueId() == Integer.parseInt(line[7])).
                findFirst();

                work = new WorksDone(
                                        line[0], 
                                        line[1],
                                        line[2], 
                                        line[3],
                                        line[4],
                                        Integer.parseInt(line[5]),
                                        line[6],
                                        line[10],
                                        issue,
                                        Boolean.parseBoolean(line[12]));
                                
                                        worksDone.add(work);
            }

        }catch(IOException e){
            e.printStackTrace();
        } 
        
        return worksDone;
    }

    public List<Quotation> loadQuotations() {

        List<Quotation> quotations = new ArrayList<Quotation>();
        List<String[]> readfile;
        Quotation quotation = null;

        try{

            readfile = FileManager.readFromFile(ClassHelper.quotationPath);

            for(String[] line : readfile){

                quotation = new Quotation(
                                    line[0],
                                    line[1],
                                    Optional.of(Double.parseDouble(line[2])),
                                    Optional.of(LocalDateTime.parse(line[3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                                    
                            );
                                
                quotations.add(quotation);
            }

        }catch(IOException e){
            e.printStackTrace();
        } 
        
        return quotations;
    }


}
