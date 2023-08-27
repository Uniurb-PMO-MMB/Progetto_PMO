package main.Model.Lavoro;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.ModelController;
import main.Model.Lavoro.Interfaces.IssueInterface;
import main.Model.Lavoro.Interfaces.WorkerType;

public class Issue implements IssueInterface{

    private final int id;
    private WorkerType issueWorkType; // tipo di lavoro
    private String issueDescription; // descrizione del problema
    private Optional<LocalDateTime> issueTime; // tempo necessario per risolverlo
    private boolean issueState; // stato del problema true = risolto, false = non risolto
    private double price; // prezzo della riparazione

    public Issue(int id, WorkerType issueWorkType, String issueDescription, Optional<LocalDateTime> issueTime, double price) {

        this.id = id;
        this.issueWorkType = issueWorkType;
        this.issueDescription = issueDescription;
        this.issueTime = issueTime;
        this.issueState = false;
        this.price = price;
    }

    public int getIssueId() {
        return this.id;
    }

    public String getDescription() {
        return this.issueDescription;
    }

    public Optional<LocalDateTime> getIssueDate() {
        return this.issueTime;
    }

    public double getPrice() {
        return this.price;
    }

    public WorkerType getIssueType() {
        return this.issueWorkType;
    }

    public void setIssueType(WorkerType type) {
        this.issueWorkType = type;
    }

    public void setDescription(String description) {
        this.issueDescription = description;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be positive");
        this.price = price;
    }

    public void setTime() {
        this.issueTime = Optional.of(LocalDateTime.now());
    }

    public boolean getState() {
        return this.issueState;
    }

    // Se si invoca questo metodo vuol dire che il problema è stato risolto di
    // conseguenza issueState diventa true
    public void setState() {
        this.issueState = true;
        int row = Controller.findRowById(ClassHelper.issuePath, String.valueOf(this.id), 0);

        try {
            FileManager.modifyRow(ClassHelper.issuePath, row, String.valueOf(this.issueState), 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFinalTime() {
        return ModelController.stopTime(this.issueTime.get());
    }

}
