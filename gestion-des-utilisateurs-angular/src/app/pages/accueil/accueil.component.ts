import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user.model';


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  user = new User();

  constructor() {
    
  }

  ngOnInit() {
    if(sessionStorage.getItem('userdetails')){
      this.user = JSON.parse(sessionStorage.getItem('userdetails') || "");
    }
  }

}
