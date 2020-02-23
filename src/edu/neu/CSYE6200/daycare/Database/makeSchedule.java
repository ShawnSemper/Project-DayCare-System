package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.neu.CSYE6200.daycare.Architecture.Schedule;
import edu.neu.CSYE6200.daycare.Architecture.Schedule.Immunization;

public class makeSchedule {
  	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   
	   public static void makeTable(Schedule s) throws ClassNotFoundException, SQLException {
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
		    System.out.println("Creating statement...schedule");
		    stmt = conn.createStatement();
		   
		    PreparedStatement pstmt;
		    
		    //creat sql table
			   String creatSql = "CREATE TABLE "
					   + s.getStudentID() + "tb"
					   + " (StudentID int(8) not null,"
					   + "name varchar(32) NOT NULL, "
					   + "date varchar(32) not null, "
					   + "statue tinyint(1)"
					   + ")ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
			   stmt.executeUpdate(creatSql);
	
			   
			//   stmt.executeUpdate(creatSql);
			   //insert data		   
			   for (Schedule.Immunization immunization : s.getImmunizations()) {
				   String sql = "INSERT INTO " + s.getStudentID() +"tb" +" VALUES (?,?,?,?)";
				   
			//	   stmt = conn.createStatement();
				   PreparedStatement ps = conn.prepareStatement(sql);
				   ps.setInt(1, s.getStudentID());
				   ps.setString(2, immunization.getName());
				   ps.setString(3, immunization.getImmunizationdate());
				   ps.setBoolean(4, immunization.getStatus());
				   ps.executeUpdate();
				   ps.close();
				   
				   
			}
			   stmt.close();
			   conn.close();

	   }
}
