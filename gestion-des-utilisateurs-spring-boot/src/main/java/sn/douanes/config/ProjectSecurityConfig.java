package sn.douanes.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.douanes.filter.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                // config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Arrays.asList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }
        })).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/erreur","/**")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLoggingAtFilter(),BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        (requests)->requests
                        // .requestMatchers("/Authorities").hasAuthority("ADMINISTRATEUR")
                        // .requestMatchers("/Users").hasAuthority("ADMINISTRATEUR")
                        // .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                        // .requestMatchers("/myLoans").authenticated()
                        // .requestMatchers("/myCards").hasRole("USER")
                        // .requestMatchers("/user").authenticated()
                        // .requestMatchers("/notices","/contact","/register").permitAll())
                        // .requestMatchers("/connexion").authenticated()
                        // .requestMatchers("/**").permitAll()

                        .requestMatchers("/Authorities").authenticated()
                        .requestMatchers("/Users").authenticated()
                        .requestMatchers("/connexion").authenticated()
                        .requestMatchers("/inscription").authenticated()
                        .requestMatchers("/AjouterUser").authenticated()
                        .requestMatchers("/RecupererUserByUserName/*").authenticated()

                        .requestMatchers("/Agents").authenticated()
                        .requestMatchers("/AjouterAgent").authenticated()
                        .requestMatchers("/ModifierAgent").authenticated()
                        .requestMatchers("/SupprimerAgentById/*").authenticated()
                        .requestMatchers("/RecupererAgentById/*").authenticated()

                        .requestMatchers("/Sections").authenticated()
                        .requestMatchers("/AjouterSections").authenticated()
                        .requestMatchers("/ModifierSections").authenticated()
                        .requestMatchers("/SupprimerSectionsById/*").authenticated()

                        .requestMatchers("/UniteDouanieres").authenticated()
                        .requestMatchers("/AjouterUniteDouaniere").authenticated()
                        .requestMatchers("/ModifierUniteDouaniere").authenticated()
                        .requestMatchers("/SupprimerUniteDouaniereById/*").authenticated()
                        .requestMatchers("/RecupererUniteDouaniereById/*").authenticated()

                        .requestMatchers("/UniteDouaniereSections").authenticated()
                        .requestMatchers("/AjouterUniteDouaniereSectionss").authenticated()
                        .requestMatchers("/ModifierUniteDouaniereSections").authenticated()
                        .requestMatchers("/SupprimerUniteDouaniereSectionsById/*").authenticated()

                        .requestMatchers("/SecteurActivites").authenticated()
                        .requestMatchers("/AjouterSecteurActivite").authenticated()
                        .requestMatchers("/ModifierSecteurActivite").authenticated()
                        .requestMatchers("/SupprimerSecteurActiviteById/*").authenticated()

                        .requestMatchers("/PrestatairesSecteurs").authenticated()
                        .requestMatchers("/AjouterPrestatairesSecteurs").authenticated()
                        .requestMatchers("/ModifierPrestatairesSecteur").authenticated()
                        .requestMatchers("/SupprimerPrestatairesSecteurById/*").authenticated()

                        .requestMatchers("/Prestataires").authenticated()
                        .requestMatchers("/AjouterPrestataires").authenticated()
                        .requestMatchers("/ModifierPrestataires").authenticated()
                        .requestMatchers("/SupprimerPrestatairesById/*").authenticated()

                        .requestMatchers("/TypeUniteDouanieres").authenticated()
                        .requestMatchers("/AjouterTypeUniteDouaniere").authenticated()
                        .requestMatchers("/ModifierTypeUniteDouaniere").authenticated()
                        .requestMatchers("/SupprimerTypeUniteDouaniereById/*").authenticated()

                        .requestMatchers("/TypeUniteDouanieres").authenticated()
                        .requestMatchers("/AjouterTypeUniteDouaniere").authenticated()
                        .requestMatchers("/ModifierTypeUniteDouaniere").authenticated()
                        .requestMatchers("/SupprimerTypeUniteDouaniereById/*").authenticated()

                        .requestMatchers("/Sections").authenticated()
                        .requestMatchers("/AjouterSections").authenticated()
                        .requestMatchers("/ModifierSections").authenticated()
                        .requestMatchers("/SupprimerSectionsById/*").authenticated()

                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
