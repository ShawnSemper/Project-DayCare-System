package edu.neu.CSYE6200.daycare.API;


import edu.neu.CSYE6200.daycare.Architecture.Student;

public class StudentFactory {

private static StudentFactory studentfactory = null;
	
	private StudentFactory()
	{
		
	}
	
	public static StudentFactory getInstance()
	{
		if (studentfactory == null)
		{
			studentfactory = new StudentFactory();
			return studentfactory;
		}
		else
			return studentfactory;
	}
	
	public Student getstudentInstance()
	{
		return new Student();
	}
	
	public Student getstudentInstance(int age, String firstname, String lastname, int studentID, int groupID, String birthday,  String nextvaccinename, String nextvaccinedate)
	{
		return new Student(age, firstname, lastname, studentID, groupID, birthday, nextvaccinename, nextvaccinedate);
	}
}
