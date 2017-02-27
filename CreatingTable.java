package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatingTable {
	
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			 con = DriverManager.getConnection(dburl);
			
			 String query="CREATE TABLE ipl_team(" 
      +" team_id INT NOT NULL ," 
	  +" team_firstname VARCHAR(15) ," 
       +"team_midname VARCHAR(15) ," 
	+"team_lastname VARCHAR(15) ," 
           +"  primary key (team_id) )";
			 
		 pstmt = con.prepareStatement(query);	 
		int n=pstmt.executeUpdate();	 
			 
		
		if(n==1)
		{
			System.out.println("s");
		}
		else
		{
			System.out.println("n");
		}
		} catch (  ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
