package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.ArticleBonPour;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonPourId;


@Repository
public interface ArticleBonPourRepository extends JpaRepository<ArticleBonPour, ArticleBonPourId> {

}
