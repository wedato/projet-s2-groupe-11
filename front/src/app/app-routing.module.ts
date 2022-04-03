import {EtudiantsListComponent} from "./components/etudiants-list/etudiants-list.component";
import {EtudiantDetailsComponent} from "./components/etudiant-details/etudiant-details.component";
import {AddEtudiantComponent} from "./components/add-etudiant/add-etudiant.component";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";


const routes = [
  {path: '' , redirectTo: 'etudiants', pathMatch:'full'},
  {path: 'etudiants' , component: EtudiantsListComponent},
  {path: 'etudiants/:id' , component: EtudiantDetailsComponent},
  {path: 'add', component: AddEtudiantComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
