import { UniteDouaniere } from "./unite-douaniere.model";
import { Sections } from "./sections.model";

export class Agent {

  public matriculeAgent: string;
  public codeAgent: string;
  public nomAgent: string;
  public prenomAgent: string;
  public numeroTelephoneAgent: number;
  public emailAgent: string;
  public codeUniteDouaniere: UniteDouaniere;
  public codeSection: Sections;


  constructor(matriculeAgent?: string, codeAgent?: string, nomAgent?: string, prenomAgent?: string, numeroTelephoneAgent?: number, emailAgent?: string, codeUniteDouaniere?: UniteDouaniere, codeSection?: Sections) {
      this.matriculeAgent = matriculeAgent || '';
      this.codeAgent = codeAgent || '';
      this.nomAgent = nomAgent || '';
      this.prenomAgent = prenomAgent || '';
      this.numeroTelephoneAgent = numeroTelephoneAgent || 0;
      this.emailAgent = emailAgent || '';
      this.codeUniteDouaniere = codeUniteDouaniere || new UniteDouaniere();
      this.codeSection = codeSection || new Sections();
  }

}
