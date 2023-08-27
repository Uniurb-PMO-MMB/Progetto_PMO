package main.Model.Veicolo;


import java.util.Optional;

import main.Model.Lavoro.Issue;

public class WorksDone {

    private String plateNumber;
    private String type;
    private String brand;
    private String model;
    private int year;
    private String color;
    private Optional<Issue> issue;
    private String customer;
    private String workerName;
    private boolean paid;

    public WorksDone(String plateNumber, String type, String brand, String model, String color, int year, String workerName, String customer, Optional<Issue> issue, boolean paid) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.workerName = workerName;
        this.issue = issue;
        this.customer = customer;
        this.paid = paid;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public String getBrand() {
        return this.brand;    
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public int getIssueId(){
        return this.issue.get().getIssueId();
    }

    public String getFinalTime(){
        return this.issue.get().getFinalTime();
    }

    public String getDescription(){
        return this.issue.get().getDescription();
    }

    public double getPrice(){
        return this.issue.get().getPrice();
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getType() {
        return this.type;
    }

    public String getWorkerName() {
        return this.workerName;
    }

    public boolean isPaid()
    {
        return paid;
    }

    public void setPaid(){
        if(paid){
            this.paid = false;
        }else {
            this.paid = true;
        }
    }
    
}
