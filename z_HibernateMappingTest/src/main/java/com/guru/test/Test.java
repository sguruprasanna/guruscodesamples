package com.guru.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.guru.test.tmp.model.Person;
import com.guru.test.tmp.model.Topic;

public class Test {


	public static void main(String args[]) {
		
		
		Topic t1 = new Topic();
		Topic t2 = new Topic();
		
		
		t1.setName("t1");
		t1.setTopicId(1);

		
		t2.setName("t1");
		t2.setTopicId(1);
		
		if(t1.equals(t2)){
			System.out.println("T1 equals T2");
		} else {
			System.out.println("T1 not equals T2");
		}  

		
		System.out.println("T1 hashcode: "+t1.hashCode());
		System.out.println("T2 hashcode: "+t1.hashCode());
		
		
		
		//Hashset test
		Set<String> set1  = new HashSet<String>();
		
		set1.add("Guru");
		set1.add("Guru1");
		set1.add("Guru2");
		set1.add("Guru");
		
		for(String s : set1){
			System.out.println(">>"+s);
		}
		
		
		
		//String split test
		String s = "a~*b~*c~*d~*e~*f~*g";
		String[] tokens = s.split("~\\*");
		
		//List<String> tokenList = Arrays.asList(tokens);
		for(String s1 : tokens){
			System.out.println("token: "+s1);
		}
		
		
	}

}
