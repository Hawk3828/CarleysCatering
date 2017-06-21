package edu;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;




/**
 * Chapter 13..ASK #1...
 * @author HAWK
 *
 */
public class StaffDinnerEventAndCreateFile  {
	
	
	private final static int MIN_WAITSTAFF = 10;
	private final static int MIN_BARSTAFF = 25;
	private static final String FILENAME = "StaffedDinnerEvent.txt";
	public static StringBuilder completeDinnerEvent;
	public static File aFile;
	
	
/**********************************************************************
 * Create Database connections and INSERT a table for DinnerEvents  
 *********************************************************************/
	public static void createConnection() throws IOException{
		 //SQL statement for  handleButtonActionNewTR method line 
	    String sql ="CREATE TABLE IF NOT EXISTS DinnerEvents (" +
	    		  	"EventNumber varchar(255) NOT NULL,"+
	    		  	"ContactNumber varchar(255) NOT NULL," +
	    		  	"EventOption varchar (255) NOT NULL," +
	    		  	"entree varchar(255) NOT NULL," +
	    		  	"sideOne varchar(255) NOT NULL," +
	    		  	"sidetwo varchar(255) NOT NULL," +
	    		  	"dessert varchar(255) NOT NULL," +
	    		  	"numberOfGuests int(100) NOT NULL," +
	    		  	"employeeList varchar(255) NOT NULL," +
	    		  	"PRIMARY KEY (EventNumber)) "+
	    		  	"ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ";
		
		try(Connection conn =  DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
														  ResultSet.CONCUR_READ_ONLY);){
				stmt.executeUpdate(sql);
				
				System.out.println("Connected to Database!");
				} catch (SQLException e) {
					DBUtil.processException(e);
				}finally{
					
				}
	}
	
	
	/************************************************************************************************************************
	 * CLASS LOGIC: Loop until you get a number that's greater or equal to 5 or less than or equal to 100..5 and 100 inclusive..
	 * Loop until you get a number that's greater or equal to 5 or less than or equal to 100..5 and 100 inclusive..
	*************************************************************************************************************************/
	static int verifyGuestCount(int numberOfGuest) {	
		int numberOfGuests = numberOfGuest;
		boolean done = false;	
		do {
				if(numberOfGuests >= 5 && numberOfGuests <= 100) {
					done = true;
		}else{
				System.out.println("Carly's Catering Require No Less than 5 guest and No More than 100 to"
						+ " book and event...Thank You");
						done = true;
			}	
		}while(!done);	
		return numberOfGuests;
	}	

	
	/**********************************************************************
	 * Create SystemFile path to save data for DinnerEvents  
	 *********************************************************************/
	 
	public static File createFile(final String aFileName) throws Exception {		
		// identify the file system..
		FileSystem fs = FileSystems.getDefault();
		// gets you the base directory structure...
		String aUserDir = System.getProperty("user.dir"); 
		// full qualified path that also includes the file name...
		//String anAbsolutePath =  aUserDir + "\\src"  + "\\out" + "\\" + FILENAME;
		String anAbsolutePath =  aUserDir + "\\" + FILENAME;
		System.out.println("Absolute Path: " + anAbsolutePath);
		// create an instance of Path with the fully qualified path...
		Path aFullyQualifiedFilePath = fs.getPath(anAbsolutePath);
		// finally, create an instance of a File class using this path...
		File aFile = new File(aFullyQualifiedFilePath.toString());
		// BUG: file is being overwritten on each run..not appended...
		aFile.createNewFile();
		// return a handle to this file (i.e the instance of the File class)
		return aFile;		
	}
	
	
	/**********************************************************************
	 * Create DinnerEvent with Dinner Options and Employee List
	 *********************************************************************/
	
	public static void demoChapter13(final Scanner scanner) throws AlphaNumericException{
	 	List<DinnerEvent> dinnerOption = new ArrayList<DinnerEvent> ();
	 	
	 	Boolean isValid = false;	
	 	int amountWaitStaff = 0 ;
	 	int barStaff = 0;
	 	boolean key ;
	 	
	 	
		while(!isValid){		 	
			 	System.out.println("Registering Your Event:");
		 		String eventNumber = CarlysEventPriceWithMethods.getEventNumber(scanner);
		 		String contactNumber = CarlysEventPriceWithMethods.getContactNumber(scanner);
		 		String eventOption = CarlysEventPriceWithMethods.getEventOption(scanner);
		 		
		 		System.out.println("Would You Like This Event Catered \nY: YES \nN: NO");
				String userDinnerReply = scanner.next();
				
			if(userDinnerReply.equalsIgnoreCase("y")){
				int[] dinnerAnswer = CarlysEventPriceWithMethods.userReplyToDinnerEvent(scanner);
				
				int entree =  dinnerAnswer[0];
				int sideOne = dinnerAnswer[1];
				int sideTwo = dinnerAnswer[2];
				int dessert = dinnerAnswer[3];
				
				int numberOfGuests = CarlysEventPriceWithMethods.getGuestCount(scanner);	
					numberOfGuests = verifyGuestCount(numberOfGuests);
					
					/*
					 * Uses Advance Data Structure example to create a Set that allows NO DUPS to prevent double employees on duty
					 */
					Set<Employee> employeeList = new HashSet<Employee>();
					employeeList.add(new Coordinator());
					employeeList.add(new WaitStaff());
					employeeList.add(new Bartender());
					
					//This while loop was  created for WaitStaff objects in the employeeList Array
					key = false;
					
					while(!key){
						amountWaitStaff = (int)(numberOfGuests / MIN_WAITSTAFF); 
//						int x = 3;// location after the first three elements in the employeeList Array
							for(int x = 0; x <= amountWaitStaff -1 ; ++x){// we started at 1 due to the initial WaitStaff
								employeeList.add(new WaitStaff());
//								x++;
							}
							key = true;
							
						}// end of while loop 
					
					//This while loop was  created for BarTender objects in the employeeList Array
					key = false;
					while(!key){
						barStaff = (int)(numberOfGuests / MIN_BARSTAFF);
//						int z = (amountWaitStaff + 1);
							for(int x = 0; x < barStaff -1; ++x){// y is the amount of time the loop will create object
								employeeList.add(new Bartender());// z is the locaton og the objecy in the array
//								++z;
							}
							key = true;
					}// end of inner while loop
					
					// Creates the Dinner Event object
					 dinnerOption.add(new DinnerEvent(eventNumber, 
													numberOfGuests, 
													contactNumber,
													eventOption,
													employeeList,
													entree ,
													sideOne, 
													sideTwo , 
													dessert));
			}else{
					
						String NoMenu = "You Chose Not To Have Your Event Catered!";
						int numberOfGuests = CarlysEventPriceWithMethods.getGuestCount(scanner);	
						numberOfGuests = verifyGuestCount(numberOfGuests);
						Employee[] employeeList = new Employee[15];
						employeeList[0] = new Coordinator();
						employeeList[1] = new WaitStaff();
						employeeList[2] = new Bartender();
						
						
						// Creates the Dinner Event object with NO-CATERING
						dinnerOption.add(new DinnerEvent(eventNumber, 
													  numberOfGuests, 
													  contactNumber,
													  eventOption,
													  employeeList, 
													  NoMenu));
										}
				
			 	System.out.println("*********************************************************");
		 		String userReply = CarlysEventPriceWithMethods.userReplyToEvent(scanner);
		 		
	
				if (userReply.equalsIgnoreCase("N")){
					
					for(DinnerEvent displayEvent: dinnerOption){
							System.out.println("***************** EVENT DETAILS FOR: " + displayEvent.getEventNumber() + "  *******************");
							// Display Event details...
							if(displayEvent.getNoMenu() != null){
								boolean noMenu = true;
								CarlysEventPriceWithMethods.displayDinnerEventDetails(displayEvent,noMenu );
								completeDinnerEvent = CarlysEventPriceWithMethods.createStaffDinnerEventDetails(displayEvent);
								System.out.println();	
							}else{
					             CarlysEventPriceWithMethods.displayStaffDinnerEventDetails(displayEvent);
					            completeDinnerEvent = CarlysEventPriceWithMethods.createStaffDinnerEventDetails(displayEvent);
								System.out.println();
							}
					}
					 	isValid = true;
				}
		}// end of While Loop
		
		
		/**********************************************************************
		 * Sorting Options for the Dinner Events  
		 *********************************************************************/
		
			System.out.println("*********************************************************");			
			System.out.println("Would You Like to Sort Your Events? \nEnter Y: Yes or N: NO");
			String sortOption = scanner.next();	
			
		 	if (sortOption.equalsIgnoreCase("Y")){
		 		System.out.println("Please Select How You Would Like to Sort Your Events:  \nE = Event Number \nN =Number Of Guest \nT= Event Type \nEnter 999 to quit");
				sortOption = scanner.next();
				
				do{
					if(sortOption.equalsIgnoreCase("E")){
				 		CarlysEventPriceWithMethods.eventSort(dinnerOption);
				 		System.out.println("Please Enter Another Format Option:  \nE = Event Number \nN = Number Of Guest \nT= Event Type \nEnter 999 to quit");
					 	sortOption = scanner.next();		 		
					}else if(sortOption.equalsIgnoreCase("N")){
				 		CarlysEventPriceWithMethods.numOfGuestSort(dinnerOption);
				 		System.out.println("Please Enter Another Format Option:  \nE = Event Number \nN =Number Of Guest \nT= Event Type \nEnter 999 to quit");
					 	sortOption = scanner.next();		 		
					}else if(sortOption.equalsIgnoreCase("T")){
				 		CarlysEventPriceWithMethods.typeOfEventSort(dinnerOption);
				 		System.out.println("Please Enter Another Format Option:  \nE = Event Number \nN =Number Of Guest \nT= Event Type \nEnter 999 to quit");
					 	sortOption = scanner.next();				 	
					}else{
						System.out.println("Please Enter One Of The Given Choices");
						System.out.println();
						System.out.println("Please Enter Another Format Option:  \nE = Event Number \nN =Number Of Guest \nT= Event Type \nEnter 999 to quit");
						sortOption = scanner.next();
					}					
		 		}while(!sortOption.equals("999"));// end of  DO-WHILE LOOP
			
		 	}	 
		 	System.out.println("THANK YOU FOR YOUR BUISNESS!");			 				 	
			 	
	}// END OF Method
	
	
	/**********************************************************************
	 * Writes the DinnerEvent to a 
	 *********************************************************************/
			
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
			
			createConnection();
			
			aFile = createFile(FILENAME);
			Scanner scanner = new Scanner(System.in);
		    demoChapter13(scanner);
		    scanner.close();
			writeListToFile(completeDinnerEvent,aFile);
			
		}	 	
		
		
}	// End of Class		 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	
			 	