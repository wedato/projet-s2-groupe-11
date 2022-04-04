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
import {HeaderComponent} from "./header/header.component";
import { AddEtudiantComponent } from './components/add-etudiant/add-etudiant.component';
import { EtudiantDetailsComponent } from './components/etudiant-details/etudiant-details.component';
import { EtudiantsListComponent } from './components/etudiants-list/etudiants-list.component';
import {AppRoutingModule} from "./app-routing.module";



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddEtudiantComponent,
    EtudiantDetailsComponent,
    EtudiantsListComponent,

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
