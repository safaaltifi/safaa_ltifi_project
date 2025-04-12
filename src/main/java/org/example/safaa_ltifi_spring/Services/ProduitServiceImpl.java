package org.example.safaa_ltifi_spring.Services;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Categorie;
import org.example.safaa_ltifi_spring.Entities.Produit;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Repository.CategorieRepository;
import org.example.safaa_ltifi_spring.Repository.ProduitRepository;
import org.example.safaa_ltifi_spring.Repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements IProduitService {


    private ProduitRepository produitRepository;


    private UtilisateurRepository utilisateurRepository;


    private CategorieRepository categorieRepository;

    @Override
    public Produit ajouterProduit(Produit p) {
        List<Categorie> categoriesFinales = new ArrayList<>();

        for (Categorie c : p.getCategories()) {
            Categorie existante = categorieRepository.findByNomCategorie(c.getNomCategorie());
            if (existante == null) {
                existante = categorieRepository.save(c);
            }
            categoriesFinales.add(existante);
        }

        p.setCategories(categoriesFinales);
        return produitRepository.save(p);
    }

}

