package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Book;
import com.revature.utils.HibernateUtil;

public class BookDAO {

	//We're going to have a bunch of DAO methods that use Sessions to open connections to the database
	//Don't forget to read up on Session methods in the notes 
	
	
	public void insertBook(Book book) {
		
		//Open a Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //Note the parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(book); //Refer to the notes if you don't recognize this method - it's a method for Insert fucntionality
		
		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
		
		//That's the whole insert method!!!
		//DAO methods are significantly cleaner with Hibernate than JDBC
	}
	
	
	public void updateBook(Book book) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(book); //this will update the entire book record in the database, if it exists
		
		//why do I like merge over update?
		//update() would throw an error if the book object already existed in Hibernate's cache
		//hence why we say merge() is safer
		
		//Left out closeSession() just to show you that you can, but it's best practice to close your resources
	}
	
	
	public Book selectBookById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Book book = ses.get(Book.class, id); //get() gets an object straight from the DB, skips the cache 
		//here we're saying "Create a new Book object by getting the Book from the DB that has this id"
		
		HibernateUtil.closeSession();
		
		return book; //rememeber, return ends the method, so we close the Session, then return
	}
	
	
	public List<Book> findAllBooks(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language it references the Java class, not the DB table
		//e.g. "Book" in our models package, instead of "books" in our database
		List<Book> bookList = ses.createQuery("FROM Book").list(); //at the end, we turn the Query object into a List
		
		//warning is unimportant, it's complaining about conversion
		//it wants a specific generic but it's not important. we could probably use casting to get rid of it
		
		HibernateUtil.closeSession();
		
		return bookList;
	}
	
	
}
