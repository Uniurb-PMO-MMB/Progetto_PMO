package main.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import main.Controller.ClassHelper;
import main.Controller.Controller;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.Model.Veicolo.Interfaces.TyreType;

public class testController {

    private List<BaseWorker> workerList;
    private List<SpecificVehicle> vehicleList;
    private List<VehicleBox> boxList;
    private List<Issue> issueList;
    private Set<Tyre> tyreSet;

    @Before
    public void setUp() {
        workerList = ClassHelper.getWorkers();
        vehicleList = ClassHelper.getVehicles();
        boxList = ClassHelper.getBoxes();
        issueList = ClassHelper.getIssues();
        tyreSet = ClassHelper.getTyres();
    }

    @Test
    public void testCreateWorker() {

        int workerId = Controller.createWorker(workerList, WorkerType.MECHANIC, "John", "Doe");

        assertNotNull(workerId);
    }

    @Test
    public void testCreateVehicle() {

        Controller.createVehicle(vehicleList, "ABC123", "Car", "Toyota", "Camry", "Red", 2023, Optional.empty(), "John Doe");

        assertNotNull(Controller.alreadyExists(vehicleList, 0, "ABC123"));
    }

    @Test
    public void testAssignTyres() {

        Controller.createVehicle(vehicleList, "XYZ789", "Car", "Ford", "Focus", "Blue", 2022, Optional.empty(), "Jane Smith");

        Tyre tyre1 = new Tyre(1, "XYZ789", TyreType.WINTER, "Pirelli", 0, 17.0);
        Tyre tyre2 = new Tyre(2, "XYZ789", TyreType.WINTER, "Pirelli",0, 17.0);
        tyreSet.add(tyre1);
        tyreSet.add(tyre2);

        Set<Tyre> assignedTyres = Controller.assignTyres(tyreSet, "XYZ789");

        assertEquals(2, assignedTyres.size());
    }  
    
    @Test
    public void testCreateBox() {

        int boxId = Controller.createBox(boxList, WorkerType.MECHANIC, Optional.empty());

        assertNotNull(boxId);
    }

    @Test
    public void testPutVehicleInBox() {

        WorkerType boxType = WorkerType.MECHANIC;
        int boxNumber = 1;
        Optional<Integer> workerId = Optional.of(101);
        String plateNumber = "ABC123";

        Controller.createBox(boxList, boxType, workerId);

        int issueId = Controller.createIssue(issueList, boxType, "sdsdasdva", boxNumber);

        Controller.createVehicle(vehicleList, plateNumber, "Car", "Honda", "Civic", "Silver", 2023, Optional.empty(), "Alice Johnson");
        Controller.setVehicleIssue(vehicleList.stream().filter(v -> v.getPlateNumber().equals(plateNumber)).findFirst().get(), 
                                    issueList.stream().filter(i -> i.getIssueId() == issueId).findFirst().orElse(null));
        Controller.addQueue(vehicleList.stream().filter(v -> v.getPlateNumber().equals(plateNumber)).findFirst().get());
        
        VehicleBox box = ((VehicleBox)Controller.findObject(boxList, 0, String.valueOf(boxNumber)));
        boxList.add(box);
        Controller.putVehicleInBox(boxList);

        assertTrue(boxList.stream().anyMatch(b -> b.getBoxNumber() == boxNumber && b.getVehicle().isPresent()));
    }

    @Test
    public void testRemoveVehicle() {

        Controller.createVehicle(vehicleList, "DEF456", "Car", "Nissan", "Altima", "Black", 2023, null, "Bob Smith");
        Controller.removeVehicle(vehicleList, "DEF456");
        SpecificVehicle removedVehicle = vehicleList.stream().filter(v -> v.getPlateNumber().equals("DEF456")).findFirst().orElse(null);

        assertNull(removedVehicle);
    }

    @Test
    public void testRemoveWorker() {
        
        int workerId = Controller.createWorker(workerList, WorkerType.MECHANIC, "Alice", "Johnson");

        Controller.removeWorker(boxList, workerList, workerId);
        boolean removedWorker = workerList.stream().filter(w -> w.getWorkerId() == workerId).findFirst().isPresent();

        assertFalse(removedWorker);
    }



    @Test
    public void testSetWorkerToBox() {

        int boxId = Controller.createBox(boxList, WorkerType.TYREDEALER, Optional.empty());
        int workerId = Controller.createWorker(workerList, WorkerType.TYREDEALER, "Michael", "Brown");

        Controller.setWorkerToBox(boxList, workerList, workerId, String.valueOf(boxId));

        assertTrue(boxList.stream().anyMatch(b -> b.getBoxNumber() == boxId && b.getWorkerId().isPresent()));
    }

    @Test
    public void testCreateIssue() {

        int issueId = Controller.createIssue(issueList, WorkerType.MECHANIC, "Engine Noise", 100.0);

        assertNotNull(issueId);
    }

    @Test
    public void testSetVehicleIssue() {

        String plateNumber = "GHI789";

        Controller.createVehicle(vehicleList, plateNumber, "Car", "Chevrolet", "Malibu", "Gray", 2022, Optional.empty(), "David Wilson");
        
        int issueId = Controller.createIssue(issueList, WorkerType.MECHANIC, "Brake Issue", 50.0);
        SpecificVehicle vehicle = ((SpecificVehicle)Controller.findObject(vehicleList, 0, plateNumber));
        Issue issue = ((Issue)Controller.findObject(issueList, 0, String.valueOf(issueId)));

        Controller.setVehicleIssue(vehicle, issue);

        assertTrue(vehicle.getIssue().isPresent());
    }

    @Test
    public void testBackInQueue() {

        VehicleBox box = new VehicleBox(3, WorkerType.COACHBUILDER, Optional.empty(), Optional.empty(), Optional.empty());
        Controller.createVehicle(vehicleList, "JKL012", "Car", "Kia", "Soul", "Green", 2022, null, "Emily Lee");

        SpecificVehicle vehicle = ((SpecificVehicle)Controller.findObject(vehicleList, 0, "JKL012"));

        Controller.putVehicleInBox(Collections.singletonList(box));
        Controller.backInQueue(boxList, vehicle.getPlateNumber());

        assertNull(box.getVehicle().orElse(null));
    }
}
