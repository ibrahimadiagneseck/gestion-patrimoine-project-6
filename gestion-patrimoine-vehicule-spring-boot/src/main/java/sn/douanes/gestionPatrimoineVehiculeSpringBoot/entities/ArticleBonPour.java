package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonPourId;


@Entity
@IdClass(ArticleBonPourId.class)
@Table(name = "article_bon_pour")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleBonPour {

    @Id
    @Column(name = "code_article_bon_pour", length = 25)
    private String codeArticleBonPour;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiant_b_p")
    private BonPour identifiantBP;


    @Column(name = "libelle_article_bon_pour", length = 100)
    private String libelleArticleBonPour;

    @Column(name = "quantite_demandee")
    private Integer quantiteDemandee;


    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;

    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;

}