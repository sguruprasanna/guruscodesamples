package com.guru.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Topic")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eventid")
	int eventId;
	
	
	
}
