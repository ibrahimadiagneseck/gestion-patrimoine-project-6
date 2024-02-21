package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.FonctionAgent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.FonctionAgentService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class FonctionAgentController {

    @Autowired
    FonctionAgentService fonctionAgentService;


    @GetMapping("/FonctionAgents")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<FonctionAgent>> getAllFonctionAgents() {
        List<FonctionAgent> fonctionAgent = fonctionAgentService.getAllFonctionAgents();
        return new ResponseEntity<>(fonctionAgent, OK);
    }

    @PostMapping("/AjouterFonctionAgent")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public FonctionAgent AjouterFonctionAgent(@RequestBody FonctionAgent fonctionAgent) {
        return fonctionAgentService.saveFonctionAgent(fonctionAgent);
    }

    @PostMapping("/AjouterRequestParamFonctionAgent")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<FonctionAgent> ajouterFonctionAgent (
            @RequestParam("codeFonctionAgent") String codeFonctionAgent,
            @RequestParam("libelleFonctionAgent") String libelleFonctionAgent
    ) {
        FonctionAgent fonctionAgent = fonctionAgentService.ajouterFonctionAgent(codeFonctionAgent, libelleFonctionAgent);
        return new ResponseEntity<>(fonctionAgent, OK);
    }

    @PutMapping("/ModifierFonctionAgent")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public FonctionAgent ModifierFonctionAgent(@RequestBody FonctionAgent f) {
        return fonctionAgentService.updateFonctionAgent(f);
    }

    @DeleteMapping("SupprimerFonctionAgentById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerFonctionAgentById(@PathVariable("id") String codeFonctionAgent) {
        fonctionAgentService.deleteFonctionAgentById(codeFonctionAgent);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
