package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginPage
{

	public static void main(String[] args) 
	{  ResultSet rs=null;
		PreparedStatement pstm=null;
	    Scanner scn =new Scanner(System.in);
		Connection con=null;
		System.out.println("enter 1 to sign-up/n 2 to login");
		int option =scn.nextInt();
		if((int)option==1 || (int)option ==2)
		{
			    System.out.println(" plaese enter the user name");
				String name= scn.next();
				System.out.println(" plaese enter the password");
				String password= scn.next();
				try{
				Class.forName("com.mysql.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				}
				catch(SQLException | ClassNotFoundException e)
				{
					e.printStackTrace();
				}
				if(option==1)
				{
					try{
					String query ="insert into user_db value (?,?)";
				    pstm=con.prepareStatement(query);
				   
					   pstm.setString(1, name);
					   pstm.setString(2, password);
				    int n=pstm.executeUpdate();
				    
				    if(n==1)
				    {
				
				   System.out.println("signed up sucessfully");
					}
					}
					catch(SQLException e)
					{
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
				
				else if(option ==2)
				{
					String query="select name from user_db where name =? and password = ?";
					try{
					pstm= con.prepareStatement(query);
						
					pstm.setString(1, name);
					pstm.setString(2, password);
					rs=pstm.executeQuery();
					if (rs.next())
						
					{
						String username=rs.getString(1);
						
						System.out.println(" hi  "+username+" its been longtime h r u ?");
					}
					else 
					{
						System.out.println(" please check the user name or password ");

					}
				}
				catch(SQLException e)
				{
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
		else
		{
			System.out.println("invalid ootion ");
		}
		
	}
	
	
}
