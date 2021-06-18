package com.revature.models;

public class Pokemon {

	//these are the fields of the Pokemon class
	private String name;
	private String type;
	
		
	public void fight() {
		System.out.println(this.name + " attacked!");
	}

	//Below is boilerplate code--- We'll talk about it more later but for now, 
	//These are overridden methods from the Object class (the root class of all classes). 
	//they give our Objects certain functionality! Which we'll talk about below
	
	//*********it looks scary but we can autogenerate it all with alt + shift + s (or the source tab).
	
	
	//Remember, constructors let you instantiate an object (initialize an object with their variables)

	//no-args constructor (so you can make a pokemon with no name or type)
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args constructor (so you can make a pokemon with all its values)
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	//the toString() method lets you do String-like stuff with your objects, like print them out
	//otherwise you'd just get a random String of characters that represent the object's location in memory
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}


	//remember what hashcodes are?? They basically assign a unique identifier to each object you create
	//Java needs this to determine whether Objects are the same or not
	//For instance, Sets won't recognize duplicates if objects don't have hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	//equals lets you compare objects to one another via their hashcode
	//Java is like - "are these objects the same object? Compare their hashcodes to check"
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	//getters and setters let you get the value of private fields, and set the values of private fields, respectively.
	//THIS IS CALLED ENCAPSULATAION!!! Good practice for security, when you don't want values messed with directly
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
	
	
}
