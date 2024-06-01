import { Component } from '@angular/core';

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
  onSportChange(event: any) {
  }
}
