package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class BordereauLivraisonController {

    @Autowired
    BordereauLivraisonService bordereauLivraisonService;




    @GetMapping("/BordereauLivraisons")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<BordereauLivraison>> getAllBordereauLivraisons() {
        List<BordereauLivraison> bordereauLivraisons = bordereauLivraisonService.getAllBordereauLivraisons();
        return new ResponseEntity<>(bordereauLivraisons, OK);
    }

    @PostMapping("/AjouterBordereauLivraison")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public BordereauLivraison AjouterBordereauLivraison(@RequestBody BordereauLivraison bordereauLivraison) {

        // return bordereauLivraisonService.saveBordereauLivraison(bordereauLivraison);
        return bordereauLivraisonService.ajouterBordereauLivraison(bordereauLivraison.getNumeroBL(), bordereauLivraison.getDescriptionBL(), bordereauLivraison.getLieuDeLivraison(), bordereauLivraison.getDateBL(), bordereauLivraison.getConformiteBL(), bordereauLivraison.getRepresentantPrestataire(), bordereauLivraison.getCodeSection(), bordereauLivraison.getNinea(), bordereauLivraison.getMatriculeAgent());
    }


    @PutMapping("/ModifierBordereauLivraison")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public BordereauLivraison ModifierBordereauLivraison(@RequestBody BordereauLivraison b) {
        return bordereauLivraisonService.updateBordereauLivraison(b);
    }

    @DeleteMapping("SupprimerBordereauLivraisonById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerBordereauLivraisonById(@PathVariable("id") String identifiantBL) {
        bordereauLivraisonService.deleteBordereauLivraisonById(identifiantBL);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
