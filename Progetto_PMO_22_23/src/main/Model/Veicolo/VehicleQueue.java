package main.Model.Veicolo;

import java.io.*;
import java.util.Queue;

import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Interfaces.SpecificVehicle;

public class VehicleQueue{

    private static String fileName = "Progetto_PMO_22_23/src/files/queue.csv";  // path del file
    private static Queue<SpecificVehicle> queue = ClassHelper.getQueue(); // coda di auto

    public static void addQueue(SpecificVehicle vehicle) {
        
        queue.add(vehicle);
        
        try {
            FileManager.writeInFile(fileName, new String[] {vehicle.getPlateNumber(), 
                                                            vehicle.getType(),
                                                            vehicle.getBrand(), 
                                                            vehicle.getModel(), 
                                                            vehicle.getColor(),
                                                            String.valueOf(vehicle.getYear()),
                                                            Integer.toString(vehicle.getIssue().get().getIssueId()), 
                                                            vehicle.getCustomer()
                                                        });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SpecificVehicle getFromQueue(WorkerType wType) throws IOException {
        
        for(SpecificVehicle v : queue){

            if(v.getIssue().get().getIssueType().equals(wType)){

                removeFirstVehicle(v.getPlateNumber());
                
                return v;
            }
        }

        return null;
    }

    public static void removeFirstVehicle(String plate) throws IOException {

        System.out.println("Rimozione veicolo dalla coda " + plate);
        
        queue.remove();
        FileManager.removeFromFile(fileName, 0, plate);
    }

}
