package main.View;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.JOptionPane;

import main.Controller.ClassHelper;
import main.Controller.Controller;
import main.Model.Lavoro.Issue;
import main.Model.Lavoro.Quotation;
import main.Model.Lavoro.Interfaces.BaseWorker;
import main.Model.Lavoro.Interfaces.WorkerType;
import main.Model.Veicolo.Tyre;
import main.Model.Veicolo.VehicleBox;
import main.Model.Veicolo.WorksDone;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.View.ui.MenuView;

public class ViewController {

    private static final String Carrozziere = "Carrozziere";
    private static final String Meccanico = "Meccanico";
    private static final String Gommista = "Gommista";

    public static void startView(){
        new MenuView();
    }

    public static String getStringWorkerType(Object obj) {
        String boxType = null;

        if(obj instanceof VehicleBox){

            if(((VehicleBox)obj).getBoxType().equals(WorkerType.MECHANIC)){
                boxType = Meccanico;
            }else if(((VehicleBox)obj).getBoxType().equals(WorkerType.TYREDEALER)){
                boxType = Gommista;
            }else if(((VehicleBox)obj).getBoxType().equals(WorkerType.COACHBUILDER)){
                boxType = Carrozziere;
            }else
                throw new IllegalArgumentException("Tipo di box non valido");
        }else if(obj instanceof BaseWorker){

            if(((BaseWorker)obj).getWorkType().equals(WorkerType.MECHANIC)){
                boxType = Meccanico;
            }else if(((BaseWorker)obj).getWorkType().equals(WorkerType.TYREDEALER)){
                boxType = Gommista;
            }else if(((BaseWorker)obj).getWorkType().equals(WorkerType.COACHBUILDER)){
                boxType = Carrozziere;
            }else
                throw new IllegalArgumentException("Tipo di worker non valido");
        }else if(obj instanceof WorkerType){

            if(((WorkerType)obj).equals(WorkerType.MECHANIC)){
                boxType = Meccanico;
            }else if(((WorkerType)obj).equals(WorkerType.TYREDEALER)){
                boxType = Gommista;
            }else if(((WorkerType)obj).equals(WorkerType.COACHBUILDER)){
                boxType = Carrozziere;
            }else
                throw new IllegalArgumentException("Tipo non valido");
        }

        return boxType;
    }

    public static WorkerType getWorkerType(String object)
    {

        WorkerType wType = null;

        if(object.equals(Meccanico))
        {
            //Rende visibile la selezione dei Meccanici//  
            wType = WorkerType.MECHANIC;
        
        }else if(object.equals(Carrozziere))
        {
            //Rende visibile la selezione dei Verniciatori//  

            wType = WorkerType.COACHBUILDER;
            
        }else if(object.equals(Gommista))
        {
          //Rende visibile la selezione dei gommisti//  

            wType = WorkerType.TYREDEALER;        
        }

        return wType;
    }

    public static void showInfoMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarningMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Attenzione", JOptionPane.WARNING_MESSAGE);
    }

    public static void showConfirmMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Conferma", JOptionPane.YES_NO_OPTION);
    }

    public static void putVehicleInBox() {
        Controller.putVehicleInBox(ClassHelper.getBoxes());
    }

    public static void removeWorkerFromBox(List<VehicleBox> boxList, int id) {
        Controller.removeWorkerFromBox(boxList, id);
    }

    public static int createBox(List<VehicleBox> boxList, Optional<Integer> workerId, WorkerType wType) {
        return Controller.createBox(boxList, wType, workerId);
    }

    public static int setWorkerToBox(List<VehicleBox> boxList, List<BaseWorker> workerList, int workerId, String boxId) {
        return Controller.setWorkerToBox(boxList, workerList, workerId, boxId);
    }

    public static void removeBoxfromList(List<VehicleBox> boxList, int boxNumber) {
        Controller.removeBoxfromList(boxList, boxNumber);
    }

    public static int createWorker(List<BaseWorker> workers, WorkerType mansione, String nome, String cognome) {
        return Controller.createWorker(workers, mansione, nome, cognome);
    }

    public static void removeWorker(List<VehicleBox> boxes, List<BaseWorker> workers, int workerId) {
        Controller.removeWorker(boxes ,workers , workerId);
    }

    public static int createIssue(List<Issue> issues, WorkerType wType, String problemi, double prezzo) {
        return Controller.createIssue( issues, wType, problemi, prezzo);
    }

    public static void setVehicleIssue(SpecificVehicle specificVehicle, Issue issue) {
        Controller.setVehicleIssue(specificVehicle, issue);
    }

    public static void updateIssue(Issue issue, int issuePos, String problemi, double prezzo) {
        Controller.updateIssue(issue, issuePos, problemi, prezzo);
    }

    public static void updateIssue(Issue issue, int issuePos, WorkerType wType, String problemi, double prezzo) {
        Controller.updateIssue(issue, issuePos, wType, problemi, prezzo);
    }

    public static void backInQueue(List<VehicleBox> boxes, String plateNumber) {
        Controller.backInQueue(boxes, plateNumber);
    }

    public static void addQueue(SpecificVehicle vehicle) {
        Controller.addQueue(vehicle);
    }

    public static void putVehicleInBox(List<VehicleBox> boxes) {
        Controller.putVehicleInBox(boxes);
    }

    public static void createQuotation(List<Quotation> quotations, WorksDone work) {
        Controller.createQuotation(quotations, work);
    }

    public static void removeTyres(Set<Tyre> tyres, String string) {
        Controller.removeTyres(tyres, string);
    }

    public static void removeVehicleFromBox(List<VehicleBox> boxes, String string) {
        Controller.removeVehicleFromBox(boxes, string);
    }

    public static void removeVehicle(List<SpecificVehicle> vehicles, String string) {
        Controller.removeVehicle(vehicles, string);
    }

    public static void createVehicle(List<SpecificVehicle> vehicles, String plateNumber, String brand, String model,
            String color, String type, int year, Optional<Issue> issue, String proprietario) {
        Controller.createVehicle(vehicles, plateNumber, brand, model, color, type, year, issue, proprietario);
    }

}
