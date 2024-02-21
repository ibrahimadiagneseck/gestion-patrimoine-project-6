package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeArme;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeArmeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeArmeController {

    @Autowired
    TypeArmeService typeArmeService;

    @GetMapping("/TypeArmes")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeArme>> getAllTypeArmes() {
        List<TypeArme> typeArme = typeArmeService.getAllTypeArmes();
        return new ResponseEntity<>(typeArme, OK);
    }

    @PostMapping("/AjouterTypeArme")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeArme AjouterTypeArme(@RequestBody TypeArme t) {
        return typeArmeService.saveTypeArme(t);
    }

    @PutMapping("/ModifierTypeArme")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeArme ModifierTypeArme(@RequestBody TypeArme t) {

        return typeArmeService.updateTypeArme(t);
    }

    @DeleteMapping("SupprimerTypeArmeById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeArmeById(@PathVariable("id") String code_type_arme) {
        typeArmeService.deleteTypeArmeById(code_type_arme);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
