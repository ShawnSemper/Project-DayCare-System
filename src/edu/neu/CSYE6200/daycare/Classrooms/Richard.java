package edu.neu.CSYE6200.daycare.Classrooms;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;

public class Richard extends Classroom {

private static AbstractClassroom richard = null;
	
	private Richard()
	{
		super();
		this.setName("Richard");
		this.setId(5);
	}
	
	
	public static synchronized AbstractClassroom getInstance()
	{
		if (richard == null)
		{
			richard = new Richard();
			return richard;
		}
		else
			return richard;
	}
}
