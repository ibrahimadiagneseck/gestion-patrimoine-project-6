package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeUniteDouaniere;


@Repository
public interface TypeUniteDouaniereRepository extends JpaRepository<TypeUniteDouaniere, String> {

}
