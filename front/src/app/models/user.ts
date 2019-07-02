import { Project } from './project';
import { Contribution } from './contribution';
import { Don } from './don';

export class User {
    id: number;
    nom: string;
    prenom: string;
    username: string;
    password: string;
    email: string;
    description: string;
    avatar: string;

    projects: Project[];
    project_contri: Project[];
    contributions: Contribution[];
    dons: Don[];

}
