package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;

import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Armes;

import java.util.List;

public interface ArmesService {

    Armes saveArmes(Armes a);
    Armes updateArmes(Armes a);
    void deleteArmes(Armes a);
    void deleteArmesById(String id);
    Armes getArmes(String id);
    List<Armes> getAllArmes();


}
