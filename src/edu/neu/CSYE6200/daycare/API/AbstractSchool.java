package edu.neu.CSYE6200.daycare.API;

import java.util.ArrayList;
import java.util.List;

import edu.neu.CSYE6200.daycare.Architecture.Student;
import edu.neu.CSYE6200.daycare.Architecture.Teacher;

public abstract class AbstractSchool {

	private List<Teacher> teachers = new ArrayList<Teacher>();
	private TeacherFactory teacherfactory = null;
	private List<Student> students = new ArrayList<Student>();
	private StudentFactory studentfactory = null;
	private List<AbstractGroup> groups = new ArrayList<AbstractGroup>();
	private GroupFactory groupfactory = null;
	private List<AbstractClassroom> classrooms = new ArrayList<AbstractClassroom>();
	private ClassroomFactory classroomfactory = null;
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<AbstractGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<AbstractGroup> groups) {
		this.groups = groups;
	}
	public List<AbstractClassroom> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(List<AbstractClassroom> classrooms) {
		this.classrooms = classrooms;
	}
	public TeacherFactory getTeacherfactory() {
		return teacherfactory;
	}
	public void setTeacherfactory(TeacherFactory teacherfactory) {
		this.teacherfactory = teacherfactory;
	}
	public StudentFactory getStudentfactory() {
		return studentfactory;
	}
	public void setStudentfactory(StudentFactory studentfactory) {
		this.studentfactory = studentfactory;
	}
	public GroupFactory getGroupfactory() {
		return groupfactory;
	}
	public void setGroupfactory(GroupFactory groupfactory) {
		this.groupfactory = groupfactory;
	}
	
	public ClassroomFactory getClassroomfactory() {
		return classroomfactory;
	}
	public void setClassroomfactory(ClassroomFactory classroomfactory) {
		this.classroomfactory = classroomfactory;
	}
	
	/**
	 *initial all class will be used in school
	 */
	public abstract void initial();
	public abstract void addStudent(int ID, int GroupID, String firstname, String lastname, int age, String birthday
			, int Hib, int DTaP, int Polio, int HepatitisB, int MMR, int Varicella, int Meningococcal );
	public abstract void addTeacher(int employeeID, int groupID, String firstname, String lastname, int age, double credit, double wage);
	public abstract void addGroup(int groupID, Teacher teacher, int studentnum, int maxnum);
	
	public abstract void addStudentToGroup(AbstractGroup group, Student student);
	public abstract void removeStudentToGroup(AbstractGroup group, Student student);
	public abstract void changeTeacherToGroup(AbstractGroup group, Teacher teacher);
	
	public abstract void addGroupToClassroom(AbstractClassroom classroom, AbstractGroup group);
	public abstract void removeGroupToClassroom(AbstractClassroom classroom, AbstractGroup group);
	
	public abstract void updateStudent(Student student);
	public abstract void updateTeacher(Teacher teacher);
	public abstract void updateGroup(AbstractGroup group);
	public abstract void setStudentVaccine(Student student);

	public abstract void removeTeacher(Teacher teacher);
	public abstract void removeStudent(Student student);
	public abstract void removeGroup(AbstractGroup group);
	public abstract AbstractGroup searchGroup(int groupID) throws Exception;
        public abstract boolean hasGroup(int groupID);
	
	
	
	
	
}
