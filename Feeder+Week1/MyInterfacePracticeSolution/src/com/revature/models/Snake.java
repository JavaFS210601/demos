package com.revature.models;

public class Snake implements Animal {

	@Override
	public void move() {
		System.out.println("I'm slithering");
	}

	@Override
	public void makeNoise() {
		System.out.println("Hello I am a snake.");
	}

	@Override
	public void showFace() {
		System.out.println("~~~~~~~~~~~~:P");
	}

}
