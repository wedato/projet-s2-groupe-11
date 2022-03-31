package com.example.projetsem2qrcode.dao;

import com.example.projetsem2qrcode.modele.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant,String>{
    @Query("{'numEtudiant' : ?0}")
    List<Etudiant> findEtudiantByNumEtudiant(String numEtudiant);
}
