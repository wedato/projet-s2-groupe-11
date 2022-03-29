package com.example.projetsem2qrcode.modele;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class GroupeTp {

    @Id
    private String id;
    private String numeroGroupe;
    private Set<Etudiant> listeEtudiantGroupe;

    public GroupeTp(String numeroGroupe, Set<Etudiant> listeEtudiantGroupe) {
        this.numeroGroupe = numeroGroupe;
        this.listeEtudiantGroupe = listeEtudiantGroupe;
    }
}
