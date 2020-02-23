package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.neu.CSYE6200.daycare.Architecture.Schedule;
import edu.neu.CSYE6200.daycare.Architecture.Schedule.Immunization;



public class updateSchedule {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   public static void update(int studentID, Schedule.Immunization s) throws SQLException, ClassNotFoundException {
		   Connection conn = null;
		   Statement stmt = null;
		   //Scanner in=new Scanner(System.in);


		    //STEP 2: Register JDBC driver
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    //STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    System.out.println("Connected database successfully...");

		    //STEP 4: Execute a query
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		    String sql = "update "+studentID+"tb set StudentID=?, name=?, date=?, statue=? where name= ?";
		    PreparedStatement pstmt;
		  //  stmt.executeUpdate(sql);

		    // Now you can extract all the records
		    // to see the updated records


		     pstmt=(PreparedStatement) conn.prepareStatement(sql);
		     pstmt.setInt(1,studentID);
		     pstmt.setString(2,s.getName());
		     pstmt.setString(3,s.getImmunizationdate());
		     pstmt.setBoolean(4, s.getStatus());
		     pstmt.setString(5,s.getName());

		     pstmt.executeUpdate();

		 //    stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
		   }
}