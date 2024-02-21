import { Component, ElementRef, HostListener, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/model/user.model';
import { Observable, Subject, Subscription, debounceTime, distinctUntilChanged, of, switchMap } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { SecuriteService } from 'src/app/services/securite.service';
import { UserService } from 'src/app/services/user.service';
import jsPDF from 'jspdf';
import autoTable from 'jspdf-autotable';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthorityService } from 'src/app/services/authority.service';
import { Authority } from 'src/app/model/authority.model';
import { UtilisateurDetailComponent } from '../utilisateur-detail/utilisateur-detail.component';
import { UtilisateurAjouterComponent } from '../utilisateur-ajouter/utilisateur-ajouter.component';

@Component({
  selector: 'app-utilisateur-liste',
  // standalone: true,
  // imports: [CommonModule],
  templateUrl: './utilisateur-liste.component.html',
  styleUrl: './utilisateur-liste.component.css'
})
export class UtilisateurListeComponent implements OnInit, OnDestroy {

  public user: User = new User();
  public users: User[] = [];

  public authority: Authority = new Authority();
  public authorities: Authority[] = [];

  private subscriptions: Subscription[] = [];


  /* ----------------------------------------------------------------------------------------- */
  focusOnInput: boolean = false;

  @ViewChild('monDiv', { static: true }) monDiv: ElementRef | undefined;

  divClique(): void {
    // Code à exécuter lorsque l'élément <div> est cliqué
    // Par exemple, vous pouvez modifier une variable ou déclencher une action
    // console.log('L\'élément <div> a été cliqué !');
    this.focusOnInput = true;
  }

  @HostListener('document:click', ['$event'])
  onDocumentClick(event: Event): void {
    // Vérifie si le clic a eu lieu en dehors de l'élément monDiv
    if (!this.monDiv?.nativeElement.contains(event.target)) {
      // Code à exécuter lorsque le clic est en dehors de monDiv
      // console.log('Clic en dehors de monDiv détecté.');
      this.focusOnInput = false;
    }
  }
  /* ----------------------------------------------------------------------------------------- */
  

  /* ----------------------------------------------------------------------------------------- */
  @ViewChild('myInputSearch') myInputSearch!: ElementRef;
  // rechercher
  searchTerms = new Subject<string>();
  users$: Observable<User[]> = of();
  // recherche custom
  searchTermsFilterDoubleEmailMobile = new Subject<string>();
  termeRechercheEmailMobile: string = "";
  userFilterDoubleEmailMobile$: Observable<User[]> = of();
  /* ----------------------------------------------------------------------------------------- */


  /* ----------------------------------------------------------------------------------------- */
  // tableau
  columnsDateFormat: string[] = [
    "lastLoginDate",
    "lastLoginDateDisplay",
    "joinDate"
  ];
  columnsToHide: string[] = [
    "lastLoginDate", 
    "lastLoginDateDisplay", 
    "active", 
    "notLocked", 
    "role",  
    "joinDate"
  ];
  dataSource = new MatTableDataSource<User>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    "userName", 
    "lastLoginDate", 
    "lastLoginDateDisplay", 
    "active", 
    "notLocked", 
    "role",  
    "joinDate",
    "rowPrenomAgent",
    "rowNomAgent",
    "rowEmailAgent",
    "rowNumeroTelephoneAgent",
  ];
  displayedColumnsCustom: string[] = [
    "N° matricule", 
    "lastLoginDate", 
    "lastLoginDateDisplay", 
    "active", 
    "notLocked", 
    "role",  
    "joinDate",
    "Prénom",
    "Nom",
    "Email",
    "Téléphone",
  ];
  /* ----------------------------------------------------------------------------------------- */

  constructor(
    private router: Router,
    private userService: UserService,
    private authorityService: AuthorityService,
    private securiteService: SecuriteService,
    private matDialog: MatDialog,
  ) { }
  
  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

  ngOnInit(): void {
    this.listeUsers();

    // this.listeAuthorities();

    /* ----------------------------------------------------------------------------------------- */
    // rechercher
    this.users$ = this.searchTerms.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.userService.searchUsersList(term, this.users))
      // {.....List(ab)............List(abc)......}
    );
    this.userFilterDoubleEmailMobile$ = this.searchTermsFilterDoubleEmailMobile.pipe(
      // {...."ab"..."abz"."ab"...."abc"......}
      debounceTime(300),
      // {......"ab"...."ab"...."abc"......}
      distinctUntilChanged(),
      // {......"ab"..........."abc"......}
      switchMap((term) => this.userService.searchUserListFilterDouble(term, this.users))
      // {.....List(ab)............List(abc)......}
    );
    /* ----------------------------------------------------------------------------------------- */
  }


  generatePDF(): void {

    const data: User[] = this.dataSource.filteredData;
    // console.log(data);
    

    const months = ['JANV.', 'FÉVR.', 'MARS', 'AVR.', 'MAI', 'JUIN', 'JUIL.', 'AOÛT', 'SEPT.', 'OCT.', 'NOV.', 'DÉC.'];

    const doc = new jsPDF();

    // Créez un tableau de données pour autoTable
    const tableData = data.map((item: User) => [
      item.matriculeAgent.prenomAgent,
      item.matriculeAgent.nomAgent,
      item.matriculeAgent.emailAgent,
      item.matriculeAgent.numeroTelephoneAgent,
      // `${new Date(item.joinDate.toString()).getDate()} ${months[new Date(item.joinDate.toString()).getMonth()]} ${new Date(item.joinDate.toString()).getFullYear() % 100}`,
      // item.joinDate
    ]);

    // Configuration pour le PDF avec une taille de page personnalisée
 
    const marginLeft = 10;
    const marginTop = 10;
    const marginRight = 10;
    const marginBottom = 10;

    // Générer le tableau dans le PDF avec des styles de texte personnalisés
    autoTable(doc, {
      head: [
        [
          { content: 'Prenom', styles: { fontSize: 6 } },
          { content: 'Nom', styles: { fontSize: 6 } },
          { content: 'Email', styles: { fontSize: 6 } },
          { content: 'Téléphone', styles: { fontSize: 6 } },
          // { content: 'Date join', styles: { fontSize: 6 } }
        ]
      ],
      body: tableData.map(row => row.map(cell => ({ content: cell.toString(), styles: { fontSize: 6 } }))),
      margin: { top: marginTop, right: marginRight, bottom: marginBottom, left: marginLeft },
      theme: 'plain'
    });

    doc.save('utilisateur-liste.pdf');
  }


  search(term: string): void {
    this.termeRechercheEmailMobile = term;
    this.searchTerms.next(term);
    this.searchTermsFilterDoubleEmailMobile.next(term);
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


  FilterDoubleEmailMobile(termeRechercheEmailMobile: string) {
    this.termeRechercheEmailMobile = termeRechercheEmailMobile;
    this.myInputSearch.nativeElement.value = termeRechercheEmailMobile;
    this.dataSource.filter = termeRechercheEmailMobile.trim().toLowerCase(); // supprimer les espaces vide et mettre minuscule
    this.focusOnInput = false;
  }


  isNumber(termeRechercheEmailMobile: string): boolean {
    return !isNaN(Number(termeRechercheEmailMobile))
  }



  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  public listeUsers(): void {

    const subscription = this.userService.listeUsers().subscribe({
      next: (response: User[]) => {
        this.users = response;
        console.log(this.users);
        

        this.dataSource = new MatTableDataSource<User>(this.users.map((item) => ({
          ...item,
          rowPrenomAgent: item.matriculeAgent.prenomAgent,
          rowNomAgent: item.matriculeAgent.nomAgent,
          rowEmailAgent: item.matriculeAgent.emailAgent,
          rowNumeroTelephoneAgent: item.matriculeAgent.numeroTelephoneAgent,

          // raisonSociale: item.identifiantBL.ninea ? item.identifiantBL.ninea.raisonSociale : '---',
          // rowNombreArticleBonPour: this.nombreArticleBonEntree(item, this.articleBonPours)
        })).sort((a, b) => a.rowNomAgent.localeCompare(b.rowNomAgent)));
    
        // console.log(this.dataSource.data);
        this.dataSource.paginator = this.paginator;
      },
      error: (errorResponse: HttpErrorResponse) => {
        // console.log(errorResponse);
      },
    });

    this.subscriptions.push(subscription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
  // ---------------------------------------------------------------------------------------------------------------------
  

  popupAjouterUser(): void {
    const dialogRef = this.matDialog.open(
      UtilisateurAjouterComponent,
      {
        width: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms'
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }
  

  goToDetail(user: User): void {
    const dialogRef = this.matDialog.open(
      UtilisateurDetailComponent,
      {
        width: '80%',
        enterAnimationDuration: '100ms',
        exitAnimationDuration: '100ms',
        data: user
      }
    );

    dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }




}