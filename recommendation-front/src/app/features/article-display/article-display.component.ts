import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { ActivatedRoute } from '@angular/router';
import { FullArticle } from '../../shared/models/articles';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-article-display',
  templateUrl: './article-display.component.html',
  styleUrl: './article-display.component.css'
})
export class ArticleDisplayComponent implements OnInit {

  id: number;
  article: FullArticle;
  constructor(private articleService: ArticleService,
    private authService: AuthenticationService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.articleService.getById(this.id).subscribe(
      res => {
        console.log(res);
      }
    )
  }


} 
