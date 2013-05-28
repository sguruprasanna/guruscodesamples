package com.guru.test.tmp.model;

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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="Topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topicid")
	int topicId;
	
	@Column(name="name")
	String name;
	
	@ManyToOne(targetEntity = com.guru.test.tmp.model.Speaker.class)
	@JoinColumn(name="speakerid",nullable=false)
	Speaker speaker;
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(targetEntity = com.guru.test.tmp.model.Event.class)
	@JoinColumn(name="eventid", nullable=false)
	Event event;
	
	
	
	
	public boolean equals(Topic t1){
		
		return new EqualsBuilder().append(this.getName(),t1.getName()).append(this.getTopicId(), t1.getTopicId()).isEquals();
		
	}
	
	public int  hashCode() {
		return new HashCodeBuilder().append(this.getName()).append(this.getTopicId()).toHashCode();
	}
	

}
