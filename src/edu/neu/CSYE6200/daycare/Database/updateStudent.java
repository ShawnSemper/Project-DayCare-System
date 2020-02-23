package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.neu.CSYE6200.daycare.Architecture.Student;



public class updateStudent {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   public static void update(Student s) throws SQLException, ClassNotFoundException {
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
		    String sql = "update Student set StudentID=?, fName=?, lName=?, GroupID=?, Age=?, BirthDate=?, NextVacc=?, NextDate=? where StudentID= ?";
		    PreparedStatement pstmt;
		  //  stmt.executeUpdate(sql);

		    // Now you can extract all the records
		    // to see the updated records


		     pstmt=(PreparedStatement) conn.prepareStatement(sql);
		     pstmt.setInt(1,s.getStudentID());
		     pstmt.setString(2,s.getFirstname());
		     pstmt.setString(3,s.getLasstname());
		     pstmt.setInt(4,s.getGroupID());
		     pstmt.setInt(5,s.getAge());
		     pstmt.setString(6,s.getBirthday());
		     pstmt.setString(7,s.getNextvaccinename());
		     pstmt.setString(8,s.getNextvaccinedate());
		     pstmt.setInt(9,s.getStudentID());

		     pstmt.executeUpdate();

		    // stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
		   }
}
