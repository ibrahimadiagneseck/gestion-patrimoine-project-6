package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeVehicule;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeVehiculeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeVehiculeController {

    @Autowired
    TypeVehiculeService typeVehiculeService;


    @GetMapping("/TypeVehicules")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeVehicule>> getAllTypeVehicules() {
        List<TypeVehicule> typeVehicule = typeVehiculeService.getAllTypeVehicules();
        return new ResponseEntity<>(typeVehicule, OK);
    }

    @PostMapping("/AjouterTypeVehicule")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeVehicule AjouterTypeVehicule(@RequestBody TypeVehicule typeVehicule) {
        return typeVehiculeService.saveTypeVehicule(typeVehicule);
    }

    @PostMapping("/AjouterRequestParamTypeVehicule")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<TypeVehicule> ajouterTypeVehicule (
            @RequestParam("codeTypeVehicule") String codeTypeVehicule,
            @RequestParam("libelleTypeVehicule") String libelleTypeVehicule
    ) {
        TypeVehicule typeVehicule = typeVehiculeService.ajouterTypeVehicule(codeTypeVehicule, libelleTypeVehicule);
        return new ResponseEntity<>(typeVehicule, OK);
    }

    @PutMapping("/ModifierTypeVehicule")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeVehicule ModifierTypeVehicule(@RequestBody TypeVehicule t) {
        return typeVehiculeService.updateTypeVehicule(t);
    }

    @DeleteMapping("SupprimerTypeVehiculeById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeVehiculeById(@PathVariable("id") String codeTypeVehicule) {
        typeVehiculeService.deleteTypeVehiculeById(codeTypeVehicule);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
