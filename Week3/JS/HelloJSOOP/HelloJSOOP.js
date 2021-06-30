console.log("===================================(A class called TacoStand)");

//defining a class with a class declaration (using the class keyword)
//also adding a constructor
class TacoStand {
    constructor(name, mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    //give the class a function
    makeTaco() {
        alert(this.name + " esta cocinando los tacos");
    }
}

console.log(TacoStand); //print out the contents of the TacoStand Class to the console

let ts1 = new TacoStand("QUE ASCO", false); //create a new TacoStand object using the constructor

ts1.makeTaco(); //call the make taco method


console.log("===================================(A variable called tacoStand assigned to an object)");

//defining a class with a class expression (assigning an object to a variable)
//notice how tacoStand and TacoStand can coexist! JS treats them as two different things.

//this object is implicitly inheriting from Object.prototype
var tacoStand = {
    name:"knockoffStand",
    mobile:true,

    makeTaco() {
        alert(this.name + " esta cocinando los tacos");
    }
}

//class expression objects are inherently singletons
//if we made a new tacoStand object with new attributes, the new one would override the old.

console.log(tacoStand); //print the contents of the tacoStand variable 

tacoStand.makeTaco(); //call the makeTaco() function of tacoStand


console.log("==============================(A variable called modernTacos that inherts from tacoStand")

//we inherit using the __proto__ property in JS! (REMEMBER - double underscores)

//here's a new object using a class expression
//we want to use the __proto__ property to declare tacoStand as a parent class
let modernTacos = {
    isModern:true,
    __proto__:tacoStand //this lets us inherit all of the properties of tacoStand
}

console.log(modernTacos.name); //we can access the "name" property of the tacoStand object

modernTacos.name = "Tacos Nuevos"; //we can also change the inherited properties 

console.log(modernTacos.name); //see the name change in the console

modernTacos.makeTaco(); //we can access this inherited function

console.log(modernTacos); //we don't see the inherited properties - but they're there!

//-------------------------------------------------------------------------

//if you want a declared class to inherit from another, you'd use extends.
class TacoStand2 extends TacoStand {

}

console.log(TacoStand2); //print out the contents of TacoStand2