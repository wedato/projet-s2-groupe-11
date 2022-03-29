import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


class GroupeTp {
  constructor(
    public numeroGroupe: string,
    public listeEtudiantGroupe: Set<Etudiant>

  ) {
  }
}

export class Etudiant {
  constructor(
    public id: string,
    public nom: string,
    public prenom: string,
    public numEtudiant: string,
    public groupeTp: GroupeTp,
    public email: string,
    public coursDeLaSemaine: Map<string,string>
  ) {

  }
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {



  constructor(
    private httpCLient: HttpClient
  ) { }

  getProducts(){
    console.log("Test call")
    return this.httpCLient.get<Etudiant[]>('http://localhost:8080/api/v1/etudiants/')
  }
}
