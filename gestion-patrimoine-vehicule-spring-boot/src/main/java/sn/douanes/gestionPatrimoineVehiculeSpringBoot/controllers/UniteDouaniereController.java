package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.UniteDouaniereService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class UniteDouaniereController {

    @Autowired
    UniteDouaniereService uniteDouaniereService;


    @GetMapping("/UniteDouanieres")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<UniteDouaniere>> getAllUniteDouanieres() {
        List<UniteDouaniere> uniteDouaniere = uniteDouaniereService.getAllUniteDouanieres();
        return new ResponseEntity<>(uniteDouaniere, OK);
    }

    @PostMapping("/AjouterUniteDouaniere")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public UniteDouaniere AjouterUniteDouaniere(@RequestBody UniteDouaniere uniteDouaniere) {
        return uniteDouaniereService.saveUniteDouaniere(uniteDouaniere);
    }

//    @PostMapping("/AjouterRequestParamUniteDouaniere")
//    public ResponseEntity<UniteDouaniere> ajouterUniteDouaniere (
//            @RequestParam("codeUniteDouaniere") String codeUniteDouaniere,
//            @RequestParam("nomUniteDouaniere") String nomUniteDouaniere,
//            @RequestParam("effectifUniteDouaniere") Integer effectifUniteDouaniere,
//            @RequestParam("nombreArme") Integer nombreArme,
//            @RequestParam("nombreAutomobile") Integer nombreAutomobile,
//            @RequestParam("nombreMateriel") Integer nombreMateriel,
//            @RequestParam("codeTypeUniteDouaniere") TypeUniteDouaniere codeTypeUniteDouaniere
//    ) {
//        UniteDouaniere uniteDouaniere = uniteDouaniereService.ajouterUniteDouaniere(codeUniteDouaniere, nomUniteDouaniere, effectifUniteDouaniere, nombreArme, nombreAutomobile,  nombreMateriel, codeTypeUniteDouaniere);
//        return new ResponseEntity<>(uniteDouaniere, OK);
//    }

    @PutMapping("/ModifierUniteDouaniere")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public UniteDouaniere ModifierUniteDouaniere(@RequestBody UniteDouaniere u) {

        return uniteDouaniereService.updateUniteDouaniere(u);
    }

    @DeleteMapping("SupprimerUniteDouaniereById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerUniteDouaniereById(@PathVariable("id") String codeUniteDouaniere) {
        uniteDouaniereService.deleteUniteDouaniereById(codeUniteDouaniere);
    }

    @GetMapping("RecupererUniteDouaniereById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public UniteDouaniere RecupererUniteDouaniereById(@PathVariable("id") String codeUniteDouaniere) {
        return uniteDouaniereService.getUniteDouaniereById(codeUniteDouaniere);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
