import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from "@angular/router";
import { EtudiantComponent } from './etudiant/etudiant.component';
import { HttpClientModule} from "@angular/common/http";



const routes: Routes = [
  {path: 'etudiants' , component: EtudiantComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent
  ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes),
        HttpClientModule
    ],
  providers: [],
  bootstrap: [AppComponent],
  exports : [RouterModule]
})
export class AppModule { }
