package edu.neu.CSYE6200.daycare.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.neu.CSYE6200.daycare.API.AbstractGroup;
import edu.neu.CSYE6200.daycare.Architecture.Group;

public class showAllGroup {
 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";


 //  Database credentials
 static final String USER = "root";
 static final String PASS = "123456";

 public static List<AbstractGroup> showAll() {
 AbstractGroup c = new Group();
 List<AbstractGroup> allGroup= new ArrayList<>();
 Connection conn = null;
 Statement stmt = null;
 
 String sql = "SELECT * FROM grouptb";
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
//    Scanner in=new Scanner(System.in);
//    int x=in.nextInt();
      ResultSet rs=stmt.executeQuery(sql);
//    PreparedStatement ps=conn.prepareStatement(sql);
//    ps.setInt(1, i);
//    ResultSet rs = ps.executeQuery();
    
    //STEP 5: Extract data from result set
    while(rs.next()){
       //Retrieve by column name
       int id  = rs.getInt("GroupID");
       //int teacherId  = rs.getInt("TeacherID");
       int studentNum  = rs.getInt("StudentNum");
       int classroomID  = rs.getInt("ClassroomID");
       int grouprule = rs.getInt("MaxStudentNum");
       c = new Group(id,classroomID,studentNum,grouprule);
       //s = new Group(id,fName,lName,age,ffName,flName,mfName,mlName,Group,Group);
       allGroup.add(c);
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
 return allGroup;
}//end main
}//end JDBCExample