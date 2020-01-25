package com.robomq.ecomUI;

import java.sql.ResultSet;
import java.util.Scanner;

import com.robomq.pojo.Customer;
import com.robomq.service.CustomerService;
import com.robomq.service.CustomerServiceImpl;

public class EcommerceUI {

	Customer c;
	Scanner sc;
	CustomerService service;
	
	// Constructor of EcommerceUI
	public EcommerceUI()
	{
		sc=new Scanner(System.in);
		c=new Customer();
		service=new CustomerServiceImpl();
	}
	
	//Register New Cuustomer
	public void registerCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		System.out.println("Enter Customer Name.");
		c.setName(sc.next());
		System.out.println("Enter Customer email.");
		c.setEmail(sc.next());
		System.out.println("Enter Customer address.");
		c.setAddress(sc.next());
		System.out.println("Enter Customer Mobileno.");
		c.setMobileno(sc.next());
		if(service.createCustomer(c))
			System.out.println("Customer registered successfully...");
		else
			System.out.println("Customer Not registered ...");
		
	}
	
	// Login 
	public void loginCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		System.out.println("Enter Customer name.");
	    c.setName(sc.next());
	    
	    ResultSet res = service.loginCustomer(c);
	    try
	    {
	    	if(res.next() != false)
	    	{
	    		System.out.println("Login Succussfuly" + "Welcome" + c.getName());
	    		
	    		System.out.println("Do you want to update and delete Customer Choose option" + "1.Delete 2. Update");
	    		int ch = sc.nextInt();
	    		if(ch ==1)
	    		{
	    		   c.getId();
	    		   if(service.deleteCustomer(c) == true)
	    		   {
	    			   System.out.println("Customer Record Deleted");
	    		   }
	    		   else
	    			   System.out.println("Customer Record is not deleted");
	    		}
	    		else if(ch == 2)
	    		{
	    			c.getId();
	    			System.out.println("Enter new Customer Email");
	    			c.setEmail(sc.next());
	    			System.out.println("Enter new Customer Address");
	    			c.setAddress(sc.next());
	    			System.out.println("Enter new Custmer Mobile no");
	    			c.setMobileno(sc.next());
	    			
	    			if(service.updateCustomer(c) == true)
	    			{
	    				System.out.println("Customer Details are updated");
	    			}
	    			else
	    			{
	    				System.out.println("Customer Details are not updated");
	    			}
	    		}
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	// view Details of the customer
	public void viewCustomer() {
		System.out.println("Please type the id of the customer you want");
		c.setId(sc.nextInt());
		ResultSet res = service.displayCustomer(c);
		
		try {
			while(res.next())
			{
				System.out.println("Customer Id: " + res.getInt(1));
				System.out.println("Customer Name: " + res.getString(2));
				System.out.println("Customer Email: " + res.getString(3));
				System.out.println("Customer Address: " + res.getString(4));
				System.out.println("Customer Mobile No" + res.getString(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ch=null;
		EcommerceUI e=new EcommerceUI();
		/*while(true)
		{*/
			System.out.println("Enter Your Choice");
			System.out.println("1. Registring New Customer");
			System.out.println("2. Login as Existing Customer");
			System.out.println("3. Exit");
			ch=sc.next();
			switch(ch)
			{
				case "1":
				{
					e.registerCustomer();  
					break;
				}
				
				case "2":
				{
					e.loginCustomer();
				}
				case "3":
				{
					System.exit(0);
				}
			}
	}

}
