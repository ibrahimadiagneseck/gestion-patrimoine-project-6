package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.BonPour;

import java.io.Serializable;

public class ArticleBonPourId implements Serializable {

    private String codeArticleBonPour;


    private BonPour identifiantBP;

    public ArticleBonPourId() {
    }

    public ArticleBonPourId(String codeArticleBonPour, BonPour identifiantBP) {
        this.codeArticleBonPour = codeArticleBonPour;
        this.identifiantBP = identifiantBP;
    }
}
