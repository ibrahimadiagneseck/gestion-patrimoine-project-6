import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { User } from '../model/user.model';

@Injectable()
export class AuthActivateRouteGuard  {
    user = null;
    
    constructor(private router: Router){

    }

    canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot) {

        if(sessionStorage.getItem('userdetails')){
            this.user = JSON.parse(sessionStorage.getItem('userdetails')!);
        }
        if(!this.user){
            this.router.navigate(['connexion']);
        }
        return this.user ? true : false;
    }

    // private isUserLoggedIn(): boolean {

    //     if (sessionStorage.getItem('Authorization')) {
    //       return true;
    //     }
    
    //     this.router.navigate(['/login']);
    //     this.notificationService.notify(NotificationType.ERROR, `You need to log in to access this page`);
    
    //     return false;
    //   }
    
}