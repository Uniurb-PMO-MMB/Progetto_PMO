package main.Model.Veicolo;

import java.util.Optional;
import java.util.Random;

import main.Model.Lavoro.Issue;
import main.Model.Veicolo.Interfaces.BaseVehicle;

public abstract class Vehicle implements BaseVehicle{

    protected String plateNumber; // targa del veicolo
    private String model; // marca del veicolo
    private String brand; // modello del veicolo
    private String color; // colore del veicolo
    private String type; // tipo di veicolo
    private int year; // anno di immatricolazione del veicolo
    private String customer; // proprietario del veicolo
    private Optional<Issue> issue; // issue del veicolo
    

    public Vehicle(String plateNumber, String type, String model, String brand, String color, int year, Optional<Issue> issue, String customer) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.issue = issue;
        this.customer = customer;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public Optional<Issue> getIssue() {
        return issue;
    }

    public void setIssue(Optional<Issue> issue) {
        this.issue = issue;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    // metodo per generare un valore casuale per l'usura delle gomme
    public int generate() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }   

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

}
