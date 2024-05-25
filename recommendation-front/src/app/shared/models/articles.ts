export interface RecommendedArticle {
    id: number,
    name: string,
    price: number,
    brandName: string,
    articleType: string,
    imagePath?: string
}

export interface FullArticle {
    id: number,
    name: string,
    price: number,
    brandName: string,
    articleType?: string,
    imagePath?: string,
    articleGenderType?: ArticleGenderType,
    ratings: Rating[],
    ballType?: string,
    barbellWeight?: number,
    barbelType?: string,
    dumbellWeight?: number,
    elasticBandWeight?: number,
    typeOfFootballGear?: string,
    numberOfCramponsFootballShoeCrampons?:number,
    numberOfCramponsGrassFootballShoe?:number,
    typeOfOrientiringGear?: string,
    racketWeight?: number,
    racketType?: string,
    racketSpanning?: string,
    sweatpantsType?: string,
    typeOfTenisGear?: string,
    tenisShoeSole?: string,
    weightliftingWeight?: number,
    weightliftingTypeOfGear?: string,
    weightliftingGloveSize?: string,
}
export interface Rating{
    id?: number,
    rating: number,
    executionTime: Date
}

export enum ArticleGenderType {
    Male, Female, Unisex
}
