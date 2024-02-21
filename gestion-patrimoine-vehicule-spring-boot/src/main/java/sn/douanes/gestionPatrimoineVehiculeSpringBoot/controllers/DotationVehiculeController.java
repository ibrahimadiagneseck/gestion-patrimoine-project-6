package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.DotationVehiculeService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class DotationVehiculeController {

    @Autowired
    DotationVehiculeService dotationVehiculeService;


    @GetMapping("/DotationVehicules")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<DotationVehicule>> getAllDotationVehicules() {
        List<DotationVehicule> dotationVehicule = dotationVehiculeService.getAllDotationVehicules();
        return new ResponseEntity<>(dotationVehicule, OK);
    }


    @PostMapping("/AjouterDotationVehicule")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public DotationVehicule AjouterDotationVehicule(@RequestBody DotationVehicule dotationVehicule) {
        // return DotationVehiculeService.saveDotationVehicule(dotationVehicule);
        return dotationVehiculeService.ajouterDotationVehicule(dotationVehicule.getIdentifiantBS(), dotationVehicule.getMatriculeAgent(),dotationVehicule.getVehiculeDotation());
    }


//    @PostMapping("/AjouterRequestParamDotationVehicule")
//    public ResponseEntity<DotationVehicule> ajouterDotationVehicule (
//        @RequestParam("numeroBE") String numeroBE,
//        @RequestParam("libelleDotationVehicule") String libelleDotationVehicule,
//        @RequestParam("dateDotationVehicule") String dateDotationVehicule,
//        @RequestParam("observationDotationVehicule") String observationDotationVehicule,
//        @RequestParam("identifiantBL") String identifiantBL
//    ) {
//        BordereauLivraison bordereauLivraison = bordereauLivraisonService.getBordereauLivraisonById(identifiantBL);
//
//        DotationVehicule DotationVehicule = DotationVehiculeService.ajouterDotationVehicule(numeroBE,  libelleDotationVehicule,  Date.valueOf(dateDotationVehicule), observationDotationVehicule, bordereauLivraison);
//        return new ResponseEntity<>(DotationVehicule, OK);
//    }


    @PutMapping("/ModifierDotationVehicule")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public DotationVehicule ModifierDotationVehicule(@RequestBody DotationVehicule d) {
        return dotationVehiculeService.updateDotationVehicule(d);
    }

    @DeleteMapping("SupprimerDotationVehiculeById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerDotationVehiculeById(@PathVariable("id") String identifiantDV) {

        dotationVehiculeService.deleteDotationVehiculeById(identifiantDV);
    }



    @GetMapping("RecupererDotationVehiculeById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public DotationVehicule RecupererDotationVehiculeById(
            @PathVariable("id") String identifiantDV) {

        return dotationVehiculeService.getDotationVehiculeById(identifiantDV);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
