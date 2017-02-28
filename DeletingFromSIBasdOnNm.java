package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletingFromSIBasdOnNm 
{
	
	public static void main(String[] args)
	{
		Scanner scn =new Scanner(System.in);
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
	//step 1 register the driver 
			
			Class.forName("com.mysql.jdbc.Driver");
		//step 2 get the connection via driver
			
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			 con = DriverManager.getConnection(dburl);
			
			// step 3 issue sql query
			 
			 String query="delete  from student_info  where age=?";
			  pstmt = con.prepareStatement(query);
			 
			 /* System.out.println("enter the name to delete the details ");
		        String name  = scn.next();*/
			 
			 pstmt.setString(1, args[0]);
			 
			 int update =pstmt.executeUpdate();
			 
			 if(update>=1)
			 {
				 System.out.println("sucessfully deleted ");
			 }
			 else 
			 {
				 System.out.println(" there is a problem");
			 }
			} 
		
		
		  catch (   ClassNotFoundException | SQLException e) 
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


