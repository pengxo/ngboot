package com.pengxo.database.entity.onetomany;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "province")
public class Province implements Serializable {

	private static final long serialVersionUID = -2137069521444244713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonBackReference
	private Country country;

	public Province() {
	}

	public Province(final String name) {
		this.name = name;
	}

	public Province(final String name, final Country country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(final Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, id, name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Province other = (Province) obj;
		return Objects.equals(country, other.country) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

}
