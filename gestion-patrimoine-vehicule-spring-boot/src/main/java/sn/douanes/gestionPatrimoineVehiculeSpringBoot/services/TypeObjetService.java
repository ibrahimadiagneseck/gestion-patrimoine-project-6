package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Sections;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeObjet;

import java.util.List;

public interface TypeObjetService {

    TypeObjet saveTypeObjet(TypeObjet t);
    TypeObjet updateTypeObjet(TypeObjet t);
    void deleteTypeObjet(TypeObjet t);
    void deleteTypeObjetById(String id);
    TypeObjet getTypeObjetById(String id);
    List<TypeObjet> getAllTypeObjets();

    TypeObjet ajouterTypeObjet(String codeTypeObjet, String libelleTypeObjet, Sections codeSection);
}
