import { Genre } from '../genre/genre';

export class Film {

    filmId: number;
    name: string;
    publishingYear: number;
    genres: Genre[];
    imagePath: string;

}
