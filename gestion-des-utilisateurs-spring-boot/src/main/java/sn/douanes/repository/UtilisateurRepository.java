package sn.douanes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.douanes.model.Agent;
import sn.douanes.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByMatriculeAgent(Agent matriculeAgent);

    Utilisateur findByUserName(String userName);
    
}
