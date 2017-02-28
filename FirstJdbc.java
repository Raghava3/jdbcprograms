package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class FirstJdbc {
	public static void main(String[] args)

	{
		
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
	
		try {
			
			
			Scanner scn=new Scanner(System.in);
			// step 1 loading the  driver 
		/*	DeletingFromSIBasdOnNm
			Driver dref =new Driver();// tightly coupled 
		    DriverManager.registerDriver(dref);
		    */
		    
			Class.forName("com.mysql.jdbc.Driver");// loose couple
		System.out.println(" please enter the user name");// to take username from user
		String username=scn.next();
		System.out.println("plsease enter the password");// to take password from user 
		String password=scn.next();
		  
		  // get the db connection via driver
		  
		  String dburl="jdbc:mysql://localhost:3306/Raghava?user="+username+"&password="+password;// sql query 
		  con=DriverManager.getConnection(dburl);// issue the sql query via connection 
		  
		  //3 issue sql query 
		  String query="select * from student_info";
		  //creating the statement 
		  stmt=con.createStatement();
		  rs= stmt.executeQuery(query);
		  System.out.println("id\tStudent name\tage\t");
		  while(rs.next())
		  {
			  int id=rs.getInt("id");
			  String StudentName =rs.getString("name");
			  int age = rs.getInt("age");
			 /* 
			  System.out.println("id is          ->\t"+id);
			  System.out.println("Student name is->\t"+StudentName);
              System.out.println("age is         DeletingFromSIBasdOnNm->\t"+age);	*/
			  
			  
			  
			
			  System.out.println(id+"\t"+StudentName+"\t"+age);
         //     System.out.println("age is         ->\t"+age);	
			  
			  
			  
             
		  }
		
		} catch ( ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
finally
{
	if(con!=null)
	{	
		try
		{
		con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	if(con!=null)
	{	
		try
		{
		con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	   
     }

		if(rs!=null)
		{
			try
			{
			rs.close();
			}
	
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
	}
}

