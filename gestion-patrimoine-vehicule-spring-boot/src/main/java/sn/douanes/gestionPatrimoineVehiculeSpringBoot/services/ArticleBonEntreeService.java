package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;

import java.util.List;

public interface ArticleBonEntreeService {

    ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a);
    ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE);
    ArticleBonEntree getArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE);
    List<ArticleBonEntree> getAllArticleBonEntrees();

    ArticleBonEntree ajouterArticleBonEntree(BonEntree identifiantBE, String codeArticleBonEntree, String libelleArticleBonEntree, Integer quantiteEntree, TypeObjet codeTypeObjet,LieuStockageVehicule codeLieuVH, Agent matriculeAgent);
}
