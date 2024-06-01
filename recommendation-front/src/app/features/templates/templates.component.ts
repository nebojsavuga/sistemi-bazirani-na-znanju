import { Component } from '@angular/core';
import { RecomendationService } from '../../core/services/recomendation.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html',
  styleUrl: './templates.component.css'
})
export class TemplatesComponent {
  sports: string[] = ['Fudbal', 'Tenis'];
  selectedSport: string = '0';
  brands: string[] = [
    "Wilson",
    "Icebug",
    "Silva",
    "Balega",
    "Vapro",
    "Trimtex",
    "Suunto",
    "SportIdent",
    "Nike",
    "Babolat",
    "Luxilon",
    "Joga",
    "Picador",
    "INOV8",
    "Head",
    "Puma",
    "Cyberfit",
    "Pulse fitness",
    "Fitness power",
    "Decathlon",
    "Sveltus",
    "Y&Y",
    "Black diamond",
    "Power system",
    "erima",
    "Erima",
    "GYMSTICK",
    "SBD",
    "Gorilla",
    "Power Gym",
    "BOOMFIT",
    "Mirafit",
    "Strength"
  ];
  selectedBrands: string[] = [];
  selectedPrices: string[] = [];
  fields: { brand: string, price: number }[] = [];

  constructor(private recomendationService: RecomendationService, private snackbar: SnackbarService) {
  }

  onSportChange(event: any) {
    this.fields = [];
  }

  addField() {
    this.fields.push({ brand: '', price: 0 });
  }
  removeField(index: number) {
    this.fields.splice(index, 1);
  }

  saveRule() {
    const transformedData = {
      brandNames: this.fields.map(item => [item.brand, item.price.toFixed(2).toString()])
    };
    this.recomendationService.generateTemplate(transformedData, this.selectedSport).subscribe(
      {
        next: _ =>{
          this.snackbar.showSnackBar('Uspešno ste generisali nova pravila.', 'Ok.');
        },
        error: _ =>{
          this.snackbar.showSnackBar('Došlo je do greške prilikom generisanja pravila.', 'Ok');
        }
      }
    )
  }
}
