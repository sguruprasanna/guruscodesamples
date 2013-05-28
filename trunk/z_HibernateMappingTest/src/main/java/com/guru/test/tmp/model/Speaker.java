package com.guru.test.tmp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
	
	@ManyToOne
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	List<Event> topics;
	
	
}
