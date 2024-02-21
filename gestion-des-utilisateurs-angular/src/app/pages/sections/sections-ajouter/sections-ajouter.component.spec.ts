import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionsAjouterComponent } from './sections-ajouter.component';

describe('SectionsAjouterComponent', () => {
  let component: SectionsAjouterComponent;
  let fixture: ComponentFixture<SectionsAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SectionsAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SectionsAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
