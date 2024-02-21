package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Pays;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.PaysService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class PaysController {

    @Autowired
    PaysService paysService;


    @GetMapping("/Pays")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<Pays>> getAllPays() {
        List<Pays> pays = paysService.getAllPays();
        return new ResponseEntity<>(pays, OK);
    }


    @PostMapping("/AjouterPays")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Pays AjouterPays(@RequestBody Pays pays) {
        return paysService.savePays(pays);
    }


    @PostMapping("/AjouterRequestParamPays")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<Pays> ajouterPays (
            @RequestParam("codePays") String codePays,
            @RequestParam("libellePays") String libellePays
    ) {
        Pays pays = paysService.ajouterPays(codePays, libellePays);
        return new ResponseEntity<>(pays, OK);
    }


    @PutMapping("/ModifierPays")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Pays ModifierPays(@RequestBody Pays p) {
        return paysService.updatePays(p);
    }

    @DeleteMapping("SupprimerPaysById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerPaysById(@PathVariable("id") String codePays) {
        paysService.deletePaysById(codePays);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
