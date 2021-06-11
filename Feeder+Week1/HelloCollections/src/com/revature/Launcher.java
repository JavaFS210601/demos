package com.revature;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.revature.models.Pokemon;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=============================(Lists)");
		
		//nothing here yet...
		
		System.out.println("=================================(Sets)");
		
		//nothing's here either :(
		
		System.out.println("===============================(Maps)");

		//instantiate a super simple map before we work with Pokemon objects
		Map<Integer, String> simpleMap = new TreeMap<>();
		//We create a TreeMap object with an Integer Key, and a String Value. call it simpleMap
		
		//insert values into simpleMap
		simpleMap.put(1, "One");
		simpleMap.put(2, "Two");
		simpleMap.put(3, "Four");
		
		System.out.println(simpleMap); //print out our map
		//notice that TreeMaps are ordered! The elements print in order based on their keys
		
		
		
		//using a HashMap with String keys for our Pokemon objects---------------
		
		//Instantiating some Pokemon Objects to put into our HashMap, using the all-args constructor.
		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
		Pokemon squirtle = new Pokemon("Squirtle", "Water");
		Pokemon mewtwo = new Pokemon("Mewtwo", "Psychic");
		
		//Let's make a HashMap that takes a String as the Key, and a Pokemon as the value
		//We'll make it a map of trainers and their pokemon
		Map<String, Pokemon> trainers = new HashMap<>();
		
		//throw some values into our trainers HashMap
		trainers.put("Joey", mewtwo);
		trainers.put("Ben", pikachu);
		trainers.put("Greg", mewtwo); //Maps can take duplicate Values
		trainers.put("Greg", squirtle); //Maps don't take duplicate Keys! This won't get registered
									  //Won't throw an error though.
		
		System.out.println(trainers); //print the contents of our HashMap

		//use .get() to grab map element values using the keys
		System.out.println(trainers.get("Joey"));
		System.out.println(trainers.get("Ben"));
		//I put them in print statements, cause it wouldn't get printed to the console otherwise.
		//It simply "gets" the value, you have to print it out yourself
		
		//you can also instantiate the Pokemon object when putting an element into the map
		trainers.put("Nancy", new Pokemon("Ditto", "Normal"));
		
		System.out.println(trainers); //HashMaps aren't ordered! these don't print in a certain order like TreeMaps
		
		
		//more Maps stuff TBD
		
		
	}

}
