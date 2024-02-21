package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Prestataires;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.PrestatairesSecteur;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.SecteurActivite;

import java.util.List;

public interface PrestatairesSecteurService {

    PrestatairesSecteur savePrestatairesSecteur(PrestatairesSecteur p);
    PrestatairesSecteur updatePrestatairesSecteur(PrestatairesSecteur p);
    void deletePrestatairesSecteur(PrestatairesSecteur p);
    void deletePrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite);
    PrestatairesSecteur getPrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite);
    List<PrestatairesSecteur> getAllPrestatairesSecteur();


    PrestatairesSecteur ajouterPrestatairesSecteur(Prestataires ninea, SecteurActivite codeSecteurActivite);
}
