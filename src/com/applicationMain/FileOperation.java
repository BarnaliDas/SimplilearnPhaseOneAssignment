package com.applicationMain;

import java.io.*;
import java.util.*;

public class FileOperation {
	// List<File> fileList = new ArrayList<File>();
	 List<FileOperation> FileOpp= new ArrayList<FileOperation>();
	//List<String> filename=new ArrayList<String>();
	Float filesize;
	String fileName;
	FileOperation(){
		
	}
	 FileOperation(Float filesize, String fileName){
		 this.filesize=filesize;
		 this.fileName=fileName;
	 }
	 
	@Override
public String toString() {
	return  fileName ;
}

	public List<FileOperation> createFileObjects(String directory){
		List<FileOperation> fileArray = new ArrayList<FileOperation>();
		try {
			final File folder = new File(directory);
				    File[] filesInFolder = folder.listFiles();
				    if (filesInFolder != null && filesInFolder.length>0 ) {
				        for (final File fileEntry : filesInFolder) {
				          
				        	if(fileEntry.isFile()) { 
				          //  fileList.add(fileEntry);
				        	fileName=fileEntry.getName();
				        	filesize=(float) fileEntry.getTotalSpace();
				        	fileArray.add(new FileOperation(filesize, fileName));
				        	}
				     }
				    }else {
				    	System.out.println("No files to show within the directory:"+directory);
				    }
			  
			}catch(NullPointerException ne){
				System.out.println("Invalid Directory");
				
			}
				 
				   
		return fileArray;
	}
	public List<FileOperation> sortFiles(List<FileOperation>FileOpp1) {
	Collections.sort(FileOpp, new sortByFileName());
	 return FileOpp;
	}
	public void displaySortedFiles(String directory) {
		try {
			FileOpp=createFileObjects(directory);
			FileOpp=(List<FileOperation>) sortFiles(FileOpp);
		       
		        for (int i = 0; i < FileOpp.size(); i++)
		            System.out.println(FileOpp.get(i));
		  
		  
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

		
class sortByFileName implements Comparator<FileOperation>{

	@Override
	public int compare(FileOperation o1, FileOperation o2) {
		// TODO Auto-generated method stub
		return o1.fileName.compareTo(o2.fileName);
	}
	
}

