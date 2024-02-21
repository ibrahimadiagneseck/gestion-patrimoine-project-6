package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.SecteurActivite;

@Repository
public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite, String> {

}
