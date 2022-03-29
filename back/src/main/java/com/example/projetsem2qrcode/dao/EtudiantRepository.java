package com.example.projetsem2qrcode.dao;

import com.example.projetsem2qrcode.modele.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends MongoRepository<Etudiant,String> {
}
