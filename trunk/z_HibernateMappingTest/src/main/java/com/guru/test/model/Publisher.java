package com.guru.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="PUBLISHER")
public class Publisher {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PUBLISHER_ID")
	long id;
	
	@Column(name="CODE")
	String code; 
	
	@Column(name="NAME")
	String name;
	
	@Column(name="ADDRESS")
	String address;
	
	@OneToMany(mappedBy="publisher",targetEntity=com.guru.test.model.Publisher.class)
	@org.hibernate.annotations.Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="BOOK_ID")
	List<Book> books;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", code=" + code + ", name=" + name
				+ ", address=" + address + ", books=" + books + "]";
	}
	
	
	

}
