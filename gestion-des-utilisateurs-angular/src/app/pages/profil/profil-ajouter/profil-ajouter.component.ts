import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { Authority } from 'src/app/model/authority.model';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/services/notification.service';
import { SecuriteService } from 'src/app/services/securite.service';
import { AuthorityService } from 'src/app/services/authority.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-profil-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './profil-ajouter.component.html',
  styleUrl: './profil-ajouter.component.css'
})
export class ProfilAjouterComponent implements OnInit, OnDestroy{


    // ----------------------------------------------------------------------------------
    public authorities: Authority[] = [];
    public authority: Authority = new Authority();



    private subscriptions: Subscription[] = [];

    constructor(

      private authorityService: AuthorityService,
      private securiteService: SecuriteService,
      private router: Router,
      private matDialog: MatDialog,
      public dialogRef: MatDialogRef<ProfilAjouterComponent>,
      private notificationService: NotificationService,
    ) {}

    private sendNotification(type: NotificationType, message: string, titre?: string): void {
      if (message) {
        this.notificationService.showAlert(type, message, titre);
      } else {
        this.notificationService.showAlert(type, 'Une erreur s\'est produite. Veuillez réessayer.', titre);
      }
    }

    ngOnInit(): void {

    }




    // --------------------------------------------------------------------------
    private clickButton(buttonId: string): void {
      document.getElementById(buttonId)?.click();
    }

    // pour envoyer tous les formulaires
    public submitForm(): void {


      this.submitAuthorityForm();
      //  this.submitBonDeSortieForm();

      // this.popupFermer();
      // this.router.navigate(['/ajouter-article']);
    }



    // --------------------------------------------------------------------------
    // pour executer ajouterUniteDouaniere
    public submitAuthorityForm(): void {
      this.clickButton('authority-form')
    }

    public ajouterAuthority(AuthorityForm: NgForm): void {



      this.subscriptions.push(this.authorityService.ajouterAuthority(AuthorityForm.value).subscribe({
          next: (response: Authority) => {
            this.authority = response;
            console.log(this.authority);
            this.popupFermer();
            // this.sendNotification(NotificationType.SUCCESS, `Ajout réussie de ${response.ninea}`);
            this.sendNotification(NotificationType.SUCCESS, `Ajout réussi d'un profil `);

          },
          error: (errorResponse: HttpErrorResponse) => {

          }
        })
      );

    }

    // --------------------------------------------------------------------------



    ngOnDestroy(): void {
      this.subscriptions.forEach(sub => sub.unsubscribe());
    }

    popupFermer(): void {
      this.dialogRef.close();
    }

}
