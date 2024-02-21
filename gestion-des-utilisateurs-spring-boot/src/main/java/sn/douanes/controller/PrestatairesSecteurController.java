package sn.douanes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.model.HttpResponse;
import sn.douanes.model.Prestataires;
import sn.douanes.model.PrestatairesSecteur;
import sn.douanes.model.SecteurActivite;
import sn.douanes.services.PrestatairesSecteurService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class PrestatairesSecteurController {

    @Autowired
    PrestatairesSecteurService prestatairesSecteurService;


    @GetMapping("/PrestatairesSecteurs")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<PrestatairesSecteur>> getAllPrestatairesSecteurs() {
        List<PrestatairesSecteur> prestatairesSecteur = prestatairesSecteurService.getAllPrestatairesSecteur();
        return new ResponseEntity<>(prestatairesSecteur, OK);
    }

    @PostMapping("/AjouterPrestatairesSecteurs")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public PrestatairesSecteur AjouterPrestatairesSecteur(@RequestBody PrestatairesSecteur prestatairesSecteur) {
        return prestatairesSecteurService.savePrestatairesSecteur(prestatairesSecteur);
    }

//    @PostMapping("/AjouterRequestParamPrestatairesSecteur")
//    public ResponseEntity<PrestatairesSecteur> ajouterPrestatairesSecteur (
//            @RequestParam("ninea") Prestataires ninea,
//            @RequestParam("codeSecteurActivite") SecteurActivite codeSecteurActivite
//    ) {
//        PrestatairesSecteur prestatairesSecteur = prestatairesSecteurService.ajouterPrestatairesSecteur(ninea, codeSecteurActivite);
//        return new ResponseEntity<>(prestatairesSecteur, OK);
//    }


    @PutMapping("/ModifierPrestatairesSecteur")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public PrestatairesSecteur ModifierPrestatairesSecteur(@RequestBody PrestatairesSecteur p) {

        return prestatairesSecteurService.updatePrestatairesSecteur(p);
    }

    @DeleteMapping("SupprimerPrestatairesSecteurById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerPrestatairesSecteurById(
            @PathVariable("ninea") Prestataires ninea,
            @PathVariable("codeSecteurActivite") SecteurActivite codeSecteurActivite
    ) {
        prestatairesSecteurService.deletePrestatairesSecteurById(ninea, codeSecteurActivite);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
