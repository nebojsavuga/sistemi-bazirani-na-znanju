import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AuthenticationService } from '../../core/services/authentication.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Injury } from '../../shared/models/injury';
import { InjuryService } from '../../core/services/injury.service';

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

  constructor(private injuryService: InjuryService
  ) { }

  ngOnInit(): void {

    this.injuryService.getAll().subscribe(
      res => {
        this.injuries = res;
      }
    )

  }

  filterSubmitted() {
    this.filterForm.patchValue({
      injuries: this.selectedInjuries
    })
    if (this.filterForm.valid) {
      this.hasError = false;
      this.searchFilter.emit(this.filterForm.value);
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
}
