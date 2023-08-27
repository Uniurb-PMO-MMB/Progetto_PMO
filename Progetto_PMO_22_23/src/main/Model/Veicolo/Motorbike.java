package main.Model.Veicolo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import main.Controller.Controller;
import main.Controller.ClassHelper;
import main.Controller.FileManager;
import main.Model.Lavoro.Issue;
import main.Model.Veicolo.Interfaces.SpecificVehicle;
import main.Model.Veicolo.Interfaces.TyreType;

public class Motorbike extends Vehicle implements SpecificVehicle {
    private Optional<Tyre> frontTyre;
    private Optional<Tyre> backTyre;

    public Motorbike(String plateNumber, String type, String model, String brand, String color, int year, Optional<Issue> issue, String customer) {
        
        super(plateNumber, type, model, brand, color, year, issue, customer);

        this.frontTyre = Optional.empty();  // gomma anteriore
        this.backTyre = Optional.empty();   //gomma posteriore
    }

    // Metodo per assegnare le gomme al veicolo mettendo i valori relativi al
    // consumo di ogni gomma in modo casuale
    public void setTyres(Set<Tyre> tyres) {

        if( tyres.size() == 0){

            String[] tBrand = {
                "Michelin",
                "Tigar",
                "GoodYear",
                "Continental"};

            String randomTyreBrand = tBrand[new Random().nextInt(tBrand.length)];  
            TyreType[] tyreTypes = TyreType.values();
            TyreType randomTyreType = tyreTypes[new Random().nextInt(tyreTypes.length)];
            int diameter = new Random().nextInt(14) + 8;
        
            for (int i = 0; i < 2; i++) {

                Tyre tyre = new Tyre(Controller.autoSetId(ClassHelper.tyrePath) + i, plateNumber, randomTyreType, randomTyreBrand, generate(), diameter);
                
                if (i == 0)
                    this.frontTyre = Optional.of(tyre);
                else if (i == 1)
                    this.backTyre = Optional.of(tyre);
                
                tyres.add(tyre);
        
                String[] s = {
                    String.valueOf(tyre.getTyreId()),
                    tyre.getPlateNumber(),
                    String.valueOf(tyre.getTyreType()),
                    tyre.getTyreBrand(),
                    String.valueOf(tyre.getTyreUsage()),
                    String.valueOf(tyre.getTyreDiameter())
                };
        
                try {
                    FileManager.writeInFile(ClassHelper.tyrePath, s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {

            ArrayList<Tyre> tyresList = new ArrayList<Tyre>(tyres);

            for (int i = 0; i < 2; i++) {
                
                if (i == 0)
                    this.frontTyre = Optional.of(tyresList.get(i));
                else if (i == 1)
                    this.backTyre = Optional.of(tyresList.get(i));
    
            }
        }
        
    }

    // metodo che serve per una funzionalità del gommista
    public Set<Tyre> getTyre() {
        Set<Tyre> tyres = new HashSet<>();
        
        frontTyre.ifPresent(tyre -> tyres.add(tyre));
        backTyre.ifPresent(tyre -> tyres.add(tyre));

        return tyres;
    }
}
