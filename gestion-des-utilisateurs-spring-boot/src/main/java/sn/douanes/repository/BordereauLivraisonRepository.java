package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.BordereauLivraison;
import sn.douanes.model.Prestataires;

import java.util.List;


@Repository
public interface BordereauLivraisonRepository extends JpaRepository<BordereauLivraison, String> {
    List<BordereauLivraison> findAllByNinea(Prestataires ninea);
}
