package org.example.safaa_ltifi_spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProduit;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Categorie> categories = new ArrayList<>();
}

