package org.example.safaa_ltifi_spring.Services;

import org.example.safaa_ltifi_spring.Entities.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);

    void affecterProdAUser(List<String> nomProduit, String email);
}
