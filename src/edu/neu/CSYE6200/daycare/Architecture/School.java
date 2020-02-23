package edu.neu.CSYE6200.daycare.Architecture;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.API.AbstractGroup;
import edu.neu.CSYE6200.daycare.API.AbstractSchool;
import edu.neu.CSYE6200.daycare.API.ClassroomFactory;
import edu.neu.CSYE6200.daycare.API.GroupFactory;
import edu.neu.CSYE6200.daycare.API.StudentFactory;
import edu.neu.CSYE6200.daycare.API.TeacherFactory;
import edu.neu.CSYE6200.daycare.Database.insertGroup;
import edu.neu.CSYE6200.daycare.Database.insertStudent;
import edu.neu.CSYE6200.daycare.Database.insertTeacher;
import edu.neu.CSYE6200.daycare.Database.makeSchedule;
import edu.neu.CSYE6200.daycare.Database.searchGroup;
import edu.neu.CSYE6200.daycare.Database.searchStudent;
import edu.neu.CSYE6200.daycare.Database.searchTeacher;
import edu.neu.CSYE6200.daycare.Database.showAllClassroom;
import edu.neu.CSYE6200.daycare.Database.showAllGroup;
import edu.neu.CSYE6200.daycare.Database.showAllSchedule;
import edu.neu.CSYE6200.daycare.Database.showAllStudent;
import edu.neu.CSYE6200.daycare.Database.showAllTeacher;
import edu.neu.CSYE6200.daycare.Database.updateStudent;
import edu.neu.CSYE6200.daycare.Database.updateTeacher;
import edu.neu.CSYE6200.daycare.Database.updateClassroom;
import edu.neu.CSYE6200.daycare.Database.updateGroup;
import java.util.logging.Level;
import java.util.logging.Logger;

public class School extends AbstractSchool {

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		this.setGroupfactory(GroupFactory.getInstance());
		this.setStudentfactory(StudentFactory.getInstance());
		this.setTeacherfactory(TeacherFactory.getInstance());
		this.setClassroomfactory(ClassroomFactory.getInstance());
		
		this.setClassrooms(showAllClassroom.showAll());
		this.setStudents(showAllStudent.showAll());
		this.setTeachers(showAllTeacher.showAll());
		this.setGroups(showAllGroup.showAll());
		
		for (Student student : this.getStudents()) {
			student.setSchedule(showAllSchedule.showAllSchedule(student));
                        student.getSchedule().setStudentID(student.getStudentID());
		}
                
                
		for (AbstractGroup group : this.getGroups()) {
			group.setStudents(searchStudent.searchStudentByGroupID(group.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(group.getGroupID());
			if (t.size() == 0)
				continue;
			else
				group.setTeacher(t.get(0));
		}
                
                
		for (AbstractClassroom c : this.getClassrooms()) {
                    List<AbstractGroup> gs = searchGroup.searchGroupByClassroomID(c.getId());
                    for (AbstractGroup g : gs) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
                    c.setGroups(gs);

		}
		

		

		

		/**
		 * if no schedule for student, create
		 */
		for(Student s : this.getStudents()) {
			if(s.getNextvaccinedate() == null)
			{
				s.autosetSchedule(0, 0, 0, 0, 0, 0, 0);
				s.autosetNextVaccine();
			
				try {
					updateStudent.update(s);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.getSchedule().setStudentID(s.getStudentID());
				try {
					makeSchedule.makeTable(s.getSchedule());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			
		}
		
		
		
		
		
		
		
	}

	@Override
	public void addStudent(int ID, int GroupID, String firstname, String lastname, int age, String birthday
			, int Hib, int DTaP, int Polio, int HepatitisB, int MMR, int Varicella, int Meningococcal ){
		// TODO Auto-generated method stub
		Student student = this.getStudentfactory().getstudentInstance(age, firstname, lastname, ID, GroupID, birthday, null, null);
		student.autosetSchedule(Hib, DTaP, Polio, HepatitisB, MMR, Varicella, Meningococcal);
		student.autosetNextVaccine();
                student.getSchedule().setStudentID(student.getStudentID());
            try {
                makeSchedule.makeTable(student.getSchedule());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
            }
//		student.getSchedule().getImmunizations().forEach(System.out::println);
//		this.getStudents().add(student);
		try {
			insertStudent.insert(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setStudents(showAllStudent.showAll());
		for (Student s : this.getStudents()) {
			s.setSchedule(showAllSchedule.showAllSchedule(s));
                        s.getSchedule().setStudentID(student.getStudentID());
		}
		
	}

	@Override
	public void addTeacher(int employeeID, int groupID, String firstname, String lastname, int age, double credit, double wage) {
		// TODO Auto-generated method stub
		Teacher teacher = this.getTeacherfactory().getteacherInstance(age, firstname, lastname, employeeID, groupID, credit, wage);
		try {
			insertTeacher.insert(teacher);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTeachers(showAllTeacher.showAll());
	}

	@Override
	public void addGroup(int groupID, Teacher teacher, int studentnum, int maxnum) {
		// TODO Auto-generated method stub
		AbstractGroup group = this.getGroupfactory().getGroupInstance(groupID, 0, studentnum, maxnum);
		teacher.setGroupID(groupID);
		group.setTeacher(teacher);
		try {
			updateTeacher.update(teacher);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			insertGroup.insert(group);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setGroups(showAllGroup.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
	}

	
	
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			updateStudent.update(student);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setStudents(showAllStudent.showAll());
		for (Student s : this.getStudents()) {
			s.setSchedule(showAllSchedule.showAllSchedule(s));
                        s.getSchedule().setStudentID(student.getStudentID());
		}
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			updateTeacher.update(teacher);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTeachers(showAllTeacher.showAll());
	}

	@Override
	public void updateGroup(AbstractGroup group) {
		// TODO Auto-generated method stub
		try {
			updateGroup.update(group);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setGroups(showAllGroup.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
	}

	@Override
	public void addGroupToClassroom(AbstractClassroom classroom, AbstractGroup group) {
		// TODO Auto-generated method stub
		try {
			updateClassroom.addGroup(classroom.getId(), group.getGroupID());
                        group.setClassroomID(classroom.getId());
                        this.getGroups().remove(group);
			classroom.getGroups().add(group);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                this.setGroups(showAllGroup.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
                
		this.setClassrooms(showAllClassroom.showAll());
		
		for (AbstractClassroom c : this.getClassrooms()) {
                    List<AbstractGroup> gs = searchGroup.searchGroupByClassroomID(c.getId());
                    for (AbstractGroup g : gs) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
                    c.setGroups(gs);

		}
		

                

                
	}

	@Override
	public void removeGroupToClassroom(AbstractClassroom classroom, AbstractGroup group) {
		// TODO Auto-generated method stub
		try {
			updateClassroom.removeGroup(classroom.getId(), group.getGroupID());
                        group.setClassroomID(0);
                        classroom.getGroups().remove(group);
                        this.getGroups().add(group);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setGroups(showAllGroup.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
		this.setClassrooms(showAllClassroom.showAll());
		
		for (AbstractClassroom c : this.getClassrooms()) {
                    List<AbstractGroup> gs = searchGroup.searchGroupByClassroomID(c.getId());
                    for (AbstractGroup g : gs) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
                    c.setGroups(gs);

		}
               
	}

	@Override
	public void setStudentVaccine(Student student) {
		// TODO Auto-generated method stub
		student.setNextVaccineStatue();
		student.autosetNextVaccine();
		this.updateStudent(student);
	}

	@Override
	public void removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			edu.neu.CSYE6200.daycare.Database.removeTeacher.remove(teacher);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AbstractGroup g = this.searchGroup(teacher.getGroupID());
			g.setTeacher(null);
			updateGroup.update(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTeachers(showAllTeacher.showAll());
	}

	@Override
	public void removeStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			edu.neu.CSYE6200.daycare.Database.removeStudent.remove(student);
			this.setGroups(showAllGroup.showAll());
			AbstractGroup g = this.searchGroup(student.getGroupID());
			this.updateGroup(g);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setStudents(showAllStudent.showAll());
		for (Student s : this.getStudents()) {
			s.setSchedule(showAllSchedule.showAllSchedule(s));
                        s.getSchedule().setStudentID(student.getStudentID());
		}
                this.setGroups(showAllGroup.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}

	}

	@Override
	public void removeGroup(AbstractGroup group) {
		// TODO Auto-generated method stub
		try {
			edu.neu.CSYE6200.daycare.Database.removeGroup.remove(group);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setGroups(showAllGroup.showAll());
                this.setTeachers(showAllTeacher.showAll());
		for (AbstractGroup g : this.getGroups()) {
			g.setStudents(searchStudent.searchStudentByGroupID(g.getGroupID()));
			List<Teacher> t = searchTeacher.searchTeacherByGroupID(g.getGroupID());
			if (t.size() == 0)
				continue;
			else
				g.setTeacher(t.get(0));
		}
	}

	@Override
	public AbstractGroup searchGroup(int groupID) throws Exception {
		for (AbstractGroup g : this.getGroups()) {
			if (g.getGroupID() == groupID)
				return g;
		}
		throw new Exception("This group not in school!");
	}

	@Override
	public void addStudentToGroup(AbstractGroup group, Student student) {
		// TODO Auto-generated method stub
                student.setGroupID(group.getGroupID());
		this.updateStudent(student);
                group.getStudents().add(student);
		group.setStudentnum(group.getStudentnum() + 1);
		this.updateGroup(group);

	}

	@Override
	public void removeStudentToGroup(AbstractGroup group, Student student) {
		// TODO Auto-generated method stub
		
                student.setGroupID(0);
		this.updateStudent(student);
		group.setStudentnum(group.getStudentnum() - 1);
                group.getStudents().remove(student);
		if(group.getGrouprule() == 0)
			group.setGrouprule(0);
		this.updateGroup(group);
	}

	@Override
	public void changeTeacherToGroup(AbstractGroup group, Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public boolean hasGroup(int groupID) {
        	for (AbstractGroup g : this.getGroups()) {
		if (g.getGroupID() == groupID)
			return true;
		}
                return false;
    }
	
	
	
	
}
