package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;


import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;

import java.util.List;

public interface BonDeSortieService {

    BonDeSortie saveBonDeSortie(BonDeSortie b);
    BonDeSortie updateBonDeSortie(BonDeSortie b);
    void deleteBonDeSortie(BonDeSortie b);
    void deleteBonDeSortieById(String id);
    BonDeSortie getBonDeSortieById(String id);
    List<BonDeSortie> getAllBonDeSorties();

    BonDeSortie ajouterBonDeSortie(String numeroBS, String descriptionBS, BonPour identifiantBP, Agent matriculeAgent);


}
