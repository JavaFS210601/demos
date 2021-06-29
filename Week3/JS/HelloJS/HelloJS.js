console.log("=======================================(Printing and Declaring Stuff)");

//console.log() will print things to the console just like a System.out.println in Java
console.log("Hello JavaScript, please be nice to me") //semicolon optional

//JS is loosely typed, so I can change the type of value a variable holds with ease
var a = 100; 
console.log(a);

a = true; //now it's a boolean
a = null; //now it's null
a = "Now I'm a String";

console.log(a);

var b; //we haven't given this a value yet, so it's undefined

console.log("hello " + b); //hello undefined

//JS will add "var" implicitly if it's the first time the variable appears
c = "I wasn't declared. JS will do the work for me." //usually you should just add "var" for clarity

console.log(c);
console.log("c is type of: " + typeof c);

console.log("=======================================(Messing with type coercion)");

//explicit type coercion is where you explicity change a variable from one type to another
var num = 12345;
console.log("num is type of: " + typeof num);

num = String(num); //this will turn our num variable from a num to a String
console.log("NOW, num is type of " + typeof num + " Because of explicit type coercion");


//implicit type coercion

//+ will concatenate the values, like in Java, and turn it into a String type
var sum = 5 + "3";
console.log("sum is type of: " + typeof sum + " and its value is: " + sum);

//ALL the other operators will do a mathematical expression and become a number type
var diff = "5" - "3";
console.log("diff is type of: " + typeof diff + " and its value is: " + diff);

var prod = "5" * "3";
console.log("prod is type of: " + typeof prod + " and its value is: " + prod);

//value is NaN (not a number) because JS couldn't figure out what to do with this mathematical operation.
//we can use , instead of + to concatenate Strings. Saves time cuase it makes the spaces for you too!!
var weird = "abc" * 5;
console.log("weird is type of:" , typeof weird , "and its value is:" , weird);


console.log("=======================================(Truthy/Falsy)");

//let's write a function that compares two vars
function compareVars(var1, var2){

    console.log("comparing" , var1, "and", var2);
    console.log(var1 == var2); //this will compare equality, unlike === which compares datatypes

}

//use the function a bunch of times to test out truthy and falsy
compareVars("3", 3); //true 
compareVars(0, false); //true - both are falsy
compareVars(1, true); //true - any number besides 0 is truthy
compareVars(5, false); //false - any number besides 0 is truthy
compareVars('', false); //true - empty string is falsy
compareVars(null, undefined) //true - both are falsy

compareVars(2, true); //despite 2 being truthy, this actually returns false... see below

//while 2 is truthy, the boolean true is evaluated as the number 1 - what the heck

//let me attempt to drive this point home...
if(15){
    console.log("15 is truthy!!");
} else {
    console.log("taqueria");
}

if(15 == true) {
    console.log("hotdog stand");
} else {
    console.log("While 15 is, in fact, truthy... the boolean true is considered equivalent to the number 1");
}