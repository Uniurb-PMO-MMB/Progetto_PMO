package main.Model.Veicolo.Interfaces;

import java.time.LocalDateTime;
import java.util.Optional;

import main.Model.Lavoro.Interfaces.WorkerType;

public interface BoxInterface {
    
    public void setBoxNumber(int boxNumber);

    public void setVehicle(Optional<SpecificVehicle> v);

    public void setWorkerId(Optional<Integer> workerId);

    public void setBoxTime(Optional<LocalDateTime> boxTime);

    public void removeVehicle();

    public WorkerType getBoxType();

    public Optional<SpecificVehicle> getVehicle();

    public int getBoxNumber();

    public Optional<LocalDateTime> getBoxTime();

    public Optional<Integer> getWorkerId();

    public void emptyBox();
}
