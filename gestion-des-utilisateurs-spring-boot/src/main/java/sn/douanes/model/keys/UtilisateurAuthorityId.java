package sn.douanes.model.keys;


import sn.douanes.model.Authority;
import sn.douanes.model.Utilisateur;

import java.io.Serializable;


public class UtilisateurAuthorityId implements Serializable {

    private Utilisateur utilisateurId;

    private Authority code;


    public UtilisateurAuthorityId() {
    }

    public UtilisateurAuthorityId(Utilisateur utilisateurId, Authority code) {
        this.utilisateurId = utilisateurId;
        this.code = code;
    }

}
