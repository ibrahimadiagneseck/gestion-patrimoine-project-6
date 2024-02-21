package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.SecteurActivite;


@Repository
public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite, String> {

}
