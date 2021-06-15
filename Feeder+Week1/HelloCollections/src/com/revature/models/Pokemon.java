package com.revature.models;

public class Pokemon {

	//these are the fields of the Pokemon class
	String name;
	String type;
		
	
	//Below is boilerplate code--- We'll talk about it more later but for now, 
	//just know that these are overridden methods from the Object class that give our Objects some functionality
	//it looks scary but we can autogenerate it all, which we'll see later.
	
	
	//these are constructors - they let you instantiate an object
	
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
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}

	//remember what hashcodes are?? They basically assign a unique identifier to each object you create
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
	
	
	
	
	
}
