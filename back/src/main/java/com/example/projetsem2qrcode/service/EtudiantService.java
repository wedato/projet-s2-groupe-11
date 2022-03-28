package com.example.projetsem2qrcode.service;

import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.dao.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}
