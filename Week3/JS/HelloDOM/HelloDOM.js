console.log("==============================(DOM Selection/Manipulation)");

//DOM selection---------------------------------------------

//I want all my divs with the classname of coolClassName
//create a variable with the value of an arry of all of the elements if the given class name
let divElements = document.getElementsByClassName("coolClassName");

console.log(typeof divElements); //object - Arrays are a subtype of object

console.log(divElements); //print out the Array of elements

//We can also access certain elements in the Array object
let firstDiv = divElements[0];
console.log(firstDiv); //the contents of firstDiv will print out!

//DOM manipulation---------------------------------------------

//we can set attributes of elements, though it's not always best practice
//styling wise, there's an actual object that you can set the properties of for every element (the style object)
firstDiv.setAttribute("style", "background-color:pink");



console.log("==================================(events)");

//let's create a variable that's assigned to our HTML button
let myButton = document.getElementById("b1"); //using DOM selection to select this button element

//event listener to listen for button clicks
myButton.onclick = domFunc; //every time this button gets clicked, the function called domFunc will run


function domFunc() {

    console.log("domFunc is running!");
    document.getElementById("b1").textContent = "Thanks for clicking me!!";
    document.getElementById("p3").textContent = "Now I have CONTENT!!!!"

}



