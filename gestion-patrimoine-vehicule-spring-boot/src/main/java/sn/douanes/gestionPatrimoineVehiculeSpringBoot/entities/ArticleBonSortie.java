package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.ArticleBonSortieId;

import java.sql.Date;

@Entity
@IdClass(ArticleBonSortieId.class)
@Table(name = "article_bon_sortie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleBonSortie {

    @Id
    @Column(name = "code_article_bon_sortie", length = 25)
    private String codeArticleBonSortie;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiant_b_s")
    private BonDeSortie identifiantBS;


    @Column(name = "libelle_article_bon_sortie", length = 100)
    private String libelleArticleBonSortie;

    @Column(name = "quantite_accordee")
    private Integer quantiteAccordee;

    @Column(name = "date_article_bon_sortie")
    private Date dateArticleBonSortie;


    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;

}