package com.example.projetsem2qrcode.modele;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Adresse {
    private String pays;
    private String ville;
    private String codePostal;
}
