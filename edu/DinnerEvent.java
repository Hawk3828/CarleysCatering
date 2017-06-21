package edu;

import java.util.Set;

public class DinnerEvent extends EnhancedEvent {
	
	// Chapter 10...1a
	private int sideOne;
	private int sideTwo;
	private int entree;
	private int dessert;
	private String menu;
	private String NoMenu;
	
	

	// Array of Dinner Options and Employee Array
	private static final String[]  userEntrees = {"Lobster","Fish","Chicken","Pasta"};
	private static final String[]  userSideDish = {"Salad","Soup","Veggies","Dips"};
	private static final String[]  userDessert = {"IceCream","CheeseCake","Brownie","Cookies"};		
	private  Employee[] employeeList = null ;
	private  Set<Employee>  setEmployeeList = null ;// modified Employee list for Set 
	String completeEmployeeList = "";
	
	
	/**
	 * CHAPTER CONSTRCUTORS
	 */

	
	// Chapter 10 ...1a
	public DinnerEvent (final String eventNumber, 
			            final int numberOfGuest,
			            final String eventChoice,
			            final int entree,
			            final int sideOne,
			            final int sideTwo,
			            final int dessert){
		super(eventNumber,numberOfGuest,eventChoice);
		this.setEntree(entree);
		this.setSideOne(sideOne);
		this.setSideTwo(sideTwo);
		this.setDessert(dessert);
	}
	
	// Chapter 11 ...1d
	public DinnerEvent (final String eventNumber, 
			            final int numberOfGuest,
			            final String contactNumber,
			            final String eventChoice,
			            final Employee[] employeeList,
			            final int entree,
			            final int sideOne,
			            final int sideTwo,
			            final int dessert){
		super(eventNumber,numberOfGuest, contactNumber, eventChoice);
		this.setEmployeeList(employeeList);
		this.setEntree(entree);
		this.setSideOne(sideOne);
		this.setSideTwo(sideTwo);
		this.setDessert(dessert);
		
	}
	
	/*
	 * This DinnerEvent Constructor was created to support the new Set Data structor
	 *  For the Employee LnkedList
	 */
	public DinnerEvent (final String eventNumber, 
			            final int numberOfGuest,
			            final String contactNumber,
			            final String eventChoice,
			            final Set<Employee> employeeList,
			            final int entree,
			            final int sideOne,
			            final int sideTwo,
			            final int dessert){
		super(eventNumber,numberOfGuest, contactNumber, eventChoice);
		this.setEmployeeList(employeeList);
		this.setEntree(entree);
		this.setSideOne(sideOne);
		this.setSideTwo(sideTwo);
		this.setDessert(dessert);
		
	}
	
	//Chapter 11...1c...This constructor is for no catering options
	public DinnerEvent(final String eventNumber, 
						final int numberOfGuest,
						final String eventChoice){
		super(eventNumber,numberOfGuest,eventChoice);
		this.setNoMenu(NoMenu);
		
	}
	
	//Chapter 11...1c...This constructor is for no catering options
	public DinnerEvent(final String eventNumber, 
						final int numberOfGuest,
						final String contactNumber,
						final String eventChoice,
						final Employee[] employeeList,
						final String NoMenu){
		super(eventNumber,numberOfGuest, contactNumber, eventChoice);
		this.setEmployeeList(employeeList);
		this.setNoMenu(NoMenu);
		
	}
	
	
	//Chapter 11 ...1c 
	public void setEmployeeList(Employee[] employeeList) {
		if(employeeList.length == 15) {
			this.employeeList = employeeList;
		}else {
			this.employeeList = new Employee[15];
		}
	}
	
	/*
	 * This setter was modified to support the  Set of employeeList
	 * This setter will guarantee no DUPS in the employee List
	 */
	public void setEmployeeList(Set<Employee> employeeList) {
	this.setEmployeeList = employeeList;
	}
	
	public String getEmployeeList() {
		StringBuilder dinnerStaff = new StringBuilder(completeEmployeeList);  
		
		for(int x = 0; x < employeeList.length; ++x){
			if(employeeList[x] != null){
			dinnerStaff.append(employeeList.getJobTitle() + ": " 
								+ em;
			dinnerStaff.append(System.getProperty("line.separator"));
			}
		}
		this.completeEmployeeList = dinnerStaff.toString();
		return completeEmployeeList;
	}
	
	//********Getter and Setters***************
	public int getSideOne() {
		return sideOne;
	}

	public void setSideOne(final int sideOne) {
		this.sideOne = sideOne - 1 ;
	}

	public int getSideTwo() {
		return sideTwo;
	}

	public void setSideTwo(final int sideTwo) {
		this.sideTwo = sideTwo - 1;
	}

	public int getEntree() {
		return entree;
	}

	public void setEntree(final int entree) {
		this.entree  = entree - 1;
		
	}

	public int getDessert() {
		return dessert;
	}

	public void setDessert(final int dessert) {
		this.dessert = dessert - 1 ;
	}
	

	public String getNoMenu() {
		return NoMenu;
	}

	public void setNoMenu(String noMenu) {
		this.NoMenu = noMenu;
	}
	//********Getter and Setters***************
	


	//********* String[] getters and Setter**************
	//Static method created to return the UserEntree Option
	public static String getUserEntrees(final int dinnerOption) {
		int Options = dinnerOption ;
		String selecteddinnerOption = "";
		
		switch(Options){
		case 0: 
			selecteddinnerOption = userEntrees[0];
			break;
		case 1: 
			selecteddinnerOption = userEntrees[1];
			break;
		case 2: 
			selecteddinnerOption = userEntrees[2];
			break;
		case 3: 
			selecteddinnerOption = userEntrees[3];
			break;
		default:
			System.out.println("There is no Dinner Option for Choice");
		}
		
		return selecteddinnerOption;

	}
	
	//Static method created to return the UserSideDish Option
	public static String getUserSideDish(final int dinnerOption) {
		int Options = dinnerOption ;
		String selecteddinnerOption = "";
		
		switch(Options){
		case 0: 
			selecteddinnerOption = userSideDish[0];
			break;
		case 1: 
			selecteddinnerOption = userSideDish[1];
			break;
		case 2: 
			selecteddinnerOption = userSideDish[2];
			break;
		case 3: 
			selecteddinnerOption = userSideDish[3];
			break;
		default:
			System.out.println("There is no Dinner Option for Choice");
		}
		return selecteddinnerOption;
	}

	///Static method created to return the UserDessert Option
	public static String getUserDessert(final int dinnerOption) {
		int Options = dinnerOption ;
		String selecteddinnerOption = "";
		
		switch(Options){
		case 0: 
			selecteddinnerOption = userDessert[0];
			break;
		case 1: 
			selecteddinnerOption = userDessert[1];
			break;
		case 2: 
			selecteddinnerOption = userDessert[2];
			break;
		case 3: 
			selecteddinnerOption = userDessert[3];
			break;
		default:
			System.out.println("There is no Dinner Option for Choice");
		}
		return selecteddinnerOption;
	}
	//********* String[] getters and Setter**************
	
	
	
	
	// ***********Methods*********************
	// Chapter 10...1a
	public void setMenu(){
		String menuChoiceString = ("");
		StringBuilder menuChoice = new StringBuilder(menuChoiceString);
		
		
		String aEntree = userEntrees[this.getEntree()];
		String aSideOne = userSideDish[this.getSideOne()];
		String aSideTwo = userSideDish[this.getSideTwo()];
		String aDessert = userDessert[this.getDessert()];
		

		menuChoice.append("Entree is: " + aEntree );
		menuChoice.append(System.getProperty("line.separator"));
		menuChoice.append("Side One is: " + aSideOne );
		menuChoice.append(System.getProperty("line.separator"));
		menuChoice.append("Side Two is: " + aSideTwo );
		menuChoice.append(System.getProperty("line.separator"));
		menuChoice.append("Dessert is: " + aDessert );
//		System.out.println(menuChoice);
		this.menu = menuChoice.toString();
	
	}
	
	public String getMenu() {
		return menu;
	}
	

	
//	
//	public static void main(String[] args){
//		
//	setMenu(1,2,3,2);
//		
//}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// End Of Class
