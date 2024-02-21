package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "bon_de_sortie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BonDeSortie {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_e", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_b_s", length = 25)
    private String identifiantBS;

    @Column(name = "numero_b_s", length = 100)
    private String numeroBS;

    @Column(name = "description_b_s")
    private String descriptionBS;

    @Column(name = "date_b_s")
    private Date dateBS;

    @ManyToOne
    @JoinColumn(name = "identifiant_b_p")
    private BonPour identifiantBP;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "identifiant_b_p", referencedColumnName = "identifiant_b_p"),
//            @JoinColumn(name = "code_article_bon_pour", referencedColumnName = "code_article_bon_pour")
//    })
//    private ArticleBonPour identifiantBP;

    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;

}