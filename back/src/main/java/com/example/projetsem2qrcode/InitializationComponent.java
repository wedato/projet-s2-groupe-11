package com.example.projetsem2qrcode;

import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.dao.GroupeTpRepository;
import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.modele.GroupeTp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationComponent {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private GroupeTpRepository groupeTpRepository;

    @PostConstruct
    private void init(){

        groupeTpRepository.deleteAll();
        etudiantRepository.deleteAll();

        GroupeTp tpA = new GroupeTp("tpA");

        Etudiant jonathan = new Etudiant("baltaci","jonathan","2150351",
                "jonathanbaltaci@gmail.com");
        Etudiant clement = new Etudiant("guyot","clement","214645",
                "clementguyot@gmail.com");

        etudiantRepository.save(clement);
        etudiantRepository.save(jonathan);
        groupeTpRepository.save(tpA);

        tpA.getListeEtudiantGroupe().add(clement);
        tpA.getListeEtudiantGroupe().add(jonathan);
        clement.setGroupeTp(tpA);
        jonathan.setGroupeTp(tpA);

        groupeTpRepository.save(tpA);
        etudiantRepository.save(clement);
        etudiantRepository.save(jonathan);






    }
}
