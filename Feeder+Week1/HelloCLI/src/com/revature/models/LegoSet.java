package com.revature.models;


//Remember - in your Project 0, the LegoCollection Class will be the database, and LegoSets will be pieces of data
public class LegoSet {
	
	public int legoSetId; //we'll use this to uniquely identify each LegoSet object
						  //setting this to be public so that we can set the id in the addLegoSet method
	int pieces;
	String franchise;
		
	
	
	//boilerplate code below: Constructors and toString()-----------------------------------------
	
	//no args constructor (chose constructor from super class)
	public LegoSet() {
		super();
		// TODO Auto-generated constructor stub
	}


	//all-args constructor (chose constructor from fields)
	public LegoSet(int legoSetId, int pieces, String franchise) {
		super();
		this.legoSetId = legoSetId;
		this.pieces = pieces;
		this.franchise = franchise;
	}

	//all-args constructor, minus the id field (Will be useful for adding LegoSets to our database)
	//(chose constructor from fields, unchecked legoSetId)
	public LegoSet(int pieces, String franchise) {
		super();
		this.pieces = pieces;
		this.franchise = franchise;
	}


	//The toString method allows us to print an object and its fields
	//Without this method, trying to print a LegoSet object would print something like com.revature.models.LegoSet@234897sfd
	@Override
	public String toString() {
		return "LegoSet [legoSetId=" + legoSetId + ", pieces=" + pieces + ", franchise=" + franchise + "]";
	}
	
	
	
	
}
