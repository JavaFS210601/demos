import { Component, OnInit } from '@angular/core';

//this is a TS decorator, like an annotation in Java
@Component({
  //the selector is the string you use to "select" this component
  selector: 'app-new-component',
  //the templateUrl specifies the HTML file assocaited with the component
  templateUrl: './new-component.component.html',
  //the styleUrls specifies CSS sheets associated with the component
  styleUrls: ['./new-component.component.css']
})
//this is just our class declaration, implements OnInit which gives us the ngOnInit
export class NewComponentComponent implements OnInit {

  //Constructors are declared with the constructor keyword
  constructor() { }

  //on initialization, this stuff runs.
  ngOnInit(): void {
  }

}
