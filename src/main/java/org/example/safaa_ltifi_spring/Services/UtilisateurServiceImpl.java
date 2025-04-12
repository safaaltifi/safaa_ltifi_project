package org.example.safaa_ltifi_spring.Services;

import lombok.AllArgsConstructor;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.example.safaa_ltifi_spring.Repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService{

    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateur.setDateInscri(new Date());
        return utilisateurRepository.save(utilisateur);
    }
}
