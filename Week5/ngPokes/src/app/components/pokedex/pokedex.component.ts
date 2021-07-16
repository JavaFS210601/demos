import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';


@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit { 

  //this is the input variable referred to by the two-way binding in HTML
  public input:number = 0; 

  //pokemon type object to hold the Pokemon that gets returned as an observable after the HTTP request
  public pokemon:any = null; //we're the pokemon variable type any so that we can leave it null 
  //(but it will be a Pokemon object)

  constructor() { }

  ngOnInit(): void { //OnInit is part of the lifecycle, so the constructor runs, then anything in here runs
  }

  //GETPOKE FUNCTION GOES HERE
  

}
