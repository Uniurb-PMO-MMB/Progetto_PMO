package main.Model.Veicolo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Interfaces.BoxInterface;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class VehicleBox implements BoxInterface{

    FileManager fileManager = new FileManager();

    private WorkerType boxType; // differenzia se è un box del meccanico del gommista o dell'autolavaggio
    private int boxNumber; // numero del box
    private Optional<Integer> workerId = Optional.empty(); // Per il momento non serve, pero intanto lo teniamo se si vuole fare anche i lavoratori
    private Optional<LocalDateTime> boxTime = Optional.empty(); // tempo che un veicolo è nel box
    private Optional<SpecificVehicle> vehicle = Optional.empty();   // veicolo che è nel box

    public VehicleBox(int boxNumber, WorkerType boxType, Optional<LocalDateTime> boxTime, Optional<SpecificVehicle> vehicle, Optional<Integer> workerId) {
        this.boxType = boxType;
        this.boxTime = boxTime;
        this.vehicle = vehicle;
        this.boxNumber = boxNumber;
        this.workerId = workerId;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public void setVehicle(Optional<SpecificVehicle> v) {
        this.vehicle = v;
    }

    public void setWorkerId(Optional<Integer> workerId) {
        this.workerId = workerId;
    }

    public void setBoxTime(Optional<LocalDateTime> boxTime) {
        this.boxTime = boxTime;
    }

    public void removeVehicle() {
        this.vehicle = Optional.empty();
    }

    public WorkerType getBoxType() {
        return boxType;
    }

    public Optional<SpecificVehicle> getVehicle() {
        return this.vehicle;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public Optional<LocalDateTime> getBoxTime() {
        return this.boxTime;
    }

    public Optional<Integer> getWorkerId() {
        return workerId;
    }

    public void emptyBox() {
        this.vehicle = Optional.empty();
        this.boxTime = null;
        this.workerId = Optional.empty();

        try {
            FileManager.modifyRow(ClassHelper.boxPath, this.boxNumber, "", 3);
            FileManager.modifyRow(ClassHelper.boxPath, this.boxNumber, "", 2);
            FileManager.modifyRow(ClassHelper.boxPath, this.boxNumber, "", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
