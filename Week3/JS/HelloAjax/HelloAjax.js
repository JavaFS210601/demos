//make some variables associated with the HTML table data cells to be populated
let pokenum = document.getElementById("pokenum");
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokepic = document.getElementById("pokepic");


//variable associated with our button element
let button = document.getElementById("btn");

//set event listener for button click
button.addEventListener("click", ajaxFunc);

//this function will send the user input to the server (pokeapi), and get a response back
function ajaxFunc() {

    let num = document.getElementById("userInput").value; //gather the user's input (the value)

    let xhr = new XMLHttpRequest();//initialize our XHR object (to send/receive data)

    //this nested function will execute every time the event listener fires (since readystate changes)
    xhr.onreadystatechange = function () {

        //if the response is ready && if status = OK, do this...
        if(this.readyState===4 && this.status===200){
            //take the JSON we get back, and put it into a JS variable using the .parse method
            let data = JSON.parse(xhr.responseText);
            //see method below - take our data variable and change the HTML accordingly
            renderHTML(data);
        }
    }

    //open(method, URL, async) - opens a certain resource on the web
    //append the user input (the num variable) to the base URL
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+num, true); 
    xhr.send(); //send the request to the server

}

//this function will manipulate the DOM based on the user's input & the server's response
function renderHTML(data) {

    //populate the previously empty table rows held by our elements
    pokename.innerText = data.name; //.name is the name value of the pokemon we receive 
    pokenum.innerText = data.id; //.id is the id value of the pokemon we receive
    poketype.innerText = data.types[0].type.name; //this gets the name of the pokemon's first type
    if(data.types[1]) { //if an index [1] exists (which would truthy)
        poketype.append(", " + data.types[1].type.name) //we append to poketype the second type
    }

    pokepic.setAttribute("src", data.sprites.front_shiny); //get a shiny sprite of the pokemon

}

