package com.guru.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personid", nullable=false)
	int personId;
	
	@Column(name="name", nullable=false)
	String name;
	
	@Column(name="sex", nullable=false)
	String sex;
	
}
