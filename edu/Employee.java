package edu;

import java.util.LinkedList;
import java.util.List;

public abstract class Employee {
	
	
	private int employeeIDNumber;
	private String name;
	protected double payRate;
	private String jobTitle;
	
	
	
	/************************************************************************************************
	 * Original Employee Constructor created first/last name with random method...updated to combine 
	 * and use index to get a random name from the linkedlist
	 ************************************************************************************************/
	 List<String> empList = new LinkedList<>();
	 
	 
	 // Default Constructor for Employee Class
	public Employee(){		
		int index = (int)(Math.random()*10);
		setEmployeeIDNumber(index);
		addempList(empList);
		setName(empList.get(index));
	}
	
	
	
	//******************Getters & Setters************************
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}

	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getPayRate() {
		return payRate;
	}
	
	// NOTE: only abstract classes can have abstract methods..
	public abstract void setPayRate(double payRate);
	
	public String getJobTitle() {
		return jobTitle;
	}
	// The professor changed this to access jobTitle..
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	//******************************************************************
	
	
	
	/****************************************************
	 * Implemented a Checked LinkedList to add employees,
	 *  Not requires in CapStone..added advance data structure
	 */
		public static List<String> addempList (List<String> empList) {
			empList.add("Mike Smith");
			empList.add("Donald Jackson");
			empList.add("Dave Jones");
			empList.add("Charles Kelly");
			empList.add("Melissa Willams");
			empList.add("Michelle WIlson");
			empList.add("Janet Moore");
			empList.add("Tyler Thomas");
			empList.add("Danny Brown");
			empList.add("Von Rafer");
			empList.add("Dwight Howard");
			empList.add("Patrick Ewing");
			empList.add("Chris Paul");
			empList.add("Tracy McGrady");
			return empList;
		}
		
	public static void main(String[] args) {
		


}
	
} // end of abstract Class Employee
