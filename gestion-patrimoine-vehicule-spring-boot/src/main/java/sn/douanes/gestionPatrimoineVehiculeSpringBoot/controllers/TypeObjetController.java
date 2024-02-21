package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Sections;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeObjet;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeObjetService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeObjetController {

    @Autowired
    TypeObjetService typeObjetService;


    @GetMapping("/TypeObjets")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeObjet>> getAllTypeObjets() {
        List<TypeObjet> typeObjet = typeObjetService.getAllTypeObjets();
        return new ResponseEntity<>(typeObjet, OK);
    }

    @PostMapping("/AjouterTypeObjet")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeObjet AjouterTypeObjet(@RequestBody TypeObjet typeObjet) {
        return typeObjetService.saveTypeObjet(typeObjet);
    }

    @PostMapping("/AjouterRequestParamTypeObjet")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<TypeObjet> ajouterTypeObjet (
            @RequestParam("codeTypeObjet") String codeTypeObjet,
            @RequestParam("libelleTypeObjet") String libelleTypeObjet,
            @RequestParam("codeSection") Sections codeSection
    ) {
        TypeObjet typeObjet = typeObjetService.ajouterTypeObjet(codeTypeObjet, libelleTypeObjet, codeSection);
        return new ResponseEntity<>(typeObjet, OK);
    }

    @PutMapping("/ModifierTypeObjet")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeObjet ModifierTypeObjet(@RequestBody TypeObjet t) {

        return typeObjetService.updateTypeObjet(t);
    }

    @DeleteMapping("SupprimerTypeObjetById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeObjetById(@PathVariable("id") String codeTypeObjet) {
        typeObjetService.deleteTypeObjetById(codeTypeObjet);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
