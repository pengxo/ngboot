package xo.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

	private static final long serialVersionUID = 6813003645119875514L;

	private final int id;

	private String name;

	private int age;

	private String gender;

	private String position;

	public Employee(final int id, final String name, final int age, final String gender, final String position) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(final String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, id, name, position);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Employee other = (Employee) obj;
		return age == other.age && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", position="
				+ position + "]";
	}

}
