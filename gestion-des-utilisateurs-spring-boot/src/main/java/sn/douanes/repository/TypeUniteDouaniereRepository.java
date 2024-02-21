package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.TypeUniteDouaniere;

@Repository
public interface TypeUniteDouaniereRepository extends JpaRepository<TypeUniteDouaniere, String> {

}
