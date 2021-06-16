package com.revature;

import com.revature.models.Cat;
import com.revature.models.Dog;
import com.revature.models.Snake;

public class Launcher {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		Snake snake = new Snake();
		
		
		
		cat.showFace();
		cat.move();
		cat.makeNoise();
		
		System.out.println("=============================================");
		
		dog.showFace();
		dog.move();
		dog.makeNoise();
		
		System.out.println("=============================================");
		
		snake.showFace();
		snake.move();
		snake.makeNoise();
		
	}
	
}
