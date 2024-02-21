package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.DotationVehicule;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Vehicule;

import java.io.Serializable;

public class DotationVehiculeVehiculeId implements Serializable {

    private Vehicule numeroSerie;

    private DotationVehicule identifiantDV;


    public DotationVehiculeVehiculeId() {

    }

    public DotationVehiculeVehiculeId(Vehicule numeroSerie, DotationVehicule identifiantDV) {
        this.numeroSerie = numeroSerie;
        this.identifiantDV = identifiantDV;
    }
}
