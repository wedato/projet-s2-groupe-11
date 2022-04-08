package com.example.projetsem2qrcode.modele;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
public class Administrateur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String mail;
    private Map<String, Prof> professeurs;
    private Map<String, Etudiant> etudiants;
    private List<Cours> cours;
    private Map<String, GroupeTp> groupes;
}
