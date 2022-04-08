import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from "@angular/router";
import { HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatCardModule} from "@angular/material/card";
import { AddEtudiantComponent } from './components/etudiant/add-etudiant/add-etudiant.component';
import { EtudiantDetailsComponent } from './components/etudiant/etudiant-details/etudiant-details.component';
import { EtudiantsListComponent } from './components/etudiant/etudiants-list/etudiants-list.component';
import {AppRoutingModule} from "./app-routing.module";
import { CoursListComponent } from './components/cours/cours-list/cours-list.component';
import { HeaderComponent } from './components/header/header/header.component';
import { GroupeTpComponent } from './components/groupe-tp/groupe-tp.component';



@NgModule({
  declarations: [
    AppComponent,
    AddEtudiantComponent,
    EtudiantDetailsComponent,
    EtudiantsListComponent,
    CoursListComponent,
    HeaderComponent,
    GroupeTpComponent,

  ],
    imports: [
        RouterModule,
        BrowserModule,
        HttpClientModule,
        BrowserAnimationsModule,
        FormsModule,
        BrowserAnimationsModule,
        MatInputModule,
        MatCardModule,
        MatButtonModule,
        MatToolbarModule,
        MatExpansionModule,
        AppRoutingModule
    ],
  providers: [],
  bootstrap: [AppComponent],
  exports : [RouterModule]
})
export class AppModule { }
