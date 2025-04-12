package org.example.safaa_ltifi_spring.Controllers;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Services.IUtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private IUtilisateurService utilisateurService;

    @PostMapping()
    public ResponseEntity<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur u = utilisateurService.ajouterUtilisateur(utilisateur);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}
