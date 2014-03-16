package com.guru.test.ftp;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FTPServer {
	
	String host;
	
	
	String username;
	
	
	String password;
	
	
	List<DataFile> file;
	
	
	public String getHost() {
		return host;
	}
	@XmlElement
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DataFile> getFile() {
		return file;
	}
	@XmlElement
	public void setFile(List<DataFile> file) {
		this.file = file;
	}
	
	
	
}
