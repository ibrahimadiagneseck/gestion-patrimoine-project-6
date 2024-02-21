package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;


import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.BonEntree;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.BordereauLivraison;

import java.sql.Date;
import java.util.List;

public interface BonEntreeService {

    BonEntree saveBonEntree(BonEntree b);
    BonEntree updateBonEntree(BonEntree b);
    void deleteBonEntree(BonEntree b);
    void deleteBonEntreeById(String id);
    BonEntree getBonEntreeById(String id);
    List<BonEntree> getAllBonEntrees();

    BonEntree ajouterBonEntree(String numeroBE, String libelleBonEntree, Date dateBonEntree, String observationBonEntree, BordereauLivraison identifiantBL);


}
