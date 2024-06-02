import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingArticleComponent } from './rating-article.component';

describe('RatingArticleComponent', () => {
  let component: RatingArticleComponent;
  let fixture: ComponentFixture<RatingArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RatingArticleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RatingArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
