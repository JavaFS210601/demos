import { Injectable } from '@angular/core';

//Injectable decorator is inherently associated with our SERVICES
//Since we expect to inject services into models/components to give them functionality
@Injectable({
  providedIn: 'root'
})

//Remember, the Services are what give functionality to our models/components
export class PokemonService {

  //
  constructor() { }
}
