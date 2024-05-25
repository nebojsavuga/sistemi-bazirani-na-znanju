export interface User {
    id?: number,
    email: string,
    name: string,
    lastName: string,
    password: string,
    repeatPassword: string,
}

export interface UserProfileDTO {
    email: string,
    name: string,
    lastName: string,
    profilePicture: string
    profilePicturePath: string
    role: Role
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