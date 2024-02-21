package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.PrestatairesSecteur;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.PrestatairesSecteurId;


@Repository
public interface PrestatairesSecteurRepository extends JpaRepository<PrestatairesSecteur, PrestatairesSecteurId> {

}
