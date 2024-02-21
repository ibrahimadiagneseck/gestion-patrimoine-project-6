package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.UtilisateurAuthorityId;

@Entity
@IdClass(UtilisateurAuthorityId.class)
@Table(name = "utilisateur_authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurAuthority {

    @Id
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateurId;

    @Id
    @ManyToOne
    @JoinColumn(name = "code")
    private Authority code;
}
