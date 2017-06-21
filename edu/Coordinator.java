package edu;

public class Coordinator extends Employee {

	public Coordinator() {
		super();
		setJobTitle("Coordinator ");
		setPayRate(20.00);
	}

	@Override
	public void setPayRate(double payRate) {
		if(payRate > 20.00) {
			payRate = 20.00;
		}
		this.payRate = payRate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
