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
    price: string,
    brandName: string,
    articleType?: string,
    imagePath?: string,
    articleGenderType?: string,
    ratings: ArticleRatingDTO[],
    ballType?: string,
    barbellWeight?: string,
    barbelType?: string,
    dumbellWeight?: string,
    elasticBandWeight?: string,
    typeOfFootballGear?: string,
    numberOfCramponsFootballShoeCrampons?: string,
    numberOfCramponsGrassFootballShoe?: string,
    typeOfOrientiringGear?: string,
    racketWeight?: string,
    racketType?: string,
    racketSpanning?: string,
    sweatpantsType?: string,
    typeOfTenisGear?: string,
    tenisShoeSole?: string,
    weightliftingWeight?: string,
    weightliftingTypeOfGear?: string,
    weightliftingGloveSize?: string,
    racketSize?: string
}

export interface ArticleRatingDTO {
    id?: number,
    rating: number,
    executionTime: Date
}

export enum ArticleGenderType {
    Male, Female, Unisex
}
