
public class Owner {

	public static String name = "Guy";
	public static Dog dog = new Dog(); //instantiating a dog object. AKA an instance of the Dog class
	//So now, the Owner Class HAS-A Dog object.
	//Therefore, this is a HAS-A relationship.  
	
	public static void main(String[] args) {
		
		System.out.println(name + "'s dog has " + dog.legs + " legs");
		//Because this Owner Class HAS-A Dog Class, it can access the Dog Class's variables
		
		dog.bark();
		//We can also access the Dog Class's methods
		
		//another way to say this, is that we can access the Dog Class's MEMBERS
		//Or everything in the dog class
		
	}
	
}
