package main.Model.Veicolo.Interfaces;

public interface TyreInterface {

    public int getTyreId();

    public TyreType getTyreType();

    public double getTyreDiameter();

    public double getTyreUsage();

    public String getPlateNumber();

    public String getTyreBrand();

    public void changeAllTyres();

    public void setPlateNumber(String plateNumber);

    public void setTyreUsage();

    public void setTyreBrand(String tyreBrand);
    
}
