import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

//Remember, routing lets us move components in and out of the page DYNAMICALLY
//Actions on the webpage will result in different paths, thus moving components around
//Remember, these components will be switching in and out via the <router-outlet> in app.component.html
const routes: Routes = [

  {
   path:'welcome',
   component:WelcomeComponent
  },

  {
   path:'', //the empty String makes this component appear given the base URL (on launch)
   component:WelcomeComponent //so when I go to localhost:4200, we'll get this component
  },

  {
   path:'pokedex',
   component:PokedexComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
