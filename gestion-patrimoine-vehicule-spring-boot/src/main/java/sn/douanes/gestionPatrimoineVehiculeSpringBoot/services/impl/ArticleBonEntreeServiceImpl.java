package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonEntreeId;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.ArticleBonEntreeRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.ArticleBonEntreeService;


@Service
public class ArticleBonEntreeServiceImpl implements ArticleBonEntreeService {

    @Autowired
    ArticleBonEntreeRepository articleBonEntreeRepository;

    @Override
    public ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a) {
        return articleBonEntreeRepository.save(a);
    }

    @Override
    public ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a) {
        return articleBonEntreeRepository.save(a);
    }

    @Override
    public void deleteArticleBonEntree(ArticleBonEntree a) {
        articleBonEntreeRepository.delete(a);
    }

    @Override
    public void deleteArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE) {
        articleBonEntreeRepository.deleteById(new ArticleBonEntreeId(codeArticleBonEntree, identifiantBE));
    }

    @Override
    public ArticleBonEntree getArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE) {
        return articleBonEntreeRepository.findById(new ArticleBonEntreeId(codeArticleBonEntree, identifiantBE)).isPresent() ? articleBonEntreeRepository.findById(new ArticleBonEntreeId(codeArticleBonEntree, identifiantBE)).get() : null;
    }



    @Override
    public List<ArticleBonEntree> getAllArticleBonEntrees() {
        return articleBonEntreeRepository.findAll();
    }


    @Override
    public ArticleBonEntree ajouterArticleBonEntree(
            BonEntree identifiantBE,
            String codeArticleBonEntree,
            String libelleArticleBonEntree,
            Integer quantiteEntree,
            TypeObjet codeTypeObjet,
            LieuStockageVehicule codeLieuVH,
            Agent matriculeAgent

    ) {

        ArticleBonEntree articleBonEntree = new ArticleBonEntree();

        articleBonEntree.setDateEnregistrement(new Timestamp(System.currentTimeMillis()));

        articleBonEntree.setIdentifiantBE(identifiantBE);
        articleBonEntree.setCodeArticleBonEntree(codeArticleBonEntree);
        articleBonEntree.setLibelleArticleBonEntree(libelleArticleBonEntree);
        articleBonEntree.setQuantiteEntree(quantiteEntree);
        articleBonEntree.setCodeTypeObjet(codeTypeObjet);
        articleBonEntree.setCodeLieuVH(codeLieuVH);
        articleBonEntree.setMatriculeAgent(matriculeAgent);


        return articleBonEntreeRepository.save(articleBonEntree);
    }




}
