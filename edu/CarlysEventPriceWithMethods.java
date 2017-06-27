package edu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;



public class CarlysEventPriceWithMethods {
	
	private static final double PRICE_PER_PERSON = 35.00;
	private static final  int MAX = 5;
	
	/*
	 * I added this method to create a Customer Name from user input
	 */
	public static String getCustomerName(final Scanner scanner){
		boolean loopExit = false;
		String customerName = null;
	while(!loopExit){
		
		System.out.print("Please Enter First Name ");
		String firstName = scanner.next();
		System.out.print("Please Enter Last Name ");
		String lastName = scanner.next();
		
		StringBuilder customername = new StringBuilder();
		
		customername.append(firstName);
		customername.append(" ");
		customername.append(lastName);
		
		customerName = customername.toString();
		
		
		 if(customerName.isEmpty()){
			 System.out.println( "Please re-enter your name");
		 }else{
			 loopExit = true;
		 }
		
		 }
	 return customerName;	 
		
	}
	
	// For Chapter 7 Capstone...
	//No Error Handling due to StringBuffer modification in setContactNumber
	public static String getContactNumber(final Scanner scanner){
		boolean loopExit = false;
		String contactNumber = null;
		
		while(!loopExit){
			System.out.print("Please Enter your Contact Number: ");
			contactNumber = scanner.next();
			loopExit = true;
		}
		loopExit = true;
		return contactNumber;
	}
	

//	// For Chapter 3 Capstone...
//	//Chapter 12 ..1...Error Handling...
//	// Example of Creating Custom Exception
//	public  static String generateEventNumber(final Scanner scanner) throws AlphaNumericException {
//		boolean loopExit = false;
//		String eventNumber = null;
//	while(!loopExit){
//		try{
//		System.out.print("Please enter an Alpha Numeric Event Number (for ex: M122): ");
//		 eventNumber = scanner.next();
//		 if(Character.isDigit(eventNumber.charAt(0))) throw  new AlphaNumericException();
//		 loopExit = true;
//		}
//		catch(AlphaNumericException e){
//			System.out.println("Please Enter Proper Event Number");
//		}
//		
//	}
//		loopExit = true;
//		return eventNumber;
//	}
	
	
	// Chapter 12..1...Error Handling
	//Example of UN-Checked Exception
		public static int getGuestCount(final Scanner scanner) {
			int numberOfGuests = 0;
			try{
			System.out.print("Please Enter the number of guests attending this event: ");
			 numberOfGuests = scanner.nextInt();
			scanner.nextLine();	
			}
			catch(InputMismatchException e){
				System.out.println("Please use Number to Enter Guest Account");
			}
			return numberOfGuests;
		}
		
		
		
	
		// For Chapter 8 Capstone...created
		//Chapter 12..1..Example of catching two Exceptions
		public static String getEventOption(final Scanner scanner) {
			int eventIn = 0;
			boolean loopExit = false;
			System.out.println("(1) : Wedding ");
			System.out.println("(2) : Baptism ");
			System.out.println("(3) : Birthday");
			System.out.println("(4) : Corporate ");
			System.out.println("(5) : Other ");
			
			// BUG: TRY..CATCH gets stuck in loop if letter is inputed...
		while(!loopExit){	
				try{
					System.out.println("Please Pick a Number for your Event: ");
					eventIn = scanner.nextInt();
					if(eventIn > 5) throw new IndexOutOfBoundsException();
					loopExit = true;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please Enter Only Number for Event");
				}
				catch(IndexOutOfBoundsException e)
				{
					eventIn = MAX;
					loopExit = true;
				}
		   }
		 		loopExit = true;
		 		return Integer.toString(eventIn);
		}
		
		
		
			 
		public static int[] userReplyToDinnerEvent(final Scanner scanner){
			String[] Options = { "Entree", "SideOne", "Dessert"};
			int[] dinnerAnswer = new int[4];

				System.out.println("*****Here is our Dinner Menu *****");
				System.out.println();
				
				// Beginin of For Loop
				for(int i=0 ; i < Options.length ; i++){
					if(i == 0){
						System.out.println("**** " + Options[i] + " ****");
						for(int x =0 ; x < Options.length +1 ; x++){
						String OptionEntree = "("+ (x+1) +")" + DinnerEvent.getUserEntrees(x);
						System.out.println(OptionEntree);
						}
					}else if(i == 1){
						System.out.println("**** " + Options[i] + " ****"); 
						for(int x =0 ; x < Options.length +1; x++){
						String OptionSideOne ="("+ (x+1) +")" +  DinnerEvent.getUserSideDish(x);
						System.out.println(OptionSideOne);
						}
						
					}else if(i == 2){
						System.out.println("**** " + Options[i] + " ****"); 
						for(int x =0 ; x < Options.length +1; x++){
						String OptionDessert ="("+ (x+1) +")" +  DinnerEvent.getUserDessert(x);
						System.out.println(OptionDessert);
						}
					}
					System.out.println();
				}//end of for loop
				
				
				boolean loopExit = false;
			while(!loopExit){
				try{
					System.out.println("Please select 1-4 to pick an Entree Option ");
					int entree = scanner.nextInt();
					dinnerAnswer[0] = entree;
					System.out.println("Please select 1-4 to pick an SideOne Option ");
					int sideOne= scanner.nextInt();
					dinnerAnswer[1] = sideOne;
					System.out.println();System.out.println("Please select 1-4 to pick an sideTwo Option ");
					int sideTwo = scanner.nextInt();
					dinnerAnswer[2] = sideTwo;
					System.out.println();System.out.println("Please select 1-4 to pick an Dessert Option ");
					int dessert = scanner.nextInt();
					dinnerAnswer[3] = dessert;
					loopExit = true;
				}
				catch (InputMismatchException  e)
				{
					System.out.println("Please Enter Only Numbers for Dinner Choices");
				}
				loopExit = true;
			}//end of loop
					return dinnerAnswer;
	}// end of  userReplyToDinnerEvent method
			
		
		
		
		public static String userReplyToEvent(final Scanner scanner){
			System.out.println("Would you like to plan Another Event \nY: YES \nN: NO");
			String userReply = scanner.next();
			return userReply;
		}
		
	
	
	
	/**
	 * OVERLOADED Display Methods************************************************************
//	 */
//		public static void displayCompanyMottoWithBorder() {
//			 // Finally display the motto....
//		    System.out.println("******************************************************");
//			System.out.println("**** Carly's makes the food that makes it a party ****");
//			System.out.println("******************************************************");
//		}
//	******************************************************************************************
//		public static void displayEventDetails(final int numberOfGuests) {		
//			// compute the total price = number of guests * price per guest.
//			double totalPrice = numberOfGuests * PRICE_PER_PERSON;
//			System.out.print("Price Per Guest: " + PRICE_PER_PERSON);
//			System.out.print("# Number of Guests: " + numberOfGuests);
//			System.out.print("Total Price: " + totalPrice);
//		
//			// Display whether job is classified as a large event or not..
//		    boolean isLargeEvent = (numberOfGuests > 50);
//		    System.out.print("Is Large Event: " + isLargeEvent);		
//		}
//		****************************************************************************************
//		// NOTE: We created this method to support the ASK in the Chapter 5 capstone..
//		public static void displayEventDetails(final EnhancedEvent event) {	
//			System.out.println("Thank You for letting us Plan your: " + event.getEventOption() + " Event" );
//			System.out.println("Your Contact Number is: " + event.getContactNumber());
//			System.out.println("Event Number: " + event.getEventNumber());
//			System.out.println("Price Per Guest: " + event.getPricePerGuest());
//			System.out.println("# Number of Guests: " + event.getNumberOfGuest());
//			System.out.println("Total Price: " + event.getTotalPrice());
//			System.out.println("Is Large Event: " + event.isLargeEvent());
//		}
//		
		// NOTE: Chapter 11 ASK...passes a Dinner Event
//		public static void displayDinnerEventDetails(final DinnerEvent event) {	
//			System.out.println("Thank You for letting us Plan your: " + event.getEventOption()  + " Event" );
//			System.out.println("Event Number: " + event.getEventNumber());
//			System.out.println("# Number of Guests: " + event.getNumberOfGuest());
//			System.out.println("Contact Number: " + event.getContactNumber());
//			System.out.println();
//			System.out.println("Your Dinner Menu");
//			event.setMenu();
//			System.out.println(event.getMenu());
//		}
//		
		// NOTE: Chapter 11 ASK...passes a Dinner Event with NO Catering Option
		public static void displayDinnerEventDetails(final DinnerEvent event, final Boolean noMenu) {	
			System.out.println("Thank You  for letting us Plan your: " + event.getEventOption()  + " Event" );
			System.out.println("Event Number: " + StaffDinnerEventAndCreateFile.modifiedEvent);
			System.out.println("# Number of Guests: " + event.getNumberOfGuest());
			System.out.println("Contact Number:  " + event.getContactNumber());
			System.out.println();
			System.out.println("Your Dinner Menu");
			event.setMenu();
			System.out.println(event.getNoMenu());
			System.out.println("Your Staff "  );
			System.out.println(event.getEmployeeList());
		
		}
		// NOTE: Chapter 11 ASK...passes a Dinner Event
		public static void displayStaffDinnerEventDetails(final DinnerEvent event) {	
			System.out.println("Thank You  for letting us Plan your: " + event.getEventOption()  + " Event" );
			System.out.println("Event Number: " + StaffDinnerEventAndCreateFile.modifiedEvent);
			System.out.println("# Number of Guests: " + event.getNumberOfGuest());
			System.out.println("Contact Number: " + event.getContactNumber());
			System.out.println();
			System.out.println("Your Dinner Menu");
			event.setMenu();
			System.out.println(event.getMenu());
			System.out.println();
			System.out.println("Your Staff "  );
			System.out.println(event.getEmployeeList());
		
		}
		// NOTE: Chapter 13 ASK...write  Dinner Event
		public static StringBuilder createStaffDinnerEventDetails(final DinnerEvent event) {
			StringBuilder completeEvent = new StringBuilder();
			
			completeEvent.append("Thank You for letting us Plan your: " + event.getEventOption()  + " Event" 
					+ System.getProperty("line.separator"));
			completeEvent.append("Event Number: " + event.getEventNumber() + 
					System.getProperty("line.separator"));
			completeEvent.append("Number of Guests: " + event.getNumberOfGuest()+
					System.getProperty("line.separator"));
			completeEvent.append("The Total Pric: $" + event.getTotalPrice()+
					System.getProperty("line.separator"));
			completeEvent.append("Contact Number: " + event.getContactNumber() +
					System.getProperty("line.separator"));
			completeEvent.append(System.getProperty("line.separator"));
			completeEvent.append("Your Dinner Menu" + 
					System.getProperty("line.separator") + "***************" +
					System.getProperty("line.separator"));
			event.setMenu();
			completeEvent.append(event.getMenu() + 
					System.getProperty("line.separator"));
			completeEvent.append(System.getProperty("line.separator"));
			
			completeEvent.append("Your Staff " + System.getProperty("line.separator") + 
					"**********" + System.getProperty("line.separator") 
					+ event.completeEmployeeList);
			
			completeEvent.append(System.getProperty("line.separator") + "##################################" +
			 System.getProperty("line.separator")) ;
			return completeEvent;
		}
		//**************************************************************************
		// SORTING OPTIONS
		// NOTE: Modified method signature to take in a List...
		// Chapter 9 request..I used the Comparator Class to sort through a Arraylist..this calls the compare method on line 127...and does a bubble sort on the list...
		public  static void eventSort(List<DinnerEvent> eventOption){
			 Collections.sort(eventOption, new Comparator<DinnerEvent>(){
				 public int compare(DinnerEvent s1,DinnerEvent  s2){
					 return Integer.valueOf(s1.getEventNumber().compareTo(s2.getEventNumber()));
				 }
			 });
			 for(DinnerEvent sortedList : eventOption){
				 System.out.println("***************** SORTED BY EVENT NUMBER : " + sortedList.getEventNumber() + "  *******************");
					// Display Event details...
					CarlysEventPriceWithMethods.displayStaffDinnerEventDetails(sortedList);
					System.out.println();
			 }
		   }// end of eventSort
		   
	// NOTE: Modified method signature to take in a List...
	// Chapter 9 request..I used the Comparator Class to sort through a Arraylist..this calls the compare method on line 127...and does a bubble sort on the list...
		public static void numOfGuestSort(List<DinnerEvent>eventOption){
		  Collections.sort(eventOption, new Comparator<DinnerEvent>(){
				 public int compare(DinnerEvent s1, DinnerEvent s2){
					 return Integer.valueOf(s1.getNumberOfGuest()).compareTo(s2.getNumberOfGuest());
				 }
			 });
			 for(DinnerEvent sortedList : eventOption){
				 System.out.println("***************** SORTED BY NUMBER OF GUEST NUMBER : " + sortedList.getEventNumber() + "  *******************");
					// Display Event details...
					CarlysEventPriceWithMethods.displayStaffDinnerEventDetails(sortedList);
					System.out.println();
			 }	     
		}// end of numofGuestSort
	 
	
	// NOTE: Modified method signature to take in a List...
	// Chapter 9 request..I used the Comparator Class to sort through a Arraylist..this calls the compare method on line 127...and does a bubble sort on the list...
	    public static void typeOfEventSort(List<DinnerEvent>eventOption){
			  Collections.sort(eventOption, new Comparator<DinnerEvent>(){
					 public int compare(DinnerEvent s1, DinnerEvent s2){
						 return String.valueOf(s1.getEventOption()).compareTo(s2.getEventOption());
					 }
				 });
				 for(DinnerEvent sortedList : eventOption){
					 System.out.println("***************** SORTED BY EVENT TYPE : " + sortedList.getEventNumber() + "  *******************");
						// Display Event details...
						CarlysEventPriceWithMethods.displayStaffDinnerEventDetails(sortedList);
						System.out.println();
				 }
		     }// end of typeOfEventSort
		
	
	/**
	 * Driver- Just used to verify local methods this class
	 * @param args
//	 */
//	public static void main(String args[]) {
//		
//		Scanner scanner = new Scanner(System.in);
//		userReplyToDinnerEvent(scanner);
//	
//	}

}
