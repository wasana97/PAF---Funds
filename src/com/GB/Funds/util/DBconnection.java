package com.GB.Funds.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection connecter()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GB", "root", "");
	 System.out.println("Connection Success");
	 if(con == null) {
		 System.out.println("Connection Failed");
	 }
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 

}
