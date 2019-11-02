import { GeneralInfoComponent } from './general-info/general-info.component';
import { SymptomsComponent } from './symptoms/symptoms.component';
import { SeverityComponent } from './severity/severity.component';
import { VitalsComponent } from './vitals/vitals.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'vitals', component: VitalsComponent},
  { path: 'severity', component: SeverityComponent},
  { path: 'symptoms', component: SymptomsComponent},
  { path: 'info', component: GeneralInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
