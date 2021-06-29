//usually, for the useCapture boolean, we just use true or false
//but we're goin to make booleans called bubbling and capturing for clarity
const bubbling = false; //if the useCapture boolean is false, we use bubbling propagation
const capturing = true; //if the useCapture boolean is true, we use capturing propagation

//rememebr - the addEventListener takes three parameters... The event to listen for, the functionality to execute, and useCapture 
document.getElementById("inner").addEventListener("click", (event) => {console.log("INNER - capturing")}, capturing);

document.getElementById("middle").addEventListener("click", (event) => {console.log("MIDDLE - capturing")}, capturing);

document.getElementById("outer").addEventListener("click", (event) => {console.log("OUTER - capturing")}, capturing);

