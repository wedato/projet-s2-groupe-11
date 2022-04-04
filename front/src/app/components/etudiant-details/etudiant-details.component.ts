import {Component, Input, OnInit} from '@angular/core';
import {Etudiant} from "../../models/etudiant.model";
import {EtudiantService} from "../../services/etudiant.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-etudiant-details',
  templateUrl: './etudiant-details.component.html',
  styleUrls: ['./etudiant-details.component.css']
})
export class EtudiantDetailsComponent implements OnInit {

  @Input() viewMode= false;
  @Input() currentEtudiant: Etudiant = {
    numEtudiant:'',
    nom:'',
    prenom:''
}
message = '';


  constructor(
    private etudiantService: EtudiantService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message ='';
      this.getEtudiant(this.route.snapshot.params['id']);
    }
  }

   getEtudiant(id:string): void {
    this.etudiantService.get(id)
      .subscribe({
        next: (data) => {
          this.currentEtudiant = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  updateEtudiant():void {
    this.message ='';
    this.etudiantService.update(this.currentEtudiant.id, this.currentEtudiant)
      .subscribe({
        next:(res) => {
          console.log(res);
          this.message = res.message ? res.message : 'letudiant a ete update avec succes';
        },
        error: (e) => console.error(e)
      });
  }
  deleteEtudiant(): void {
    this.etudiantService.delete(this.currentEtudiant.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/etudiants'])
        },
        error:(e) => console.error(e)
      });
  }
}
