package sn.douanes.gestionPatrimoineVehiculeSpringBoot.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.HttpResponse;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.UniteHierarchique;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.UniteHierarchiqueService;

import static org.springframework.http.HttpStatus.OK;


@RestController
////@RequestMapping(path = { "/", "/user"})
//@RequestMapping( "/")
//@CrossOrigin("http://localhost:4200")
public class UniteHierarchiqueController {

    @Autowired
    UniteHierarchiqueService uniteHierarchiqueService;

    @GetMapping("/UniteHierarchiques")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public ResponseEntity<List<UniteHierarchique>> getAllUniteHierarchiques() {
        List<UniteHierarchique> uniteHierarchique = uniteHierarchiqueService.getAllUniteHierarchiques();
        return new ResponseEntity<>(uniteHierarchique, OK);
    }

    @PostMapping("/AjouterUniteHierarchique")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public UniteHierarchique AjouterUniteHierarchique(@RequestBody UniteHierarchique u) {
        return uniteHierarchiqueService.saveUniteHierarchique(u);
    }

    @PutMapping("/ModifierUniteHierarchique")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public UniteHierarchique ModifierUniteHierarchique(@RequestBody UniteHierarchique u) {

        return uniteHierarchiqueService.updateUniteHierarchique(u);
    }

    @DeleteMapping("SupprimerUniteHierarchiqueById/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATEUR')")
    public void SupprimerUniteHierarchiqueById(@PathVariable("id") String code_unite_hierarchique ) {
        uniteHierarchiqueService.deleteUniteHierarchiqueById(code_unite_hierarchique);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
