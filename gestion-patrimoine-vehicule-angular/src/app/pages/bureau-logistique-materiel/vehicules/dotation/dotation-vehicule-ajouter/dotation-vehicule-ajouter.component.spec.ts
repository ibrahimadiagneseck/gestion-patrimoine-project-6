import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeAjouterComponent } from './dotation-vehicule-ajouter.component';

describe('DotationVehiculeAjouterComponent', () => {
  let component: DotationVehiculeAjouterComponent;
  let fixture: ComponentFixture<DotationVehiculeAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
