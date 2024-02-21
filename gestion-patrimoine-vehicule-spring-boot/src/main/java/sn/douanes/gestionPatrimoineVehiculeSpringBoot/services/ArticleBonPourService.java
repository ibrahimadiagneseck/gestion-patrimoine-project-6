package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Agent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.ArticleBonPour;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.BonPour;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeObjet;

import java.util.List;

public interface ArticleBonPourService {

    ArticleBonPour saveArticleBonPour(ArticleBonPour a);
    ArticleBonPour updateArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP);
    ArticleBonPour getArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP);
    List<ArticleBonPour> getAllArticleBonPours();

    ArticleBonPour ajouterArticleBonPour(BonPour identifiantBP, String codeArticleBonPour, String libelleArticleBonPour, Integer quantiteDemandee, TypeObjet codeTypeObjet, Agent matriculeAgent);

}
