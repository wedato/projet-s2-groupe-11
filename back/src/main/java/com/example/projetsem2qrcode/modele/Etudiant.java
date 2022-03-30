package com.example.projetsem2qrcode.modele;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
@Document
@NoArgsConstructor
public class Etudiant {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String numEtudiant;
    @DBRef
    private GroupeTp groupeTp;
    private String email;
    private Map<LocalDate, Set<Cours>> coursDeLaSemaine;

    public Etudiant(String nom, String prenom, String numEtudiant,  String email ) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEtudiant = numEtudiant;
        this.email = email;

    }
}
