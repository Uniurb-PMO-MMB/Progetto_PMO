package main.Model.Veicolo.Interfaces;

import java.util.Optional;

import main.Model.Lavoro.Issue;

public interface BaseVehicle {

    public String getPlateNumber();

    public String getBrand();

    public String getModel();

    public int getYear();

    public String getColor();

    public Optional<Issue> getIssue();

    public void setIssue(Optional<Issue> issue);

    public void setColor(String color);

    public void setYear(int year);

    public void setModel(String model);

    public void setBrand(String brand);

    public void setPlateNumber(String plateNumber);

    public void setCustomer(String customer);

    public void setType(String type);

    public String getCustomer();

    public String getType();

}
