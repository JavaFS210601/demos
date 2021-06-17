package com.revature;

import static org.junit.jupiter.api.Assertions.*; //these are for your assert method
//.*; will import everything in the package, which is fine for what we're doing
//But in huge applications, you want to save as much memory as you can...
//So best practice is just importing what you need specifically. Also helps with readability.
//"It's also a big maybe cause you don't know what you're getting exactly"

//we need static imports to import static members

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//keyboard shortcut to run JUnit tests:
//alt + shift + x , T

public class MathOpsTests {

	
	//In order to access the methods in the Launcher I need to...
	public static Launcher l; //static stuff will always make the l look like L. don't get confused!
	
	
	//the Launcher's methods take int arguments. So let's make uninitialized variables
	public int i;
	public int j;
	public int k;
	public int result; //this is going to be useful __________
	
	
	
	//the @Before/After methods are just to help set up for our Testing (Assert) methods
	
	@BeforeAll //used for things you want to happen BEFORE the test Class does anything.
	public static void initializeLauncher() {
		System.out.println("In BeforeAll");
		l = new Launcher(); //I want this method to initialize my Launcher object (it's not initialized on line 9)
	}
	
	
	@BeforeEach //used for things you want to happen BEFORE EACH testing method
	public void setVariables() {
		System.out.println("In BeforeEach");
		i = 3;
		j = 7;
		k = 0;
	}
	
	@AfterEach //Used for things you want to happen AFTER EACH testing method
	public void clearResults() {
		System.out.println("In AfterAll");
		result = 0;
	}
	
	
	//Now let's actually write some tests (using assert methods)----------------------------------
	
	//Remember, our @BeforeEach method resets i = 3, j = 7, k = 0 "before each" method runs
	//And the @AfterEach method sets our result variable back to 0.
	
	
	@Test //we need the @Test annotation in order for the method to be recognized as a test
	public void testAdd() {
		System.out.println("TESTING ADD...");
		
		//assigning the result variable to the value of the Launcher's add method
		//using our variables i and k, which have been initialized to 3 and 0 in the @BeforeEach
		result = l.add(i, k); 
		
		assertTrue(result == 3);
	}
	
	@Test
	public void testSubtract() {
		System.out.println("TESTING SUBTRACT...");
		
		result = l.subtract(i, j);
		
		assertNotEquals(0, result); 
	}
	

	@Test
	public void testDivideByZero() {
		System.out.println("Going to try dividing by zero :(");
		//We're using a lambda here, which like a single use, unnamed method.
			//Lambdas take arguments in the (), and do certain functionality with the arguments
			//In this case we have no arguments
		assertThrows(ArithmeticException.class, () -> l.divide(i, k));
		//"assert that an arithmetic exception is thrown, when we use the divide method to divide by zero"
	}
	
	
	//troubleshooting-----------------------------------
	
	//note on lambdas -> they were added in Java 1.8 so any version before that won't work with it. 
	//If the pom.xml didn't do it, change your Java version by right clicking your JDK and going into properties
	
	//some people including myself had to manually add JUunit in the build path... which is weird 
	//(configured the build path and added the Junit library in the libraries tab)
	//Mine worked after I just waited a while, others worked after making some changes in the Test Class
	
	
	//You should make sure the appropriate imports are being made, who knows which ones Java will implicitly import
	//Caused problems for some people. So just make sure your imports look like mine.
}
