package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.MarqueArme;

import java.util.List;

public interface MarqueArmeService {

    MarqueArme saveMarqueArme(MarqueArme m);
    MarqueArme updateMarqueArme(MarqueArme m);
    void deleteMarqueArme(MarqueArme m);
    void deleteMarqueArmeById(String id);
    MarqueArme getMarqueArme(String id);
    List<MarqueArme> getAllMarqueArmes();


}
