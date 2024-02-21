package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.Sections;


@Repository
public interface SectionsRepository extends JpaRepository<Sections, String> {

}
