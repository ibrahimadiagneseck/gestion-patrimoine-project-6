import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { DeconnexionComponent } from './pages/deconnexion/deconnexion.component';
import { UtilisateurListeComponent } from './pages/utilisateur/utilisateur-liste/utilisateur-liste.component';
import { AgentListeComponent } from './pages/agent/agent-liste/agent-liste.component';
import { UniteDouaniereListeComponent } from './pages/unite-douaniere/unite-douaniere-liste/unite-douaniere-liste.component';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { SectionsListeComponent } from './pages/sections/sections-liste/sections-liste.component';
import { SecteurActiviteListeComponent } from './pages/secteur-activite/secteur-activite-liste/secteur-activite-liste.component';
import { ProfilListeComponent } from './pages/profil/profil-liste/profil-liste.component';


const routes: Routes = [
  { path: '', redirectTo: '/connexion', pathMatch: 'full'},
  { path: 'connexion', component: ConnexionComponent},
  { path: 'accueil', component: AccueilComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'deconnexion', component: DeconnexionComponent},


  { path: 'agent-liste', component: AgentListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'utilisateur-liste', component: UtilisateurListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'unite-douaniere', component: UniteDouaniereListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'prestataire', component: PrestataireSecteurListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'section', component: SectionsListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'secteur-activite', component: SecteurActiviteListeComponent, canActivate: [AuthActivateRouteGuard]},
  
  { path: 'profil', component: ProfilListeComponent, canActivate: [AuthActivateRouteGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
