package sn.douanes.model.keys;


import sn.douanes.model.Sections;
import sn.douanes.model.UniteDouaniere;

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
