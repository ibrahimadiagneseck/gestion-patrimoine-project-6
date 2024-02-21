package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "utilisateur_id", nullable = false, updatable = false)
    private Long utilisateurId;

    @Column(name = "user_name", length = 7)
    private String userName; // userName -> matricule

    private Date lastLoginDate;
    private Date lastLoginDateDisplay;

    private boolean isActive;
    private boolean isNotLocked;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    private Date joinDate;

    // @JsonIgnore
//    @OneToMany(mappedBy="utilisateur")
//    // @ToString.Exclude // Exclure ce champ de la méthode toString pour éviter les boucles infinies
//    private Set<Authority> authorities;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "utilisateur_authority",
//            joinColumns = @JoinColumn(name = "utilisateur_id"),
//            inverseJoinColumns = @JoinColumn(name = "code")
//    )
//    private Set<Authority> authorities = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "utilisateur_authority",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    private Set<Authority> authorities = new HashSet<>();



    @OneToOne
    @JoinColumn(name = "matricule_agent")
    private Agent matriculeAgent;


    public boolean getActive() {
        return this.isActive;
    }

    public boolean getNotLocked() {
        return this.isNotLocked;
    }


}
