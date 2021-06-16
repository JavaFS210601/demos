package com.revature.models;

public class Dog implements Animal {

	@Override
	public void move() {
		System.out.println("I'm moving with my dog paws");
	}

	@Override
	public void makeNoise() {
		System.out.println("YIP YIP YIP YIP YIP YIP YIPY IPY IPY YIP YIP YIPY IPY");
	}

	@Override
	public void showFace() {

	       System.out.println("           /~~~~~~~~\\   ");
	        System.out.println("    ##\\__/ O)      ~~~~~");
	        System.out.println("    |              /~~\\~");
	        System.out.println("     \\    /           | ");
	        System.out.println("      (~~~   /         \\");
	        System.out.println("       \\~~~~~~~~~~~~~~~~");
	
		
	}

}
