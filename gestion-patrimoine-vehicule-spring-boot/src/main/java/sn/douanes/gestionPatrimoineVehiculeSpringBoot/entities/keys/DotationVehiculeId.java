package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Vehicule;

import java.io.Serializable;
import java.sql.Date;

public class DotationVehiculeId implements Serializable {

    private Date dateDotation;


    private Vehicule numeroSerie;

    public DotationVehiculeId() {
    }

    public DotationVehiculeId(Date dateDotation, Vehicule numeroSerie) {
        this.dateDotation = dateDotation;
        this.numeroSerie = numeroSerie;
    }
}
