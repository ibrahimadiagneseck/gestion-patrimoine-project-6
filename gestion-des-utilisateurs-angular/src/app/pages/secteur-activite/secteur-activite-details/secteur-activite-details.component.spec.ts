import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecteurActiviteDetailsComponent } from './secteur-activite-details.component';

describe('SecteurActiviteDetailsComponent', () => {
  let component: SecteurActiviteDetailsComponent;
  let fixture: ComponentFixture<SecteurActiviteDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SecteurActiviteDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SecteurActiviteDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
