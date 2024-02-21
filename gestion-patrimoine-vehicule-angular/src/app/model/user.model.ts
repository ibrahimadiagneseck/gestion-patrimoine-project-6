import { Section } from "jspdf-autotable";
import { CorpsAgent } from "./corps-agent.model";
import { UniteDouaniere } from "./unite-douaniere.model";
import { Sections } from "./sections.model";
import { Authority } from "./authority.model";
import { Agent } from "./agent.model";
import { MyDate } from "./my-date.model";

export class User{

  public userName: string;
  public lastLoginDate: MyDate;
  public lastLoginDateDisplay: MyDate;
  public active: boolean;
  public notLocked: boolean;
  public pwd: string;
  public role : string;
  public joinDate: MyDate;
  public authorities: Authority[];
  public matriculeAgent: Agent;
    
  public statusCd: string;
  public statusMsg : string;
  public authStatus : string;


  constructor(userName?: string, lastLoginDate?: MyDate, lastLoginDateDisplay?: MyDate, active?: boolean, notLocked?: boolean,
    pwd?: string, role?: string, joinDate?: MyDate, authorities?: [], matriculeAgent?: Agent, statusCd?: string, statusMsg?: string, authStatus?: string,) {

        this.userName = userName || '';
        this.lastLoginDate = new MyDate();
        this.lastLoginDateDisplay = new MyDate();
        this.active = active || false;
        this.notLocked = notLocked || false;
        this.pwd = pwd || '';
        this.role = role || '';
        this.joinDate = new MyDate();
        this.authorities = [];
        this.matriculeAgent = matriculeAgent || new Agent();
  
        this.statusCd = statusCd || '';
        this.statusMsg = statusMsg || '';
        this.authStatus = authStatus || '';
  }

}
