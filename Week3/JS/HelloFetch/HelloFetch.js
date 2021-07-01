//PokeAPI endpoint - making a variable to hold the URL. Makes our script cleaner
const api = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('btn').onclick = getData; //when user clicks the button, getData() executes
//when you call a function with an event listener, don't call a function with parenthesis

//getData will... get the data from our server (pokeapi)
//remember, async tells a function to return a Ppromise object instead of a direct value
async function getData() {

    let userInput = document.getElementById('userInput').value; //put the user input into a variable

    //we're going to use the fetch() method to return a promise object
    //remember, await pauses the async function until the promise is returned
    let response = await fetch(api+userInput) //fetch() returns a promise, we put it in a variable

    if(response.status === 200) { //if the response comes back successfully (200 = 'OK')
  
        //if you use await on the fetch() method, you need to use it on the response method too
        let data = await response.json(); //parse the reponse as JSON so JS can read it, and put it in a variable
        populateData(data); //call the function below that populates the data onto our page
    } else {
        //if the status code is anything other than 200, tell the user the request failed
        document.getElementById('data').innerHTML = 'It got away!!';
    }
}


//this function will use the JS object variable "data" to populate the data on our webpage
function populateData(data) {
    let dataSection = document.getElementById('data'); //this is our (so far) empty section tag

    let nameTag = document.createElement('h3'); //create a header elemet (DOM manipulation!)
    nameTag.innerHTML = data.name; //populating the h3 with the name of the Pokemon 

    let abilitiesArray = data.abilities; //create an array, assign the abilities to it
    //it's an array of ability objects! pokeapi has an abilities array, full of ability object

    let abilities = document.createElement('ul'); //create an unordered list to hold the abilities

    for(let oneAbility of abilitiesArray) { //for every ability in the abilitiesArray...

        let listItem = document.createElement('li'); //create a list item
        listItem.innerHTML = oneAbility.ability.name; //populate the list item with the ability name
        abilities.appendChild(listItem); //append the listItem to our abilities unorder list.

    }

    //Actually populate the section element with the data gathered from the response
    dataSection.appendChild(nameTag); //add our nameTag variable into the <section> tag of our HTML
    dataSection.innerHTML += 'Abilities<br>'; //make a subheader for the abilities
    dataSection.appendChild(abilities); //add the unorderd list that's been populated with abilties

}



