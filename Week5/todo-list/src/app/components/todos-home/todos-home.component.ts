import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

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

}
