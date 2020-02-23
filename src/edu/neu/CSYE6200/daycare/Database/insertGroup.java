package edu.neu.CSYE6200.daycare.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


import edu.neu.CSYE6200.daycare.API.AbstractGroup;
import edu.neu.CSYE6200.daycare.Architecture.Group;

public class insertGroup {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/DayCare?useSSl=false&serverTimezone=UTC";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "123456";

	/*
	 * insert(Group), å�‚æ•°ï¼šGroup å¯¹è±¡list
	 * 
	 */   
   public static void insert(AbstractGroup c) throws IOException{
   Connection conn = null;
   Statement stmt = null;
   
   String sql = "INSERT INTO groupTB VALUES (?,?,?,?)";
   
//   System.out.println("input Group id:");
//   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//   String[] str=br.readLine().split(" ");
//   Integer idGroup = Integer.valueOf(str[0]);
   //String fName=str[1].toString();
   //String lName=str[2].toString();
   //Integer age=Integer.valueOf(str[3]);
   //Integer Group=Integer.valueOf(str[4]);
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");

      stmt = conn.createStatement();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, c.getGroupID());
      ps.setInt(4, c.getClassroomID());
 
      ps.setInt(2, c.getStudentnum());
      ps.setInt(3, c.getGrouprule());

      int rs=ps.executeUpdate();
      ps.close();
      conn.close();

      
      System.out.println("Inserted records into the table...");
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
}//end main
}//end JDBCExample