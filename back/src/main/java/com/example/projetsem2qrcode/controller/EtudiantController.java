package com.example.projetsem2qrcode.controller;


import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.modele.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;


    @PostMapping("/etudiant")
    public void addEtudiant(@RequestBody Etudiant etudiant){
        etudiantRepository.save(etudiant);
    }

    @PostMapping("/etudiants")
    public void addEtudiants(@RequestBody List<Etudiant> etudiants) {
        etudiantRepository.saveAll(etudiants);
    }

    @GetMapping("/etudiants")
    public List<Etudiant> findEtudiants(){
        return etudiantRepository.findAll();
    }
    @GetMapping("/etudiants/{etudiantId}")
    public Optional<Etudiant> findEtudiant(@PathVariable String etudiantId){
        return etudiantRepository.findById(etudiantId);
    }

    }

