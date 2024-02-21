package sn.douanes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.model.Authority;
import sn.douanes.repository.AuthorityRepository;
import sn.douanes.services.AuthorityService;

import java.util.List;


@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public Authority saveAuthority(Authority s) {
        return authorityRepository.save(s);
    }

    @Override
    public Authority updateAuthority(Authority p) {
        return authorityRepository.save(p);
    }

    @Override
    public void deleteAuthority(Authority p) {
        authorityRepository.delete(p);
    }

    @Override
    public void deleteAuthorityById(String id) {
        authorityRepository.deleteById(id);
    }

    @Override
    public Authority getAuthorityById(String id) {
        return authorityRepository.findById(id).isPresent() ? authorityRepository.findById(id).get() : null;
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }




}
