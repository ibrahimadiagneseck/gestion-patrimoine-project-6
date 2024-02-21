package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Agent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByMatriculeAgent(Agent matriculeAgent);

    Utilisateur findByUserName(String userName);
    
}
