package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;


import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Vidange;

import java.util.List;

public interface VidangeService {
    
    Vidange saveVidange(Vidange v);
    
    Vidange updateVidange(Vidange v);
    void deleteVidange(Vidange v);
    void deleteVidangeById(String id);
    
    Vidange getVidange(String id);
    List<Vidange> getAllVidanges();

}
