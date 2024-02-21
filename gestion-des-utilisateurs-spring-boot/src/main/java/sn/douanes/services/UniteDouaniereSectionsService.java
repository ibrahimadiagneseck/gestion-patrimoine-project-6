package sn.douanes.services;

import sn.douanes.model.Sections;
import sn.douanes.model.UniteDouaniere;
import sn.douanes.model.UniteDouaniereSections;

import java.util.List;

public interface UniteDouaniereSectionsService {

    UniteDouaniereSections saveUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    UniteDouaniereSections updateUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    void deleteUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    void deleteUniteDouaniereSectionsById(UniteDouaniere codeUniteDouaniere, Sections codeSection);
    UniteDouaniereSections getUniteDouaniereSectionsById(UniteDouaniere codeUniteDouaniere, Sections codeSection);
    List<UniteDouaniereSections> getAllUniteDouaniereSections();

    UniteDouaniereSections ajouterUniteDouaniereSections(UniteDouaniere codeUniteDouaniere, Sections codeSection);
}
