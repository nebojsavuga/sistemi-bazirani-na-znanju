import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'translate' })
export class TranslationPipe implements PipeTransform {
    translations: Map<string, string> = new Map();
    constructor() {
        this.initializeTranslations();
    }

    transform(value: string): string {
        return this.translations.get(value) || value;
    }

    initializeTranslations(): void {
        this.translations.set("Musko", "Male");
        this.translations.set("Zensko", "Female");
        this.translations.set("Amater", "Amateur");
        this.translations.set("Rekreativac", "Recreational");
        this.translations.set("Pro", "Pro");
        this.translations.set("Povreda skocnog zgloba", "Ankle injury");
        this.translations.set("Povreda rucnog zgloba", "Wrist injury");
        this.translations.set("Povreda kolena", "Knee injury");
        this.translations.set("Povreda lakta", "Elbow injury");
        this.translations.set("Golman", "Goalkeeper");
        this.translations.set("Igrac", "Player");
        this.translations.set("Mali", "Small");
        this.translations.set("Veliki", "Big");
        this.translations.set("GradskaSprint", "City Sprint");
        this.translations.set("SumskaSprint", "Forest sprint");
        this.translations.set("SumskaDuga", "Forest long");
        this.translations.set("Trava", "Grass");
        this.translations.set("Beton", "Hard");
        this.translations.set("Sljaka", "Clay");
        this.translations.set("Powerlifting", "Powerlifting");
        this.translations.set("Weightlifting", "Weightlifting");
        this.translations.set("Bodybuilding", "Bodybuilding");
        this.translations.set("Fudbal", "Football");
        this.translations.set("Tenis", "Tenis");
        this.translations.set("DizanjeTegova", "Bodybuilding");
        this.translations.set("Orijentiring", "Orientiring");
    }
}
