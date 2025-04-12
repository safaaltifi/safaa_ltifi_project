package org.example.safaa_ltifi_spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Date dateInscri;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Produit> produits;


}
