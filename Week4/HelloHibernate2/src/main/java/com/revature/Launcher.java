package com.revature;

import java.util.List;

import com.revature.daos.BookDAO;
import com.revature.models.Author;
import com.revature.models.Book;

public class Launcher {

	private static BookDAO bDAO = new BookDAO(); //so we can use the BookDAO methods
	//needs to be static so we can call it in our static main method
	
	//we're going to use the main method to insert Books into our database (thus creating the tables automagically)
	public static void main(String[] args) {
		
		
		//We'll create Author objects to make Book construction easier
		//So once we make each Author a1, a2, an, we can just pop them into the Book constructors below
		Author a1 = new Author("Johnathan", "Stroud", null);
		Author a2 = new Author("J.R.R.", "Tolkein", null);
		Author a3 = new Author("Stephen", "King", null);
		//why null? It'll get populated once we attach books to an Author! (Upon Book creation)
		//So when we create a Book, it has an author. Thus, the Book will be added to the Author's anthology field
			//(Which is a list of books)
		
		
		Book b1 = new Book("The Amulet of Samarkand", "Fantasy", a1);
		Book b2 = new Book("Lord of the Rings", "Fantasy", a2);
		Book b3 = new Book("The Gunslinger", "Fantasy", a3);
		
		
		//insert our new books using our BookDAO method
		bDAO.insertBook(b1);
		bDAO.insertBook(b2);
		bDAO.insertBook(b3);
		
		//use the findAll method to populate a list of books 
		List<Book> books = bDAO.findAllBooks();
		
		//print out the List of books in an enhanced for loop
		for(Book b : books) {
			System.out.println(b);
		}
		
	}

}
