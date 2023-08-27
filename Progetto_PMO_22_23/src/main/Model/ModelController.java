package main.Model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Coachbuilder;
import main.Model.Lavoro.Mechanic;
import main.Model.Lavoro.TyreDealer;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Veicolo.VehicleQueue;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ViewController;

public class ModelController {

    // metodo per aggiungere un veicolo ad un eventuale box libero
    public static void addVehicle( VehicleBox box, int pos, SpecificVehicle v) {

        Optional<LocalDateTime> issueDate = v.getIssue().get().getIssueDate();

        box.setVehicle(Optional.of(v));
        box.setBoxTime(issueDate);

        try {

            FileManager.modifyRow(ClassHelper.boxPath, pos, v.getPlateNumber(), 3);
            FileManager.modifyRow(ClassHelper.boxPath, pos, String.valueOf(issueDate.get().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))), 2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // metodo per aggiungere un lavoratore ad un box
    public static int addWorker(List<VehicleBox> boxes, List<BaseWorker> workers, int workerId, String boxId) {

        VehicleBox box = boxes.stream()
                                .filter(b -> b.getBoxNumber() == Integer.parseInt(boxId))
                                .findFirst().get();

        boolean equalsType = workers.stream()
                                    .filter(w -> w.getWorkerId() == workerId)
                                    .findFirst().get()
                                    .getWorkType().equals(box.getBoxType());

        if (!box.getWorkerId().isPresent()) {
            if(equalsType) {

                box.setWorkerId(Optional.of(workerId));

                try {
                    int pos = Controller.findRowById(ClassHelper.boxPath, String.valueOf(box.getBoxNumber()), 0);

                    FileManager.modifyRow(ClassHelper.boxPath, pos, String.valueOf(workerId), 4);
                    
                } catch (IllegalArgumentException e) {
                    ViewController.showErrorMessage(" BOx non trovato");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return 1;
            }
        }

        return 0;
    }

    // metodo per rimuovere un lavoratore da un box
    public static void removeWorkerFromBox(List<VehicleBox> boxes, int workerId) {

        int boxNumber = boxes.stream()
                    .filter(b -> b.getWorkerId().isPresent())
                    .filter(b -> b.getWorkerId().get() == workerId)
                    .findFirst().get().getBoxNumber();

        boxes.stream()
            .filter(b -> b.getWorkerId().isPresent())
            .filter(b -> b.getWorkerId().get() == workerId)
            .findFirst().get()
            .setWorkerId(Optional.empty());
    
        int row = Controller.findRowById(ClassHelper.boxPath, String.valueOf(boxNumber), 0);

        try {
            FileManager.modifyRow(ClassHelper.boxPath, row, "", 4);

        } catch (IllegalArgumentException e) {
            System.out.println("Box non trovato");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // metodo per rimuovere un veicolo dal box
    public static void removeVehicle(List<VehicleBox> boxes, String plateNumber) {

        Supplier<VehicleBox> vehicleInBox = () -> boxes.stream()
                                                .filter(b -> b.getVehicle().isPresent())
                                                .filter(b -> b.getVehicle().get().getPlateNumber().equals(plateNumber))
                                                .findFirst().orElse(null);


        if (!vehicleInBox.get().equals(null)) {

            boxReset(vehicleInBox.get());

            try {

                int row = Controller.findRowById(ClassHelper.boxPath, plateNumber, 3);

                FileManager.modifyRow(ClassHelper.boxPath, row, "", 3);
                FileManager.modifyRow(ClassHelper.boxPath, row, "", 2);
                FileManager.removeFromFile(ClassHelper.issuePath, 2, plateNumber);
            
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Il veicolo non e' presente in nessun box");
        }
    }

    public static void boxReset(VehicleBox box){
        box.setVehicle(Optional.empty());
        box.setBoxTime(Optional.empty());
    }

    // metodo per rimuovere un box dalla lista di box
    public static void deleteBox(List<VehicleBox> boxes, int boxNumber) {

        boxes.remove(boxes.stream()
                            .filter(b -> b.getBoxNumber() == boxNumber)
                            .findFirst()
                            .get());

        try {
            FileManager.removeFromFile(ClassHelper.boxPath, 0, String.valueOf(boxNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // metodo per rimuovere un worker dal box
    public static void removeWorker(List<VehicleBox> boxes, List<BaseWorker> workers, int workerId) {

        if(boxes.stream().filter(b -> b.getWorkerId().isPresent()).anyMatch(b -> b.getWorkerId().get() == workerId))
            removeWorkerFromBox(boxes, workerId);

        workers.stream()
                .filter(w -> w.getWorkerId() == workerId)
                .findFirst()
                .ifPresent(w -> workers.remove(w));

        try {
            
            FileManager.removeFromFile(ClassHelper.workerPath, 0, String.valueOf(workerId));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void changeColor(SpecificVehicle vehicle, String newColor) {
        Coachbuilder.paint(vehicle, newColor);
    }

    public static void fixMechanical(VehicleBox box, Mechanic mechanic, List<BaseWorker> workerList,
                                        List<WorksDone> worksDone, List<SpecificVehicle> vehicles, List<VehicleBox> boxes) {
        mechanic.fix(box, vehicles, workerList,  worksDone, boxes);
    }

    public static void fixCoachbuilder(VehicleBox box, Coachbuilder coachbuilder, List<BaseWorker> workerList, 
                                        List<WorksDone> worksDone, List<SpecificVehicle> vehicles, List<VehicleBox> boxes) {
        coachbuilder.fix(box, vehicles, workerList, worksDone, boxes);
    }

    public static void fixTyreDealer(VehicleBox box, TyreDealer tyreDealer, List<BaseWorker> workerList, 
                                    List<WorksDone> worksDone, List<SpecificVehicle> vehicles, List<VehicleBox> boxes) {
        tyreDealer.fix(box, vehicles, workerList, worksDone, boxes);
    }

    public static void changeAllTyresUsages(TyreDealer tyreDealer, Set<Tyre> tyres, String plateNumber) {
        tyreDealer.checkTyres(tyres, plateNumber);
    }

    // metodo per rimuovere un veicolo da un box e aggiornare la coda
    public static void putBackInQueue(List<VehicleBox> boxes, String plateNumber) {
        VehicleBox box = boxes.stream()
                                .filter(b -> b.getVehicle().isPresent())
                                .filter(b -> b.getVehicle().get().getPlateNumber().equals(plateNumber))
                                .findFirst().orElse(null);
        if(box != null && box.getVehicle().isPresent()){
            VehicleQueue.addQueue(box.getVehicle().get());
            removeVehicle(boxes, plateNumber);
        }                                    
    }

    

    // metodo per calcolare la durata di un determinato lavoro
    public static String stopTime(LocalDateTime date) {

        LocalDateTime d1 = LocalDateTime.now();

        LocalDateTime tempDateTime = LocalDateTime.from(date);

        long years = tempDateTime.until(d1, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(years);

        long months = tempDateTime.until(d1, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(months);

        long days = tempDateTime.until(d1, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(days);

        long hours = tempDateTime.until(d1, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(hours);

        long minutes = tempDateTime.until(d1, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutes);

        if(years == 0 ){
            if(months == 0){
                if(days == 0){
                    if(hours == 0){
                        return ("00:"+ "00:" + "00:" + minutes);
                    }
                    return ("00:"+ "00:" + hours + ":" + minutes);
                }
                return ("00:" + days + ":" + hours + ":" + minutes + ":");
            }
            return (months + ":" + days + ":" + hours + ":" + minutes);
        }

        return ("00");
    }


}
