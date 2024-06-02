import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreHomeComponent } from './store-home.component';

describe('StoreHomeComponent', () => {
  let component: StoreHomeComponent;
  let fixture: ComponentFixture<StoreHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StoreHomeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StoreHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
