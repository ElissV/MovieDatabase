import { Genre } from '../genre/genre';
import { Review } from '../review/review';

export class Film {

    id: number;
    name: string;
    publishingYear: number;
    description: string;
    genres: Genre[];
    filmReviews: Review[];
    imagePath: string;

}
