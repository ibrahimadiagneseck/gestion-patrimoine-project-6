package sn.douanes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.model.*;
import sn.douanes.services.AuthorityService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;


    @GetMapping("/Authorities")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<Authority>> getAllAjouterAuthorities() {
        List<Authority> authority = authorityService.getAllAuthorities();
        return new ResponseEntity<>(authority, OK);
    }

    @PostMapping("/AjouterAuthority")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Authority AjouterAjouterAuthority(@RequestBody Authority authority) {
        return authorityService.saveAuthority(authority);
    }


    @PutMapping("/ModifierAuthority")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Authority ModifierAuthority(@RequestBody Authority t) {

        return authorityService.updateAuthority(t);
    }

    @DeleteMapping("SupprimerAuthorityById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerAuthorityById(@PathVariable("id") String authorityId) {
        authorityService.deleteAuthorityById(authorityId);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
