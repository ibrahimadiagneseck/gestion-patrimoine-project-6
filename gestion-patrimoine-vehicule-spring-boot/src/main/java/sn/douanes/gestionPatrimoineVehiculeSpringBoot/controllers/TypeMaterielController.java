package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.TypeMateriel;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.TypeMaterielService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class TypeMaterielController {

    @Autowired
    TypeMaterielService typeMaterielService;


    @GetMapping("/TypeMateriels")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<TypeMateriel>> getAllTypeMateriels() {
        List<TypeMateriel> typeMateriel = typeMaterielService.getAllTypeMateriels();
        return new ResponseEntity<>(typeMateriel, OK);
    }

    @PostMapping("/AjouterTypeMateriel")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeMateriel AjouterTypeMateriel(@RequestBody TypeMateriel t) {
        return typeMaterielService.saveTypeMateriel(t);
    }

    @PutMapping("/ModifierTypeMateriel")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public TypeMateriel ModifierTypeMateriel(@RequestBody TypeMateriel t) {
        return typeMaterielService.updateTypeMateriel(t);
    }

    @DeleteMapping("SupprimerTypeMaterielById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerTypeMaterielById(@PathVariable("id") String code_type_materiel) {
        typeMaterielService.deleteTypeMaterielById( code_type_materiel);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
