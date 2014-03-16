package com.guru.test.ftp;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class TestFTPClient {
	private static FTPClient ftp;
	
	
	
	public static void main(String args[]){
		ftp = new FTPClient();
	    FTPClientConfig config = new FTPClientConfig();
	    //config.setXXX(YYY); 
	    // change required options
	    ftp.configure(config);
	    
	    boolean error = false;
	    try {
	      int reply;
	      String server="ftp.nasdaqtrader.com";
	      ftp.connect("ftp.nasdaqtrader.com");
	      System.out.println("Connected to " + server + ".");
	      System.out.print(ftp.getReplyString());

	      // After connection attempt, you should check the reply code to verify
	      // success.
	      reply = ftp.getReplyCode();

	      if(!FTPReply.isPositiveCompletion(reply)) {
	        ftp.disconnect();
	        System.err.println("FTP server refused connection.");
	        System.exit(1);
	      }
	      
	      
	      System.out.println("Connection established...");
	      ftp.login("anonymous", "g@gmail.com");
	      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
		        ftp.disconnect();
		        System.err.println(ftp.getReplyString());
		        System.exit(1);
		  }

	      
	      System.out.println("Login complete.");
	      System.out.println("Current directory:"+ftp.printWorkingDirectory());
	      
	      ftp.changeWorkingDirectory("SymbolDirectory");	      
	      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
		        ftp.disconnect();
		        System.err.println("FTP server refused connection.");
		        System.exit(1);
		  }

	      ftp.enterLocalPassiveMode();
	      ftp.setFileType(FTP.ASCII_FILE_TYPE);
	      
	      System.out.print(ftp.getReplyString());
	      
	      InputStream fis = (InputStream) ftp.retrieveFileStream("nasdaqlisted.txt");
	      if(!ftp.completePendingCommand()) {
	    	     ftp.logout();
	    	     ftp.disconnect();
	    	     System.err.println("File transfer failed.");
	    	     System.exit(1);
	      }
	      
	      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
		        ftp.disconnect();
		        System.err.println(ftp.getReplyString());
		        System.exit(1);
		  }	      
	      
	      System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
	      
	      for(String s : ftp.getReplyStrings()){
	    	  System.out.println("Reply String: "+s);
	      }
	      
	      Scanner sc = new Scanner( fis );
	      
	      while(sc.hasNextLine()){
		      String input = sc.nextLine();
		      System.out.println(input);
	      }
	      sc.close();
	      
	      
	      // transfer files
	      ftp.logout();
          System.out.println("Logout completed."+ftp.getReplyString());

	    } catch(Exception e) {
	      error = true;
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
	      System.exit(error ? 1 : 0);
	    }
	}
    
 
}
