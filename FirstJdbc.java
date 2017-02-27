package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FirstJdbc {
	public static void main(String[] args)

	{
		
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
	
		try {
			// step 1 loading the  driver 
			Driver dref = new Driver();
		  DriverManager.registerDriver(dref);
		
		  
		  // get the db connection via driver
		  
		  String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
		  con=DriverManager.getConnection(dburl);
		  
		  //3 issue sql query 
		  String query="select * from student_info";
		  stmt=con.createStatement();
		  rs= stmt.executeQuery(query);
		  
		  while(rs.next())
		  {
			  int id=rs.getInt("id");
			  String StudentName =rs.getString("name");
			  int age = rs.getInt("age");
			  
			  System.out.println("id is          ->\t"+id);
			  System.out.println("Student name is->\t"+StudentName);
              System.out.println("age is         ->\t"+age);	
              System.out.println("--------------------------------");
		  }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
finally
{
	try{
		if(con!=null)
		{
			con.close();
		}
		if (stmt!=null)
		{
			stmt.close();
		}
		if(rs!=null)
		{
			rs.close();
		}
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
}
