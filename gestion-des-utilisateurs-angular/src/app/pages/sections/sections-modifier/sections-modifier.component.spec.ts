import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionsModifierComponent } from './sections-modifier.component';

describe('SectionsModifierComponent', () => {
  let component: SectionsModifierComponent;
  let fixture: ComponentFixture<SectionsModifierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SectionsModifierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SectionsModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
