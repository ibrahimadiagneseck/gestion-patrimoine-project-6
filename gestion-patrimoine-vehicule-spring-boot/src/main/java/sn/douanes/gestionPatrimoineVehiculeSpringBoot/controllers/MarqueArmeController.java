package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.MarqueArme;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.MarqueArmeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class MarqueArmeController {

    @Autowired
    MarqueArmeService marqueArmeService;


    @GetMapping("/MarqueArmes")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<MarqueArme>> getAllMarqueArmes() {
        List<MarqueArme> marqueArme = marqueArmeService.getAllMarqueArmes();
        return new ResponseEntity<>(marqueArme, OK);
    }

    @PostMapping("/AjouterMarqueArme")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public MarqueArme AjouterMarqueArme(@RequestBody MarqueArme m) {
        return marqueArmeService.saveMarqueArme(m);
    }

    @PutMapping("/ModifierMarqueArme")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public MarqueArme ModifierMarqueArme(@RequestBody MarqueArme m) {

        return marqueArmeService.updateMarqueArme(m);
    }

    @DeleteMapping("SupprimerMarqueArmeById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerMarqueArmeById(@PathVariable("id") String code_marque_arme) {
        marqueArmeService.deleteMarqueArmeById(code_marque_arme);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
