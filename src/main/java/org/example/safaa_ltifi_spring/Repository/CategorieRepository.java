package org.example.safaa_ltifi_spring.Repository;

import org.example.safaa_ltifi_spring.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByNomCategorie(String nomCategorie);
}
