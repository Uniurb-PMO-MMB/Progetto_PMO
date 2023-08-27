package main.Model.Lavoro;

import java.io.IOException;
import java.util.*;

import main.Controller.*;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.SpecificWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.Model.Veicolo.Interfaces.TyreType;

public class TyreDealer extends Worker implements SpecificWorker{

    private Set<Tyre> tyresStock = ClassHelper.getTyres(); // gomme in stock

    public TyreDealer(int id, WorkerType workerType, String name, String surname) {
        super(id, workerType, name, surname);
    }

    // metodo per aggiungere una gomma al magazzino
    public void addTyre(Tyre tyre) {

        String tType = null;

        if(tyre.getTyreType().equals(TyreType.SUMMER)){
            tType = "estive";
        } else if(tyre.getTyreType().equals(TyreType.WINTER)) {
            tType = "invernali";
        } else if(tyre.getTyreType().equals(TyreType.ALLSEASON)) {
            tType = "4stagioni";
        }

        String[] data = { Integer.toString(tyre.getTyreId()), tType, Double.toString(tyre.getTyreUsage()), Double.toString(tyre.getTyreDiameter()) };

        tyresStock.add(tyre);

        try {
            FileManager.writeInFile(ClassHelper.tyrePath, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkTyres(Set<Tyre> tyres, String plateNumber) {

        for (Tyre t : tyres) {
            if (t.getPlateNumber().equals(plateNumber)) {
                if (t.getTyreUsage() < 75) {
                    t.setTyreUsage();
                }
            }
        }    
    }

    @Override
    public boolean fix(VehicleBox vehicleBox, List<SpecificVehicle> vehicles, 
                        List<BaseWorker> workers, List<WorksDone> worksDone, List<VehicleBox> boxes) {

        WorksDone workDone = null;

        vehicleBox.getVehicle().get().getIssue().get().setState();
        vehicleBox.getVehicle().get().getIssue().get().getIssueDate();

        BaseWorker worker = workers.stream()
                            .filter(w -> w.getWorkerId() == vehicleBox.getWorkerId().get())
                            .findFirst()
                            .get();
        String name = worker.getWorkerName() + " " + worker.getWorkerSurname();

        String[] s = {  vehicleBox.getVehicle().get().getPlateNumber(),
                        vehicleBox.getBoxType().toString(),
                        vehicleBox.getVehicle().get().getBrand(),
                        vehicleBox.getVehicle().get().getModel(),
                        vehicleBox.getVehicle().get().getColor(),
                        String.valueOf(vehicleBox.getVehicle().get().getYear()),
                        name,
                        String.valueOf(vehicleBox.getVehicle().get().getIssue().get().getIssueId()),
                        vehicleBox.getVehicle().get().getIssue().get().getDescription(),
                        vehicleBox.getVehicle().get().getIssue().get().getFinalTime(),
                        vehicleBox.getVehicle().get().getCustomer(),
                        String.valueOf(vehicleBox.getVehicle().get().getIssue().get().getPrice()),
                        String.valueOf(false)
        };

        workDone = new WorksDone(vehicleBox.getVehicle().get().getPlateNumber(), 
                                    vehicleBox.getBoxType().toString(), 
                                    vehicleBox.getVehicle().get().getBrand(), 
                                    vehicleBox.getVehicle().get().getModel(),
                                    vehicleBox.getVehicle().get().getColor(),
                                    vehicleBox.getVehicle().get().getYear(), 
                                    name, 
                                    vehicleBox.getVehicle().get().getCustomer(),  
                                    Optional.of(vehicleBox.getVehicle().get().getIssue().get()),
                                    false);
        worksDone.add(workDone);

        try {

            FileManager.writeInFile(ClassHelper.worksPath, s);
            FileManager.removeFromFile(ClassHelper.vehiclePath, 0, vehicleBox.getVehicle().get().getPlateNumber());
            FileManager.removeFromFile(ClassHelper.tyrePath, 1, vehicleBox.getVehicle().get().getPlateNumber());
    
            Controller.removeVehicle(vehicles, vehicleBox.getVehicle().get().getPlateNumber());
            vehicleBox.emptyBox();

            Controller.putVehicleInBox(boxes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return true;
    }

}
