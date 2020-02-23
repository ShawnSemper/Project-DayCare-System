package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.neu.CSYE6200.daycare.API.AbstractGroup;
import edu.neu.CSYE6200.daycare.Architecture.Group;



public class updateGroup {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   public static void update(AbstractGroup s) throws SQLException, ClassNotFoundException {
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
		    String sql = "update Grouptb set GroupID=?, StudentNum=?, MaxStudentNum=?, ClassroomID=?  where GroupID= ?";
		    String sql2 =  " UPDATE classroom A set A.StudentNum = (SELECT SUM(StudentNum) FROM grouptb WHERE ClassroomID = A.ClassroomID)";
		    PreparedStatement pstmt;
		  //  stmt.executeUpdate(sql);

		    // Now you can extract all the records
		    // to see the updated records


		     pstmt=(PreparedStatement) conn.prepareStatement(sql);
		     pstmt.setInt(1,s.getGroupID());
		     pstmt.setInt(2,s.getStudentnum());
		     pstmt.setInt(3,s.getGrouprule());
		     pstmt.setInt(4,s.getGroupID());
		     pstmt.setInt(5,s.getGroupID());

		     pstmt.executeUpdate();
		     
		     pstmt=(PreparedStatement) conn.prepareStatement(sql2);
		     pstmt.executeUpdate();

		   //  stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
		   }
}
