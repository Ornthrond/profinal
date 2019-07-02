import { Categorie } from './categorie';
import { Contribution } from './contribution';
import { User } from './user';
import { News } from './news';
import { Don } from './don';

export class Project {
    id: number;
    titre: string;
    description: string;
    montantSouhait: number;
    montantRecu: number;
    img: string;
    categorie: Categorie;
    contrepartie: Contribution[];
    user: User;
    contributeur: User[];
    news: News[];
    dons: Don[]
}
