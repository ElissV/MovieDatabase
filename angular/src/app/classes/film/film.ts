import { Genre } from '../genre/genre';

export class Film {

    filmId: number;
    name: string;
    publishingYear: number;
    description: string;
    genres: Genre[];
    imagePath: string;

}
