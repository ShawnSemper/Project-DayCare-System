package edu.neu.CSYE6200.daycare.API;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClassroom {

	private int id;
	private String name;
	private List<AbstractGroup> groups = new ArrayList<AbstractGroup>();
	private int groupnum;
	private int studentnum;
	private int maxgroupnum;	//which is 2 or 3, based on the grouprule
	
	
	public List<AbstractGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<AbstractGroup> groups) {
		this.groups = groups;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroupnum() {
		return groupnum;
	}
	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}
	public int getStudentnum() {
		return studentnum;
	}
	public void setStudentnum(int studentnum) {
		this.studentnum = studentnum;
	}
	public int getMaxgroupnum() {
		return maxgroupnum;
	}
	public void setMaxgroupnum(int maxgroupnum) {
		this.maxgroupnum = maxgroupnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
}
