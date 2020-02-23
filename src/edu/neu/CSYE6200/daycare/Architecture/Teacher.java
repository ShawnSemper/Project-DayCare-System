package edu.neu.CSYE6200.daycare.Architecture;

public class Teacher extends Person {

	private int employeeID;
	private int groupID;
	private double credit;	//which is the incoming for each student
	private double wage;	//which is the total incoming
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int age, String firstname, String lasstname, int employeeID, int groupID, double credit, double wage) {
		super(age, firstname, lasstname);
		// TODO Auto-generated constructor stub
		this.credit = credit;
		this.wage = wage;
		this.groupID = groupID;
		this.employeeID = employeeID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	@Override
	public String toString() {
		return Integer.toString(this.getEmployeeID());
	}
	
	
	
	
	
	
}
