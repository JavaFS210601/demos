//A variable in Java is something that represents or "holds" a piece of data.
//Variables come in two types in Java: primitives and reference variables.
//Primitives hold a simple value, such as the number 5. <-talking about this!
//Whereas reference variables hold a reference to a location in memory where an object is stored. 

public class Launcher {

	public static void main(String[] args) {
		
		
		System.out.println("=============================(Integer-Type Primitives)");
		//There are 8 primitives in Java
		
		//The first 5 primitives I want to talk about are integer types
		//As in whole numbers, no decimals
		
		byte b = 1; //1 byte in size
		System.out.println(Byte.MAX_VALUE); //127
		System.out.println(Byte.MIN_VALUE); //-128
		
		//byte c = 129; Java won't even recognize I'm trying to assign 129 to a byte
		
		short s = 300; //2 bytes in size
		System.out.println(Short.MAX_VALUE); //32767
		System.out.println(Short.MIN_VALUE); //-32768
		
	//Note about Longs - you have to put an L at the end of the number
	//To tell Java you intend to make it of type Long
		
		long l = 9000000000000000000L; //8 bytes in size
		System.out.println(Long.MAX_VALUE); //big number
		System.out.println(Long.MIN_VALUE); //smol number
		
		//Now for primitive types we'll actually use----------------------
		
		int i = 20000; //4 bytes in size
		System.out.println(Integer.MAX_VALUE); //2147483647
		System.out.println(Integer.MIN_VALUE); //-2147483648
		
		//char can hold integers, but really it stands for "character"
		//so single unicode value can be a char. 
		//chars are typically between single quotes (double quotes would be a String)
		
		char c = 'a';
		char c2 = '$';
		char c3 = '3';
		char c4 = 65; //Will print out uppercase A
		System.out.println(c4); //this will print the unicode value associated with this number
		
		System.out.println("=============================(Floating Point Primitives)");
		
		//These next 2 primitives are floating point numbers
		//By that I mean they can have decimal places
		
		//we use Double more than Float - double is more precise
		double d = 2.2; //8 bytes in size
		System.out.println(Double.MAX_VALUE); //big scientific notation 
		System.out.println(Double.MIN_VALUE); //small scientific notation 
		
		//Java doesn't expect us to use floats
		//so we have to specify f at the end
		float f = 1.1f; //4 bytes
		System.out.println(Float.MAX_VALUE); //big scientific notation 
		System.out.println(Float.MIN_VALUE); //small scientific notation 
		
		System.out.println("=============================(Booleans)");
		
		//The last primitive is boolean
		//this is how we denote True or False
		//cannot use 1 for True or 0 for False, no using nulls, ONLY BOOLEAN >:0
		
		boolean bool = true;
		boolean bool2 = false;
		
		System.out.println(bool);
		System.out.println(bool2);
		
		
		
	}
	
}
