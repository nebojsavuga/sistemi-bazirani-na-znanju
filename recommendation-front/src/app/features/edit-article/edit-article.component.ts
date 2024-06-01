import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FullArticle } from '../../shared/models/articles';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrl: './edit-article.component.css'
})
export class EditArticleComponent implements OnInit {

  id: number | undefined;
  article: FullArticle;
  constructor(private articleService: ArticleService, private route: ActivatedRoute,
    private router: Router
  ) {
  
  }
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
    });
    
    if(this.id){
      this.articleService.getById(this.id).subscribe(
        res =>{
          this.article = res;
        }
      )
    }
  }

}
