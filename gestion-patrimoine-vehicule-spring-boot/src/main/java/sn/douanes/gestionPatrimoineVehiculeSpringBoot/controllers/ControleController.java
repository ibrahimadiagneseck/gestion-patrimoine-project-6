package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Controle;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.ControleService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class ControleController {

    @Autowired
    ControleService controleService;


    @GetMapping("/Controles")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<Controle>> getAllControles() {
        List<Controle> controle = controleService.getAllControles();
        return new ResponseEntity<>(controle, OK);
    }

    @PostMapping("/AjouterControle")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Controle AjouterControle(@RequestBody Controle c) {
        return controleService.saveControle(c);
    }

    @PutMapping("/ModifierControle")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Controle ModifierControle(@RequestBody Controle c) {
        return controleService.updateControle(c);
    }

    @DeleteMapping("SupprimerControleById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerControleById(@PathVariable("id") String numeroImmatriculation ) {
        controleService.deleteControleById(numeroImmatriculation );
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
