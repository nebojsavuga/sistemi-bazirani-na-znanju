import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticlesTypeDisplayComponent } from './articles-type-display.component';

describe('ArticlesTypeDisplayComponent', () => {
  let component: ArticlesTypeDisplayComponent;
  let fixture: ComponentFixture<ArticlesTypeDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ArticlesTypeDisplayComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArticlesTypeDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
