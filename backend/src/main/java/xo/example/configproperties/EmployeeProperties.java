package xo.example.configproperties;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration()
@ConfigurationProperties(prefix = "employee")
@Validated
public class EmployeeProperties {

	private String name;

	private int age;

	private String gender;

	private String position;

	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
	private String mail;

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

	public String getMail() {
		return mail;
	}

	public void setMail(final String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, mail, name, position);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final EmployeeProperties other = (EmployeeProperties) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(mail, other.mail)
				&& Objects.equals(name, other.name) && Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "EmployeeProperties [name=" + name + ", age=" + age + ", gender=" + gender + ", position=" + position
				+ ", mail=" + mail + "]";
	}

}
