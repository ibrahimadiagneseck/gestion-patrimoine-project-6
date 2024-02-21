package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Prestataires;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.SecteurActivite;

import java.io.Serializable;

public class PrestatairesSecteurId implements Serializable {

    private Prestataires ninea;

    private SecteurActivite codeSecteurActivite;


    public PrestatairesSecteurId() {
    }

    public PrestatairesSecteurId(Prestataires ninea, SecteurActivite codeSecteurActivite) {
        this.ninea = ninea;
        this.codeSecteurActivite = codeSecteurActivite;
    }

}
