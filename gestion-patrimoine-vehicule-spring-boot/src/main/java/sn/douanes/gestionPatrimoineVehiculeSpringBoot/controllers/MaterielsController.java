package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Materiels;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.MaterielsService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class MaterielsController {

    @Autowired
    MaterielsService materielsService;


    @GetMapping("/Materiels")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<Materiels>> getAllMateriels() {
        List<Materiels> materiels = materielsService.getAllMateriels();
        return new ResponseEntity<>(materiels, OK);
    }

    @PostMapping("/AjouterMateriels")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Materiels AjouterMateriels(@RequestBody Materiels m) {
        return materielsService.saveMateriels(m);
    }

    @PutMapping("/ModifierMateriels")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public Materiels ModifierMateriels(@RequestBody Materiels m) {

        return materielsService.updateMateriels(m);
    }

    @DeleteMapping("SupprimerMaterielsById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerMaterielsById(@PathVariable("id") String code_materiel) {
        materielsService.deleteMaterielsById( code_materiel );
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
