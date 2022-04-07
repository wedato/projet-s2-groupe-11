package com.example.projetsem2qrcode.controller;


import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.dao.GroupeTpRepository;
import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.modele.GroupeTp;
import com.example.projetsem2qrcode.modele.IdEtudiant;
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
public class GroupeTpController {

    @Autowired
    GroupeTpRepository groupeTpRepository;
    @Autowired
    EtudiantRepository etudiantRepository;


    @PostMapping("/groupetp")
    public ResponseEntity<GroupeTp> createGroupeTp(@RequestBody GroupeTp groupeTp){
        try {
            GroupeTp _groupeTp = groupeTpRepository.save(new GroupeTp(
                    groupeTp.getNumeroGroupe()));
            return new ResponseEntity<>(_groupeTp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/groupetp")
    public ResponseEntity<List<GroupeTp>> getAllGroupeTp() {
        try {
            List<GroupeTp> groupeTps = new ArrayList<GroupeTp>();
            groupeTpRepository.findAll().forEach(groupeTps::add);
            if (groupeTps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(groupeTps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/groupe/{idGroupe}")
    public ResponseEntity<GroupeTp> addEtudiantAuGroupeTp(@PathVariable("idGroupe") String idGroupe ,@RequestBody IdEtudiant idEtudiant){
       Optional<Etudiant> etudiantdata = etudiantRepository.findById(idEtudiant.getId());
       Optional<GroupeTp> groupeTpData = groupeTpRepository.findById(idGroupe);
        if (etudiantdata.isPresent() && groupeTpData.isPresent()){
            Etudiant _etudiant = etudiantdata.get();
            GroupeTp _groupeTp = groupeTpData.get();
            _etudiant.setGroupeTp(_groupeTp.getNumeroGroupe());
            etudiantRepository.save(_etudiant);
            _groupeTp.getListeEtudiantGroupe().add(_etudiant);



            return new ResponseEntity<>(groupeTpRepository.save(_groupeTp),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/groupetp/{id}")
    public ResponseEntity<GroupeTp> getGroupeTp(@PathVariable("id")String id){
        Optional<GroupeTp> groupeTpData = groupeTpRepository.findById(id);
        if (groupeTpData.isPresent()){
            return new ResponseEntity<>(groupeTpData.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/etudiants/numEtu/{numEtudiant}")
//    public ResponseEntity<Etudiant> getEtudiantByNumEtudiant(@PathVariable("numEtudiant") String numEtudiant){
//        Optional<Etudiant> etudiantData = etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);
//        if(etudiantData.isPresent()){
//            return new ResponseEntity<>(etudiantData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/etudiants/{id}")
//    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") String id, @RequestBody Etudiant etudiant){
//        Optional<Etudiant> etudiantData = etudiantRepository.findById(id);
//        if(etudiantData.isPresent()){
//            Etudiant _etudiant = etudiantData.get();
//            _etudiant.setNom(etudiant.getNom());
//            _etudiant.setPrenom(etudiant.getPrenom());
//            _etudiant.setNumEtudiant(etudiant.getNumEtudiant());
//            return new ResponseEntity<>(etudiantRepository.save(_etudiant),HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/etudiants/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
//        try {
//            etudiantRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/etudiants")
//    public ResponseEntity<HttpStatus> deleteAllEtudiant(){
//        try {
//            etudiantRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    }

