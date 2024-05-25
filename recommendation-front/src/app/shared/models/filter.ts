export interface Filter {
    gender?: string,
    height: number,
    age?: number,
    level?: string,
    injuries?: number[],
    typeOfFotballPlayer: string,
    typeOfFootball: string,
    typeOfRace: string,
    typeOfField: string,
    typeOfWeightlifting: string
}

export enum Gender {
    Musko,
    Zensko
}

export enum SportLevel {
    Rekreativac,
    Amater,
    Pro
}

export enum Sport {
    Fudbal,
    DizanjeTegova,
    Tenis,
    Orijentiring
}

export enum SportFootballPlayer {
    Golman,
    Igrac
}

export enum SportFootballType {
    Mali,
    Veliki
}

export enum SportOrientiringType {
    GradskaSprint,
    SumskaSprint,
    SumskaDuga
}

export enum SportTenisField {
    Trava,
    Beton,
    Sljaka
}

export enum SportWeightliftingType {
    Powerlifting,
    Weightlifting,
    Bodybuilding
}
