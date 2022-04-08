package com.example.projetsem2qrcode.modele;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
@Document("etudiants")
public class Etudiant {

    @Id
    private String id;

    private String nom;
    private String prenom;
    private String numEtudiant;
    private String email;

    public Etudiant(String nom, String prenom, String numEtudiant, String email ) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEtudiant = numEtudiant;
        this.email = email;

    }
}
