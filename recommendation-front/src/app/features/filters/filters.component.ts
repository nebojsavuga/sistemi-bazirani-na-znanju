import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Injury } from '../../shared/models/injury';
import { InjuryService } from '../../core/services/injury.service';
import { TokenDecoderService } from '../../core/services/token-decoder.service';
import { ArticleService } from '../../core/services/article.service';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrl: './filters.component.css'
})
export class FiltersComponent implements OnInit {

  @Output() searchFilter: EventEmitter<any> = new EventEmitter<any>();
  genders: string[] = ['Musko', 'Zensko'];
  levels: string[] = ['Amater', 'Rekreativac', 'Pro'];
  sports: string[] = ['Fudbal', 'Tenis', 'DizanjeTegova', 'Orijentiring'];
  injuries: Injury[] = [];
  typeOfFootballPlayers: string[] = ['Golman', 'Igrac'];
  sportFootballTypes: string[] = ['Mali', 'Veliki'];
  sportOrientiringTypes: string[] = ['GradskaSprint', 'SumskaSprint', 'SumskaDuga'];
  sportTenisFields: string[] = ['Trava', 'Beton', 'Sljaka'];
  sportWeightliftingTypes: string[] = ['Powerlifting', 'Weightlifting', 'Bodybuilding']
  selectedInjuries: number[] = [];
  hasError = false;
  id: number = -1;
  isLoggedIn = false;
  filterForm = new FormGroup(
    {
      sport: new FormControl('', [Validators.required]),
      height: new FormControl('', [Validators.min(90), Validators.max(300)]),
      age: new FormControl('', [Validators.min(3), Validators.max(120)]),
      level: new FormControl('', []),
      typeOfFotballPlayer: new FormControl('', []),
      typeOfFootball: new FormControl('', []),
      typeOfRace: new FormControl('', []),
      typeOfField: new FormControl('', []),
      typeOfWeightlifting: new FormControl('', []),
      gender: new FormControl('', []),
      injuries: new FormControl([])
    }
  );

  constructor(private injuryService: InjuryService,
    private authService: AuthenticationService,
    private articleService: ArticleService,
    private jwtService: TokenDecoderService
  ) { }

  ngOnInit(): void {
    if (this.authService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.id = this.jwtService.getDecodedAccesToken()['id']
    }
    this.injuryService.getAll().subscribe(
      res => {
        this.injuries = res;
        this.checkCheckboxes();
      }
    );

  }

  private checkCheckboxes() {
    setTimeout(() => {
      const filterFormValue = this.articleService.getFilterForm();
      if (filterFormValue.sport) {
        const nonUndefinedValues = Object.entries(filterFormValue)
          .filter(([key, value]) => value !== undefined)
          .reduce((obj, [key, value]) => {
            obj[key] = value;
            return obj;
          }, {});
        this.filterForm.patchValue({ ...nonUndefinedValues });
        if (!filterFormValue.injuries) {
          this.filterSubmitted();
          return;
        }
        for (let injuryId of this.injuries.map(x => x.id)) {
          if (filterFormValue.injuries.includes(injuryId)) {
            const checkbox = document.getElementById('injury_' + String(injuryId)) as HTMLInputElement;
            checkbox.checked = true;
            this.selectedInjuries.push(injuryId);
          }
        }
        this.filterSubmitted();
      }
    });
  }

  filterSubmitted() {
    this.filterForm.patchValue({
      injuries: this.selectedInjuries
    })
    if (this.filterForm.valid) {
      this.hasError = false;
      this.searchFilter.emit(this.filterForm.value);
      this.articleService.setFilterForm(this.filterForm.value);
    } else {
      this.hasError = true;

    }
  }

  onInjuryChange(event: any, injuryId: number): void {
    if (event.target.checked) {
      this.selectedInjuries.push(injuryId);
    } else {
      const index = this.selectedInjuries.indexOf(injuryId);
      if (index !== -1) {
        this.selectedInjuries.splice(index, 1);
      }
    }
  }

  prefill() {
    this.authService.getById(this.id).subscribe(
      res => {
        this.filterForm.patchValue({
          age: res.age.toString(),
          height: res.height.toString(),
          gender: res.gender
        })
      });
  }

  removeFilters() {
    this.filterForm.reset();
    this.filterForm.patchValue({
      gender: '',
      sport: '',
      level: '',
      typeOfField: '',
      typeOfFootball: '',
      typeOfFotballPlayer: '',
      typeOfRace: '',
      typeOfWeightlifting: ''
    })
  }
}
