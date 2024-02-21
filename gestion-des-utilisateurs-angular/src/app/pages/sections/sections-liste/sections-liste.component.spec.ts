import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionsListeComponent } from './sections-liste.component';

describe('SectionsListeComponent', () => {
  let component: SectionsListeComponent;
  let fixture: ComponentFixture<SectionsListeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SectionsListeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SectionsListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
