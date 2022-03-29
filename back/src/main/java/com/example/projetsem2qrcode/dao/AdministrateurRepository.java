package com.example.projetsem2qrcode.dao;

import com.example.projetsem2qrcode.modele.Administrateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends MongoRepository<Administrateur, String> {

}
