import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'translate' })
export class TranslationPipe implements PipeTransform {
    translations: Map<string, string> = new Map();
    constructor() {
        this.initializeTranslations();
    }

    initializeTranslations(): void {
        this.translations.set("FootballArticle", "Fudbalski artikal");
        this.translations.set("Article", "Artikal");
        this.translations.set("Ball", "Lopta");
        this.translations.set("FootbalShoe", "Fudbalska patika");
        this.translations.set("FootballGear", "Fudbalska oprema");
        this.translations.set("FootbalShoeCrampons", "Fudbalska patika sa kramponima");
        this.translations.set("FootbalShoeNoCrampons", "Fudbalska patika bez krampona");
        this.translations.set("GrassFootbalShoe", "Kopačke");

        this.translations.set("OrientiringArticle", "Orijentiring artikal");
        this.translations.set("OrientiringGear", "Orijentiring oprema");
        this.translations.set("OrientiringShoe", "Orijentiring patika");
        this.translations.set("Sweatpants", "Trenerka");
        this.translations.set("BigCramponOrientiringShoe", "Orijentiring patika sa velikim kramponima");
        this.translations.set("NoCramponOrientiringShoe", "Orijentiring patika bez krampona");

        this.translations.set("TenisArticle", "Teniski artikal");
        this.translations.set("Racket", "Reket");
        this.translations.set("RacketString", "Žica za reket");
        this.translations.set("TenisGear", "Teniska oprema");
        this.translations.set("TenisShoe", "Patike za tenis");
        this.translations.set("Grip", "Grip");

        this.translations.set("WeightliftingArticle", "Artikal za dizanje tegova");
        this.translations.set("Barbel", "Šipka");
        this.translations.set("Dumbell", "Teg");
        this.translations.set("ElasticBand", "Elastična traka");
        this.translations.set("Weight", "Teg");
        this.translations.set("WeightliftingGear", "Oprema za dizanje tegova");
        this.translations.set("WeightliftingShoe", "Patike za dizanje tegova");
        this.translations.set("WeightliftingGlove", "Rukavice za dizanje tegova");
    }

    transform(value: string): string {
        return this.translations.get(value) || value;
    }
}
