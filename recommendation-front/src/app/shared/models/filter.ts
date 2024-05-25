export interface Filter {
    gender?: Gender,
    height: number,
    age?: number,
    level?: SportLevel,
    injuries?: number[],
    typeOfFotballPlayer: SportFootballPlayer,
    typeOfFootball: SportFootballType,
    typeOfRace: SportOrientiringType,
    typeOfField: SportTenisField,
    typeOfWeightlifting: SportWeightliftingType
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
