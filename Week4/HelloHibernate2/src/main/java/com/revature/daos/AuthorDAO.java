package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Author;
import com.revature.utils.HibernateUtil;

public class AuthorDAO {

	//We're going to have a bunch of DAO methods that use Sessions to open connections to the database
	//Don't forget to read up on Session methods in the notes 
	
	
	public void insertAuthor(Author author) {
		
		//Open a Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //Note the parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(author); //Refer to the notes if you don't recognize this method - it's a method for Insert functionality
		
		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
		
		//That's the whole insert method!!!
		//DAO methods are significantly cleaner with Hibernate than JDBC
	}
	
	
	public void updateAuthor(Author author) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(author); //this will update the entire author record in the database, if it exists
		
		//why do I like merge over update?
		//update() would throw an error if the author object already existed in Hibernate's cache
		//hence why we say merge() is safer
		
		//Left out closeSession() just to show you that you can, but it's best practice to close your resources
	}
	
	
	public Author selectAuthorById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Author author = ses.get(Author.class, id); //get() gets an object straight from the DB, skips the cache 
		//here we're saying "Create a new Author object by getting the Author from the DB that has this id"
		
		HibernateUtil.closeSession();
		
		return author; //remember, return ends the method, so we close the Session, then return
	}
	
	
	public List<Author> findAllAuthors(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language it references the Java class, not the DB table
		//e.g. "Author" in our models package, instead of "authors" in our database
		List<Author> authorList = ses.createQuery("FROM Author").list(); //at the end, we turn the Query object into a List
		
		//warning is unimportant, it's complaining about conversion
		//it wants a specific generic but it's not important. we could probably use casting to get rid of it
		
		HibernateUtil.closeSession();
		
		return authorList;
	}
	
	
}
