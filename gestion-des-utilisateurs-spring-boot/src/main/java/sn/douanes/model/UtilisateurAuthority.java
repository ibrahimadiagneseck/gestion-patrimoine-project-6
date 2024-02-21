package sn.douanes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import sn.douanes.model.keys.UtilisateurAuthorityId;

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
