package sn.douanes.services;

import sn.douanes.model.Prestataires;
import sn.douanes.model.PrestatairesSecteur;
import sn.douanes.model.SecteurActivite;

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
