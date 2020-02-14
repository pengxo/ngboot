package com.pengxo.database.entity;

import com.pengxo.database.listener.EntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "employee")
@Entity
@EntityListeners(EntityListener.class)
public class Employee implements Serializable {

    private static final long serialVersionUID = -7068123562520312603L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private int age;

    private String gender;

    private String job;

    public Employee(final String name, final int age, final String gender, final String job) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
    }

    public Employee() {
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

    public String getJob() {
        return job;
    }

    public void setJob(final String job) {
        this.job = job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender, id, name, job);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Employee other = (Employee) obj;
        return age == other.age && Objects.equals(gender, other.gender) && id == other.id
                && Objects.equals(name, other.name) && Objects.equals(job, other.job);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", position=" + job
                + "]";
    }
}
