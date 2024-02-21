import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { User } from 'src/app/model/user.model';
import { Authority } from 'src/app/model/authority.model';
import { AuthorityService } from 'src/app/services/authority.service';
import { UserService } from 'src/app/services/user.service';
import { NotificationService } from 'src/app/services/notification.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-utilisateur-detail',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './utilisateur-detail.component.html',
  styleUrl: './utilisateur-detail.component.css'
})
export class UtilisateurDetailComponent implements OnInit, OnDestroy {

  afficherPopupDetail: boolean = true;

  public authoritiesSelect: Authority[] = [];

  public authorities: Authority[] = [];
  public authority: Authority = new Authority();

  public users: User[] = [];
  // public user: User = new User();

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<UtilisateurDetailComponent>,
    private authorityService: AuthorityService,
    private userService: UserService,
    private matDialog: MatDialog,
    private notificationService: NotificationService,
    @Inject(MAT_DIALOG_DATA) public user: User
  ) {}

  private sendNotification(type: NotificationType, message: string, titre?: string): void {
    if (message) {
      this.notificationService.showAlert(type, message, titre);
    } else {
      this.notificationService.showAlert(type, 'Une erreur s\'est produite. Veuillez réessayer.', titre);
    }
  }

  ngOnInit(): void {
    // console.log(this.prestataire);
    this.listeAuthorities();
    
  }
  

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeAuthorities(): void {

    const subscription = this.authorityService.listeAuthorities().subscribe({
      next: (response: Authority[]) => {
        this.authorities = response;
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------



  // supprimerPrestataireById(ninea: String): void {

  //   const dialogRef = this.matDialog.open(
  //     PopupConfirmationSupprimerComponent,
  //     {
  //       width: '40%',
  //       enterAnimationDuration: '100ms',
  //       exitAnimationDuration: '100ms',
  //       data: {
  //         id: ninea,
  //         categorie: "prestataire",
  //         message: "Voulez-vous supprimer ce prestataire?"
  //       }
  //     }
  //   );

  //   dialogRef.afterClosed().subscribe(() => {
  //     this.popupFermer();
  //   });
  // }

  popupFermer(): void {
    this.dialogRef.close();
  }

  popupModifier(): void {
    this.afficherPopupDetail = false;
  }

  PopupDetail(): void {
    this.afficherPopupDetail = true;
  }


  // --------------------------------------------------------------------------

  private clickButton(buttonId: string): void {
    document.getElementById(buttonId)?.click();
  }

  // pour envoyer tous les formulaires
  public submitForm(): void { 
    this.clickButton('utilisateur-form');
  }


  // --------------------------------------------------------------------------
  
  // pour executer ajouterBonEntree
  public submitUtilisateurForm(): void { 
    this.clickButton('utilisateur-form')
  }


  public modifierUtilisateur(utilisateurForm: NgForm): void {

    // SECTEUR ACTIVITE
    utilisateurForm.value.authorities = this.authoritiesSelect;

    console.log(utilisateurForm.value);
    
    this.subscriptions.push(this.userService.modifierUser(utilisateurForm.value).subscribe({
        next: (response: User) => {
          console.log(response);
          this.popupFermer();
          this.sendNotification(NotificationType.SUCCESS, `Modification réussie du utilisateur`);
        },
        error: (errorResponse: HttpErrorResponse) => {

        }
      })
    );
  }
  // --------------------------------------------------------------------------


  popupAuthorities(authorities: Authority[], user: User, authoritiesSelect?: Authority[]): void {
    // const dialogRef = this.matDialog.open(
    //   PopupSecteurActiviteComponent,
    //   {
    //     width: '80%',
    //     // height: '80%',
    //     enterAnimationDuration: '100ms',
    //     exitAnimationDuration: '100ms',
    //     data:  {
    //       authorities: authorities,
    //       prestataires: prestataires,
    //       secteurActivitesSelected: secteurActivitesSelect
    //     }
    //   }
    // );

    // dialogRef.afterClosed().subscribe(() => {
    //   // ----------------------------------
    //   // Accéder à this.secteurActivitesForm après la fermeture du popup
    //   if (dialogRef.componentInstance instanceof PopupSecteurActiviteComponent) {
    //     this.secteurActivitesSelect = dialogRef.componentInstance.secteurActivitesSelect;
    //     // console.log(this.secteurActivitesSelect);
    //     this.prestataire.secteurActivite = this.secteurActivitesSelect;
    //   }
    //   // ----------------------------------
    //   this.ngOnInit();
    // });
  }

}
