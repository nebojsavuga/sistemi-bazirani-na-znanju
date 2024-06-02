export interface Injury{
    id: number,
    name: string,
    executionTime?: Date
}

export interface InjuryDTO{
    injury: string,
    executionTime: Date
}