package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {
    Agent findByMatriculeAgent(String matriculeAgent);
    Agent findByEmailAgent(String emailAgent);
}
