package edu.neu.CSYE6200.daycare.API;

import java.util.HashMap;
import java.util.Map;

import edu.neu.CSYE6200.daycare.Classrooms.Curry;
import edu.neu.CSYE6200.daycare.Classrooms.Ell;
import edu.neu.CSYE6200.daycare.Classrooms.Hunt;
import edu.neu.CSYE6200.daycare.Classrooms.Marino;
import edu.neu.CSYE6200.daycare.Classrooms.Richard;

public class ClassroomFactory {

	private static ClassroomFactory classroomfactory = null;
	private static Map<String, Integer> map = new HashMap<String, Integer>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("Curry", 1);
		put("Ell", 2);
		put("Hunt", 3);
		put("Marino", 4);
		put("Richard", 5);
	}};
	
	private ClassroomFactory()
	{
		
	}
	
	public static ClassroomFactory getInstance()
	{
		if (classroomfactory == null)
		{
			classroomfactory = new ClassroomFactory();
			return classroomfactory;
		}
		else
			return classroomfactory;
	}
	
	private AbstractClassroom getCurry()
	{
		return Curry.getInstance();
	}
	private AbstractClassroom getEll()
	{
		return Ell.getInstance();
	}
	private AbstractClassroom getHunt()
	{
		return Hunt.getInstance();
	}
	private AbstractClassroom getMarino()
	{
		return Marino.getInstance();
	}
	private AbstractClassroom getRichard()
	{
		return Richard.getInstance();
	}
	
	public  AbstractClassroom getInstance(String name, int id, int GroupNum, int StudentNum, int MaxGroupNum) throws Exception {
		int i = map.get(name);
		switch (i) {
		case 1:
			this.getCurry().setMaxgroupnum(MaxGroupNum);;
			this.getCurry().setStudentnum(StudentNum);;
			this.getCurry().setGroupnum(GroupNum);;
			this.getCurry().setId(id);
			return this.getCurry();
		case 2:
			this.getEll().setMaxgroupnum(MaxGroupNum);;
			this.getEll().setStudentnum(StudentNum);;
			this.getEll().setGroupnum(GroupNum);;
			this.getEll().setId(id);
			return this.getEll();
		case 3:
			this.getHunt().setMaxgroupnum(MaxGroupNum);;
			this.getHunt().setStudentnum(StudentNum);;
			this.getHunt().setGroupnum(GroupNum);;
			this.getHunt().setId(id);
			return this.getHunt();
		case 4:
			this.getMarino().setMaxgroupnum(MaxGroupNum);;
			this.getMarino().setStudentnum(StudentNum);;
			this.getMarino().setGroupnum(GroupNum);;
			this.getMarino().setId(id);
			return this.getMarino();
		case 5:
			this.getRichard().setMaxgroupnum(MaxGroupNum);;
			this.getRichard().setStudentnum(StudentNum);;
			this.getRichard().setGroupnum(GroupNum);;
			this.getRichard().setId(id);
			return this.getRichard();
			default:
				throw new Exception("This classroom not in school!");
		}
	}
	
	public  AbstractClassroom getInstance(String name) throws Exception {
		int i = map.get(name);
		switch (i) {
		case 1:
			return this.getCurry();
		case 2:
			return this.getEll();
		case 3:
			return this.getHunt();
		case 4:
			return this.getMarino();
		case 5:
			return this.getRichard();
			default:
				throw new Exception("This classroom not in school!");
		}
	}
}
