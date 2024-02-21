import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilListeComponent } from './profil-liste.component';

describe('ProfilListeComponent', () => {
  let component: ProfilListeComponent;
  let fixture: ComponentFixture<ProfilListeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilListeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
