import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-admin-articles',
  templateUrl: './admin-articles.component.html',
  styleUrl: './admin-articles.component.css'
})
export class AdminArticlesComponent implements OnInit {
  articles: RecommendedArticle[] = []

  constructor(private router: Router, private articleService: ArticleService) { }
  
  ngOnInit(): void {
    if (localStorage.getItem('role') !== 'Admin') {
      this.router.navigate(['']);
    }
  }

}
