package edu.neu.CSYE6200.daycare.API;

import edu.neu.CSYE6200.daycare.Architecture.Teacher;

public class TeacherFactory {

private static TeacherFactory teacherfactory = null;
	
	private TeacherFactory()
	{
		
	}
	
	public static TeacherFactory getInstance()
	{
		if (teacherfactory == null)
		{
			teacherfactory = new TeacherFactory();
			return teacherfactory;
		}
		else
			return teacherfactory;
	}
	
	public Teacher getteacherInstance()
	{
		return new Teacher();
	}
	
	public Teacher getteacherInstance(int age, String firstname, String lastname, int employeeID, int groupID, double credit, double wage)
	{
		return new Teacher(age, firstname, lastname, employeeID, groupID, credit, wage);
	}
	
}
