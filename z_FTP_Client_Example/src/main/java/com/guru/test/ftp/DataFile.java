package com.guru.test.ftp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataFile {
	
	
	String location;
	
	
	String name;
	
	
	public String getLocation() {
		return location;
	}
	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	
}
