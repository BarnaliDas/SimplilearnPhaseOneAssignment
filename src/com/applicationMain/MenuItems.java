package com.applicationMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuItems {
	private  Map <Integer,String> userOperations=new HashMap<Integer,String>(); 
	private  Map <Integer,String> userBusinessOperations=new HashMap<Integer,String>(); 
	private String developerName;
	private final String developer="Barnali Subhankar Das";
	
	MenuItems(){
		this.developerName=developer;
		userOperations.put(1, "Show Files in the Directory");
		userOperations.put(2, "Perform Business Operations");
		userOperations.put(3, "Exit Application");
		userBusinessOperations.put(4, "Add File into the Directory");
		userBusinessOperations.put(5, "Search File from the Directory");
		userBusinessOperations.put(6, "Delete File from the Directory");
		userBusinessOperations.put(7, "Return to Main Menu");
		
	}
	public Map<Integer, String> getUserOperations() {
		return userOperations;
	}
	
	public Map<Integer, String> getUserBusinessOperations() {
		return userBusinessOperations;
	}
	
	public String getDeveloperName() {
		return developerName;
	}
	
	public int DisplayMenu(Map <Integer,String> menuMap, Scanner sc) {
		int userOperation=0;
		System.out.println("Below are the List of Action you can perform:");
		menuMap.forEach((key,value) -> System.out.println(key + "  "+ value));
		
		System.out.println("Enter Key to perform Action:");
		userOperation=sc.nextInt();
		System.out.println("==============================================================");
		return userOperation;
		
	}
	
	
	
}
