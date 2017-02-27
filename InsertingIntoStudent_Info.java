package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class InsertingIntoStudent_Info {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstm=null;
		
		try {
			// step 1 driver register
			
			Driver dref =new Driver();
		    DriverManager.registerDriver(dref);
		    
		    // get the connection 
		    
		    String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
		   con= DriverManager.getConnection(dburl);
		    
		    // issue sql query 
		    
		    String query ="insert into student_info value (?,?,?)";
		    pstm=con.prepareStatement(query);
		    
		    // if u want to take input from command line 
		    
		   /* 
		    * pstm.setInt(1,Integer.parseInt(args[0]));
			   pstm.setString(2, args[1]);
			   pstm.setInt(3,Integer.parseInt(args[2]));
			   
			   */
		    
		    // if u want to take input from the console during run time 
			   System.out.println("enter the id of the student");
			   int id=scn.nextInt();
			   System.out.println("enter the name of the student");
			   String name=scn.next();
			   System.out.println("enter the age ");
			   int age=scn.nextInt();
			   pstm.setInt(1,id);
			   pstm.setString(2, name);
			   pstm.setInt(3,age);
		    int n=pstm.executeUpdate();
		    
		   
		
		   System.out.println("sucessfully added "+n+"row");
			}
		
		catch (SQLException e)
		{
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
				if(pstm!=null)
				{
					pstm.close();
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}