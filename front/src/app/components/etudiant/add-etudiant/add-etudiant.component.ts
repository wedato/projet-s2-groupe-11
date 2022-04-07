import { Component, OnInit } from '@angular/core';
import {Etudiant} from "../../../models/etudiant.model";
import {EtudiantService} from "../../../services/etudiant.service";

@Component({
  selector: 'app-add-etudiant',
  templateUrl: './add-etudiant.component.html',
  styleUrls: ['./add-etudiant.component.css']
})
export class AddEtudiantComponent implements OnInit {
  etudiant: Etudiant = {
    nom:'',
    prenom:'',
    numEtudiant:''
  };
  submitted = false;

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
  }
  saveEtudiant(): void {
    const data = {
      nom: this.etudiant.nom,
      prenom:this.etudiant.prenom,
      numEtudiant: this.etudiant.numEtudiant
    };
    this.etudiantService.create(data)
      .subscribe({
        next:(res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }
  newEtudiant():void {
    this.submitted = false;
    this.etudiant = {
      nom:'',
      prenom:'',
      numEtudiant:''
    };
  }

}
