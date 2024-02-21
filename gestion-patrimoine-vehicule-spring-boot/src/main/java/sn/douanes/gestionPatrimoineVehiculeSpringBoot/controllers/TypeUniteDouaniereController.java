package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeUniteDouaniere;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeUniteDouaniereService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeUniteDouaniereController {

    @Autowired
    TypeUniteDouaniereService typeUniteDouaniereService;


    @GetMapping("/TypeUniteDouanieres")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeUniteDouaniere>> getAllTypeUniteDouanieres() {
        List<TypeUniteDouaniere> typeUniteDouaniere = typeUniteDouaniereService.getAllTypeUniteDouanieres();
        return new ResponseEntity<>(typeUniteDouaniere, OK);
    }

    @PostMapping("/AjouterTypeUniteDouaniere")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeUniteDouaniere AjouterTypeUniteDouaniere(@RequestBody TypeUniteDouaniere typeUniteDouaniere) {
        return typeUniteDouaniereService.saveTypeUniteDouaniere(typeUniteDouaniere);
    }

    @PostMapping("/AjouterRequestParamTypeUniteDouaniere")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<TypeUniteDouaniere> ajouterTypeUniteDouaniere (
            @RequestParam("codeTypeUniteDouaniere") String codeTypeUniteDouaniere,
            @RequestParam("libelleTypeUniteDouaniere") String libelleTypeUniteDouaniere
    ) {
        TypeUniteDouaniere typeUniteDouaniere = typeUniteDouaniereService.ajouterTypeUniteDouaniere(codeTypeUniteDouaniere, libelleTypeUniteDouaniere);
        return new ResponseEntity<>(typeUniteDouaniere, OK);
    }

    @PutMapping("/ModifierTypeUniteDouaniere")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeUniteDouaniere ModifierTypeUniteDouaniere(@RequestBody TypeUniteDouaniere t) {

        return typeUniteDouaniereService.updateTypeUniteDouaniere(t);
    }

    @DeleteMapping("SupprimerTypeUniteDouaniereById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeUniteDouaniereById(@PathVariable("id") String codeTypeUniteDouaniere) {
        typeUniteDouaniereService.deleteTypeUniteDouaniereById(codeTypeUniteDouaniere);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
