package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.neu.CSYE6200.daycare.Architecture.Teacher;

public class searchTeacher {
	// JDBC driver name and database URL
		 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		 static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";


	 //  Database credentials
	 static final String USER = "root";
	 static final String PASS = "123456";

	 public static List<Teacher> searchTeacherByGroupID(int groupID) {
	 Teacher c = new Teacher();
	 List<Teacher> allTeacher= new ArrayList<>();
	 Connection conn = null;
	 Statement stmt = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	// Scanner in=new Scanner(System.in);
	// int i=in.nextInt();
	 try{
	    //STEP 2: Register JDBC driver
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    //STEP 3: Open a connection
	    System.out.println("Connecting to a selected database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    System.out.println("Connected database successfully...");

	    //STEP 4: Execute a query
	    System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	 	 String sql = "SELECT * FROM Teacher where GroupID = ?";

	 	 pstmt = conn.prepareStatement(sql);
	 	 
	 	 pstmt.setInt(1, groupID);
	 	 
	 	 rs = pstmt.executeQuery();
	 	 
	    
	    //STEP 5: Extract data from result set
	 	while(rs.next()){
	        //Retrieve by column name
	        int id  = rs.getInt("EmployID");
	        int groupId  = rs.getInt("EmployID");
	        double credit = rs.getDouble("Credit");
	        double wage = rs.getDouble("Wage");
	        String fName = rs.getString("fName");
	        String lName = rs.getString("lName");

	        int age = rs.getInt("Age");
//	        int Teacher = rs.getInt("TeacherID");
//	        int TeacherNumber = rs.getInt("TeacherNumber");
//	        int TeacherAgeRange = rs.getInt("TeacherAgeRange");
	        c = new Teacher(age,fName,lName,id,groupId,credit,wage);
	        //s = new Teacher(id,fName,lName,age,Teacher,Teacher);
	        allTeacher.add(c);
	    }
	    rs.close();
	    conn.close();
	 }catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
	 System.out.println("Goodbye!");
	 return allTeacher;
	}//end m
}
