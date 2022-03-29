import { Component, OnInit } from '@angular/core';
import {Etudiant, HttpClientService} from "../service/http-client.service";

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {

  etudiants!: Etudiant[];

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getProducts().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  // @ts-ignore
  handleSuccessfulResponse(response) {
    this.etudiants = response;
  }

}
