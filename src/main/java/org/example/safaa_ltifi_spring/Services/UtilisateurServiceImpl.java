package org.example.safaa_ltifi_spring.Services;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Produit;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Repository.ProduitRepository;
import org.example.safaa_ltifi_spring.Repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    private UtilisateurRepository utilisateurRepository;
    private ProduitRepository produitRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateur.setDateInscri(new Date());
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void affecterProdAUser(List<String> nomProduit, String email) {

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }


        List<Produit> produits = produitRepository.findByNomProduitIn(nomProduit);
        if (produits.isEmpty()) {
            throw new RuntimeException("Aucun produit trouvé");
        }

        utilisateur.setProduits(produits);
        utilisateurRepository.save(utilisateur);
    }
}
