package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) 
	{

		 Scanner scn=new Scanner(System.in);
			PreparedStatement pstmt=null;
			Connection con=null;
         ResultSet rs =null;
       System.out.println(" plaese enter the user name");
		String name= scn.next();
		System.out.println(" plaese enter the password");
		String password= scn.next();
			
		try {
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			
			String query="select name from user_db where name =? and password = ?";
			
		pstmt=	con.prepareStatement(query);
			
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		if (rs.next())
			
		{
			String username=rs.getString(1);
			
			System.out.println(" welcome "+username);
		}
		else 
		{
			System.out.println(" not found ");

		}
			
		} catch (SQLException | ClassNotFoundException e) {
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