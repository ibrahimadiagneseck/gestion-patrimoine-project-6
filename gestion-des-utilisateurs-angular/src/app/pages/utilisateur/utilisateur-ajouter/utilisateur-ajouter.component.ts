import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Authority } from 'src/app/model/authority.model';
import { User } from 'src/app/model/user.model';
import { Subscription } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/services/notification.service';
import { UserService } from 'src/app/services/user.service';
import { AuthorityService } from 'src/app/services/authority.service';
import { SectionsService } from 'src/app/services/sections.service';
import { UniteDouaniere } from 'src/app/model/unite-douaniere.model';
import { UniteDouaniereService } from 'src/app/services/unite-douaniere.service';
import { NotificationType } from 'src/app/enum/notification-type.enum';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Section } from 'jspdf-autotable';
import { Sections } from 'src/app/model/sections.model';
import { AgentService } from 'src/app/services/agent.service';
import { Agent } from 'src/app/model/agent.model';
// import { CorpsAgentService } from 'src/app/services/corps-agent.service';

@Component({
  selector: 'app-utilisateur-ajouter',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './utilisateur-ajouter.component.html',
  styleUrl: './utilisateur-ajouter.component.css'
})
export class UtilisateurAjouterComponent implements OnInit, OnDestroy {

  public condition: Boolean = true;

  public uniteDouanieres: UniteDouaniere[] = [];
  public uniteDouaniere: UniteDouaniere = new UniteDouaniere();

  public sections: Sections[] = [];
  public section: Sections = new Sections();

  public authorities: Authority[] = [];
  public authority: Authority = new Authority();


  public users: User[] = [];
  public user: User = new User();

  public agents: Agent[] = [];
  public agent: Agent = new Agent();

  private subscriptions: Subscription[] = [];

  constructor(
    public dialogRef: MatDialogRef<UtilisateurAjouterComponent>,
    private authorityService: AuthorityService,
    private sectionsService: SectionsService,
    private uniteDouaniereService: UniteDouaniereService,
    // private corpsAgentService: CorpsAgentService,
    private userService: UserService,
    private agentService: AgentService,
    private matDialog: MatDialog,
    private notificationService: NotificationService,
  ) { }

  private sendNotification(type: NotificationType, message: string, titre?: string): void {
    if (message) {
      this.notificationService.showAlert(type, message, titre);
    } else {
      this.notificationService.showAlert(type, 'Une erreur s\'est produite. Veuillez réessayer.', titre);
    }
  }

  ngOnInit(): void {
    this.listeAuthorities();
    this.listeUniteDouanieres();
    this.listeSections();
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


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeUniteDouanieres(): void {

    const subscription = this.uniteDouaniereService.listeUniteDouanieres().subscribe({
      next: (response: UniteDouaniere[]) => {
        this.uniteDouanieres = response;
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------


  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeSections(): void {

    const subscription = this.sectionsService.listeSections().subscribe({
      next: (response: Sections[]) => {
        this.sections = response;
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------



  popupFermer(): void {
    this.dialogRef.close();
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

  public ajouterUtilisateur(UtilisateurForm: NgForm): void {

    this.condition = true;

    this.user = new User();
    this.user = UtilisateurForm.value;

    // ------------------------------------------------------------------------------------------------------
    this.subscriptions.push(this.agentService.recupererAgentById(this.user.userName).subscribe({
      next: (response: Agent) => {
        // console.log(response);
        this.agent = response;
        this.user.matriculeAgent = this.agent;

        if (!this.agent) {
          this.condition = false;
          this.sendNotification(NotificationType.ERROR, `Cet agent n'existe pas`);
        }

        // ------------------------------------------------------------------------------------------------------
        this.subscriptions.push(this.userService.recupererUserByUserName(this.user.userName).subscribe({
          next: (response: User) => {
            // console.log(response);
            // this.user = response;
            if (response) {
              this.condition = false;
              this.sendNotification(NotificationType.ERROR, `Cet utilisateur existe déjà`);
            }

            // ------------------------------------------------------------------------------------------------------
            if (this.condition) {
              this.user.authorities = [UtilisateurForm.value.authorities];
              
              console.log(this.user);

              // pas sa place
              setTimeout(() => {
                this.popupFermer();
                this.sendNotification(NotificationType.SUCCESS, `Ajout réussi du utilisateur`);
              }, 2500);

              this.subscriptions.push(this.userService.ajouterUser(this.user).subscribe({
                next: (response: User) => {
                  // console.log(response);
                  // this.popupFermer();
                  // this.sendNotification(NotificationType.SUCCESS, `Ajout réussi du utilisateur`);
                },
                error: (errorResponse: HttpErrorResponse) => {
          
                }
              }));
            }
          },
          error: (errorResponse: HttpErrorResponse) => {

          }
        }));

        

      
      },
      error: (errorResponse: HttpErrorResponse) => {

      }
    }));

  }



  // --------------------------------------------------------------------------



  // onSubmit(): void {
  //   // console.log(this.vehiculeForm.value);
  //   // this.AjouterVehicule();
  // }

}
