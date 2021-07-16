import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; //we had to manually import this

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    PokedexComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, //gotta import the forms module if we want to use two-way binding
    HttpClientModule //we have to import this manually, it's probably too deep to Angular to find
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
