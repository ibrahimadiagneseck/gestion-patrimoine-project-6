package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;

import java.util.List;
import java.util.Set;

public interface DotationVehiculeService {

    DotationVehicule saveDotationVehicule(DotationVehicule d);
    DotationVehicule updateDotationVehicule(DotationVehicule d);
    void deleteDotationVehicule(DotationVehicule d);
    void deleteDotationVehiculeById(String id);
    DotationVehicule getDotationVehiculeById(String id);
    List<DotationVehicule> getAllDotationVehicules();

    DotationVehicule ajouterDotationVehicule(ArticleBonSortie identifiantBS, Agent matriculeAgent, Set<Vehicule> vehiculeDotation);




}
