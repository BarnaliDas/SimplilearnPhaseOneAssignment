package com.applicationMain;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class FileOperation {
	 Set<File> fileList = new TreeSet<File>();
	 String [] filename=null;
	

	public void displaySortedFiles(String directory) {
		try {
		final File folder = new File(directory);
			    File[] filesInFolder = folder.listFiles();
			    if (filesInFolder != null && filesInFolder.length>0 ) {
			        for (final File fileEntry : filesInFolder) {
			          
			        	if(fileEntry.isFile()) 
			            fileList.add(fileEntry);
			           
			     }
			    }else {
			    	System.out.println("No files to show within the directory:"+directory);
			    }
			    
			 for(File f:fileList) {
				 System.out.println(f.getName());
			 }
		}catch(NullPointerException ne){
			System.out.println("Invalid Directory");
			
		}
			 
			    }


	public void addNewFileToDirectory(String directory, String fileName) {
		//to add new file into the directory
		boolean success=false;
		File f = new File(directory+"\\"+fileName); 
		if (f.exists()) 
		{ 
			System.out.println("File already exists"); 
			} 
		else 
		{ 
			
			try {
				success = f.createNewFile();
			} catch (IOException e) {
				System.out.println("Sorry file couldn't be created.Please try again");
			} 
			if (success) {
				System.out.println("Successfully created new file at : "+ f.getAbsolutePath()); 
				} 
			else {
				System.out.println("Failed to create new file"); 
				} 
			}

		
		
	}


	public void deleteFileFromDirectory(String directory, String fileName) {
		// to delete file form the directory
		boolean success=false;
		File f = new File(directory+"\\"+fileName); 
		if (!f.exists()) 
		{ 
			System.out.println("File not found in the directory"); 
			} 
		else 
		{ 
				success = f.delete();
			
			 
			if (success) {
				System.out.println("File Successfully deleted "); 
				} 
			else {
				System.out.println("Failed to delete file"); 
				} 
			}

		
		

	}


	public void searchFileWithinTheDirectory(String directory, String fileName) {
		//To search for given file
		 FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String file) { 
	            return file.equals(fileName);
	         } 
	      };
	      File dir = new File(directory);
	      String[] filesFound = dir.list(filter);
	      if(filesFound !=null && filesFound.length>0) {
	    	  System.out.println("File found in the Directory.");
	    	   }
	      else {
	    	  System.out.println("File cannot be found in the Directory.");
	      }
	}
			 }

		


