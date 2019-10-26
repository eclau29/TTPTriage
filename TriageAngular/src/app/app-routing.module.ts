import { SeverityComponent } from './severity/severity.component';
import { VitalsComponent } from './vitals/vitals.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'vitals', component: VitalsComponent},
  { path: 'severity', component: SeverityComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
