package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books") //this isn't super necessary, but without it, hibernate would call the table "Book"
public class Book {

	@Id //this makes a field the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
	@Column(name = "book_id") //otherwise it would just be "id" in the database
	private int id;
	
	@Column(name = "book_title", nullable = false) //we set a not null constraint here - books need titles!
	private String title;
	
	@Column(name = "book_genre")
	private String genre;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id") //specify with Author column to create a relationship on
	private Author author;

	///WOAH, what the heck are FetchType and CascadeType?
	
	//FetchType defines WHEN hibernate will go to the database to fetch an associated object.
	/*
	 * LAZY - Hibernate will give a proxy object instead of going to the database, until
	 * your code actually calls for the object. This only works while the object is in the database (aka persistent)
	 * Once it leaves the database (aka detached), there is no longer a Session to replace the proxy
	 * 
	 * EAGER - Returns the dependent object immediately without making a proxy object. This is generally less error prone
	 * Why is EAGER less error prone? For starters, if you close a Session, proxies are no longer available
	 */
	
	//Since Author can be null in this case, and since FetchType is set to LAZY...
	//The author field will have a proxy object that will be filled IF there's an author assocaited with the book.

	//CascaseType defines how the queries will maintain referential integrity 
	//So in the case of CascadeType.ALL, all changes made will cascade to dependent entities
	
	
	
	
	//boilerplate code-------------------------------
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int id, String title, String genre, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.author = author;
	}





	public Book(String title, String genre, Author author) {
		super();
		this.title = title;
		this.genre = genre;
		this.author = author;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	} 
	
	
	
	
}
