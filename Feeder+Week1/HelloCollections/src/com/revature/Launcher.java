package com.revature;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
		
		//HashSet is a general-use implementation of Set Interface
		Set<Pokemon> myPokemonSet = new HashSet<>();
		
		//Let's show example of how Sets differ from Lists
		
		
		//.add() method can add elements to your Collections
		myPokemonSet.add(new Pokemon("Pikachu", "Electric"));
		myPokemonSet.add(new Pokemon("Torkoal", "Fire"));
		myPokemonSet.add(new Pokemon("Treeko", "Grass")); 
		myPokemonSet.add(new Pokemon("Mudkip", "Water/Ground")); 
		myPokemonSet.add(new Pokemon("Mudkip", "Water/Ground")); //Sets CANNOT have duplicates!! This won't register
		myPokemonSet.add(new Pokemon("Gengar", "Ghost/Poison"));
		
		
		//notice how Sets are not ordered! The Pokemon objects don't print in any particular order!
		//also notice how the duplicate record isn't printed!! (Despite Java letting you try...)
		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		
		//remember, Sets have no order... so they have no index.
		//So what happens if we try to use .get() (which needs an index to get a certain Object)
		
		//myPokemonSet.get(4); nothing happens. Sets don't have .get() functionality
		
		
		//One way to see if specific objects exists in the Set .contains(). 
		//This would require us to instantiate an object on its own, then add it into the Set
		Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass/Poison");
		
		myPokemonSet.add(bulbasaur); //adding the bulbasaur variable that points to the Pokemon object we instantiated
		
		System.out.println(myPokemonSet.contains(bulbasaur)); //true! bulbasaur object exists
		
		myPokemonSet.remove(bulbasaur); //remove our bulbasaur objects
		
		System.out.println(myPokemonSet.contains(bulbasaur)); //now this is false, since bulbasaur isn't in the set
		
		
		System.out.println("==============================================(Queues) (LinkedList)");
		
		//We won't upcast here, since we want access to the overridden methods in LinkedList(peek, poll)
		LinkedList<Pokemon> PokemonLL = new LinkedList<Pokemon>();
		
	     //Adding elements to the linked list, note some of the different methods we can use to add
		PokemonLL.add(new Pokemon("Sudowoodo", "Rock"));
		PokemonLL.add(new Pokemon("Sobble", "Water"));
		PokemonLL.add(new Pokemon("Murkrow", "Dark/Flying"));
		PokemonLL.add(2, new Pokemon("Arcanine", "Fire")); //add to a specific index
		
		//iterate through the LinkedList - Queues are ordered, very strict structure based on index!
		for(Pokemon p : PokemonLL) {
			System.out.println(p.getName() + " is in the LinkedList!");
		}
		
		//show the name of the first Pokemon of the LinkedList
		System.out.println(PokemonLL.peek().getName() + " is the first element"); 
		
		//show the name and remove the first Pokemon of the LinkedList
		System.out.println(PokemonLL.poll().getName() + " has left..."); 
		
		//original first Pokemon is gone!
		System.out.println(PokemonLL.peek().getName() + " is the new first element"); 
 		
		System.out.println("=========================================(Maps)");

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
		
		//throw some values into our trainers HashMap - using the variables of our Pokemon objects
		trainers.put("Joey", mewtwo);
		trainers.put("Ben", pikachu);
		trainers.put("Greg", mewtwo); //Maps can take duplicate Values
		trainers.put("Greg", squirtle); //Maps don't take duplicate Keys! This won't get registered
									  //Won't throw an error though.

		//use .get() to grab map element values using the keys
		System.out.println(trainers.get("Joey"));
		System.out.println(trainers.get("Ben"));
		//I put them in print statements, cause it wouldn't get printed to the console otherwise.
		//It simply "gets" the value, you have to print it out yourself
		
		
		System.out.println(trainers); //HashMaps aren't ordered! these don't print in a certain order like TreeMaps

		
		System.out.println("========================================(Comparator Interface)");
		
		//Let's sort our Pokemon ArrayList alphabetically 
		
		//The Collections Class (not Collection Interface) has methods that all Collections can use
		//.sort() will take in a Collection and a Comparator in order to sort the Collection
		Collections.sort(myPokemonList, new ComparePokeName());
		//Now our ArrayList has been sorted according to the compare() method in ComparePokeName
		
		for(Pokemon p : myPokemonList) {
			System.out.println(p);
		}
	
		
	
		//Another cool Collections method is .reverse(), which reverses the elements
		Collections.reverse(myPokemonList);
		
		System.out.println("---------------We've reversed the order using .reverse()---------------");
		
		for(Pokemon p : myPokemonList) {
			System.out.println(p);
		}
		
		
	}

}
