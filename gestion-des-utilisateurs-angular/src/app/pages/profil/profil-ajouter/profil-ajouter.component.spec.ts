import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilAjouterComponent } from './profil-ajouter.component';

describe('ProfilAjouterComponent', () => {
  let component: ProfilAjouterComponent;
  let fixture: ComponentFixture<ProfilAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
