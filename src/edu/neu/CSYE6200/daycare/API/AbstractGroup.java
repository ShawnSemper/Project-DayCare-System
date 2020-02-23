package edu.neu.CSYE6200.daycare.API;

import java.util.ArrayList;
import java.util.List;

import edu.neu.CSYE6200.daycare.Architecture.Student;
import edu.neu.CSYE6200.daycare.Architecture.Teacher;

public class AbstractGroup {

	private int groupID;
	private int classroomID;
	private Teacher teacher = new Teacher();
	private List<Student> students = new ArrayList<Student>();
	private int studentnum;	//represent how many students in this group now
	private int grouprule; 	//ratio = grouprule(Student) : 1(Teacher), so the just use grouprule represent ratio
							//studentnum should lesser than grouprule
	
	
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getStudentnum() {
		return studentnum;
	}
	public void setStudentnum(int studentnum) {
		this.studentnum = studentnum;
	}
	public int getGrouprule() {
		return grouprule;
	}
	public void setGrouprule(int grouprule) {
		this.grouprule = grouprule;
	}
	public int getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}


	
	
	
	
}
