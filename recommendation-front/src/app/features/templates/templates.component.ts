import { Component } from '@angular/core';
import { RecomendationService } from '../../core/services/recomendation.service';
import { SnackbarService } from '../../core/services/snackbar.service';

@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html',
  styleUrl: './templates.component.css'
})
export class TemplatesComponent {
  sports: string[] = ['Football', 'Tenis'];
  selectedSport: string = '0';
  brands: string[] = [
    "Adidas",
    "Babolat",
    "Balega",
    "Black diamond",
    "BOOMFIT",
    "Cyberfit",
    "Decathlon",
    "erima",
    "Erima",
    "Fitness power",
    "Gorilla",
    "GYMSTICK",
    "Head",
    "Icebug",
    "INOV8",
    "Joga",
    "Luxilon",
    "Mirafit",
    "Nike",
    "Picador",
    "Power Gym",
    "Power system",
    "Pulse fitness",
    "Puma",
    "Silva",
    "SBD",
    "SportIdent",
    "Strength",
    "Suunto",
    "Sveltus",
    "Trimtex",
    "Vapro",
    "Wilson",
    "Y&Y",
    "Yonex"
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
    const lastField = this.fields[this.fields.length - 1];
    if (lastField && this.fields.some((field, idx) => field.brand === lastField.brand && field.price === lastField.price && idx !== this.fields.length - 1)) {
      this.snackbar.showSnackBar('Duplicate brand and price. Enter unique values.', 'Ok');
      lastField.brand = '';
      lastField.price = 0;
    } else {
      this.fields.push({ brand: '', price: 0 });
    }
  }
  removeField(index: number) {
    this.fields.splice(index, 1);
  }

  saveRule() {
    const transformedData = {
      brandNames: this.fields.map(item => [item.brand, item.price.toFixed(2).toString()])
    };
    if(this.selectedSport === 'Football'){
      this.selectedSport = 'Fudbal';
    }
    this.recomendationService.generateTemplate(transformedData, this.selectedSport).subscribe(
      {
        next: _ => {
          this.snackbar.showSnackBar('Sucessfully generated new rules.', 'Ok.');
        },
        error: _ => {
          this.snackbar.showSnackBar('There was a mistake generating new rules.', 'Ok');
        }
      }
    )
  }
}
