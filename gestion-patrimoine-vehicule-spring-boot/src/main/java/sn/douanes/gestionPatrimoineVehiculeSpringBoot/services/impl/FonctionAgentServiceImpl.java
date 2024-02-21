package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.FonctionAgent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.FonctionAgentRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.FonctionAgentService;


@Service
public class FonctionAgentServiceImpl implements FonctionAgentService {

    @Autowired
    FonctionAgentRepository fonctionAgentRepository;

    @Override
    public FonctionAgent saveFonctionAgent(FonctionAgent f) {
        return fonctionAgentRepository.save(f);
    }

    @Override
    public FonctionAgent updateFonctionAgent(FonctionAgent f) {
        return fonctionAgentRepository.save(f);
    }

    @Override
    public void deleteFonctionAgent(FonctionAgent f) {
        fonctionAgentRepository.delete(f);
    }

    @Override
    public void deleteFonctionAgentById(String id) {
        fonctionAgentRepository.deleteById(id);
    }

    @Override
    public FonctionAgent getFonctionAgentById(String id) {
        return fonctionAgentRepository.findById(id).isPresent() ? fonctionAgentRepository.findById(id).get() : null;
    }

    @Override
    public List<FonctionAgent> getAllFonctionAgents() {
        return fonctionAgentRepository.findAll();
    }


    @Override
    public FonctionAgent ajouterFonctionAgent(
            String codeFonctionAgent,
            String libelleFonctionAgent
    ) {

        FonctionAgent fonctionAgent = new FonctionAgent();

        fonctionAgent.setCodeFonctionAgent(codeFonctionAgent);
        fonctionAgent.setLibelleFonctionAgent(libelleFonctionAgent);


        return fonctionAgentRepository.save(fonctionAgent);
    }


}
