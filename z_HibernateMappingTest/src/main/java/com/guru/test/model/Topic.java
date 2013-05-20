package com.guru.test.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topicid")
	int topicId;
	
	@Column(name="name")
	String name;
	
	@ManyToOne(targetEntity = com.guru.test.model.Speaker.class)
	@JoinColumn(name="speakerid",nullable=false)
	Speaker speaker;
	
	@ManyToOne(targetEntity = com.guru.test.model.Event.class)
	@JoinColumn(name="eventid", nullable=false)
	Event event;

}
