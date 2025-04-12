package org.example.safaa_ltifi_spring.Services;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.*;
import org.example.safaa_ltifi_spring.Repository.CategorieRepository;
import org.example.safaa_ltifi_spring.Repository.ProduitRepository;
import org.example.safaa_ltifi_spring.Repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements IProduitService {


    private ProduitRepository produitRepository;


    private UtilisateurRepository utilisateurRepository;


    private CategorieRepository categorieRepository;

    @Override
    public Produit ajouterProduit(Produit p) {
        List<Categorie> categoriesFinales = new ArrayList<>();


        if (p.getCategories() != null) {
            for (Categorie c : p.getCategories()) {
                Categorie existante = categorieRepository.findByNomCategorie(c.getNomCategorie());
                if (existante == null) {

                    existante = categorieRepository.save(c);
                }

                categoriesFinales.add(existante);
            }
        }


        p.setCategories(categoriesFinales);

        return produitRepository.save(p);
    }

    @Override
    public boolean chercherProduit(String nomProduit) {
        Produit produit = produitRepository.findByNomProduit(nomProduit);
        return produit != null && produit.getEtat() == Etat.BOYCOTT;
    }

    @Override
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, Date d, TypeUtilisateur tu) {

        List<Utilisateur> utilisateursFiltres = utilisateurRepository
                .findByTypeUtilisateurAndDateInscriAfter(tu, d);


        return utilisateursFiltres.stream()
                .filter(u -> u.getProduits().stream()
                        .anyMatch(p -> p.getCategories().stream()
                                .anyMatch(c -> c.getNomCategorie().equals(nomCategorie))))
                .collect(Collectors.toList());
    }

    @Override
    public void desAffecterCatDeProd(List<String> nomCategories, String nomProduit) {

        Produit produit = produitRepository.findByNomProduit(nomProduit);
        if (produit == null) {
            throw new RuntimeException("Produit non trouvé");
        }


        List<Categorie> categoriesASupprimer = produit.getCategories().stream()
                .filter(c -> nomCategories.contains(c.getNomCategorie()))
                .collect(Collectors.toList());


        categoriesASupprimer.forEach(c -> {
            produit.getCategories().remove(c);
            c.getProduits().remove(produit);
        });


        produitRepository.save(produit);
    }
}

