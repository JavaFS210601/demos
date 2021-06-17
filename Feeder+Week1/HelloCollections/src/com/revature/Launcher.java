package com.revature;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.revature.models.Pokemon;

//Collection are like Arrays in that they are objects that hold things
//but specifically, they hold references to other objects

//unlike Arrays, collections can change size DYNAMICALLY (so they can grow and shrink)
//there are MANY flavors of Collections, and we'll touch on some popular ones below

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=============================(Lists)");
		
		//ArrayList is a very common implementation of the List Interface
		//QC asked me the different between Arrays and ArrayLists.
		
		List<Pokemon> myPokemonList = new ArrayList<>(); //empty ArrayList
		
		
		//.add() method can add elements to your Collections
		myPokemonList.add(new Pokemon("Pikachu", "Electric"));
		myPokemonList.add(new Pokemon("Torkoal", "Fire"));
		myPokemonList.add(new Pokemon("Treeko", "Grass"));
		myPokemonList.add(new Pokemon("Mudkip", "Water/Ground")); 
		myPokemonList.add(new Pokemon("Mudkip", "Water/Ground")); //Lists can have duplicates!!
		myPokemonList.add(new Pokemon("Gengar", "Ghost/Poison"));
		
		//thanks to the toString() method in the Pokemon Class, we can just print this out
		//System.out.println(myPokemonList);
		
		//But it'll be cleaner to use a enhanced for loop to iterate over the data structure 
		//and print each object out on one line
		for(Pokemon p : myPokemonList) {
			System.out.println(p.getName() + " " + p.getType()); //the fields are private, so we use getters
		}
		
		
		//let's explore some populate List methods----------------------
		
		//we can also use .add() at specific indexes
		myPokemonList.add(4, new Pokemon("Lucario", "Fighting/Steel"));
		
		
		//.get(index) is how we specify a certain index in a List
		//NOTE: becasuse of zero-indexing, Lucario is at index 4, but it's technically the 5th element
		System.out.println("The Pokemon at index 4 is: " + myPokemonList.get(4));
	
		
		//.size() is analogous to .length in Arrays - simply returns the number of elements
		System.out.println("I have " + myPokemonList.size() + " Pokemon in my party");
		
		
		//We're going to use a forEach with a lambda to make the Pokemon "fight"
		//the forEach method will loop through our Collection and perform a given action FOR EACH element
		myPokemonList.forEach(pokemon -> pokemon.fight());
		
		
		//.remove() will remove a specific element OR an element at a specific index.
		myPokemonList.remove(6);
		myPokemonList.remove(4);
		
		System.out.println("Two Pokemon have fainted");
		
		//use the forEach method again to print out which Pokemon survived
		myPokemonList.forEach(pokemon -> System.out.println(pokemon.getName() + " Remains"));
		
		
		
		System.out.println("=================================(Sets)");
		
		//nothing's here yet :(
		
		System.out.println("===============================(Maps)");

//		//instantiate a super simple map before we work with Pokemon objects
//		Map<Integer, String> simpleMap = new TreeMap<>();
//		//We create a TreeMap object with an Integer Key, and a String Value. call it simpleMap
//		
//		//insert values into simpleMap
//		simpleMap.put(1, "One");
//		simpleMap.put(2, "Two");
//		simpleMap.put(3, "Four");
//		
//		System.out.println(simpleMap); //print out our map
//		//notice that TreeMaps are ordered! The elements print in order based on their keys
//		
//		
//		
//		//using a HashMap with String keys for our Pokemon objects---------------
//		
//		//Instantiating some Pokemon Objects to put into our HashMap, using the all-args constructor.
//		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
//		Pokemon squirtle = new Pokemon("Squirtle", "Water");
//		Pokemon mewtwo = new Pokemon("Mewtwo", "Psychic");
//		
//		//Let's make a HashMap that takes a String as the Key, and a Pokemon as the value
//		//We'll make it a map of trainers and their pokemon
//		Map<String, Pokemon> trainers = new HashMap<>();
//		
//		//throw some values into our trainers HashMap
//		trainers.put("Joey", mewtwo);
//		trainers.put("Ben", pikachu);
//		trainers.put("Greg", mewtwo); //Maps can take duplicate Values
//		trainers.put("Greg", squirtle); //Maps don't take duplicate Keys! This won't get registered
//									  //Won't throw an error though.
//		
//		System.out.println(trainers); //print the contents of our HashMap
//
//		//use .get() to grab map element values using the keys
//		System.out.println(trainers.get("Joey"));
//		System.out.println(trainers.get("Ben"));
//		//I put them in print statements, cause it wouldn't get printed to the console otherwise.
//		//It simply "gets" the value, you have to print it out yourself
//		
//		//you can also instantiate the Pokemon object when putting an element into the map
//		trainers.put("Nancy", new Pokemon("Ditto", "Normal"));
//		
//		System.out.println(trainers); //HashMaps aren't ordered! these don't print in a certain order like TreeMaps
//		
//		
//		//more Maps stuff TBD
		
		
	}

}
