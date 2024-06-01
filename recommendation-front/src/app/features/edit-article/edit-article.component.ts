import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrl: './edit-article.component.css'
})
export class EditArticleComponent implements OnInit {

  id: number | undefined;
  constructor(private articleService: ArticleService, private route: ActivatedRoute,
    private router: Router
  ) {
  
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });

  }

}
