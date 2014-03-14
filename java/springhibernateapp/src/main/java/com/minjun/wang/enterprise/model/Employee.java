package com.minjun.wang.enterprise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;



@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private long age;

	@OneToMany(cascade = {CascadeType.ALL})
	private Set<Passport> passports = new HashSet<Passport>();

	public Set<Passport> getPassport() {
		return passports;
	}
	public void addPassport(Passport passport) {
		passports.add(passport);
	}
	
    public String getId() {

	return id;

    }

    public void setId(String id) {

	this.id = id;

    }

    public String getName() {

	return name;

    }

    public void setName(String name) {

	this.name = name;

    }

    public long getAge() {

	return age;

    }

    public void setAge(long age) {

	this.age = age;

    }

}