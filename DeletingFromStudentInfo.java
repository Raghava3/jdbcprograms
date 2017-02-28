package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletingFromStudentInfo
{

	public static void main(String[] args)
	{   Scanner scn=new Scanner(System.in);
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			//load the  driver 
			/*Driver dref=new Driver();
		    DriverManager.registerDriver(dref);//  tightly coupled
		    */
			Class.forName("com.mysql.jdbc.Driver");// loose couple

		    // get the connection via driver
			  String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
		       con = DriverManager.getConnection(dburl);

		    // issue sql query 
		       String query="delete from student_info where id=?";
		        pstmt = con.prepareStatement(query);
		        
		     //   pstmt.setInt(1, Integer.parseInt(args[0])); this is to take the input from the console
		        
		        System.out.println("enter the id to delete the details ");
		        int id = scn.nextInt();
		       
		        pstmt.setInt(1, id);  
		        int n = pstmt.executeUpdate();
		       if(n>0)
		       {
		    	   
		       
		        System.out.println("sucessfully deleted the details of "+id+" id ");
		       }
		       else
		       {
		    	   System.out.println(" not sucessfully deleted");
		       }
		       
		}   
		
		
		catch ( ClassNotFoundException | SQLException e)
		{
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
		}
		}
		
	}

