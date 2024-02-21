package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeUniteDouaniere;

import java.util.List;

public interface TypeUniteDouaniereService {

    TypeUniteDouaniere saveTypeUniteDouaniere(TypeUniteDouaniere t);
    TypeUniteDouaniere updateTypeUniteDouaniere(TypeUniteDouaniere t);
    void deleteTypeUniteDouaniere(TypeUniteDouaniere t);
    void deleteTypeUniteDouaniereById(String id);
    TypeUniteDouaniere getTypeUniteDouaniereById(String id);
    List<TypeUniteDouaniere> getAllTypeUniteDouanieres();


    TypeUniteDouaniere ajouterTypeUniteDouaniere(String codeTypeUniteDouaniere, String libelleTypeUniteDouaniere);

}
