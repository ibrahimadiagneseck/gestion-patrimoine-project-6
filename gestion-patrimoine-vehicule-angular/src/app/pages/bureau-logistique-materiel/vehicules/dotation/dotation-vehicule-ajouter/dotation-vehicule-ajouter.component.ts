import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dotation-vehicule-ajouter',
  // standalone: true,
  // imports: [],
  templateUrl: './dotation-vehicule-ajouter.component.html',
  styleUrl: './dotation-vehicule-ajouter.component.css'
})
export class DotationVehiculeAjouterComponent {


  constructor(
    public dialogRef: MatDialogRef<DotationVehiculeAjouterComponent>,
    // @Inject(MAT_DIALOG_DATA) public section: Sections,
    // private matDialog: MatDialog,
    // private sectionsService: SectionsService,
    // private notificationService: NotificationService,

  ) {}

  popupFermer(): void {
    this.dialogRef.close();
  }



}
