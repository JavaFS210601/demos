import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

//dynamically display the todos-home.component via routing!
//we want the home component (containing our tasks card) to be able to move in and out of the page
const routes: Routes = [

  {
    path: "todos", //the endpoint "todos" will display the component below
    component: TodosHomeComponent //this names the Class name of the component to display
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
