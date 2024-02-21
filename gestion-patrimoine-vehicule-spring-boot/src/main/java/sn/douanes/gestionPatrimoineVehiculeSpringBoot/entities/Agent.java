package sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Agent {

    @Id
    @Column(name = "matricule_agent", length = 7)
    private String matriculeAgent;

    @Column(name = "code_agent", unique = true, length = 5)
    private String codeAgent;

    @Column(name = "nom_agent", length = 100)
    private String nomAgent;

    @Column(name = "prenom_agent")
    private String prenomAgent;


    @Column(name = "numero_telephone_agent")
    private Integer numeroTelephoneAgent;

    @Column(name = "email_agent")
    private String emailAgent;

    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;

    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;

}
