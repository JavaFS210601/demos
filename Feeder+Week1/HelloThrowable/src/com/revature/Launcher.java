package com.revature;

import com.revature.throwables.MyCheckedException;
import com.revature.throwables.MyError;
import com.revature.throwables.MyUncheckedException;

public class Launcher {

	//Note - these custom exceptions/error aren't very useful... Mostly for demo purposes
	//But custom exceptions can be quite useful if you want to prevent certain actions/inputs to occur
	
	public static void main(String[] args) {
		
		//The compiler will let you call these error/exception throwing methods 
		//but of course, this will crash your program once the first Error is thrown
		
		//throwError();
		//throwChecked(); //Java won't even let you do this, unless you have throws or a try/catch
		//throwUnchecked(); //Java WILL let you do this, since it's unchecked
		
		
		System.out.println("==========================(Using our custom exceptions)");
		
		System.out.println("Starting the main method...");
		
		try { //this will TRY a block of code that may or may not throw an Exception
			System.out.println("Try block is starting...");
			throwChecked();
		} catch(MyUncheckedException e) {
			System.out.println("I wont run - I can only catch MyUncheckedException");
		} catch(MyCheckedException e) {
			System.out.println("Hello from the catch block!");
			System.out.println("I catch MyCheckedExceptions");
		} catch (Exception e) {
			System.out.println("I could've caught any old Exception!");
			System.out.println("This is good practice for catching anything you may not have accounted for");
		} finally {
			System.out.println("Hello from the finally block! I will ALWAYS run!");
		}
		
		
		System.out.println("==========================(A Couple Misc. Exceptions)");
		
		//these are both unchecked exceptions btw....
		//Java won't notice they're problems until they actually execute
		
		
		//IndexOutOfBoundsException
		try {
			System.out.println("I'm going to try accessing an index that's out of bounds!");
			int[] nums = {1, 2};
			System.out.println(nums[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException caught! That index doesn't exist...");
			e.printStackTrace(); //This will print out the problem to the console
		}
		
		//ArithmeticException
		try {
			System.out.println("I'm going to try dividing by zero! Wish me luck...");
			int i = 5/0;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException caught!! You really shouldn't be doing that...");
			e.printStackTrace(); 
		}
		
		
		//This try block won't run... The generic exception catch block renders the more specific one unreachable.
		
//		try {
//			System.out.println("I'm going to try dividing by zero! Wish me luck...");
//			int i = 5/0;
//		} catch (Exception e) {
//			System.out.println("I'm up to no good... This will lead to unreachable code");
//			e.printStackTrace(); 
//		} catch (ArithmeticException e) {
//			System.out.println("I'm up to no good... This will lead to unreachable code");
//			e.printStackTrace(); 
//		}
		
	}
	
	
	//creating some methods that let us throw our exceptions/error------------------
	
	//Note - "throws" tells Java that you know your method throws an Exception 
	//and leaves it to the calling method to handle it. (In this case, main is the calling method)
	
	public static void throwError() throws MyError {
		System.out.println("I'm going to throw an error!!!");
		throw new MyError("Error Thrown :(");
	}
	
	public static void throwChecked() throws MyCheckedException {
		System.out.println("I'm going to throw a Checked Exception!!!");
		throw new MyCheckedException();
	}
	
	public static void throwUnchecked() throws MyUncheckedException {
		System.out.println("I'm going to throw an Unchecked Exception!!!");
		throw new MyUncheckedException();
	}

}
