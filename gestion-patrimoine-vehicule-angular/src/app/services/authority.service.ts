import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CustomHttpRespone } from '../model/custom-http-response.model';
import { Authority } from '../model/authority.model';



@Injectable({
  providedIn: 'root'
})
export class AuthorityService {

  private urlServeur = environment.rooturl1;

  constructor(private httpClient: HttpClient) {}

  // RECHERCHER Authority SANS DOUBLONS
 public searchAuthorityListFilterDouble(term: string, listeAuthority: Authority[]): Observable<Authority[]> {

  if (term.length <= 1) {
    return of([]);
  }

  // Filtrer la liste d' authorities en fonction du terme de recherche
  const filteredAuthority: Authority[] = listeAuthority.filter((authority) =>
  authority.code.toString().includes(term.toLowerCase()) || authority.name.toLowerCase().includes(term.toLowerCase())
  );

  // Utilisation de la méthode filter() pour éliminer les doublons
  const filteredAuthority1: Authority[] = filteredAuthority.filter((item, index, self) =>
    index === self.findIndex((t) => (
      t.name === item.name || t.code === item.code
    ))
  );

  return of(filteredAuthority1);
}

// RECHERCHER UniteDouaniere
public searchAuthorityList(term: string, listeAuthority: Authority[]): Observable<Authority[]> {
  if (term.length <= 1) {
    return of([]);
  }

  // Filtrer la liste de UniteDouaniere en fonction du terme de recherche
  const filteredAuthority = listeAuthority.filter((authority) =>
    this.doesAuthorityMatchTerm(authority, term)
  );

  return of(filteredAuthority);
}

private doesAuthorityMatchTerm(authority: Authority, term: string): boolean {
  // Vérifier si le terme de recherche correspond à n'importe lequel des attributs de Authority
  const termLowerCase = term.toLowerCase();
  return (
    authority.code.toString().includes(termLowerCase) || authority.name.toLowerCase().includes(termLowerCase)
    // Ajoutez d'autres attributs à vérifier si nécessaire
  );
}



  
  public listeAuthorities(): Observable<Authority[]> {
    return this.httpClient.get<Authority[]>(`${this.urlServeur}/Authorities`, { withCredentials: true });
  }

  public ajouterAuthority(authority: Authority): Observable<Authority> {
    return this.httpClient.post<Authority>(`${this.urlServeur}/AjouterAuthority`, authority, { withCredentials: true });
  }

  public modifierAuthority(authority: Authority): Observable<Authority> {
    return this.httpClient.post<Authority>(`${this.urlServeur}/ModifierAuthority`, authority, { withCredentials: true });
  }

  public supprimerAuthorityById(authorityId: string): Observable<CustomHttpRespone> {
    return this.httpClient.delete<CustomHttpRespone>(`${this.urlServeur}/SupprimerAuthorityById/${authorityId}`, { withCredentials: true });
  }

}
