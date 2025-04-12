package org.example.safaa_ltifi_spring.Controllers;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Produit;
import org.example.safaa_ltifi_spring.Services.IProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
