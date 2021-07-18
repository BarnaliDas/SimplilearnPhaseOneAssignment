package com.applicationMain;
import java.io.File;
import java.util.Scanner;

public class LockedMeMain {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Scanner sc =new Scanner(System.in);
		MenuItems menu = new MenuItems();
		FileOperation fo =  new FileOperation();
		boolean flag=true;
		// on welcome screen show developer details with project name
		showWelcomeScreen(menu.getDeveloperName());
		//show operation options to be selected
		showMenuScreen(flag,menu,sc,fo);
		sc.close();
		}catch(Exception e) {
			System.out.println("Some Error occured ");
		}
		

	}

	

	private static void showMenuScreen(boolean flag, MenuItems menu, Scanner sc, FileOperation fo) {
		while(flag) {
			int operation = menu.DisplayMenu(menu.getUserOperations(),sc);
			if(menu.getUserOperations().containsKey(operation)) {
				performMainMenuOperations(operation,menu,sc,fo);
				flag=false;
			}else {
				System.out.println("Invalid response");
				System.out.println("================================");
			}
		}
		
	}
	private static void showSubMenuScreen(boolean flag, MenuItems menu, Scanner sc, FileOperation fo) {
		while(flag) {
			int operation = menu.DisplayMenu(menu.getUserBusinessOperations(),sc);
			if(menu.getUserBusinessOperations().containsKey(operation)) {
				performSubMenuOperations(operation,menu,sc,fo);
				flag=false;
			}else {
				System.out.println("Invalid response");
				System.out.println("================================");
			}
		}
		
	}



	private static void performMainMenuOperations(int operation, MenuItems menu, Scanner sc, FileOperation fo) {
		switch(operation) {
		case 1:
			String directory=getDirectoryFormUser(sc);
			fo.displaySortedFiles(directory);
			break;
			
		case 2:
			showSubMenuScreen(true,menu,sc,fo);
			break;
			
		case 3:
			System.out.print("Application Exited");
			System.exit(0);
			break;
			
		}
	}

	private static String getDirectoryFormUser(Scanner sc) {
		String directory=null;
			System.out.println("Please Enter directory : ");
				 directory=sc.next();
				 File folder = new File(directory);
				 if(!folder.exists()) {
					System.out.println("Invalid directory");
					System.out.println("================================");
					getDirectoryFormUser(sc);
				 }
				 
				/*if(!directory.matches("^(?:[\\w]\\:|\\\\)(\\\\[a-z_\\-\\s0-9\\.])")) {
					System.out.println("Invalid directory");
					System.out.println("================================");
					getDirectoryFormUser(sc);
				}*/
		return directory;
	}



	private static void performSubMenuOperations(int operation, MenuItems menu, Scanner sc, FileOperation fo) {
		switch(operation) {
		case 4: 
			System.out.println("Add File");
			String directory=getDirectoryFormUser(sc);
			String fileName=getFileNameFormUser(sc);
			fo.addNewFileToDirectory(directory,fileName);
			break;
			
		case 5:
			System.out.println("Delete File");
			String directory1=getDirectoryFormUser(sc);
			String fileName1=getFileNameFormUser(sc);
			fo.deleteFileFromDirectory(directory1,fileName1);
			break;
			
		case 6:
			System.out.println("Search File");
			String directory2=getDirectoryFormUser(sc);
			String fileName2=getFileNameFormUser(sc);
			fo.searchFileWithinTheDirectory(directory2,fileName2);
			break;
			
		case 7: 
			showMenuScreen(true,menu,sc,fo);
			
		}
	}
	

	private static String getFileNameFormUser(Scanner sc) {

		String fileName=null;
		Boolean flag=true;
			System.out.println("Please Enter File Name : ");
			fileName=sc.next();
				
				 if(!fileName.matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.txt|.gif|.pdf|.doc|.docx|.xls|.xlsx)$")) {
					System.out.println("Invalid File Name");
					System.out.println("================================");
					getFileNameFormUser(sc);
				 }
			
		return fileName;
	}



	private static void showWelcomeScreen(String developerName) {
	
	System.out.println("WELCOME TO LOCKEDME.COM");	
	System.out.println("Developer Name : "+developerName);
	System.out.println("==============================================================");
	}

}
