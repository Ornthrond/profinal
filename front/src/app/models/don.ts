import { Project } from './project';
import { User } from './user';

export class Don {
    id: number;
    montant: number;
    description: string;
    date: Date;
    project: Project;
    user: User;
    
}
