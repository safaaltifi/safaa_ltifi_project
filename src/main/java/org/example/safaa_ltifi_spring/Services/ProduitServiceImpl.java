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

        // Vérifier si la liste des catégories n'est pas null
        if (p.getCategories() != null) {
            for (Categorie c : p.getCategories()) {
                Categorie existante = categorieRepository.findByNomCategorie(c.getNomCategorie());
                if (existante == null) {
                    // Sauvegarder la nouvelle catégorie
                    existante = categorieRepository.save(c);
                }
                // Ajouter la catégorie trouvée ou créée à la liste finale
                categoriesFinales.add(existante);
            }
        }

        // Associer les catégories au produit
        p.setCategories(categoriesFinales);
        // Sauvegarder le produit
        return produitRepository.save(p);
    }

}

