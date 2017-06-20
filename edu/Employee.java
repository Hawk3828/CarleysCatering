package edu;

public abstract class Employee {
	
	private int employeeIDNumber;
	private String lastName;
	private String firstName;
	protected double payRate;
	private String jobTitle;
	// creates theses arrays to automatically set my employess for the dinnerEvent Object
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
	
	// Employee Contructor ...creates random number 0-10..then uses it to set array element in Arrays
	public Employee(){
		int x = (int)(Math.random()*10);
		setFirstName(empFirstName[x]);
		setLastName(empLastName[x]);
		setEmployeeIDNumber(empID[x]);
	}
	
	public int getEmployeeIDNumber() {
		return employeeIDNumber;
	}


	public void setEmployeeIDNumber(int employeeIDNumber) {
		this.employeeIDNumber = employeeIDNumber;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public double getPayRate() {
		return payRate;
	}
	// NOTE: only abstract classes can have abstract methods..
	public abstract void setPayRate(double payRate);
	
	public String getJobTitle() {
		return jobTitle;
	}
	// The professor changged this to access jobTitle..
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
