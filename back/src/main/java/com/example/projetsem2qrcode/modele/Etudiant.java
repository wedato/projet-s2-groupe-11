package com.example.projetsem2qrcode.modele;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
    private GroupeTp groupeTp;
    @Indexed(unique = true)
    private String email;
    private Map<LocalDate, Set<Cours>> coursDeLaSemaine;

    public Etudiant(String nom, String prenom, String numEtudiant, GroupeTp groupeTp, String email, Map<LocalDate, Set<Cours>> coursDeLaSemaine ) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEtudiant = numEtudiant;
        this.groupeTp = groupeTp;
        this.email = email;
        this.coursDeLaSemaine = coursDeLaSemaine;

    }
}
