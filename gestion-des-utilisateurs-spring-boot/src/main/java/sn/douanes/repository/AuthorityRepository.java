package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.model.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

}