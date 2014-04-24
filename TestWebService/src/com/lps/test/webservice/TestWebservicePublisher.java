package com.lps.test.webservice;


import javax.xml.ws.Endpoint;

public class TestWebservicePublisher {
 public static void main(String[] args) {
  Endpoint.publish("http://localhost:8888/services/TestWebservice",new TestWebserviceImpl());
 }
}