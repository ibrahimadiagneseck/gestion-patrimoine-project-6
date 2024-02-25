package sn.douanes.gestionPatrimoineVehiculeSpringBoot.config;

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
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.filter.*;


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

//                        .requestMatchers("/Authorities").authenticated()
//                        .requestMatchers("/Users").authenticated()
//                        .requestMatchers("/connexion").authenticated()
//                        .requestMatchers("/inscription").authenticated()
//                        .requestMatchers("/AjouterUser").authenticated()
//                        .requestMatchers("/RecupererUserByUserName/*").authenticated()

                        .requestMatchers("/**").authenticated()





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
