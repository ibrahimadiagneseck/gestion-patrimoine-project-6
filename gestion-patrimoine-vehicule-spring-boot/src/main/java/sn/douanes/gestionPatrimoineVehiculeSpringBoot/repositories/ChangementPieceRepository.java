package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.ChangementPiece;


@Repository
public interface ChangementPieceRepository extends JpaRepository<ChangementPiece, String> {
}
