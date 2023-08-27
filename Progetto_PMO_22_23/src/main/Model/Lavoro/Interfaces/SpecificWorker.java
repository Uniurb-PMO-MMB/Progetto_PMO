package main.Model.Lavoro.Interfaces;

import java.util.List;

import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public interface SpecificWorker extends BaseWorker{

    public boolean fix(VehicleBox vehicleBox, List<SpecificVehicle> vehicles, List<BaseWorker> workers, List<WorksDone> worksDone, List<VehicleBox> vehicleBoxes);
}
