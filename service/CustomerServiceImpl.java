
/*robomq
 * Abhishek Khandelwal
 * 24-01-2020
 * EcommerceUI
 */

package com.robomq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.robomq.dao.DBConnection;
import com.robomq.pojo.Customer;

public  class CustomerServiceImpl implements CustomerService {
	Connection con;
	PreparedStatement pre;
	int ra;
	ResultSet res;
	boolean flag=false;
	public CustomerServiceImpl()
	{
		con=DBConnection.getConnection();
	}

	//Register a New Customer
	public boolean createCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("insert into Customer values(?,?,?,?,?)");
			pre.setInt(1,c.getId());
			pre.setString(2,c.getName());
			pre.setString(3,c.getEmail());
			pre.setString(4,c.getAddress());
			pre.setString(5,c.getMobileno());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ResultSet displayCustomer(Customer c)
	{
		try {
			pre=con.prepareStatement("select * from Customer where id=? and name=?");
			pre.setInt(1, c.getId());
			pre.setString(2, c.getName()); 
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ResultSet loginCustomer(Customer c)
	{
		try
		{
			pre = con.prepareStatement("Select * from Customer where id=? and name=?");
			pre.setInt(1, c.getId());
			pre.setString(2, c.getName());
			res = pre.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	
	public boolean updateCustomer(Customer c){
		try {
			pre = con.prepareStatement("update Customer set email=?.address=?,mobile_no=? where id=?");
			pre.setString(1,c.getEmail());
			pre.setString(2, c.getAddress());
			pre.setString(3, c.getMobileno());
			pre.setInt(4,c.getId());
			
			ra  = pre.executeUpdate();
			
			if(ra > 0)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    return flag;
		}
	
	public boolean deleteCustomer(Customer c)
	{
		try
		{
			pre = con.prepareStatement("delete from Customer where id=?");
			pre.setInt(1, c.getId());
			int del = pre.executeUpdate();
			if(del > 0)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

}
