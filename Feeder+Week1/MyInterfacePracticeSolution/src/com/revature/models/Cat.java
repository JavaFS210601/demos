package com.revature.models;

public class Cat implements Animal {

	@Override
	public void move() {
		System.out.println("I'm moving with my cat paws");
	}

	@Override
	public void makeNoise() {
		System.out.println("mew mew mew mew mew mew mew mew mew mew mew mew");
	}

	@Override
	public void showFace() {

	    System.out.println("   /\\_/\\   ");
	    System.out.println("  / o o \\  ");
	    System.out.println("  \\~(*)~/  ");
	    System.out.println("   // \\\\   ");
		
	}

}
