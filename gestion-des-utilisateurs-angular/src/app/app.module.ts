import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClientXsrfModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { XhrInterceptor } from './interceptors/app.request.interceptor';
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard';
import { DeconnexionComponent } from './pages/deconnexion/deconnexion.component';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { ComposantModule } from './composants/composant.module';
import { NgToastModule } from 'ng-angular-popup';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UtilisateurListeComponent } from './pages/utilisateur/utilisateur-liste/utilisateur-liste.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { UtilisateurAjouterComponent } from './pages/utilisateur/utilisateur-ajouter/utilisateur-ajouter.component';
import { UtilisateurDetailComponent } from './pages/utilisateur/utilisateur-detail/utilisateur-detail.component';
import { AgentListeComponent } from './pages/agent/agent-liste/agent-liste.component';
import { AgentAjouterComponent } from './pages/agent/agent-ajouter/agent-ajouter.component';
import { AgentDetailComponent } from './pages/agent/agent-detail/agent-detail.component';
import { UniteDouaniereListeComponent } from './pages/unite-douaniere/unite-douaniere-liste/unite-douaniere-liste.component';
import { UniteDouaniereAjouterComponent } from './pages/unite-douaniere/unite-douaniere-ajouter/unite-douaniere-ajouter.component';
import { UniteDouaniereDetailComponent } from './pages/unite-douaniere/unite-douaniere-detail/unite-douaniere-detail.component';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { PrestataireSecteurAjouterComponent } from './pages/prestataire/prestataire-secteur-ajouter/prestataire-secteur-ajouter.component';
import { PrestataireSecteurDetailComponent } from './pages/prestataire/prestataire-secteur-detail/prestataire-secteur-detail.component';
import { SectionsListeComponent } from './pages/sections/sections-liste/sections-liste.component';
import { SectionsAjouterComponent } from './pages/sections/sections-ajouter/sections-ajouter.component';
import { SectionsDetailComponent } from './pages/sections/sections-detail/sections-detail.component';
import { SectionsModifierComponent } from './pages/sections/sections-modifier/sections-modifier.component';
import { SecteurActiviteListeComponent } from './pages/secteur-activite/secteur-activite-liste/secteur-activite-liste.component';
import { SecteurActiviteAjouterComponent } from './pages/secteur-activite/secteur-activite-ajouter/secteur-activite-ajouter.component';
import { SecteurActiviteDetailsComponent } from './pages/secteur-activite/secteur-activite-details/secteur-activite-details.component';
import { ProfilListeComponent } from './pages/profil/profil-liste/profil-liste.component';
import { ProfilAjouterComponent } from './pages/profil/profil-ajouter/profil-ajouter.component';
import { ProfilDetailComponent } from './pages/profil/profil-detail/profil-detail.component';



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

    AgentListeComponent,
    AgentAjouterComponent,
    AgentDetailComponent,

    UtilisateurListeComponent,
    UtilisateurAjouterComponent,
    UtilisateurDetailComponent,

    UniteDouaniereListeComponent,
    UniteDouaniereAjouterComponent,
    UniteDouaniereDetailComponent,

    PrestataireSecteurListeComponent,
    PrestataireSecteurAjouterComponent,
    PrestataireSecteurDetailComponent,

    SectionsListeComponent,
    SectionsAjouterComponent,
    SectionsDetailComponent,
    SectionsModifierComponent,

    SecteurActiviteListeComponent,
    SecteurActiviteAjouterComponent,
    SecteurActiviteDetailsComponent,

    ProfilListeComponent,
    ProfilAjouterComponent,
    ProfilDetailComponent
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

    ComposantModule, // composant

    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'XSRF-TOKEN',
      headerName: 'X-XSRF-TOKEN',
    }),
  ],
  providers: [
    { provide: MY_DATE_FORMATS, useValue: MY_DATE_FORMATS },
    {
      provide : HTTP_INTERCEPTORS,
      useClass : XhrInterceptor,
      multi : true
    },
    AuthActivateRouteGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
