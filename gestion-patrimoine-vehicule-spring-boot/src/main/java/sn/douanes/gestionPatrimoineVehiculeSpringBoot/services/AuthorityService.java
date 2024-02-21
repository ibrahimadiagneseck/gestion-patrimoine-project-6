package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;


import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Authority;

import java.util.List;

public interface AuthorityService {

    Authority saveAuthority(Authority c);
    Authority updateAuthority(Authority c);
    void deleteAuthority(Authority c);
    void deleteAuthorityById(String id);
    Authority getAuthorityById(String id);
    List<Authority> getAllAuthorities();


}

