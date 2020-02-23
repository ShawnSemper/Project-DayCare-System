package edu.neu.CSYE6200.daycare.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import edu.neu.CSYE6200.daycare.Architecture.Schedule;
import edu.neu.CSYE6200.daycare.Architecture.Student;

public class showAllSchedule {
 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";


 //  Database credentials
 static final String USER = "root";
 static final String PASS = "123456";

 public static Schedule showAllSchedule(Student s) {
 Schedule c = new Schedule();
// List<Schedule> s = new ArrayList<Schedule>();
 Connection conn = null;
 Statement stmt = null;
 PreparedStatement ps = null;

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
    System.out.println("Creating statement...show schedule");
    String sql = "SELECT * FROM " + s.getStudentID()+"tb";
      stmt = conn.createStatement();
//    Scanner in=new Scanner(System.in);
//    int x=in.nextInt();
//      ResultSet rs=stmt.executeQuery(sql);
      ps=conn.prepareStatement(sql);
//    ps.setInt(1, i);

    ResultSet rs = ps.executeQuery(sql);
    
    //STEP 5: Extract data from result set
    while(rs.next()){
       //Retrieve by column name
       int id  = rs.getInt("StudentID");
       String name = rs.getString("name");
       String date = rs.getString("date");
       boolean statue = rs.getBoolean("statue");
//       int Schedule = rs.getInt("idSchedule");
       c.setStudentID(id);
       c.addImmunization(c.new Immunization(name, date, statue));
      
       //s = new Schedule(id,fName,lName,age,Schedule,Schedule);
    }
//    c.getImmunizations().forEach(System.out::println);
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
 return c;
}//end main
}//end JDBCExample