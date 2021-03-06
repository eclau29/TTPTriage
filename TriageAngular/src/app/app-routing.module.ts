import { CatastropheComponent } from './catastrophe/catastrophe.component';
import { GeneralInfoComponent } from './general-info/general-info.component';
import { SymptomsComponent } from './symptoms/symptoms.component';
import { SeverityComponent } from './severity/severity.component';
import { VitalsComponent } from './vitals/vitals.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { ScannerComponent } from './scanner/scanner.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'scanner' },
  { path: 'vitals', component: VitalsComponent},
  { path: 'severity', component: SeverityComponent},
  { path: 'symptoms', component: SymptomsComponent},
  { path: 'info', component: GeneralInfoComponent},
  { path: 'menu', component: MenuComponent},
  { path: 'scanner', component: ScannerComponent},
  { path: 'catastrophe', component: CatastropheComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
