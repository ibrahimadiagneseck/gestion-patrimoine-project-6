package sn.douanes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.exception.PrestatairesExistException;
import sn.douanes.exception.PrestatairesNotFoundException;
import sn.douanes.model.BordereauLivraison;
import sn.douanes.model.Prestataires;
import sn.douanes.model.SecteurActivite;
import sn.douanes.repository.BordereauLivraisonRepository;
import sn.douanes.repository.PrestatairesRepository;
import sn.douanes.services.PrestatairesService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static sn.douanes.constants.ApplicationConstants.PRESTATAIRES_ALREADY_EXISTS;

@Service
public class PrestatairesServiceImpl implements PrestatairesService {

    @Autowired
    PrestatairesRepository prestatairesRepository;

    @Autowired
    BordereauLivraisonRepository bordereauLivraisonRepository;

    @Override
    public Prestataires savePrestataires(Prestataires p) throws PrestatairesExistException {
        Prestataires prestataires = getPrestatairesById(p.getNinea());

        if(prestataires != null) {
            throw new PrestatairesExistException(PRESTATAIRES_ALREADY_EXISTS);
        } else {
            return prestatairesRepository.save(p);
        }

    }

    @Override
    public Prestataires updatePrestataires(Prestataires p) throws PrestatairesNotFoundException {
        return prestatairesRepository.save(p);
    }

    @Override
    public void deletePrestataires(Prestataires p) {
        prestatairesRepository.delete(p);
    }

    @Override
    public void deletePrestatairesById(String id) {
        // bordereauLivraisonRepository.existsByNinea(ninea)
        Prestataires prestataires = getPrestatairesById(id);
        List<BordereauLivraison> bordereaux = bordereauLivraisonRepository.findAllByNinea(prestataires);
        for (BordereauLivraison bordereau : bordereaux) {
            bordereau.setNinea(null);  // Mettez à jour la référence à null ou une autre valeur appropriée
            bordereauLivraisonRepository.save(bordereau);
        }

        prestatairesRepository.deleteById(id);
    }
    

    @Override
    public Prestataires getPrestatairesById(String id) {
        return prestatairesRepository.findById(id).isPresent() ? prestatairesRepository.findById(id).get() : null;
    }

    @Override
    public List<Prestataires> getAllPrestataires() {
        return prestatairesRepository.findAll();
    }


    @Override
    public Prestataires ajouterPrestataires(
            String ninea,
            String raisonSociale,
            Integer numeroTelephone,
            String adresseEmail,
            String adresse,
            Set<SecteurActivite> secteurActivite
    ) throws PrestatairesExistException {


        Prestataires prestataires = getPrestatairesById(ninea);

        if(prestataires != null) {
            throw new PrestatairesExistException(PRESTATAIRES_ALREADY_EXISTS);
        } else {
            prestataires = new Prestataires();
            prestataires.setNinea(ninea);
            prestataires.setRaisonSociale(raisonSociale);
            prestataires.setNumeroTelephone(numeroTelephone);
            prestataires.setAdresseEmail(adresseEmail);
            prestataires.setAdresse(adresse);
            return prestatairesRepository.save(prestataires);
        }

    }

    @Override
    public List<Prestataires> getAllPrestatairesWithSecteursActivite() {
        return prestatairesRepository.findAllWithSecteursActivite();
    }

    @Override
    public Set<SecteurActivite> getSecteurActiviteByPrestataires(Prestataires prestataire) {
        Optional<Prestataires> optionalPrestataire = Optional.ofNullable(prestataire);
        return optionalPrestataire.map(p -> p.getSecteurActivite()).orElse(new HashSet<>());
    }



}
