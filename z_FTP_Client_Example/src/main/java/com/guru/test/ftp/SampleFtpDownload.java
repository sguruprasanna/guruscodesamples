package com.guru.test.ftp;

import org.apache.commons.net.ftp.FTPClient; 

import java.io.InputStream;
import java.io.IOException; 
import java.io.FileOutputStream; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleFtpDownload {
  
  public static void main(String[] args) { 
	     String files[] = {"/SymbolDirectory/otherlisted.txt","/SymbolDirectory/nasdaqlisted.txt"};
	      List<String> symbols;
	      for(String s : files){
	    	  symbols = getFile(s);
	    	  System.out.println(symbols);
	    	  System.out.println(s+" has "+symbols.size()+" symbols.");
	      }
}

  public static List<String> getFile(String s){
    FTPClient ftp = new FTPClient(); 
    FileOutputStream fos = null; 
	List<String> symbols = new ArrayList<String>();
	String delims = "[|]+";

    try {
    	ftp.connect("ftp.nasdaqtrader.com");
      System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
      // Pass username and password 
      ftp.login("anonymous", "g@gmail.com"); 
      System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
      
      
      // The remote filename to be downloaded.      
      //String filename = "/home/guru/otherlisted.txt"; 
      //fos = new FileOutputStream(filename); 

      // Download file from FTP server 
//      InputStream is = ftp.retrieveFileStream("/SymbolDirectory/otherlisted.txt"); 
 
 	      InputStream is = (InputStream) ftp.retrieveFileStream(s);
      //InputStream is = ftp.retrieveFileStream("/SymbolDirectory/nasdaqlisted.txt"); 

      System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
      
		Scanner sc = new Scanner( is );
	      
	      while(sc.hasNextLine()){
		      String input = sc.nextLine();
			    String[] dataElements = input.split(delims);
			    symbols.add(dataElements[0]);
		      //System.out.println(input);
	      }

	      sc.close();
	      is.close();

    } catch (IOException e) { 
      e.printStackTrace(); 
    } finally { 
      try { 
        if (fos != null) { 
          fos.close(); 
        } 
        ftp.disconnect(); 
        //System.out.print(ftp.getReplyCode()+"-"+ftp.getReplyString());
      } catch (IOException e) {
        e.printStackTrace(); 
      } 
    }
    return symbols;
  } 

} 
