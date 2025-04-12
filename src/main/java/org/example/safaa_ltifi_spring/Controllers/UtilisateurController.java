package org.example.safaa_ltifi_spring.Controllers;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Services.IUtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/affecterProduits/{email}")
    public ResponseEntity<String> affecterProdAUser(@PathVariable String email, @RequestBody List<String> nomProduit) {
        try {
            // Appeler le service pour affecter les produits
            utilisateurService.affecterProdAUser(nomProduit, email);
            return ResponseEntity.ok("Produits affectés avec succès !");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erreur : " + e.getMessage());
        }
    }
}
