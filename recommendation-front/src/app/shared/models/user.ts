export interface User {
    id?: number,
    email: string,
    name: string,
    lastName: string,
    password: string,
    repeatPassword: string,
}

export interface UserDTO{
    id: number,
    age: number,
    height: number,
    gender: string
}

export interface UserProfileDTO {
    email: string,
    name: string,
    lastName: string,
    profilePicture: string
    profilePicturePath: string
    role: Role
}

export interface LoggedUserProfileDTO {
    email: string,
    firstName: string,
    lastName: string,
    age: number
    height: number
    gender: string
}


export interface EditUserDTO {
    name: string,
    lastName: string,
    profilePicture: string,
    typeOfImage: string,
    email?: string
}

export enum Role {
    ADMIN,
    USER
}

export interface ChangePasswordDTO {
    oldPassword: string,
    newPassword: string,
    repeatNewPassword: string
}

export interface RegisteredUser {
    id: number,
    email: string
}