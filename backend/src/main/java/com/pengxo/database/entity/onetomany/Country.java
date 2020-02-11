package com.pengxo.database.entity.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = -5980696754316069699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Long code;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country", orphanRemoval = true)
	@JsonManagedReference
	private final List<Province> provinces = new ArrayList<>();

	public Country() {
	}

	public Country(final String name, final Long code) {
		this.name = name;
		this.code = code;
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

	public Long getCode() {
		return code;
	}

	public void setCode(final Long code) {
		this.code = code;
	}

	public List<Province> getProvinces() {
		return Collections.unmodifiableList(provinces);
	}

	public void addProvince(final Province province) {
		provinces.add(province);
	}

	public void removeProvince(final Province province) {
		provinces.remove(province);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, id, name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Country other = (Country) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
