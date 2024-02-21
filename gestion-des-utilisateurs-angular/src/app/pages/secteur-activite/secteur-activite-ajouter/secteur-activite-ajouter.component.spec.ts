import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecteurActiviteAjouterComponent } from './secteur-activite-ajouter.component';

describe('SecteurActiviteAjouterComponent', () => {
  let component: SecteurActiviteAjouterComponent;
  let fixture: ComponentFixture<SecteurActiviteAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SecteurActiviteAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SecteurActiviteAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
