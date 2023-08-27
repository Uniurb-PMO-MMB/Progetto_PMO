package main.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.Controller.ClassHelper;
import main.Controller.Controller;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class tester {

    public static void main(String[] args) {
        
        List<BaseWorker> workerList = ClassHelper.getWorkers();
        List<VehicleBox> boxList = ClassHelper.getBoxes();
        List<Issue> issueList = ClassHelper.getIssues();
        List<SpecificVehicle> vehicleList = ClassHelper.getVehicles();
        String plateNumber = "FEWfE";

        WorkerType boxType = WorkerType.MECHANIC;
        int boxNumber = 1;
        Optional<Integer> workerId = Optional.of(110);

        Controller.createBox(boxList, boxType, workerId);

        int issueId = Controller.createIssue(issueList, boxType, "sdsdasdva", 0);

        Controller.createVehicle(vehicleList, plateNumber, "Car", "Honda", "Civic", "Silver", 2023, Optional.empty(), "Alice Johnson");
        Controller.setVehicleIssue(vehicleList.stream().filter(v -> v.getPlateNumber().equals(plateNumber)).findFirst().get(), 
                                    issueList.stream().filter(i -> i.getIssueId() == issueId).findFirst().get());
        Controller.addQueue(vehicleList.stream().filter(v -> v.getPlateNumber().equals(plateNumber)).findFirst().get());
        
        VehicleBox box = ((VehicleBox)Controller.findObject(boxList, 0, String.valueOf(boxNumber)));
        boxList.add(box);
        Controller.putVehicleInBox(boxList);
    }
}