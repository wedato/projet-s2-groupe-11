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
        return etudiant.isPresent() ?
                new ResponseEntity<>(etudiant,HttpStatus.FOUND) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiant")
    public ResponseEntity<Etudiant> getEtudiantByNumEtudiant(@RequestParam(value = "numEtudiant") String numEtudiant){
        Etudiant etudiant = repository.findByNumEtudiant(numEtudiant);
        return etudiant == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(etudiant,HttpStatus.FOUND) ;
    }

    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> creatEtudiant(@RequestBody Etudiant etudiant){
       return new ResponseEntity<>(repository.saveEtudiant(etudiant), HttpStatus.CREATED);
    }

    @DeleteMapping("/etudiant")
    public ResponseEntity<HttpStatus> deleteEtudiantByNumEtudiant(@RequestParam(value = "numEtudiant") String numEtudiant){
        try {
            repository.deleteEtudiantByNumEtudiant(numEtudiant);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/etudiant")
    public ResponseEntity<HttpStatus> deleteAllEtudiant(){
        try {
            repository.deleteAllEtudiant();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
