package com.example.projetsem2qrcode.controller;


import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class EtudiantController {

    @Autowired
    private final EtudiantService etudiantService;
    //???

    @GetMapping("/etudiants")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Etudiant> fetchAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
}
