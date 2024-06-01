import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { ArticleService } from '../../core/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FullArticle } from '../../shared/models/articles';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../core/services/authentication.service';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrl: './edit-article.component.css'
})
export class EditArticleComponent implements OnInit {

  id: number | undefined;
  article: FullArticle;
  articleForm: FormGroup;
  imageBase64: string | ArrayBuffer | null;
  hasError: boolean = false;
  successfullyRegistered = false;
  successMessage: string = '';
  errorValue: string = '';
  @ViewChild('articleImage', { static: false }) articleImage: ElementRef;
  @ViewChild('fileInput') fileInput: ElementRef<HTMLInputElement>;
  fieldsNotToTransform = ['articleGenderType', 'ballType', 'barbellWeight', 'barbelType', 'dumbellWeight', 'elasticBandWeight', 'typeOfFootballGear', 'numberOfCramponsFootballShoeCrampons', 'numberOfCramponsGrassFootballShoe', 'typeOfOrientiringGear', 'racketWeight', 'racketType', 'racketSpanning', 'sweatpantsType', 'typeOfTenisGear', 'tenisShoeSole', 'weightliftingWeight', 'weightliftingTypeOfGear', 'weightliftingGloveSize', 'racketSize'];

  constructor(private articleService: ArticleService, private route: ActivatedRoute,
    private authService: AuthenticationService,
    private renderer: Renderer2,
    private router: Router) { }

  ngOnInit(): void {
    this.initForm();
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
    });

    if (this.id) {
      this.articleService.getById(this.id).subscribe(
        res => {
          this.article = res;
          this.articleForm.patchValue(this.article);
          this.authService.getPicture('images/' + this.article.imagePath).subscribe(result => {
            this.convertBlobToBase64(result).then(base64 => {
              this.imageBase64 = base64;
            });
          });
        }
      )
    }
  }

  initForm() {
    this.articleForm = new FormGroup({
      id: new FormControl(null, [Validators.required]),
      name: new FormControl('', [Validators.required, Validators.minLength(1)]),
      price: new FormControl('', [Validators.required, Validators.min(1), Validators.max(5000)]),
      brandName: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      articleType: new FormControl('', []),
      articleGenderType: new FormControl('', []),
      ballType: new FormControl('', []),
      barbellWeight: new FormControl('', []),
      barbelType: new FormControl('', []),
      dumbellWeight: new FormControl('', []),
      elasticBandWeight: new FormControl('', []),
      typeOfFootballGear: new FormControl('', []),
      numberOfCramponsFootballShoeCrampons: new FormControl('', []),
      numberOfCramponsGrassFootballShoe: new FormControl('', []),
      typeOfOrientiringGear: new FormControl('', []),
      racketWeight: new FormControl('', []),
      racketType: new FormControl('', []),
      racketSpanning: new FormControl('', []),
      sweatpantsType: new FormControl('', []),
      typeOfTenisGear: new FormControl('', []),
      tenisShoeSole: new FormControl('', []),
      weightliftingWeight: new FormControl('', []),
      weightliftingTypeOfGear: new FormControl('', []),
      weightliftingGloveSize: new FormControl('', []),
      racketSize: new FormControl('', [])
    });
  }

  convertBlobToBase64(blob: Blob): Promise<string | ArrayBuffer | null> {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onloadend = () => resolve(reader.result);
      reader.onerror = reject;
      reader.readAsDataURL(blob);
    });
  }

  onSubmit() {
    if (this.articleForm.valid) {
      const updatedArticle = this.articleForm.value as FullArticle;
      // Add IMAGE LOGIC
      console.log(updatedArticle);
    }
  }

  onFileChange(event: Event) {
    const target = event.target as HTMLInputElement;
    if (target.files && target.files[0]) {
      const file = target.files[0];
      if (!(file.type.includes('image/jpeg') || file.type.includes('image/png'))) {
        this.hasError = true;
        this.errorValue = 'You can only upload JPG or PNG files.';
        return;
      }
      this.hasError = false;
      this.errorValue = '';

      const reader = new FileReader();
      reader.onload = () => {
        this.imageBase64 = reader.result;
        this.articleForm.patchValue({ image: reader.result });
      };
      reader.readAsDataURL(file);
    }
  }
}
