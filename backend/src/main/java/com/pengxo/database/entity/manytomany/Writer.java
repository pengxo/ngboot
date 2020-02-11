package com.pengxo.database.entity.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "writer")
@Entity
public class Writer implements Serializable {

	private static final long serialVersionUID = 5093217731972234247L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String address;

	@ManyToMany(mappedBy = "writers")
	@JsonBackReference
	private final List<Book> books = new ArrayList<>();

	public Writer() {
	}

	public Writer(final String name, final String email, final String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(final Book book) {
		books.add(book);
		book.getWriters().add(this);
	}

	public void removeBook(final Book book) {
		books.remove(book);
		book.getWriters().remove(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Writer other = (Writer) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Writer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

}
