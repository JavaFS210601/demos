package com.revature.throwables;

@SuppressWarnings("serial") //not necessary, unless you hate warnings popping up
//We're extending the Error class, thus creating a custom Error
public class MyError extends Error{

	//constructor for MyError class
	//will be exactly the same as the constructor in Error, hence super();
	public MyError() {
		super();
	}
	
	//Another constructor for MyError
	//This one displays an error message when the error gets thrown
	public MyError (String message) {
		super(message);
	}
	
}
