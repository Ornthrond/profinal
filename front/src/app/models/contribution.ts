import { Project } from './project';
import { User } from './user';

export class Contribution {
    id: number;
    titre: string;
    description: string;
    montant: number;
    nombre: number;
    project: Project;
    user: User[];
}
