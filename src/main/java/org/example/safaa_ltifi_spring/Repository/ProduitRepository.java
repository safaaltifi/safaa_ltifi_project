package org.example.safaa_ltifi_spring.Repository;

import org.example.safaa_ltifi_spring.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findByNomProduit(String nomProduit);
}
