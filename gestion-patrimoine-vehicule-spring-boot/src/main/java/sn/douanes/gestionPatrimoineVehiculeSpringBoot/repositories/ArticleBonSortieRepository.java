package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.ArticleBonSortie;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonSortieId;


@Repository
public interface ArticleBonSortieRepository extends JpaRepository<ArticleBonSortie, ArticleBonSortieId> {

}
