package org.example.safaa_ltifi_spring.Services;

import org.example.safaa_ltifi_spring.Entities.Produit;
import org.example.safaa_ltifi_spring.Entities.TypeUtilisateur;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IProduitService {
    Produit ajouterProduit(Produit produit);

    boolean chercherProduit(String nomProduit);

    List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, Date d, TypeUtilisateur tu);

    void desAffecterCatDeProd(List<String> nomCategories, String nomProduit);
}
