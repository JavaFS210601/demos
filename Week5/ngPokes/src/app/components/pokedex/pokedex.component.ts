import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit { 

  //this is the input variable referred to by the two-way binding in HTML (user input goes in here)
  public input:number = 0; 

  //pokemon type object to hold the Pokemon that gets returned as an observable after the HTTP request
  public pokemon:any = null; //we'll make the pokemon variable type any so that we can leave it null 
  //(but it will be a Pokemon object)

  //constructor injection of PokemonService, so that we can use the fancy function we wrote in it 
  constructor(private ps:PokemonService) { }

  ngOnInit(): void { //OnInit is part of the lifecycle, so the constructor runs, then anything in here runs
  }

  //This is the function that gets our Pokemon object, given a user input
  //This function utilizes the getPokeFromApi function in PokemonService
  //Thus, it will return an Observable. We need to SUBSCRIBE to the observable to get its data/message
        //"We subscribe to observables to get their messages (data)"
  getPoke():void {
    //getPokemonFromApi returns an Observable, so we are going to subscribe to it to see its data
    this.ps.getPokemonFromApi(this.input).subscribe(
      //we turn the data we get into a Pokemon object, then assign to our pokemon variable above
      //this happens if things go right...
      (data:Pokemon) => { this.pokemon=data; }, 
      //if things go wrong... set the pokemon variable = null, since we didn't get any data back
      () => {
        this.pokemon = null;
        console.log("Something went wrong catching your pokemon!!!")
      }
    )
  }

}
