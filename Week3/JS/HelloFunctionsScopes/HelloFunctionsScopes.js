console.log("========================================(Functions)");

//This is a basic JS function.
//Note that because of hoisting, we can call the function before we declare it

helloWorld(); //this is hoisted, so it's callable before the actual declaration happens

function helloWorld() {
    console.log("HELLO WORLD!!!");
}

//subtypes of Functions below------------------------------------------------------------------

//here's an Anonymous function, it hasn't been named, but it's assigned to a variable
var anon = function () {
    console.log("I'm an anonymous function!!");
}

anon(); //using the anonymous function


//Arrow functions are pretty much like labmdas in Java (arguments => expression)
var arrow = () => {console.log("I'm in an arrow function!")};

arrow(); //using the arrow function


//Two functions to demonstrate Callback Functions - you make these when you need to call functions inside of functions
function func1(x) {
    console.log("in func1");
    console.log("x =" , x);
}

function func2(y, callback) {
    console.log("in func2");
    callback(y); //so "callback" is intended to be a function, and take y as an argument.
    helloWorld(); //this named function can work in the same way
}

//let's call func2, and pass in func1 as the "callback" argument
func2(9, func1);


//Finally let's look at a closure - it's a way to acheive encapsulation in JS

//these are two anonymous functions we'll use to demonstrate a closure
let HelloName = function(name) { //remember, we use let if we want things to be mutable
    
    return function () { //this inner function won't be able to change the "name" value once it's given a value
        console.log("Hello" , name);
    }
}

let nameBen = HelloName("Ben"); //we can make new variables that call HelloName, without permanently assigning it a name variable

nameBen(); //we get Hello Ben

//But if we give HelloName a direct value, like below...
HelloName = HelloName("Luke");
//now we can never change the name value from Luke

HelloName();

let nameJohn = HelloName("John"); //we get Hello Luke... a value can been directly assigned, and now it's permanent.

//nameJohn(); //error: nameJohn() is not a function! the compiler won't recognize it


console.log("=====================================(Global Scopes)");

console.log(a); //prints undefined, because a has not been defined in the script yet. If it wasn't a var, this would throw an error

//this is a globally scoped var, gets hoisted
var a = 5; 

console.log(a) //NOW, of course, this prints 5.

//console.log(b) //this will return an error in the consol - b is a "let", so it doesn't get hoisted

let b = 3; //NOW, we give b a value

console.log(b); //now, printing out b works just fine

console.log("==========================================(Local Scopes)");

//block scope--------------------------

console.log(c); //print undefined because of hoisting (see the if statement)

if(true) {
    var c = "I'm a var in a block!";
    console.log(c); 
    //outside of this if statement, c is undefined. 
    //but IN this if statment, c has a string value.
}


//functional scope----------------------

function testScope() {
    //var d is hoisted only to the top of the function, because hoisting send to the top of the SCOPE, not the entire script
    console.log(d); //undefined
    var d = "I'm a var in a function!"
    console.log(d);
}

testScope(); //actually call the function...

