package com.GB.Funds.service;
import java.sql.*;
import com.GB.Funds.util.DBconnection;
import com.GB.Funds.model.*;
import com.GB.Funds.util.*;



public class FundsService {
	
Connection con = null;
	
	public FundsService() {
		
		con = DBconnection.connecter();
	}
	
	 //A common method to connect to the DB
	
	
	public String insertFunds(Funds Funds)
	 {
		String query = " insert into Funds(`FundId`,`FundingAgency`,`FAddress`,`FPhone`,`FProjectID`,`Fund`)"
				  + " values (?,?, ?, ?, ?, ?)";
		  
	 String output;
		try {	
				PreparedStatement preparedStatement = con.prepareStatement(query); 
				preparedStatement.setString(1, Funds.getFundId());
				preparedStatement.setString(2, Funds.getFundingAgency());
				preparedStatement.setString(3, Funds.getFAddress());
				preparedStatement.setString(4,  Funds.getFPhone());
				preparedStatement.setString(5, Funds.getFProjectID());
				preparedStatement.setString(6, Funds.getFund()); 
				preparedStatement.execute();
				 con.close();
			  output = "Inserted successfully";
			
		} catch (SQLException e) {
		    output = "Error while inserting the Fund.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	public String readFunds()
	 {
	 String output = "";
	 try
	 {
	
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>Fund ID</th><th>Funding Agency</th><th>Address</th><th>Phone</th><th>Prject ID</th><th>Fund Amount</th></tr>";
	 String query = "select * from Funds";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String FundId = rs.getString("FundId");
		 String FundingAgency = rs.getString("FundingAgency");
		 String FAddress = rs.getString("FAddress");
		 String FPhone = rs.getString("FPhone");
		 String FProjectId = rs.getString("FProjectId");
		 String Fund = rs.getString("Fund");
	 // Add into the html table
		 output += "<tr><td>" + FundId + "</td>";
		 output += "<td>" + FundingAgency + "</td>";
		 output += "<td>" + FAddress + "</td>";
		 output += "<td>" + FPhone + "</td>";
		 output += "<td>" + FProjectId + "</td>";
		 output += "<td>" + Fund + "</td>";
	 
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Funds.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String updateFunds(Funds Funds){
	
	 String query = "UPDATE Funds SET FundingAgency=?,FAddress=?,FPhone=?,FProjectId=?,Fund=? WHERE FundId=?";
	 String output = "";
	 try
	 {
	 
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 
		preparedStatement.setString(1, Funds.getFundingAgency());
		preparedStatement.setString(2, Funds.getFAddress());
		preparedStatement.setString(3, Funds.getFPhone());
		preparedStatement.setString(4, Funds.getFProjectID());
		preparedStatement.setString(5, Funds.getFund()); 
		preparedStatement.setString(6, Funds.getFundId());
		
		
		preparedStatement.execute();
		con.close();
		output = "Updated successfully";
	}
	 catch (Exception e)
	 {
	 output = "Error while updating the Funds.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String deleteFunds(Funds Funds){
		String query = "delete from Funds where FundId=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1,Funds.getFundId() );
	 // execute the statement
	 if(preparedStatement.execute()) {
		 output = "Deleted successfully";
	 }else {
		 output = "id not found";
	 }
		
	 con.close();
	 
	 }catch (Exception e){
	 output = "Error while deleting the Funds.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	

	
	 

}

