package com.example.projetsem2qrcode.controller;


import com.example.projetsem2qrcode.modele.Etudiant;
import com.example.projetsem2qrcode.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/etudiants")
@AllArgsConstructor
public class EtudiantController {
}
