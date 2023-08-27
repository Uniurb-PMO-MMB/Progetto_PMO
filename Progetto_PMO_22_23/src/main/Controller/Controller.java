package main.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import main.Model.ModelController;
import main.Model.Lavoro.Coachbuilder;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Mechanic;
import main.Model.Lavoro.Quotation;
import main.Model.Lavoro.TyreDealer;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Car;
import main.Model.Veicolo.VehicleQueue;
import main.Model.Veicolo.Motorbike;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class Controller extends VehicleQueue{

    private String username;
    private String password;

    public Controller(String username) {
        this.username = username;
        this.password = "admin";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //genera un nuovo Box
    public static int createBox(List<VehicleBox> boxList, WorkerType workType, Optional<Integer> workerId) {

        int id = autoSetId(ClassHelper.boxPath);

        try {
            if (workerId.isPresent()) {

                if(!boxList.stream().anyMatch(b -> b.getWorkerId().equals(workerId))){
                    
                    boxList.add(new VehicleBox(id, workType, null, Optional.empty(), workerId));
                    
                        FileManager.writeInFile(ClassHelper.boxPath,
                                    new String[] { String.valueOf(id), String.valueOf(workType), "", "", workerId.get().toString() });
                
                }else{
                    throw new IllegalArgumentException("Il lavoratore è già impegnato in un altro box");
                }
            }else {
                boxList.add(new VehicleBox(id, workType, null, Optional.empty(), Optional.empty()));

                FileManager.writeInFile(ClassHelper.boxPath,
                                new String[] { String.valueOf(id), String.valueOf(workType), "", "", "" });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return id;
    }

    //Serve a creare un nuovo lavoratore
    public static int createWorker(List<BaseWorker> workerList, WorkerType workType, String name, String surname) {

        BaseWorker worker = null;

        int id = autoSetId(ClassHelper.workerPath);

        try {

            FileManager.writeInFile(ClassHelper.workerPath,
                    new String[] {String.valueOf(id), String.valueOf(workType), name, surname });

            if (workType.equals(WorkerType.MECHANIC)) {
                worker = new Mechanic(id, workType, name, surname);
            } else if(workType.equals(WorkerType.TYREDEALER)){
                worker = new TyreDealer(id, workType, name, surname);
            } else if(workType.equals(WorkerType.COACHBUILDER)){
                worker = new Coachbuilder(id, workType, name, surname);
            }

            workerList.add(worker);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return id;
    }

    //Serve a creare un nuovo veicolo
    public static void createVehicle(List<SpecificVehicle> vehicles, String plateNumber, String type, String brand, String model, String color, int year,
                                    Optional<Issue> issue, String customer) {

        SpecificVehicle vehicle = null;
        Set<Tyre> tyres = new HashSet<>();

        if (!alreadyExists(vehicles, 0, plateNumber)) {

            try {

                FileManager.writeInFile(ClassHelper.vehiclePath,
                        new String[] { plateNumber, type, brand, model, color, String.valueOf(year),"", customer });

                if (type.equals("Macchina")) {
                    vehicle = new Car(plateNumber, type, brand, model, color, year, issue, customer);
                    vehicle.setTyres(tyres);

                    vehicles.add(vehicle);

                } else {
                    vehicle = new Motorbike(plateNumber, type, brand, model, color, year, issue, customer);
                    vehicle.setTyres(tyres);
                    
                    vehicles.add(vehicle);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else {
            throw new IllegalArgumentException("La targa inserita è già presente nel sistema");
        }

    }

    // deve essere chiamato solo se il veicolo ha già le gomme assegnate 
    // lo si richiama dopo che vengono caricate le auto dal file
    public static Set<Tyre> assignTyres(Set<Tyre> tyres, String plateNumber){

        Set<Tyre> newTyres = new HashSet<>();

        tyres.stream()
        .filter(t -> t.getPlateNumber().equals(plateNumber))
        .forEach(t -> newTyres.add(t));

        return newTyres;
    }

    //Permette l'inserimento di un veicolo, preso da una coda, in un box libero.
    public static void putVehicleInBox(List<VehicleBox> boxes) {

        SpecificVehicle vehicle = null;
        int i = 0;

        try {

            for(VehicleBox box : boxes) {
                if(box.getVehicle().isEmpty()) {
                    vehicle = getFromQueue(box.getBoxType());
                    if(vehicle != null){
                        ModelController.addVehicle(box, i, vehicle);
                        break;
                    }
                }
                i++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Permette di rimuovere un veicolo dalla lista
    public static void removeVehicle(List<SpecificVehicle> vehicles, String plateNumber) {

        vehicles.removeIf(v -> v.getPlateNumber().equals(plateNumber));

        try {
            FileManager.removeFromFile(ClassHelper.vehiclePath, 0, plateNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Permette di rimuovere un lavoratore da un box
    public static void removeWorkerFromBox(List<VehicleBox> vehicleBoxes, int boxId) {

        ModelController.removeWorkerFromBox(vehicleBoxes, boxId);
    }


    //Permette di rimuovere un box dalla lista
    public static void removeBoxfromList(List<VehicleBox> boxes, int boxId) {

        ModelController.deleteBox(boxes, boxId);
    }

    //Permette la rimozione di un veicolo da un box
    public static void removeVehicleFromBox(List<VehicleBox> boxes, String plateNumber) {

        ModelController.removeVehicle(boxes, plateNumber);
    }

    //Permette di rimuovere un worker dalla lista
    public static void removeWorker(List<VehicleBox> boxList, List<BaseWorker> workerList, int workerId) {

        ModelController.removeWorker(boxList, workerList, workerId);

    }

    //Permette di rimuovere degli pneumatici dalla lista
    public static void removeTyres(Set<Tyre> tyres, String plateNumber) {

        try {
            FileManager.removeFromFile(ClassHelper.tyrePath, 1, plateNumber);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        tyres.removeIf(t -> t.getPlateNumber().equals(plateNumber));

    }

    /**
     * @return -> return a Worker object
     ** Assegna un lavoratore al box di lavoro       
     */
    public static int setWorkerToBox(List<VehicleBox> boxes, List<BaseWorker> workers, int workerId, String boxId) {

        return ModelController.addWorker(boxes, workers, workerId, boxId);

    }

    /**
     * @return -> return an Issue object
     ** Crea una nuova issue 
     ** non viene impostata la data da subito perchè prima deve essere assegnata a un veicolo
     */
    public static int createIssue(List<Issue> issueList, WorkerType issueType, String issueDescription, double issueCost) {
        
        int id = autoSetId(ClassHelper.issuePath);

        Issue issue = null;

        try {
            FileManager.writeInFile(ClassHelper.issuePath,
                    new String[] {  String.valueOf(id), 
                                    String.valueOf(issueType), 
                                    issueDescription,
                                    "",
                                    "false", 
                                    String.valueOf(issueCost)
                                });

            issue = new Issue(id, issueType, issueDescription, null, issueCost);
            
            issueList.add(issue);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * @param quotations -> lista di preventivi
     * @param work -> lavoro da aggiungere
     * 
     ** Crea una nuova issue 
     ** non viene impostata la data da subito perchè prima deve essere assegnata a un veicolo
     */
    public static void createQuotation(List<Quotation> quotations, WorksDone work) {

        try{
            FileManager.writeInFile(ClassHelper.quotationPath, 
                                    new String[] {work.getPlateNumber(), 
                                                work.getDescription(), 
                                                String.valueOf(work.getPrice()),
                                                Optional.of(LocalDateTime.now()).get().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                                            });

            quotations.add(new Quotation(work.getPlateNumber(), work.getDescription(), Optional.of(work.getPrice()), Optional.of(LocalDateTime.now())));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    

    /**
     * @param issue -> issue da modificare
     * @param issueType -> tipo di issue da sostituire
     * @param issueDescription -> descrizione da sostituire
     * @param issueCost -> costo da sostituire
     *
     ** Modifica una issue
     */
    public static void updateIssue(Issue issue, int issuePos, WorkerType issueType, String issueDescription, double issueCost) {

        issue.setIssueType(issueType);
        issue.setDescription(issueDescription);
        issue.setPrice(issueCost);

        try {
        
            FileManager.modifyRow(ClassHelper.issuePath, issuePos, issue.getIssueType().toString(), 1);
            FileManager.modifyRow(ClassHelper.issuePath, issuePos, issue.getDescription(), 2);
            FileManager.modifyRow(ClassHelper.issuePath, issuePos, String.valueOf(issue.getPrice()), 5);
            
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * @param issue -> issue da modificare
     * @param issueDescription -> descrizione da sostituire
     * @param issueCost -> costo da sostituire
     *
     ** Modifica una issue
     */
    public static void updateIssue(Issue issue, int issuePos, String issueDescription, double issueCost){

        issue.setDescription(issueDescription);
        issue.setPrice(issueCost);

        try {

            FileManager.modifyRow(ClassHelper.issuePath, issuePos, issue.getDescription(), 2);
            FileManager.modifyRow(ClassHelper.issuePath, issuePos, String.valueOf(issue.getPrice()), 5);
            
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     ** Metodo che permette di assegnare una issue
     ** a un veicolo
     * 
     * @return -> return true se l'assegnazione è andata a buon fine
     * altrimenti se il veicolo non ha problemi o se la issue è già stata assegnata
     */
    public static void setVehicleIssue(SpecificVehicle vehicle, Issue issue) {

        if (vehicle.getIssue().isEmpty()) {

            int vRow = -1,
                iRow = -1;

            issue.setTime();
            vehicle.setIssue(Optional.of(issue));
            
            vRow = findRowById(ClassHelper.vehiclePath, vehicle.getPlateNumber(), 0);
            iRow = findRowById(ClassHelper.issuePath, String.valueOf(issue.getIssueId()), 0);

            System.out.println(vRow + " " + iRow);
            try {
                if(vRow >= 0 && iRow >= 0){
                    FileManager.modifyRow(ClassHelper.vehiclePath, vRow, String.valueOf(vehicle.getIssue().get().getIssueId()), 6);
                    FileManager.modifyRow(ClassHelper.issuePath, iRow, issue.getIssueDate().get().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 3);
                }else
                    throw new IllegalArgumentException("Errore nella ricerca del problema o della macchina");

            } catch (IOException e) {
                e.printStackTrace();
            }

            addQueue(vehicle);

            putVehicleInBox(ClassHelper.getBoxes());

        }
    }

    /**
     ** Metodo che rimette in coda una macchina
     * 
     * @param boxes -> lista di box
     * @param plateNumber -> targa del veicolo da rimettere in coda
     * 
     * @method putBackInQueue -> metodo che rimette in coda una macchina
     * 
     */
    public static void backInQueue(List<VehicleBox> boxes, String plateNumber) {

        ModelController.putBackInQueue(boxes, plateNumber);

    }

    /**
     ** Serve a creare un nuovo id senza conflitti
     * @param path: file da controllare
     */
    public static int autoSetId(String path) {

        List<String[]> idList;
        int missingId = 0;

        try {
            idList = FileManager.readFromFile(path);

                for (int i = 1; i <= idList.size(); i++) {
                    boolean found = false;
                    for (String[] row : idList) {
                        int id = Integer.parseInt(row[0]);
                        if (id == i) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        missingId = i;
                        break;
                    }
                }

        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
            e.printStackTrace();
        }

        return missingId;

    }

    /**
     ** Cerca nelle liste se esiste già un elemento con quell'id
     * 
     * @param objects -> lista da controllare
     * 
     * @param id   -> id dell'elemento da controllare
     * 
     * @param pos  -> posizione dell'elemento da controllare
     * 
     * @return -> true se esiste già un elemento con quell'id
     */
    public static boolean alreadyExists(List<?> objects, int pos, String id) {

        List<String> lists = new ArrayList<>();
        
        for (Object obj : objects) {
            if(obj instanceof SpecificVehicle && pos == 6)
                lists.add(String.valueOf(((SpecificVehicle) obj).getIssue().get().getIssueId()));
            else if(obj instanceof SpecificVehicle)
                lists.add(((SpecificVehicle) obj).getPlateNumber());
            else if(obj instanceof BaseWorker)
                lists.add(String.valueOf(((BaseWorker) obj).getWorkerId()));
            else if(obj instanceof Issue)
                lists.add(String.valueOf(((Issue) obj).getIssueId()));
            else if(obj instanceof VehicleBox && pos == 3){
                if(((VehicleBox) obj).getVehicle().isEmpty())
                    lists.add("");
                else
                    lists.add(String.valueOf(((VehicleBox) obj).getVehicle().get().getPlateNumber())); 
            }else if(obj instanceof VehicleBox && pos == 4){
                if(((VehicleBox) obj).getWorkerId().isEmpty())
                    lists.add("");
                else
                    lists.add(String.valueOf(((VehicleBox) obj).getWorkerId().get()));
            }else if(obj instanceof VehicleBox)
                lists.add(String.valueOf(((VehicleBox) obj).getBoxNumber()));
            
        }

        for (String list : lists) {
            if (list.equals(id)) {
                return true;
            }
        }

        return false;
    }

    public static Object findObject(List<?> objects, int pos, String id)
    {
        switch (objects.get(0).getClass().getSimpleName())
        {
            case "Motorbike", "Car":
                for (Object object : objects) {
                    if(((SpecificVehicle) object).getPlateNumber().equals(id))
                        return object;
                }
                break;

            case "BaseWorker":
                for (Object object : objects) {
                    if(((BaseWorker) object).getWorkerId() == Integer.parseInt(id))
                        return object;
                }
                break;

            case "Issue":
                for (Object object : objects) {
                    if(((Issue) object).getIssueId() == Integer.parseInt(id))
                        return object;
                }
                break;

            case "VehicleBox":
                for (Object object : objects) {
                    if(((VehicleBox) object).getBoxNumber() == Integer.parseInt(id))
                        return object;
                }
                break;

            default:
                throw new IllegalArgumentException("Errore nella ricerca dell'oggetto");

        }

        return null;
    }

    /**
     ** Cerca una riga in un file
     * 
     * @param path -> path del file da controllare
     * 
     * @param id   -> id dell'elemento da controllare
     * 
     * @param pos  -> posizione dell'elemento da controllare
     * 
     * @return -> ritorna la riga trovata
     */
    public static int findRowById( String path, String id, int pos){

        List<String[]> lists = new ArrayList<String[]>();

        try {
            lists = FileManager.readFromFile(path);
            
            for (String[] list : lists) {
                if (list[pos].equals(String.valueOf(id))) {
                    
                    return lists.indexOf(list);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;

    }
}
