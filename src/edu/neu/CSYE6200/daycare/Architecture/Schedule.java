package edu.neu.CSYE6200.daycare.Architecture;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;





public class Schedule {

	private List<Immunization> immunizations = new ArrayList<Schedule.Immunization>();
	private int studentID;
	
	
	public class Immunization{
		private String name;
		private String immunizationdate;
		private Boolean status;
		
		public Immunization(String name, String date, Boolean status) {
			super();
			// TODO Auto-generated constructor stub
			this.name = name;
			this.immunizationdate = date;
			this.status = status;
			
		
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImmunizationdate() {
			return immunizationdate;
		}
		public void setImmunizationdate(String immunizationdate) {
			this.immunizationdate = immunizationdate;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return this.name;
		}
		
		
	}

	public void showschedule() {
		for (Immunization immunization : immunizations) {
			System.out.println(immunization.toString());
		}
	}

	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Schedule(int studentID) {
		super();
		// TODO Auto-generated constructor stub
		this.studentID = studentID;
	}



	public List<Immunization> getImmunizations() {
		return immunizations;
	}


	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}
	
	public void addImmunization(Immunization immunization) {
		this.getImmunizations().add(immunization);
	}
	
	public static String setImmunizationdate(String date, int ayear, int amonth, int aday) {
		String[] d = date.split("/");
		int year = new Integer(d[0]);
		int month = new Integer(d[1]);
		int day = new Integer(d[2]);
		year += ayear;
		month += amonth;
		day += aday;
		if(day > 30) {
			month++;
			day -= 30;
		}
		if(month > 12) {
			year++;
			month -= 12;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(year).append('/');
		sb.append(month).append('/');
		sb.append(day);
		return sb.toString();
		
	}
	
	public static Boolean judgestatus(String immunizationdate) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy/MM/dd");
		String d = dataformat.format(c.getTime());
		String[] date = immunizationdate.split("/");
		int year = new Integer(date[0]);
		int month = new Integer(date[1]);
		int day = new Integer(date[2]);
		String[] i = d.split("/");
		int nyear = new Integer(i[0]);
		int nmonth = new Integer(i[1]);
		int nday = new Integer(i[2]);
		if (year < nyear) {
			return true;
		}
		else if (year == nyear) {
			if(month < nmonth) {
				return true;
			}
			else if (month == nmonth) {
				if(day < nday) 
					return true;
				else if (day == nday)
					return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		return false;
	}
	
}
