import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DynamicComponentComponent } from './components/dynamic-component/dynamic-component.component';

//This is the dynamic way to display components! ROUTING!!!
//We use routing to move components in and out of the page
//For this basic demo, we have to manually append /dynamic to our URL to display it
//But, in the future, we'll use our webpage logic to move components around
const routes: Routes = [

{
  path:"dynamic", //the endpoint "dynamic" will display the component below
  component: DynamicComponentComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
