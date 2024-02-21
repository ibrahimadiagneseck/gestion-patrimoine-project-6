package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dotation_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DotationVehicule {


    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_e", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_d_v", length = 25)
    private String identifiantDV;


    @Column(name = "date_dotation")
    private Date dateDotation;



    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identifiant_b_s", referencedColumnName = "identifiant_b_s"),
            @JoinColumn(name = "code_article_bon_sortie", referencedColumnName = "code_article_bon_sortie")
    })
    private ArticleBonSortie identifiantBS;



    @ManyToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "dotation_vehicule_vehicule",
            joinColumns = @JoinColumn(name = "identifiant_d_v"),
            inverseJoinColumns = @JoinColumn(name = "numero_serie")
    )
    private Set<Vehicule> vehiculeDotation = new HashSet<>();



}