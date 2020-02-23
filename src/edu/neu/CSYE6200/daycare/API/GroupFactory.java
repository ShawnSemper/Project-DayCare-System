package edu.neu.CSYE6200.daycare.API;

import edu.neu.CSYE6200.daycare.Architecture.Group;

public class GroupFactory {

	private static GroupFactory groupfactory = null;
	
	private GroupFactory()
	{
		
	}
	
	public static GroupFactory getInstance()
	{
		if (groupfactory == null)
		{
			groupfactory = new GroupFactory();
			return groupfactory;
		}
		else
			return groupfactory;
	}
	


	public AbstractGroup getGroupInstance(int groupID, int classroomID, int studentnum, int grouprule) {
		return new Group(groupID, classroomID, studentnum, grouprule);
	}

}