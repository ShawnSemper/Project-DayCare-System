package edu.neu.CSYE6200.daycare.Classrooms;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;

public class Curry extends Classroom {

private static AbstractClassroom curry = null;
	
	private Curry()
	{
		super();
		this.setName("Curry");
		this.setId(1);
	}
	
	
	public static synchronized AbstractClassroom getInstance()
	{
		if (curry == null)
		{
			curry = new Curry();
			return curry;
		}
		else
			return curry;
	}
	
}
