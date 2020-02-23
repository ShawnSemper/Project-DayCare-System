package edu.neu.CSYE6200.daycare.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.neu.CSYE6200.daycare.API.AbstractClassroom;
import edu.neu.CSYE6200.daycare.Architecture.Classroom;
import edu.neu.CSYE6200.daycare.Architecture.Group;
import edu.neu.CSYE6200.daycare.Architecture.Teacher;

public class updateClassroom {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "123456";
	   
	   
	   public static void update(AbstractClassroom s) throws SQLException, ClassNotFoundException {
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
		    String sql = "update classroom set GroupNum=?, StudentNum=?, MaxGroupNum=?, name=?  where ClassroomID= ?";
		    PreparedStatement pstmt;
		   // stmt.executeUpdate(sql);

		    // Now you can extract all the records
		    // to see the updated records


		     pstmt=(PreparedStatement) conn.prepareStatement(sql);
		     pstmt.setInt(1,s.getGroupnum());
		     pstmt.setInt(2,s.getStudentnum());
		     pstmt.setInt(3,s.getMaxgroupnum());
		     pstmt.setString(4,s.getName());
		     pstmt.setInt(5,s.getId());

		     pstmt.executeUpdate();
		    // stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
		   }
	   
	   //remove a group from the classroom by set the group's classroomID to 0(not delete the group) 
	   public static void removeGroup(int classroomId, int groupId) throws ClassNotFoundException, SQLException {
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
		    String sql = "update classroom set GroupNum= GroupNum-1 where ClassroomID= ?";
		    String sql2 = 	"update grouptb set ClassroomID = 0 where GroupID = ?";
		    String sql3 = 	" UPDATE classroom A set A.StudentNum = (SELECT SUM(StudentNum) FROM grouptb WHERE ClassroomID = A.ClassroomID)";
		    
		    PreparedStatement pstmt;
		//    stmt.executeUpdate(sql);
		    pstmt=(PreparedStatement) conn.prepareStatement(sql);

		    pstmt.setInt(1,classroomId);
		     pstmt.executeUpdate();
		     
			pstmt=(PreparedStatement) conn.prepareStatement(sql2);

			    pstmt.setInt(1,groupId);
			     pstmt.executeUpdate();

			     pstmt=(PreparedStatement) conn.prepareStatement(sql3);

				     pstmt.executeUpdate();    
		//    stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
	   }
	   
	   // add a group to the classroom and update the classroom's student number
	   public static void addGroup(int classroomId, int groupId) throws ClassNotFoundException, SQLException {
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
		    String sql = "update classroom set GroupNum= GroupNum+1 where ClassroomID= ?";
		    String sql2 = 	"update grouptb set ClassroomID = ? where GroupID = ?";
		    String sql3 = 	" UPDATE classroom A set A.StudentNum = (SELECT SUM(StudentNum) FROM grouptb WHERE ClassroomID = A.ClassroomID)";
		    
		    PreparedStatement pstmt;
		//    stmt.executeUpdate(sql);
		    pstmt=(PreparedStatement) conn.prepareStatement(sql);

		    pstmt.setInt(1,classroomId);
		     pstmt.executeUpdate();
		     
			pstmt=(PreparedStatement) conn.prepareStatement(sql2);

			pstmt.setInt(1,classroomId);
	        pstmt.setInt(2,groupId);
			pstmt.executeUpdate();

			pstmt=(PreparedStatement) conn.prepareStatement(sql3);

		    pstmt.executeUpdate();  
		  //  stmt.executeUpdate(sql);
		     pstmt.close();
		     conn.close(); 
	   }
	   
	   
	  
}
