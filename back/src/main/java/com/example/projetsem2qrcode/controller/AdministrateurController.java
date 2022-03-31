package com.example.projetsem2qrcode.controller;

import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(value = "/admin")
public class AdministrateurController {

    @Autowired
    private EtudiantService repository;

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<Optional<Etudiant>> getEtudiant(@PathVariable(value = "id") String id){
        Optional<Etudiant> etudiant = repository.etudiantOptional(id);
        if (etudiant != null){
            return new ResponseEntity<>(etudiant,HttpStatus.FOUND);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiant")
    public ResponseEntity<List<Etudiant>> getEtudiantByNumEtudiant(@RequestParam(value = "numEtudiant") String numEtudiant){
        return new ResponseEntity<>(repository.findByNumEtudiant(numEtudiant),HttpStatus.FOUND);
    }

    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> creatEtudiant(@RequestBody Etudiant etudiant){
       return new ResponseEntity(repository.saveEtudiant(etudiant), HttpStatus.CREATED);
    }
}
