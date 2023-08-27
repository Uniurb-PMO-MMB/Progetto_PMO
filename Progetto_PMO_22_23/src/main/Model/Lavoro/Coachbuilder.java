package main.Model.Lavoro;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import main.Controller.ClassHelper;
import main.Controller.Controller;
import main.Controller.FileManager;

import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.SpecificWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class Coachbuilder  extends Worker implements SpecificWorker{

    public Coachbuilder(int id, WorkerType workerType, String name, String surname) {
        super(id, workerType, name, surname);

    }

    public static void paint(SpecificVehicle vehicle, String color) {
        
            vehicle.setColor(color);

            try {
                int row = Controller.findRowById(ClassHelper.vehiclePath, vehicle.getPlateNumber(), 0);
                FileManager.modifyRow(ClassHelper.vehiclePath, row, color, 4);
            } catch (IOException e) {
                e.printStackTrace();
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
