package main.Model.Lavoro;

import java.time.LocalDateTime;
import java.util.Optional;

public class Quotation {

    private String plateNumber;     // targa del veicolo
    private Optional<Double> amount;          // importo della quotazione
    private Optional<LocalDateTime> date;            // data di emissione della quotazione
    private String description;     // descrizione della quotazione

    public Quotation(String plateNumber, String description, Optional<Double> amount, Optional<LocalDateTime> date ) {
        this.plateNumber = plateNumber;
        this.amount = amount;
        this.date = date;

        this.description = description;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Optional<Double> getAmount() {
        return amount;
    }

    public  Optional<LocalDateTime> getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = Optional.of(amount);
    }

    public void setDate() {
        this.date = Optional.of(LocalDateTime.now());
    }
    
}
