import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  //these variables are being referred to in our HTML page
  hiddenToggle:boolean = true;

  greeterDiv:boolean = true;

  name:string = "";

  //Creating some variables that will be the tasks on the To Do List webpage
  //These are variables that point to {objects} that represent each of our To Do tasks
  todo1 = {
    id:1,
    content:"Wake Up",
    status: "Incomplete"
  }

  todo2 = {
    id:2,
    content:"Grab a Brush",
    status: "Incomplete"
  }

  todo3 = {
    id:3,
    content:"Put a Little Makeup",
    status: "Incomplete"
  }

  todo4 = {
    id:4,
    content:"Remember the rest of the lyrics",
    status: "Incomplete"
  }

  //Make an Array filled with the above todo objects
  //We'll be calling from this Array in our HTML with String Interpolation
  //the "this" keyword just makes sure we're referring to members of this class, otherwise TS can't tell
  todosArray = [this.todo1, this.todo2, this.todo3, this.todo4];


  constructor() { }

  //on initialization, stuff in this function will run. 
  //If we want some specific stuff to happen when this component is displayed
  ngOnInit(): void {
  }

  //this function will change the status of a todo from "Incomplete" to "Complete"
  toggleStatus(id:number) {
    this.todosArray[id-1].status = "Complete";
  }

  //this function will toggle our property-bound "hiddenToggle" variable between true/false
  toggleVisibility() {
    this.hiddenToggle = !this.hiddenToggle 
    //change the value of the "hiddenToggle" variable to the opposite of what it is
  }

  //when the user submits their name, it will hide the div that asks for the name 
  //(by making the greeterDiv variable false. Structural directives!!!)
  submitName() {
    this.greeterDiv = false;
  }

}
