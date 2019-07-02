import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private projectsUrl: string ='http://localhost:8080/api/projects'

  constructor(private http: HttpClient) { }

  findAll(): Observable<Project[]>{
    return this.http.get<Project[]>(this.projectsUrl);
  }

  findById(id: number): Observable<Project>{
    return this.http.get<Project>(this.projectsUrl+ '/' + id);
  }

  saveProject(project: Project): Observable<Project>{
    return this.http.post<Project>(this.projectsUrl, project);
  }

}
