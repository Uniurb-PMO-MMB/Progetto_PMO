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

public class Car extends Vehicle  implements SpecificVehicle{

    private Optional<Tyre> front1Tyre;
    private Optional<Tyre> back1Tyre;
    private Optional<Tyre> front2Tyre;
    private Optional<Tyre> back2Tyre;

    public Car(String plateNumber, String type, String brand, String model, String color, int year, Optional<Issue> issue, String customer) {
        
        super(plateNumber, type, brand, model, color, year, issue, customer);

        this.front1Tyre = Optional.empty();
        this.back1Tyre = Optional.empty();
        this.front2Tyre = Optional.empty();
        this.back2Tyre = Optional.empty();

    }

    // Metodo per assegnare le gomme al veicolo mettendo i valori relativi al
    // consumo di ogni gomma in modo casuale
    
    public void setTyres(Set<Tyre> tyres) {

        if( tyres.size() == 0){ // se non ci sono gomme nel sistema, ne crea 4
            
            String[] tBrand = {
                "Michelin",
                "Tigar",
                "GoodYear",
                "Continental"};
            
            TyreType[] tyreTypes = TyreType.values();
            TyreType randomTyreType = tyreTypes[new Random().nextInt(tyreTypes.length)];
            String randomTyreBrand = tBrand[new Random().nextInt(tBrand.length)];
            int diameter = new Random().nextInt(14) + 8;
        
            for (int i = 0; i < 4; i++) {

                Tyre tyre = new Tyre(Controller.autoSetId(ClassHelper.tyrePath) + i, plateNumber, randomTyreType, randomTyreBrand, generate(), diameter);
                
                if (i == 0)
                    this.front1Tyre = Optional.of(tyre);
                else if (i == 1)
                    this.back1Tyre = Optional.of(tyre);
                else if (i == 2)
                    this.front2Tyre = Optional.of(tyre);
                else if (i == 3)
                    this.back2Tyre = Optional.of(tyre);
                
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
        } else {

            ArrayList<Tyre> tyresList = new ArrayList<Tyre>(tyres);

            for (int i = 0; i < 4; i++) {
                
                if (i == 0){
                    this.front1Tyre = Optional.of(tyresList.get(i));
                }else if (i == 1){
                    this.back1Tyre = Optional.of(tyresList.get(i));
                }else if (i == 2){
                    this.front2Tyre = Optional.of(tyresList.get(i));
                }else if (i == 3){
                    this.back2Tyre = Optional.of(tyresList.get(i));
                }
            }
        }
        
    }

    // metodo che serve per una funzionalità del gommista
    public Set<Tyre> getTyre() {
        Set<Tyre> tyres = new HashSet<>();
        
        front1Tyre.ifPresent(tyre -> tyres.add(tyre));
        back1Tyre.ifPresent(tyre -> tyres.add(tyre));
        front2Tyre.ifPresent(tyre -> tyres.add(tyre));
        back2Tyre.ifPresent(tyre -> tyres.add(tyre));

        return tyres;
    }


}
