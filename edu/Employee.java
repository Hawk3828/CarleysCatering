package edu;

import java.util.LinkedList;
import java.util.List;

public abstract class Employee {
	
	
	// Removed First and last name and replaces with just a full name
	private int employeeIDNumber;
	//private String lastName;
	//private String firstName;
	private String name;
	protected double payRate;
	private String jobTitle;
	
	
	/*******************************************************************************************
	* This  was my original attempt to create random names to use for employeeList

		private String[] empFirstName ={"Mike",
							       		"Dave", 
							       		"Charles", 
							       		"Melissa",
							       		"Danny",
							       		"April",
							       		"Jane",
							       		"Michelle",
							       		"Janet",
								   		"Tyler"};
									
		private String[] empLastName = {"Smith",
										"Jones",
										"Kelly",
										"Willams",
										"Brown",
										"Davis",
										"Miller",
										"WIlson",
										"Moore",
										"Thomas",
										"Jackson"};
	
	 	private int[] empID = { 1,2,3,4,5,6,7,8,9,10};
	
	 * 
	 ***********************************************************************************************/
	
	
	/*Original Employee Constructor created first/last name with random method...updated to combine 
	 * and use index to get a random name from the linkedlist
	 */
	 List<String> empList = new LinkedList<>();
	 
	public Employee(){
		int index = (int)(Math.random()*10);
		setEmployeeIDNumber(index);
		addempList(empList);
		setName(empList.get(index));
//		setFirstName(empFirstName[x]);
//		setLastName(empLastName[x]);
//		setName(empLastName[x]);
	}
	
	
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

//	public String getLastName() {
//		return lastName;
//	}
//
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}

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
			empList.add("April Miller");
			return empList;
		}
		
	public static void main(String[] args) {
		
//		Employee sam = new Employee();
//		
//		sam.empList.forEach(p-> {System.out.println(p.indexOf(3));
//		});
//
//	}

}
	
} // end of abstract Class Employee
