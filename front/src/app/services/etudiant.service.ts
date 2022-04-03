import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Etudiant} from "../models/etudiant.model";

const baseUrl = 'http://localhost:8080/api/etudiants';
@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(baseUrl);
  }
  get(id: any): Observable<Etudiant>{
    return this.http.get(`${baseUrl}/${id}`)
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  findByNumEtu(numEtudiant: any): Observable<Etudiant[]> {
    return this.http.get<Etudiant[]>(`${baseUrl}?title=${numEtudiant}`);
  }
}
