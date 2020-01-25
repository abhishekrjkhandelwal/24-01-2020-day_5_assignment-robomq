/*robomq
 * Abhishek Khandelwal
 * 24-01-2020
 * EcommerceUI
 */
package com.robomq.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{	
	static Connection conn;
	public static Connection getConnection()
	{
		try 
		{	   //Creating the connection 
		       Class.forName("com.mysql.jdbc.Driver");
		       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer","root","A889026a");
		       System.out.println("Connected");
		      
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
}
