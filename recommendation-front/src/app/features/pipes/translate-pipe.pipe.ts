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
        this.translations.set("FootballArticle", "Fudbalski artikal");
        this.translations.set("Article", "Artikal");
        this.translations.set("Ball", "Lopta");
        this.translations.set("FootbalShoe", "Fudbalske patike");
        this.translations.set("Footbal Shoe", "Fudbalska patika");
        this.translations.set("FootballGear", "Fudbalska oprema");
        this.translations.set("Football Gear", "Fudbalska oprema");
        this.translations.set("FootbalShoeCrampons", "Fudbalske patike sa kramponima");
        this.translations.set("FootbalShoeNoCrampons", "Fudbalske patike bez krampona");
        this.translations.set("GrassFootbalShoe", "Kopačke");

        this.translations.set("OrientiringArticle", "Orijentiring artikal");
        this.translations.set("Glasses", "Naočare");
        this.translations.set("Shorts", "Šorc");
        this.translations.set("Running shoes", "Patike za trčanje");
        this.translations.set("OrientiringGear", "Orijentiring oprema");
        this.translations.set("Orientiring Gear", "Orijentiring oprema");
        this.translations.set("Orientiring Shoe", "Orijentiring patike");
        this.translations.set("OrientiringShoe", "Orijentiring patike");
        this.translations.set("Sweatpants", "Trenerka");
        this.translations.set("BigCramponOrientiringShoe", "Orijentiring patike sa velikim kramponima");
        this.translations.set("NoCramponOrientiringShoe", "Orijentiring patike bez krampona");

        this.translations.set("TenisArticle", "Teniski artikal");
        this.translations.set("Tenis Article", "Teniski artikal");
        this.translations.set("Racket", "Reket");
        this.translations.set("RacketString", "Žica za reket");
        this.translations.set("Racket String", "Žica za reket");
        this.translations.set("TenisGear", "Teniska oprema");
        this.translations.set("Tenis Gear", "Teniska oprema");
        this.translations.set("TenisShoe", "Patike za tenis");
        this.translations.set("Tenis Shoe", "Patike za tenis");
        this.translations.set("Grip", "Grip");

        this.translations.set("WeightliftingArticle", "Artikal za dizanje tegova");
        this.translations.set("Barbel", "Šipka");
        this.translations.set("Dumbell", "Teg");
        this.translations.set("Dumbells", "Tegovi");
        this.translations.set("Chalk", "Kreda");
        this.translations.set("ElasticBand", "Elastična traka");
        this.translations.set("Elastic Band", "Elastična traka");
        this.translations.set("Weight", "Teg");
        this.translations.set("WeightliftingGear", "Oprema za dizanje tegova");
        this.translations.set("WeightliftingShoe", "Patike za dizanje tegova");
        this.translations.set("Weightlifting Shoes", "Patike za dizanje tegova");
        this.translations.set("WeightliftingGlove", "Rukavice za dizanje tegova");
        this.translations.set("Weightlifting Gloves", "Rukavice za dizanje tegova");
        this.translations.set("Half sweatpants", "Poludugacka trenerka");
        this.translations.set("Orientiring shoes", "Poludugacka trenerka");
        this.translations.set("Shoes", "Patike");
        this.translations.set("Gaiters", "Kamasne");
        this.translations.set("Short socks", "Kratke carape");
        this.translations.set("sock garters", "Podvezice");
        this.translations.set("Shin protector", "Kostobrani");
        this.translations.set("Leg warmers", "Stucne");
        this.translations.set("Racket string", "Zica za rekete");

    }
}
