//You can think of the models folder in Angular like the models package in Java
//We fill it with Classes that we intend to make Objects from - like this Pokemon class
export class Pokemon {

    //All I want in this class is a constructor so we can initialize this Class with data
    //We don't need to declare variables, we can jsut create a constructor
    constructor(
        public name:string,
        public types:object[],
        public sprites:object 
    ) { }

}
