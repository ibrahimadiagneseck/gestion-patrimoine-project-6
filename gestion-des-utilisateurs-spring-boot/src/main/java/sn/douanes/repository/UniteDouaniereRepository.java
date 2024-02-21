package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.UniteDouaniere;


@Repository
public interface UniteDouaniereRepository extends JpaRepository<UniteDouaniere, String> {

}
