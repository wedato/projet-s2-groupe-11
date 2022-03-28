package com.example.projetsem2qrcode;

import com.example.projetsem2qrcode.modele.Adresse;
import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.modele.Gender;
import com.example.projetsem2qrcode.dao.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ProjetSem2QRcodeApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjetSem2QRcodeApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EtudiantRepository repository, MongoTemplate mongoTemplate){
        return args -> {
            Adresse adresse = new Adresse(
                    "France",
                    "Saint jean de braye",
                    "45800"
            );
            String email = "jonathanbaltaci@gmail.com";
            Etudiant etudiant = new Etudiant(
                    "Baltaci",
                    "Jonathan",
                    Gender.HOMME,
                    email,
                    adresse,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
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
