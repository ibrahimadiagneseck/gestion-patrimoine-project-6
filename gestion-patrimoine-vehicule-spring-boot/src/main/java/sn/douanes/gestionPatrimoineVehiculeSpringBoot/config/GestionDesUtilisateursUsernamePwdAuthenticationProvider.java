package sn.douanes.gestionPatrimoineVehiculeSpringBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Authority;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Utilisateur;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.AgentRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.UtilisateurRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class GestionDesUtilisateursUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); // username -> matriculeAgent
        String pwd = authentication.getCredentials().toString();

        Utilisateur utilisateur = utilisateurRepository.findByUserName(username);

        if (null != utilisateur) {
            if (passwordEncoder.matches(pwd, utilisateur.getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(utilisateur.getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
