package sn.douanes.services;


import sn.douanes.model.Agent;
import sn.douanes.model.Sections;
import sn.douanes.model.UniteDouaniere;

import java.util.List;

public interface AgentService {

    Agent saveAgent(Agent a);
    Agent updateAgent(Agent a);
    void deleteAgent(Agent a);
    void deleteAgentById(String matriculeAgent);
    Agent getAgentById(String matriculeAgent);

    Agent getAgentByMatriculeAgent(String matriculeAgent);
    List<Agent> getAllAgents();

    Agent ajouterAgent(String matriculeAgent, String codeAgent, String nomAgent, String prenomAgent, Integer numeroTelephoneAgent, String emailAgent, UniteDouaniere codeUniteDouaniere, Sections codeSection);
}
