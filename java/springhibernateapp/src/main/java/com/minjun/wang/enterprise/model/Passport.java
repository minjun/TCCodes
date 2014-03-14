package com.minjun.wang.enterprise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;



@Entity
public class Passport {
	@Id
	private String id;
	private String name;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Employee employee;
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
    }
}