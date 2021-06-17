
public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=============================(Testing String Equality)");
		
		String s1 = "Hi Java";
		String s2 = "Hi Java"; //since s2 is the same as s1, they will refer to the same Objects in the string pool
		String s3 = "hi java";
		String s4 = new String("Hi Java"); //since we used "new", s4 will be a different object in memory. 
										   //won't be in the String pool, just the regular heap
		
		//REMEMBER we won't use == with Strings or any objects. Just trying to drive some points home
		//== will compare memory locations
		System.out.println(s1 == s2); //true - they're the same object in memory
		System.out.println(s1 == s3); //false - not the same object in memory
		System.out.println(s1 == s4); //false - not the same object in memory
		
		//Here's the .equals() method, which we will be using with Strings and other objects
		//.equals() will compare the actual values
		System.out.println(s1.equals(s2)); //true - the Strings are identical
		System.out.println(s1.equals(s3)); //false - the Strings are different
		System.out.println(s1.equals(s4)); //true - the String are identical, though not the same object in memory
		
		System.out.println("==============================(Some String Methods)");
		
		//Remember, Strings AREN'T primitives. We assign String objects to reference variables
		//The Strings we're working with are objects (instantiations) of the String class
		
		String pangram = "Sphnix of Black Quartz, judge my vow";
		
		//hopefully these method names are self explanatory :)
		System.out.println(pangram.toLowerCase());
		System.out.println(pangram.toUpperCase());
		
		//.length() returns the length of the String, similar to the .length property in Arrays
		System.out.println("The pangram is " + pangram.length() + " characters long!");
		
		//charAt() returns the character at a given index
		System.out.println(pangram.charAt(0)); //first character - S
		System.out.println(pangram.charAt(pangram.length() - 1)); //last character - w
	
		//using charAt() in a for loop to print out every char in the String
		for(int i = 0; i <= pangram.length() - 1; i++) {
			System.out.println(pangram.charAt(i));
		}
		
		//.indexOf() will find the index where a certain String occurs
		System.out.println(pangram.indexOf("a")); //first "a" is found at index 12. Returns 12!
		System.out.println(pangram.lastIndexOf("a")); //last "a" is found at index 18
		
		
		System.out.println(pangram.substring(5, 20)); //returns a substring of index 5-19. 
													  //remember, the ending position won't be included
		
		//note that using these methods WON'T change the original pangram String.
		//See StringBuilder below for immutable String-like behavior
		
		//That being said, you can always assign a new String to some manipulation of the original String
		String newStr = s1 + s2.length() + s3.toUpperCase() + pangram.substring(5,10);
		System.out.println(newStr);
		
		//.split() will create an Array via specified partitions
		String[] words = pangram.split(" "); //"Split the String on each of the empty spaces"
		
		//"For every String (which we'll call s) in the array called words...
		//Print out the current String s"
		for(String s : words) {
			System.out.println(s);
		}
		
		
		System.out.println("===============================(Using StringBuilder)");
		
		StringBuilder sb = new StringBuilder(pangram);
		
		//You can do these methods, and it'll change the actual value of the StringBuilder object
		//Unlike with Strings 
		
		sb.reverse();
		System.out.println(sb);
		
		sb.append("BENJAMIN");
		System.out.println(sb);
		
		sb.insert(0, "hi");
		sb.insert(20, false);
		sb.insert(13, 700000000);
		System.out.println(sb);
		
		sb.delete(3, 7);
		System.out.println(sb);
		
		sb.replace(0, 3, s3);
		System.out.println(sb);
		
		
	}
	
}
