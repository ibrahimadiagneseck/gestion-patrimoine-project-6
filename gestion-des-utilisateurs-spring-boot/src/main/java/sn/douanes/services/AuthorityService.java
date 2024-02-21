package sn.douanes.services;


import sn.douanes.model.Authority;

import java.util.List;

public interface AuthorityService {

    Authority saveAuthority(Authority c);
    Authority updateAuthority(Authority c);
    void deleteAuthority(Authority c);
    void deleteAuthorityById(String id);
    Authority getAuthorityById(String id);
    List<Authority> getAllAuthorities();


}

