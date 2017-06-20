package edu;

public class Bartender extends Employee {

	public Bartender() {
		super();
		setJobTitle("Bartender ");
		setPayRate(30.00);
	}

	@Override
	public void setPayRate(double payRate) {
		if(payRate > 14.00) {
			payRate = 14.00;
		}
		this.payRate = payRate;
	}

//	@Override
//	public void setJobTitle(String jobTitle) {
//		// TODO Auto-generated method stub
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
