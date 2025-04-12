package org.example.safaa_ltifi_spring.Controllers;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Produit;
import org.example.safaa_ltifi_spring.Entities.TypeUtilisateur;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Services.IProduitService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {

    private IProduitService produitService;

    @PostMapping()
    public ResponseEntity<Produit> ajouterProduitEtCategories(@RequestBody Produit produit) {
        Produit saved = produitService.ajouterProduit(produit);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/chercher/{nomProduit}")
    public boolean chercherProduit(@PathVariable String nomProduit) {
        return produitService.chercherProduit(nomProduit);
    }


    @GetMapping("/utilisateurs/filtres")
    public List<Utilisateur> recupererUtilisateursParCriteres(
            @RequestParam String nomCategorie,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
            @RequestParam TypeUtilisateur typeUtilisateur) {
        return produitService.recupererUtilisateursParCriteres(nomCategorie, date, typeUtilisateur);
    }

    @PostMapping("/{nomProduit}/desaffecter-categories")
    public void desAffecterCatDeProd(
            @RequestBody List<String> nomCategories,
            @PathVariable String nomProduit) {
        produitService.desAffecterCatDeProd(nomCategories, nomProduit);
    }

}
