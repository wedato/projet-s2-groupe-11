package com.example.projetsem2qrcode;

import com.example.projetsem2qrcode.dao.EtudiantRepository;
import com.example.projetsem2qrcode.modele.Cours;
import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.modele.GroupeTp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class ProjetSem2QRcodeApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjetSem2QRcodeApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EtudiantRepository repository, MongoTemplate mongoTemplate){
        return args -> {

            Set<Etudiant> setEtudiant = new HashSet<>();
            Map<LocalDate, Set<Cours>> coursDeLaSemaine = new HashMap<>();
            GroupeTp groupeTp = new GroupeTp("TP1",setEtudiant);
            String email = "jonathanbaltaci@gmail.com";
            Etudiant etudiant = new Etudiant(
                    "Baltaci",
                    "Jonathan",
                    "2150351",
                    groupeTp,
                    email,
                    coursDeLaSemaine
            );

           repository.findEtudiantByEmail(email)
                   .ifPresentOrElse(e -> {
                       System.out.println(e + "existe déjà ");
                   } , () -> {
                       System.out.println("Ajout étudiant " + etudiant);
                       repository.insert(etudiant);
                   } );

        };
    }

}
