package com.guru.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Speaker")
public class Speaker extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="speakerid", nullable=false)
	int speakerId;
	
	@Column(name="personid")
	int personId;
	
	@Column(name="topicid", nullable=false)
	@m
	List<Event> topics;
	
	
}
