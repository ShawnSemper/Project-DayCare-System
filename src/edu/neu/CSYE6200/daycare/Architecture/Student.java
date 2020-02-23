package edu.neu.CSYE6200.daycare.Architecture;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.StyledEditorKit.BoldAction;

import edu.neu.CSYE6200.daycare.Architecture.Schedule.Immunization;
import edu.neu.CSYE6200.daycare.Database.showAllSchedule;
import edu.neu.CSYE6200.daycare.Database.updateSchedule;

public class Student extends Person {

	private int studentID;
	private int groupID;
	private String birthday = null;
	private Schedule schedule = new Schedule();
	private String nextvaccinename;
	private String nextvaccinedate;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(int age, String firstname, String lasstname, int studentID, int groupID, String birthday, String nextvaccinename, String nextvaccinedate) {
		super(age, firstname, lasstname);
		// TODO Auto-generated constructor stub
		this.birthday = birthday;
		this.groupID = groupID;
		this.studentID = studentID;
		this.nextvaccinedate = nextvaccinedate;
		this.nextvaccinename = nextvaccinename;
	}

	
	public String getNextvaccinename() {
		return nextvaccinename;
	}
	public void setNextvaccinename(String nextvaccinename) {
		this.nextvaccinename = nextvaccinename;
	}
	public String getNextvaccinedate() {
		return nextvaccinedate;
	}
	public void setNextvaccinedate(String nextvaccinedate) {
		this.nextvaccinedate = nextvaccinedate;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	
	public void autosetSchedule(int Hib, int DTaP, int Polio, int HepatitisB, int MMR, int Varicella, int Meningococcal) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy/MM/dd");
		String enddate = dataformat.format(c.getTime());
		enddate = Schedule.setImmunizationdate(enddate, 0, -1, 0);
		if(Hib == 0 && DTaP == 0 && Polio == 0 && HepatitisB == 0 && MMR == 0 && Varicella == 0 && Meningococcal == 0){	
			for (int i = Hib; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Hib" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = DTaP; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("DTaP" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Polio; i < 3; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Polio" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = HepatitisB; i < 3; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("HepatitisB" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = MMR; i < 1; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("MMR" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Varicella; i < 1; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Varicella" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Meningococcal; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Meningococcal" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
		}
		else {
			for (int i = 0; i < Hib; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Hib" + Integer.toString(i)), "Unknow",true));
			}
			for (int i = 0; i < DTaP; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("DTaP" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = 0; i < Polio; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Polio" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = 0; i < HepatitisB; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("HepatitisB" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = 0; i < MMR; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("MMR" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = 0; i < Varicella; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Varicella" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = 0; i < Meningococcal; i++) {
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Meningococcal" + Integer.toString(i)), "Unknow", true));
			}
			for (int i = Hib; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Hib" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = DTaP; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("DTaP" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Polio; i < 3; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Polio" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = HepatitisB; i < 3; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("HepatitisB" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = MMR; i < 1; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("MMR" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Varicella; i < 1; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Varicella" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
			for (int i = Meningococcal; i < 4; i++) {
				enddate = Schedule.setImmunizationdate(enddate, 0, 1, 0);
				this.getSchedule().addImmunization(this.schedule.new Immunization(("Meningococcal" + Integer.toString(i)), enddate, Schedule.judgestatus(enddate)));
			}
		}
		
		
		
	}

	public void setNextVaccineStatue() {
		for (Immunization i : this.getSchedule().getImmunizations()) {
			if ( i.getImmunizationdate().equals(this.nextvaccinedate) ){
				i.setStatus(true);;
				try {
					updateSchedule.update(this.getStudentID(), i);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.setSchedule(showAllSchedule.showAllSchedule(this));
	}

	public Boolean autosetNextVaccine() {
		for (Immunization i : this.getSchedule().getImmunizations()) {
			if (!(i.getStatus())){
				this.setNextvaccinedate(i.getImmunizationdate());
				this.setNextvaccinename(i.getName());
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return Integer.toString(this.getStudentID());
	}
	

	

	

	

	
}
