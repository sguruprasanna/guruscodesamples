package com.guru.test.ftp;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.guru.test.ftp.FtpServiceConfig.FtpServer;

public class TestJAXB {
	
	
	public static void main(String args[]){
		
		try{
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();           
			InputStream stream = loader.getResourceAsStream("ftp-service-config.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(FtpServiceConfig.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FtpServiceConfig ftpServiceConfig = (FtpServiceConfig) jaxbUnmarshaller.unmarshal(stream);
			
			
			for(FtpServer server : ftpServiceConfig.getFtpServer() ){
				System.out.println(server.getHostName());
			}
			//System.out.println();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
