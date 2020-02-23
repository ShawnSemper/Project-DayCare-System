package edu.neu.CSYE6200.daycare.Classrooms;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;

public class Hunt extends Classroom {

private static AbstractClassroom hunt = null;
	
	private Hunt()
	{
		super();
		this.setName("Hunt");
		this.setId(3);
	}
	
	
	public static synchronized AbstractClassroom getInstance()
	{
		if (hunt == null)
		{
			hunt = new Hunt();
			return hunt;
		}
		else
			return hunt;
	}
}
