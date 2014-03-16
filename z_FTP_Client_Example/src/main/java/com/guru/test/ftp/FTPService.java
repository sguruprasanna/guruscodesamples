package com.guru.test.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class FTPService {
	
	FTPClient ftp;
	FTPClientConfig config;
	Properties prop;
	
	public void loadProperties() throws IOException{
		prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
		InputStream stream = loader.getResourceAsStream("ftpservice.properties");
		prop.load(stream);
	}
	
	public String getProperty(String key) throws IOException{
		if(prop == null){
			loadProperties();
		}
		return prop.getProperty(key);
	}
	
	public void checkReturnCode() throws IOException{
      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
	        ftp.disconnect();
	        System.err.println(ftp.getReplyString());
	        throw new IOException(ftp.getReplyString());
	  }
	}
	
	
	public void connect(String server, String username, String password) {
		try {
			
			ftp = new FTPClient();
			config = new FTPClientConfig();
			//config.setXXX(YYY); 
			// change required options
			ftp.configure(config);
	    

			  ftp.connect(server);
			  System.out.println("Connected to " + server + ".");
			  System.out.print(ftp.getReplyString());
			
			  // After connection attempt, you should check the reply code to verify
			  // success.
			  checkReturnCode();
			  
			  
			  System.out.println("Connection established...");
			  ftp.login("anonymous", "g@gmail.com");
			  checkReturnCode();
			
			  
			  System.out.println("Login complete.");
			  System.out.println("Current directory:"+ftp.printWorkingDirectory());
			  
			  ftp.changeWorkingDirectory(getProperty("dataDirectory"));	      
			  checkReturnCode();
			
			  
			  ftp.enterLocalPassiveMode();
			  ftp.setFileType(FTP.ASCII_FILE_TYPE);
			  
			  System.out.print(ftp.getReplyString());
			
			} catch(Exception e) {
				e.printStackTrace();
			} /*finally {
				if(ftp.isConnected()) {
		        try {
		          ftp.disconnect();
		          System.out.println("FTP disconnect completed.");
		        } catch(Exception e) {
		          e.printStackTrace();
		        }
			}*/

	    }
	
	public InputStream getFile(String file) {
		InputStream fis = null;
		try {
		      fis = (InputStream) ftp.retrieveFileStream(file);
		      if(!ftp.completePendingCommand()) {
		    	     ftp.logout();
		    	     ftp.disconnect();
		    	     System.err.println("File transfer failed.");
		    	     //System.exit(1);
		    	     throw new Exception("Error when retrieving file from ftp server");
		      }
		      
		      checkReturnCode();  
		} catch(Exception e){
			e.printStackTrace();
			
		} /*finally {
	      if(ftp.isConnected()) {
		        try {
		          ftp.disconnect();
		          System.out.println("FTP disconnect completed.");
		        } catch(Exception e) {
		          e.printStackTrace();
		        }
	      }
		}*/
		return fis;
    }

	public void logout(){
		try{
			ftp.logout();
	        System.out.println("Logout completed."+ftp.getReplyString());
		} catch(Exception e){
			e.printStackTrace();
		} finally {
	      if(ftp.isConnected()) {
	        try {
	          ftp.disconnect();
	          System.out.println("FTP disconnect completed.");
	        } catch(Exception e) {
	          e.printStackTrace();
	        }
	      }
		}

	}
	
	public List<String> getAllSymbols() throws Exception{
		List<String> symbols = new ArrayList<String>();
		String delims = "[|]+";
		
		String server = getProperty("server");
		String username = getProperty("username");
		String password = getProperty("password");
		
		connect(server, username, password);
		
		InputStream is = getFile(getProperty("dataFile"));
		Scanner sc = new Scanner( is );
		  
		while(sc.hasNextLine()){
		    String input = sc.nextLine();
		    String[] dataElements = input.split(delims);
		    symbols.add(dataElements[0]);
		    //System.out.println(input);
		}
		sc.close();
		logout();
		return symbols;
	}

	public static void main(String args[]){
		FTPService ftpService = new FTPService();
		try {
			List<String> symbols = ftpService.getAllSymbols();
			for(String s : symbols){
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FTPClient getFtp() {
		return ftp;
	}


	public void setFtp(FTPClient ftp) {
		this.ftp = ftp;
	}


	public FTPClientConfig getConfig() {
		return config;
	}


	public void setConfig(FTPClientConfig config) {
		this.config = config;
	}
    
 
}
