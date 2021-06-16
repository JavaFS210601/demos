package com.revature.daos;

import com.revature.models.LegoSet;

public interface LegoCollectionInterface {

	//I'm going to write out abstract methods that reflect the methods LegoCollection should have/implement
	
	LegoSet[] getAllLegoSets(); //this method will show the user all LegoSets in the database
	
	LegoSet getLegoSetById(int idInput); //this method will return one LegoSet of a given id 
	
	void addLegoSet(LegoSet legoSet); //this method will let the user input a new LegoSet into their collection
	
}
