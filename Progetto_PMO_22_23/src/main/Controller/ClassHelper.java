package main.Controller;

import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Quotation;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class ClassHelper {

    public static final String vehiclePath = "Progetto_PMO_22_23/src/files/vehicles.csv";
    public static final String workerPath = "Progetto_PMO_22_23/src/files/workers.csv";
    public static final String boxPath = "Progetto_PMO_22_23/src/files/boxes.csv";
    public static final String tyrePath = "Progetto_PMO_22_23/src/files/tyres.csv";
    public static final String issuePath = "Progetto_PMO_22_23/src/files/issues.csv";
    public static final String queuePath = "Progetto_PMO_22_23/src/files/queue.csv";
    public static final String worksPath = "Progetto_PMO_22_23/src/files/worksDone.csv";
    public static final String quotationPath = "Progetto_PMO_22_23/src/files/quotations.csv";

    private static LoadFiles loadFiles = new LoadFiles();
    
    private static List<Issue> issues = loadFiles.loadIssues(issuePath);
    private static Set<Tyre> tyres = loadFiles.loadTyres(tyrePath);
    private static List<SpecificVehicle> vehicles = loadFiles.loadVehicles(vehiclePath);
    private static List<BaseWorker> workers = loadFiles.loadWorkers(workerPath);
    private static List<VehicleBox> boxes = loadFiles.loadBoxes(boxPath);
    private static List<WorksDone> worksDone = loadFiles.loadWorksDone(worksPath);
    private static Queue<SpecificVehicle> queue = loadFiles.loadQueue(queuePath);
    private static List<Quotation> quotations = loadFiles.loadQuotations();

    public static List<SpecificVehicle> getVehicles() {
        return vehicles;
    }

    public static List<BaseWorker> getWorkers() {

        return workers;
    }

    public static List<VehicleBox> getBoxes() {

        return boxes;
    }

    public static List<Issue> getIssues() {

        return issues;
    }

    public static Set<Tyre> getTyres() {

        return tyres;
    }

    public static Queue<SpecificVehicle> getQueue() {

        return queue;
    }

    public static List<WorksDone> getWorksDone() {

        return worksDone;
    }

    public static List<Quotation> getQuotations() {

        return quotations;
    }

    public static double getTotPrice() {

        return quotations.stream()
                .filter(q -> q.getAmount().isPresent())
                .mapToDouble(q -> q.getAmount().get())
                .sum();
    }

}
