const url = 'http://localhost:8080/P1Demo/' //I grabbed this base URL from postman
//it's also what shows up when you run as server and get your 404 page
//Eventually, we'll use this base URL and make calls to the server by adding endpoints to it

//add functionality to our button using an event listener
document.getElementById('getAvengerButton').addEventListener('click', assembleFunc);
//so when this button gets clicked, the function called assembleFunc will run
//we could have used: document.getElementById('getAvengerButton').onClick(assembleFunc);

//this function will get all avengers from our Java server
async function assembleFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    //await wmakes the async functions wait until the promise returns with the fetched data
    let response = await fetch(url + 'avengers');

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        //now, I want to put each avenger into my table
        for(let avenger of data) { //for every avenger in the data variable/object

            console.log(avenger); //just for debug, print the avenger in the console

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = avenger.av_id; //fill the cell with avenger data
            row.appendChild(cell) //this row now has the first cell (av_id)

            //the we'll do this^ for each field in the avenger model



            
            document.getElementById("avengerBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }







    }

}




