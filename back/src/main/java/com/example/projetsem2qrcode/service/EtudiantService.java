package com.example.projetsem2qrcode.service;

import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.dao.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public Etudiant saveEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    public Optional<Etudiant> etudiantOptional(String id){
        return etudiantRepository.findById(id);
    }

    public Etudiant findByNumEtudiant(String numEtudiant) {
        List<Etudiant> listEtu = etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);
        return listEtu.size() > 0 ? listEtu.get(0) : null;
    }

    public void deleteAllEtudiant() {
        etudiantRepository.deleteAll();
    }

    public void deleteEtudiantByNumEtudiant(String numEtudiant){
        List<Etudiant> etudiants = etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);
        String id = etudiants.get(0).getId();
        etudiantRepository.deleteById(id);
    }

    public Etudiant updateEtudiantByNumEtudiant(String numEtudiant , Etudiant etudiantUp){
        List <Etudiant> etudiants = etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);
        String id = etudiants.get(0).getId();
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if (etudiant.isPresent()){
            Etudiant etucurrent = etudiants.get(0);
            etucurrent.setNom(etudiantUp.getNom());
            etucurrent.setPrenom(etudiantUp.getPrenom());
            etucurrent.setEmail(etudiantUp.getEmail());
            etucurrent.setNumEtudiant(etudiantUp.getNumEtudiant());
            return etucurrent;
        }
        return null;
    }

}
