import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InfoProjectComponent } from './info-project/info-project.component';
import { DeleteProjectComponent } from './delete-project/delete-project.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { ProposerProjectComponent } from './proposer-project/proposer-project.component';
import { SearchByCategorieComponent } from './search-by-categorie/search-by-categorie.component';
import { SearchByTitleComponent } from './search-by-title/search-by-title.component';
import { UpdateProjectComponent } from './update-project/update-project.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    InfoProjectComponent,
    DeleteProjectComponent,
    InscriptionComponent,
    LoginComponent,
    ProposerProjectComponent,
    SearchByCategorieComponent,
    SearchByTitleComponent,
    UpdateProjectComponent,
    UpdateUserComponent,
    UserComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
