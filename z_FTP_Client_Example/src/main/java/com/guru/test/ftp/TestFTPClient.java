package com.guru.test.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
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
	      
	      
			ftp.setDataTimeout(30000);
			ftp.setDefaultTimeout(30000);
		    ftp.setControlKeepAliveTimeout(60);
		    ftp.setBufferSize(1024 * 1024);
		    
	      ftp.connect("ftp.nasdaqtrader.com");
	      reply = ftp.getReplyCode();

	      
	      System.out.println("Connected to " + server + ".");
	      System.out.print(ftp.getReplyString());
	      
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

/*			//ftp.enterLocalActiveMode();//LocalPassiveMode();
			ftp.enterLocalPassiveMode();
			System.out.print(ftp.getReplyString());
			
	      ftp.changeWorkingDirectory("SymbolDirectory");	      
	      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
		        ftp.disconnect();
		        System.err.println("FTP server refused connection.");
		        System.exit(1);
		  }

	      System.out.println("Current directory:"+ftp.printWorkingDirectory());

	      // After connection attempt, you should check the reply code to verify
	      // success.
	      //reply = ftp.getReplyCode();
	      
	      //ftp.setFileType(FTP.ASCII_FILE_TYPE);
	      //System.out.print(ftp.getReplyString());
*/

	      
	      String files[] = {"/SymbolDirectory/otherlisted.txt","/SymbolDirectory/nasdaqlisted.txt"};
	      
	      for(String s : files){
	    	  
		      InputStream fis = (InputStream) ftp.retrieveFileStream(s);
	//	      InputStream fis = (InputStream) ftp.retrieveFileStream("nasdaqlisted.txt");
		      
		      
		      /*
		      FileOutputStream out = new FileOutputStream(new File("/home/guru/otherListed.txt"));
		      ftp.retrieveFile("/SymbolDirectory/otherlisted.txt", out);
		      */
		      
		      if(fis == null){
			      if(!ftp.completePendingCommand()) {
			    	     ftp.logout();
			    	     ftp.disconnect();
			    	     System.err.println("File transfer failed.");
			    	     System.exit(1);
			      }
		      }
/*		      
		      if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
			        ftp.disconnect();
			        System.err.println(ftp.getReplyString());
			        System.exit(1);
			  }	      
		      
		      System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
		      
		      for(String s : ftp.getReplyStrings()){
		    	  System.out.println("Reply String: "+s);
		      }
		      */
		      int count=1;
 			Scanner sc = new Scanner( fis );
		      while(sc.hasNextLine()){
			       sc.nextLine();
			      count++;
		      }
		      
		      System.out.println("Count:"+count);

		      sc.close();
		      fis.close();
	      }
	      
	      
	      // transfer files
	      ftp.logout();
          System.out.println("Logout completed."+ftp.getReplyString());
          
          //out.close();
          //sc.close();

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
