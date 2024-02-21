import { APP_INITIALIZER, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ErreurComponent } from './pages/erreur/erreur.component';



import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatDividerModule} from '@angular/material/divider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { CommonModule, DatePipe, registerLocaleData } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
// import { NotifierModule, NotifierOptions } from 'angular-notifier';

import localeFr from '@angular/common/locales/fr';
// import { MatTableExporterModule } from 'mat-table-exporter';

// import { UtilisateurListeComponent } from './pages/utilisateur/utilisateur-liste/utilisateur-liste.component';

import { BureauLogistiqueMaterielModule } from './pages/bureau-logistique-materiel/bureau-logistique-materiel.module';
import { NgToastModule } from 'ng-angular-popup';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { ComposantModule } from './composant/composant.module';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { PrestataireSecteurAjouterComponent } from './pages/prestataire/prestataire-secteur-ajouter/prestataire-secteur-ajouter.component';
import { PrestataireSecteurDetailComponent } from './pages/prestataire/prestataire-secteur-detail/prestataire-secteur-detail.component';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { AjouterBonPourListeComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-liste/ajouter-bon-pour-liste.component';
import { ConsultationBonPourListeComponent } from './pages/bon-pour/consultation/consultation-bon-pour-liste/consultation-bon-pour-liste.component';
import { AjouterBonPourAjouterComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-ajouter/ajouter-bon-pour-ajouter.component';
import { AjouterBonPourListeDetailComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-liste-detail/ajouter-bon-pour-liste-detail.component';
import { AjouterBonPourAjouterArticleComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-ajouter-article/ajouter-bon-pour-ajouter-article.component';
import { UniteDouaniereListeComponent } from './pages/unite-douaniere/unite-douaniere-liste/unite-douaniere-liste.component';
import { UniteDouaniereAjouterComponent } from './pages/unite-douaniere/unite-douaniere-ajouter/unite-douaniere-ajouter.component';
import { UniteDouaniereDetailComponent } from './pages/unite-douaniere/unite-douaniere-detail/unite-douaniere-detail.component';
import { XhrInterceptor } from './interceptors/app.request.interceptor';
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard';
import { DeconnexionComponent } from './pages/deconnexion/deconnexion.component';
import { ConnexionComponent } from './pages/connexion/connexion.component';



// the second parameter 'fr' is optional
registerLocaleData(localeFr, 'fr');



export const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'YYYY-MM-DD',
  },
  display: {
    dateInput: 'YYYY-MM-DD',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'YYYY-MM-DD',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};


@NgModule({
  declarations: [

    AppComponent,
    ConnexionComponent,
    AccueilComponent,
    DeconnexionComponent,
    ErreurComponent,


    PrestataireSecteurListeComponent,
    PrestataireSecteurAjouterComponent,
    PrestataireSecteurDetailComponent,

    AjouterBonPourListeComponent,
    AjouterBonPourAjouterComponent,
    AjouterBonPourListeDetailComponent,
    AjouterBonPourAjouterArticleComponent,

    ConsultationBonPourListeComponent,

    UniteDouaniereListeComponent,
    UniteDouaniereAjouterComponent,
    UniteDouaniereDetailComponent,


  ],
  imports: [
    BrowserModule,
    CommonModule, // ngif ngfor
    FormsModule,
    ReactiveFormsModule, // pour formGroup
    BrowserAnimationsModule,
    HttpClientModule, // pour le backend

    MatTableModule, MatPaginatorModule,

    MatExpansionModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatDialogModule,

    NgToastModule,

    NgbModule,

    ComposantModule, // composant

    BureauLogistiqueMaterielModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),

  ],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS },
    {
      provide: LOCALE_ID, useValue: "fr-FR"
    },
    {
      provide : HTTP_INTERCEPTORS,
      useClass : XhrInterceptor,
      multi : true
    },
    AuthActivateRouteGuard,
  //   {
  //     provide: APP_INITIALIZER,
  //     useFactory: initializeKeycloak,
  //     multi: true,
  //     deps: [KeycloakService],
  //  },
   DatePipe,

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
