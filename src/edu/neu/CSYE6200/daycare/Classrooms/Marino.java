package edu.neu.CSYE6200.daycare.Classrooms;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;

public class Marino extends Classroom {

private static AbstractClassroom marino = null;
	
	private Marino()
	{
		super();
		this.setName("Marino");
		this.setId(4);
	}
	
	
	public static synchronized AbstractClassroom getInstance()
	{
		if (marino == null)
		{
			marino = new Marino();
			return marino;
		}
		else
			return marino;
	}
}
