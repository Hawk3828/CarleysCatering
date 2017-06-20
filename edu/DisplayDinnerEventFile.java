package edu;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;



/**
 * Chapter 13..ASK #1...
 * @author HAWK
 *
 */
public class DisplayDinnerEventFile {

	
	private static final String FILENAME = "StaffedDinnerEvent.txt";
	public static File aFile;
	
	
	public static BufferedReader openFile(final String aFileName) throws Exception {		
		// identify the file system..
		FileSystem fs = FileSystems.getDefault();		
		// gets you the base directory structure...
		String aUserDir = System.getProperty("user.dir"); 		
		// full qualified path that also includes the file name...
		String anAbsolutePath =  aUserDir + "\\" + FILENAME;
		//System.out.println("Absolute Path: " + anAbsolutePath);		
		// create an instance of Path with the fully qualified path...
		Path aFullyQualifiedFilePath = fs.getPath(anAbsolutePath);		
		BufferedInputStream anInputStream = new BufferedInputStream(Files.newInputStream(aFullyQualifiedFilePath));
		InputStreamReader aReader = new InputStreamReader(anInputStream);
		BufferedReader aBufferedReader = new BufferedReader(aReader);		
		// return a handle to this file (i.e the instance of the File class)
		return aBufferedReader;		
	}	
	
	
	public static ArrayList<String> readFileToList(BufferedReader aFileReader) throws Exception {		
		 ArrayList<String> aList = new ArrayList<String>();   
		 boolean done = false;
		 while(!done) {
			String aLine = aFileReader.readLine();
			if(aLine == null) { 
				done = true;
			}else {
				aList.add(aLine);
			}
         }  
		 aFileReader.close();		 
		 return aList;		
	}
	
	
	
			
			public static void writeListToFile(StringBuilder anEvent, File aFile) throws Exception {
				// connects a PrintWriter instance to a File to enable writing to the file...
				PrintWriter aWriter = new PrintWriter(aFile);
				// iterate thru  the array list and write each node of the array list to the file...
				//for (StringBuilder aData : anEvent) 
				// for (Survey survey : aList) {
				// Use the StringBuilder to format the members of the survey class and then send it to the writer
				aWriter.println(anEvent);
				
				// close the writer and therefore the file..
				aWriter.close();
			}
			
			
		 /********************************************************************************
		 * Driver MAIN	
		 * @throws AlphaNumericException 
		 * 
		 * *******************************************************************************
		 */
			
		public static void main(String[] args) throws AlphaNumericException,Exception {
			try{
			BufferedReader aReader = DisplayDinnerEventFile.openFile(FILENAME);
			ArrayList<String> aList = DisplayDinnerEventFile.readFileToList(aReader);
			 StringBuilder aFinalList = new StringBuilder();
			for(String aNewList : aList ){
				aFinalList.append(aNewList + System.getProperty("line.separator"));
			}
			String finalList= aFinalList.toString();
			JOptionPane.showMessageDialog(null, finalList);
			}catch (Exception e) {
			e.printStackTrace();
			}
		} 	
}	// End of Class		 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	