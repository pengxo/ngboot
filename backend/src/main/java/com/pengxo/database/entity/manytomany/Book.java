package com.pengxo.database.entity.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "book")
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 7528868308569005510L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	/**
	 * The {@link CascadeType#REMOVE}} could not be used because it could removes
	 * all elements of both side.
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "book_writer", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
	@JsonManagedReference
	private final List<Writer> writers = new ArrayList<>();

	public Book() {
	}

	public Book(final String name) {
		this.name = name;
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

	public List<Writer> getWriters() {
		return writers;
	}

	public void addWriters(final Writer writer) {
		writers.add(writer);
		writer.getBooks().add(this);
	}

	public void removeWriters(final Writer writer) {
		writers.remove(writer);
		writer.getBooks().remove(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Book other = (Book) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

}
