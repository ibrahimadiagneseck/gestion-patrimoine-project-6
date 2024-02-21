package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeEnergie;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeEnergieService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeEnergieController {

    @Autowired
    TypeEnergieService typeEnergieService;

    @GetMapping("/TypeEnergies")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeEnergie>> getAllTypeEnergies() {
        List<TypeEnergie> typeEnergie = typeEnergieService.getAllTypeEnergies();
        return new ResponseEntity<>(typeEnergie, OK);
    }

    @PostMapping("/AjouterTypeEnergie")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeEnergie AjouterTypeEnergie(@RequestBody TypeEnergie typeEnergie) {
        return typeEnergieService.saveTypeEnergie(typeEnergie);
    }

    @PostMapping("/AjouterRequestParamTypeEnergie")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<TypeEnergie> ajouterTypeEnergie (
            @RequestParam("codeTypeEnergie") String codeTypeEnergie,
            @RequestParam("libelleTypeEnergie") String libelleTypeEnergie
    ) {
        TypeEnergie typeEnergie = typeEnergieService.ajouterTypeEnergie(codeTypeEnergie, libelleTypeEnergie);
        return new ResponseEntity<>(typeEnergie, OK);
    }

    @PutMapping("/ModifierTypeEnergie")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeEnergie ModifierTypeEnergie(@RequestBody TypeEnergie t) {
        return typeEnergieService.updateTypeEnergie(t);
    }

    @DeleteMapping("SupprimerTypeEnergieById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeEnergieById(@PathVariable("id") String codeTypeEnergie) {
        typeEnergieService.deleteTypeEnergieById(codeTypeEnergie);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
