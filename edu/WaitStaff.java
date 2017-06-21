package edu;

public class WaitStaff extends Employee {

	public WaitStaff() {
		super();
		setJobTitle("Waitstaff ");
		setPayRate(15.00);
	}

	@Override
	public void setPayRate(double payRate) {
		if(payRate > 10.0) {
			payRate = 10.0;
		}
		this.payRate = payRate;
	}
	
	public static void main(String[] args) {

}
}
