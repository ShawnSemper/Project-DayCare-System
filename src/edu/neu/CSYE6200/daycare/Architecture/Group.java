package edu.neu.CSYE6200.daycare.Architecture;

import edu.neu.CSYE6200.daycare.API.AbstractGroup;

public class Group extends AbstractGroup{

	
	public Group(int groupID, int classroomID, int studentnum, int grouprule) {
		this.setGroupID(groupID);
		this.setClassroomID(classroomID);
		this.setStudentnum(studentnum);
		this.setGrouprule(grouprule);
		
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return Integer.toString(this.getGroupID());
	}
	
	
	
}
