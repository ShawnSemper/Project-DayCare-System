package edu.neu.CSYE6200.daycare.Classrooms;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;

public class Ell extends Classroom {

private static AbstractClassroom ell = null;
	
	private Ell()
	{
		super();
		this.setName("Ell");
		this.setId(2);
	}
	
	
	public static synchronized AbstractClassroom getInstance()
	{
		if (ell == null)
		{
			ell = new Ell();
			return ell;
		}
		else
			return ell;
	}
}
