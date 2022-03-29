package com.example.projetsem2qrcode;

import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.modele.Cours;
import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.modele.GroupeTp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class InitializationComponent {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostConstruct
    private void init(){

        etudiantRepository.deleteAll();

        Map<LocalDate, Set<Cours>> coursDeLaSemaine = new HashMap<>();
        GroupeTp groupeTp = new GroupeTp("TP1",new HashSet<>());
        String email = "jonathanbaltaci@gmail.com";
        Etudiant etudiant = new Etudiant(
                "Baltaci",
                "Jonathan",
                "2150351",
                groupeTp,
                email,
                coursDeLaSemaine
        );
        etudiantRepository.save(etudiant);

    }
}
