//usually, for the useCapture boolean, we just use true or false
//but we're goin to make booleans called bubbling and capturing for clarity
const bubbling = false; //if the useCapture boolean is false, we use bubbling propagation
const capturing = true; //if the useCapture boolean is true, we use capturing propagation

//rememebr - the addEventListener takes three parameters... The event to listen for, the functionality to execute, and useCapture 
document.getElementById("inner").addEventListener("click", (event) => {console.log("INNER - capturing")}, capturing);

document.getElementById("middle").addEventListener("click", (event) => {console.log("MIDDLE - capturing")}, capturing);

document.getElementById("outer").addEventListener("click", (event) => {console.log("OUTER - capturing")}, capturing);

//running these three event listeners alone will print only "OUTER - capturing" if you click the outer div
//BUT it'll print all three, starting with the outermost element if you click the inner div 

//now let's see bubbling work--------------------

document.getElementById("inner").addEventListener("click", (event) => {console.log("INNER - bubbling")}, bubbling);

document.getElementById("middle").addEventListener("click", (event) => {console.log("MIDDLE - bubbling")}, bubbling);

document.getElementById("outer").addEventListener("click", (event) => {console.log("OUTER - bubbling")}, bubbling);


//With bubbling, clicking the outermost element will just print "OUTER - bubbling" alone
//BUT it'll print all three, starting with the innermost element if you click the inner div