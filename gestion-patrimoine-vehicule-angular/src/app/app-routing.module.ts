import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './pages/connexion/connexion.component';
import { ErreurComponent } from './pages/erreur/erreur.component';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { PrestataireSecteurListeComponent } from './pages/prestataire/prestataire-secteur-liste/prestataire-secteur-liste.component';
import { ReceptionVehiculeListeComponent } from './pages/bureau-logistique-materiel/vehicules/reception/reception-vehicule-liste/reception-vehicule-liste.component';
import { ConsultationVehiculeListeComponent } from './pages/bureau-logistique-materiel/vehicules/consultation/consultation-vehicule-liste/consultation-vehicule-liste.component';
import { ReceptionVehiculeDetailComponent } from './pages/bureau-logistique-materiel/vehicules/reception/reception-vehicule-detail/reception-vehicule-detail.component';
import { AjouterBonPourListeComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-liste/ajouter-bon-pour-liste.component';
import { AjouterBonPourListeDetailComponent } from './pages/bon-pour/ajouter/ajouter-bon-pour-liste-detail/ajouter-bon-pour-liste-detail.component';
import { ConsultationBonPourListeComponent } from './pages/bon-pour/consultation/consultation-bon-pour-liste/consultation-bon-pour-liste.component';
import { UniteDouaniere } from './model/unite-douaniere.model';
import { UniteDouaniereListeComponent } from './pages/unite-douaniere/unite-douaniere-liste/unite-douaniere-liste.component';
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard';
import { DeconnexionComponent } from './pages/deconnexion/deconnexion.component';

const routes: Routes = [

  { path: '', redirectTo: '/connexion', pathMatch: 'full'},
  { path: 'connexion', component: ConnexionComponent},
  { path: 'accueil', component: AccueilComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'deconnexion', component: DeconnexionComponent},
  

  { path: 'prestataire', component: PrestataireSecteurListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'ajouter-bon-pour', component: AjouterBonPourListeComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'ajouter-bon-pour-detail/:identifiantBP', component: AjouterBonPourListeDetailComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'consultation-bon-pour', component: ConsultationBonPourListeComponent, canActivate: [AuthActivateRouteGuard]},

  { path: 'unite-douaniere', component: UniteDouaniereListeComponent, canActivate: [AuthActivateRouteGuard]},

  

  { path: 'erreur', component: ErreurComponent },
  // { path: '**', redirectTo: 'erreur', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
