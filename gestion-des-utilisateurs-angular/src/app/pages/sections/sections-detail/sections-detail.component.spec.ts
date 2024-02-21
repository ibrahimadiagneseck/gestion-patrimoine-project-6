import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SectionsDetailComponent } from './sections-detail.component';

describe('SectionsDetailComponent', () => {
  let component: SectionsDetailComponent;
  let fixture: ComponentFixture<SectionsDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SectionsDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SectionsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
