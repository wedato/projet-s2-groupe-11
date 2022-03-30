package com.example.projetsem2qrcode.modele;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document
public class GroupeTp {

    @Id
    private String id;
    private String numeroGroupe;
    @DBRef
    private Set<Etudiant> listeEtudiantGroupe;

    public GroupeTp(String numeroGroupe) {
        this.numeroGroupe = numeroGroupe;
        this.listeEtudiantGroupe = new HashSet<>();
    }
}
