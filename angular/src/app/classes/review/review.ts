import { Film } from '../film/film';
import { ReviewType } from '../review-type/review-type';

export class Review {

    reviewId: number;
    film: Film;
    reviewType: ReviewType;
    text: string;

}
