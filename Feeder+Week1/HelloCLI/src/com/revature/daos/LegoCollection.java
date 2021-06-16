package com.revature.daos;

import com.revature.models.LegoSet;

//This LegoCollection class will contain a mock database of LegoSets. In your P0, you will have a real database
//We're just going to instantiate an Array of LegoSet objects. Essentially we're hardcoding a database to read/manipulate
public class LegoCollection implements LegoCollectionInterface {

	
	//Array of LegoSet objects, this will act as our database
	LegoSet[] legoSets = {
			new LegoSet(1, 500, "Star Wars"),
			new LegoSet(2, 1000, "Star Wars"),
			new LegoSet(3, 500, "Lord of the Rings"),
			new LegoSet(4, 20000000, "Harry Potter")
	};

	
	//Some data-access methods we can call with our CLI Menu.
	
	@Override
	public LegoSet[] getAllLegoSets() {
		return legoSets; //return the entire array of LegoSets
	}


	@Override
	public LegoSet getLegoSetById(int idInput) {
		return legoSets[idInput - 1]; //return the legoset at index idInput - 1
		//we need to put idInput - 1 for the index, because arrays are zero indexed!
		//If the user searches for legoSetId 3, and we don't include -1...
			//The LegoSet of id 4 would be returned. 
		
		//we could have avoided this if we make Ids start with 0,
		//but in SQL, they tend to start with 1 so you'll usually be doing stuff like this
	}


	@Override
	public void addLegoSet(LegoSet legoSet) {
		
		
		
	}



	
	
}
