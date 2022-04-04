package com.example.projetsem2qrcode.controller;


import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.modele.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EtudiantController {

    @Autowired
    EtudiantRepository etudiantRepository;


    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant){
        try {
            Etudiant _etudiant = etudiantRepository.save(new Etudiant(
                    etudiant.getNom(),
                    etudiant.getPrenom(),
                    etudiant.getNumEtudiant()));
            return new ResponseEntity<>(_etudiant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        try {
            List<Etudiant> etudiants = new ArrayList<Etudiant>();
            etudiantRepository.findAll().forEach(etudiants::add);
            if (etudiants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") String id){
        Optional<Etudiant> etudiantData = etudiantRepository.findById(id);
        if(etudiantData.isPresent()){
            return new ResponseEntity<>(etudiantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/etudiants/numEtu/{numEtudiant}")
    public ResponseEntity<Etudiant> getEtudiantByNumEtudiant(@PathVariable("numEtudiant") String numEtudiant){
        Optional<Etudiant> etudiantData = etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);
        if(etudiantData.isPresent()){
            return new ResponseEntity<>(etudiantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") String id, @RequestBody Etudiant etudiant){
        Optional<Etudiant> etudiantData = etudiantRepository.findById(id);
        if(etudiantData.isPresent()){
            Etudiant _etudiant = etudiantData.get();
            _etudiant.setNom(etudiant.getNom());
            _etudiant.setPrenom(etudiant.getPrenom());
            _etudiant.setNumEtudiant(etudiant.getNumEtudiant());
            return new ResponseEntity<>(etudiantRepository.save(_etudiant),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            etudiantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/etudiants")
    public ResponseEntity<HttpStatus> deleteAllEtudiant(){
        try {
            etudiantRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    }

