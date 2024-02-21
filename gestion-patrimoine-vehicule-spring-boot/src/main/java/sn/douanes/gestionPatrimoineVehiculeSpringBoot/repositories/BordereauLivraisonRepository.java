package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.BordereauLivraison;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Prestataires;

import java.util.List;


@Repository
public interface BordereauLivraisonRepository extends JpaRepository<BordereauLivraison, String> {
    List<BordereauLivraison> findAllByNinea(Prestataires ninea);
}
