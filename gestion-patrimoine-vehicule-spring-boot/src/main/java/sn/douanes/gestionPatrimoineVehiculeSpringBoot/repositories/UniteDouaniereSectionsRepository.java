package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.UniteDouaniereSections;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.UniteDouaniereSectionsId;


@Repository
public interface UniteDouaniereSectionsRepository extends JpaRepository<UniteDouaniereSections, UniteDouaniereSectionsId> {

}
