package com.example.projetsem2qrcode.service;

import com.example.projetsem2qrcode.dao.AdministrateurRepository;
import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.modele.Etudiant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AdministrateurService {
    @Autowired
    private AdministrateurRepository administrateurRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    public Optional<Etudiant> getEtudiantById(final String id){
        return etudiantRepository.findById(id);
    }

    public Iterable<Etudiant> getAllEtudiant(){
        return etudiantRepository.findAll();
    }

    public void deleteEtudiant(final String id){
        etudiantRepository.deleteById(id);
    }

    public Etudiant createEtudiant(Etudiant etudiant){
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return savedEtudiant;
    }

    public Etudiant updateEtudiant (final String id, Etudiant etudiantUp){
        Optional<Etudiant> updateEtudiant = etudiantRepository.findById(id);
        if (updateEtudiant.isPresent()){
            Etudiant etudiant = updateEtudiant.get();
            etudiant.setNom(etudiantUp.getNom());
            etudiant.setPrenom(etudiantUp.getPrenom());
            etudiant.setNumEtudiant(etudiantUp.getNumEtudiant());
            etudiant.setEmail(etudiantUp.getEmail());
            etudiant.setGroupeTp(etudiantUp.getGroupeTp());
            etudiant.setCoursDeLaSemaine(etudiantUp.getCoursDeLaSemaine());
            return etudiant;
        }
        return null;
    }

    public void deleteAllEtudiant(){
        etudiantRepository.deleteAll();
    }
}
