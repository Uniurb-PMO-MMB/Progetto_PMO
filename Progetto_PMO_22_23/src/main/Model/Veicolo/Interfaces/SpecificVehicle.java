package main.Model.Veicolo.Interfaces;

import java.util.Set;

import main.Model.Veicolo.Tyre;

public interface SpecificVehicle extends BaseVehicle {

    public void setTyres(Set<Tyre> tyres);

    public Set<Tyre> getTyre();

}
