package edu.neu.CSYE6200.daycare.Architecture;

public class Person {

	private int age;
	private String firstname;
	private String lasstname;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(int age, String firstname, String lasstname) {
		super();
		this.age = age;
		this.firstname = firstname;
		this.lasstname = lasstname;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasstname() {
		return lasstname;
	}
	public void setLasstname(String lasstname) {
		this.lasstname = lasstname;
	}
	
	
	@Override
	public String toString() {
		return "age=" + age + ", firstname=" + firstname + ", lasstname=" + lasstname + "";
	}
	
}
