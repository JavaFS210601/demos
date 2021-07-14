import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodosBannerComponent } from './components/todos-banner/todos-banner.component';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

@NgModule({
  declarations: [
    AppComponent,
    TodosBannerComponent,
    TodosHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
