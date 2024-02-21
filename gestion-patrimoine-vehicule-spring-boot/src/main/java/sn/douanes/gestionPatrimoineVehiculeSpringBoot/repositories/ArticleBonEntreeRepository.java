package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.ArticleBonEntree;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonEntreeId;


@Repository
public interface ArticleBonEntreeRepository extends JpaRepository<ArticleBonEntree, ArticleBonEntreeId> {

}
