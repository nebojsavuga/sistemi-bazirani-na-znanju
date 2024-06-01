import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecommendedArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-admin-articles',
  templateUrl: './admin-articles.component.html',
  styleUrl: './admin-articles.component.css'
})
export class AdminArticlesComponent implements OnInit {
  articles: RecommendedArticle[] = [];
  totalArticles: RecommendedArticle[] = [];
  disableShowMore = false;
  sliceIndex = 0;
  constructor(private router: Router, private articleService: ArticleService,
    private snackBarService: SnackbarService
  ) { }

  ngOnInit(): void {
    if (localStorage.getItem('role') !== 'Admin') {
      this.router.navigate(['']);
    }

    this.getAll();
  }

  private getAll() {
    this.articleService.getAll().subscribe(
      res => {
        this.articles = res;
        this.totalArticles = this.articles.slice(0, 8 * (this.sliceIndex + 1));
      }
    );
  }

  showMore() {
    this.sliceIndex += 1;
    this.disableShowMore = false;
    if (this.totalArticles.length >= this.articles.length) {
      this.disableShowMore = true;
    }
    this.totalArticles = this.articles.slice(0, 8 * (this.sliceIndex + 1));
  }

  editArticle(id: number) {
    this.router.navigate(['edit-article'], { queryParams: { id: id } });
  }
  add() {
    this.router.navigate(['edit-article']);
  }
}
