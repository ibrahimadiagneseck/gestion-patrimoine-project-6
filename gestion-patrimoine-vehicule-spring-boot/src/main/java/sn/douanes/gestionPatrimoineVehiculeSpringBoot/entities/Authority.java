package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
//    @GenericGenerator(name = "native", strategy = "native")
//    @Column(name = "authority_id", nullable = false, updatable = false)
//    private Long authorityId;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "utilisateur_id")
//    private Utilisateur utilisateur;


//    @ManyToMany(mappedBy = "authorities")
//    Set<Utilisateur> utilisateurs = new HashSet<>();

}
