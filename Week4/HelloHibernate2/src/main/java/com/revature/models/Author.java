package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;

	@OneToMany(mappedBy="author", fetch=FetchType.EAGER)
	private List<Book> anthology;
	//what is mappedBy? It's the field in the Book Class that references the Author class 
	//(the Book Class has an "author" field)
	//Super necessary if we want this to act like a ManyToMany Relationship
	//So when we create a Book, this anthology field links the Book the Author
	
	//boilerplate code below-------------------------------
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Author(int id, String first_name, String last_name, List<Book> anthology) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.anthology = anthology;
	}



	public Author(String first_name, String last_name, List<Book> anthology) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.anthology = anthology;
	}



	@Override
	public String toString() {
		return "Author [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", anthology="
				+ anthology + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anthology == null) ? 0 : anthology.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
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
		Author other = (Author) obj;
		if (anthology == null) {
			if (other.anthology != null)
				return false;
		} else if (!anthology.equals(other.anthology))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public List<Book> getAnthology() {
		return anthology;
	}



	public void setAnthology(List<Book> anthology) {
		this.anthology = anthology;
	}
	
	
	
	
	
}
