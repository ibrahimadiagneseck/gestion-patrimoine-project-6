package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Sections;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.UniteDouaniere;

import java.io.Serializable;

public class UniteDouaniereSectionsId implements Serializable {

    private UniteDouaniere codeUniteDouaniere;

    private Sections codeSection;


    public UniteDouaniereSectionsId() {
    }

    public UniteDouaniereSectionsId(UniteDouaniere codeUniteDouaniere, Sections codeSection) {
        this.codeUniteDouaniere = codeUniteDouaniere;
        this.codeSection = codeSection;
    }

}
