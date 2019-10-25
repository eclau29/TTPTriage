import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { VitalsComponent } from './vitals/vitals.component';
import { SymptomsComponent } from './symptoms/symptoms.component';
import { GeneralInfoComponent } from './general-info/general-info.component';
import { ScannerComponent } from './scanner/scanner.component';
import { SeverityComponent } from './severity/severity.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    VitalsComponent,
    SymptomsComponent,
    GeneralInfoComponent,
    ScannerComponent,
    SeverityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
