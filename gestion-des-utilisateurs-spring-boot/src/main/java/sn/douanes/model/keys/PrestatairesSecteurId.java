package sn.douanes.model.keys;


import sn.douanes.model.Prestataires;
import sn.douanes.model.SecteurActivite;

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
