package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonEntreeId;

import java.sql.Timestamp;


@Entity
@IdClass(ArticleBonEntreeId.class)
@Table(name = "article_bon_entree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleBonEntree {

    @Id
    @Column(name = "code_article_bon_entree", length = 25)
    private String codeArticleBonEntree;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiant_b_e")
    private BonEntree identifiantBE;

    @Column(name = "libelle_article_bon_entree")
    private String libelleArticleBonEntree;

    @Column(name = "quantite_entree")
    private Integer quantiteEntree;

    @Column(name = "date_enregistrement")
    private Timestamp dateEnregistrement;

    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;

    @ManyToOne
    @JoinColumn(name = "code_lieu_vh")
    private LieuStockageVehicule codeLieuVH;

    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;



}