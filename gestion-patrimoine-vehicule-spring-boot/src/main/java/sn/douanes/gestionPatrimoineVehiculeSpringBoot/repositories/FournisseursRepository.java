package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Fournisseurs;


@Repository
public interface FournisseursRepository extends JpaRepository<Fournisseurs, String> {

}
