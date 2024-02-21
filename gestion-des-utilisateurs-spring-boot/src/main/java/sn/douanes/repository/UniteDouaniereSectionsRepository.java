package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.UniteDouaniereSections;
import sn.douanes.model.keys.UniteDouaniereSectionsId;


@Repository
public interface UniteDouaniereSectionsRepository extends JpaRepository<UniteDouaniereSections, UniteDouaniereSectionsId> {

}
