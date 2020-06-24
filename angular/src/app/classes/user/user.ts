import { Role } from '../role/role';

export class User {

    public userId: number;
    public name: string;
    public roles: Role[];
    public email: string;
    public password: string;
    public avatar: string;

}
