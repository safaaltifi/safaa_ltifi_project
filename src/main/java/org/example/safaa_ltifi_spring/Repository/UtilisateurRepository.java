package org.example.safaa_ltifi_spring.Repository;

import org.example.safaa_ltifi_spring.Entities.TypeUtilisateur;
import org.example.safaa_ltifi_spring.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);

    List<Utilisateur> findByTypeUtilisateurAndDateInscriAfter(
            TypeUtilisateur typeUtilisateur, Date date);
}
