package main.Model.Veicolo;

import java.io.IOException;

import main.Controller.FileManager;
import main.Model.Veicolo.Interfaces.TyreInterface;
import main.Model.Veicolo.Interfaces.TyreType;

public class Tyre implements TyreInterface{

    FileManager fileManager = new FileManager();

    private TyreType tyreType; // anteriore, posteriore
    private String plateNumber; // targa del veicolo
    private String tyreBrand; // marca della ruota
    private double tyreDiameter; // diametro della ruota
    private double tyreUsage; // usura della ruota in percentuale da 0 a 100
    private final int tyreId; // valore per identificare la ruota

    public Tyre(int tyreId, String plateNumber, TyreType tyreType, String tyreBrand, double tyreUsage, double tyreDiameter) {

        this.tyreType = tyreType;
        this.tyreUsage = tyreUsage;
        this.plateNumber = plateNumber;
        this.tyreDiameter = tyreDiameter;
        this.tyreBrand = tyreBrand;
        this.tyreId = tyreId;
    }

    public int getTyreId() {
        return this.tyreId;
    }

    public TyreType getTyreType() {
        return this.tyreType;
    }

    public double getTyreDiameter() {
        return this.tyreDiameter;
    }

    public double getTyreUsage() {
        return this.tyreUsage;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public String getTyreBrand() {
        return this.tyreBrand;
    }

    // metodo per aggiornare l'usura della ruota dopo averla sostituita
    public void changeAllTyres() {

        String tType = null;

        this.tyreUsage = 100.0;

        if(this.tyreType.equals(TyreType.SUMMER)) 
            tType = "estive";
        else if(this.tyreType.equals(TyreType.WINTER)) 
            tType = "invernali";
        else if(this.tyreType.equals(TyreType.ALLSEASON)) 
            tType = "4stagioni";
        
        try {

            FileManager.removeFromFile("Progetto_PMO_22_23/src/files/tyres.csv", 0, Integer.toString(this.tyreId));

            FileManager.writeInFile("Progetto_PMO_22_23/src/files/tyres.csv",
                    new String[] { String.valueOf(this.tyreId), this.plateNumber, tType, String.valueOf(this.tyreUsage), String.valueOf(this.tyreDiameter) });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setTyreType(String type) {
        if(type.equals("estive"))
            this.tyreType = TyreType.SUMMER;
        else if(type.equals("invernali"))
            this.tyreType = TyreType.WINTER;
        else if(type.equals("4stagioni"))
            this.tyreType = TyreType.ALLSEASON;
        
    }

    public void setTyreUsage() {
        this.tyreUsage = 100.0;
    }

    public void setTyreBrand(String tyreBrand) {
        this.tyreBrand = tyreBrand;
    }


}
