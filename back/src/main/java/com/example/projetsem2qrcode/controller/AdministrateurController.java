package com.example.projetsem2qrcode.controller;

import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("admin")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @GetMapping("/etudiants")
    public ResponseEntity<Iterable<Etudiant>> pageEtudiant() {
        return ResponseEntity.ok(administrateurService.getAllEtudiant());
    }

    @PostMapping("/etudiants/{id}")
    public ResponseEntity<Optional<Etudiant>> ficheEtudiant(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(administrateurService.getEtudiantById(id), HttpStatus.FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<HttpStatus> deleteEtudiantById(@PathVariable("id") String id){
        try{
            administrateurService.deleteEtudiant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/etudiants")
    public ResponseEntity<HttpStatus> deleteAllEtudiant(){
        try{
            administrateurService.deleteAllEtudiant();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/etudiants")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant){
        try{
            return new ResponseEntity<>(administrateurService.createEtudiant(etudiant), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id")String id, @RequestBody Etudiant etudiantUp){
        if (administrateurService.updateEtudiant(id,etudiantUp) == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(administrateurService.updateEtudiant(id,etudiantUp), HttpStatus.OK);
    }
}
