package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
	
	//here, we're creating a Logger object for the Launcher
	private static final Logger log = LogManager.getLogger(Launcher.class);
	
	
	public static void main(String[] args) {
		System.out.println(add(3, 5));
		System.out.println(subtract(8, 4));
	}
	
	
	//simple methods to test logging
	
	//I want to log when this add method runs
	public static int add(int i, int j) {
		log.info("add method is running!");
		return i + j;
	}
	
	//I want to log when this subtract method runs
	public static int subtract(int i, int j) {
		log.warn("subtract method is running!");
		return i - j;
	}
	
}
