package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.PrestatairesSecteur;
import sn.douanes.model.keys.PrestatairesSecteurId;

@Repository
public interface PrestatairesSecteurRepository extends JpaRepository<PrestatairesSecteur, PrestatairesSecteurId> {

}
