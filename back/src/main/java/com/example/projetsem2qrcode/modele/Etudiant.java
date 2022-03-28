package com.example.projetsem2qrcode.modele;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Etudiant {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private Gender gender;
    @Indexed(unique = true)
    private String email;
    private Adresse adresse;
    private List<String> matierePref;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;

    public Etudiant(String nom, String prenom, Gender gender, String email, Adresse adresse, List<String> matierePref, BigDecimal totalSpentInBooks, LocalDateTime created) {
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.email = email;
        this.adresse = adresse;
        this.matierePref = matierePref;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
