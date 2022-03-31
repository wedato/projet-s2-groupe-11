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

    public Optional<Etudiant> finByNumEtudiant(String numEtudiant) { return etudiantRepository.findEtudiantByNumEtudiant(numEtudiant);}

}
