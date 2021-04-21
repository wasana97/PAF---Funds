package com.GB.Funds.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.GB.Funds.model.*;
import com.GB.Funds.service.FundsService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@Path("/Funds")
public class FundResource {
	
	Funds FundObj = new Funds();
	// Read API
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readFunds() {
			FundsService FundObj = new FundsService();

			return FundObj.readFunds();

		}
		
		// Insert API
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertFunds(String FundData) {
			JsonObject FundObject = new JsonParser().parse(FundData).getAsJsonObject();

			String FundId = FundObject.get("FundId").getAsString();
			String FundingAgency = FundObject.get("FundingAgency").getAsString();
			String FAddress = FundObject.get("FAddress").getAsString();
			String FPhone = FundObject.get("FPhone").getAsString();
			String FProjectID = FundObject.get("FProjectID").getAsString();
			String Fund = FundObject.get("Fund").getAsString();

			FundsService FundObject2 = new FundsService();

			FundObj.setFundId(FundId);
			FundObj.setFundingAgency(FundingAgency);
			FundObj.setFAddress(FAddress);
			FundObj.setFPhone(FPhone);
			FundObj.setFProjectID(FProjectID);
			FundObj.setFund(Fund);

			String output =FundObject2.insertFunds(FundObj);
			return output;
		}
		
		// Update API
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateFunds(String FundData) {
			// Convert the input string to a JSON object
			JsonObject FundObject = new JsonParser().parse(FundData).getAsJsonObject();
			// Read the values from the JSON object
			String FundId = FundObject.get("FundId").getAsString();
			String FundingAgency = FundObject.get("FundingAgency").getAsString();
			String FAddress = FundObject.get("FAddress").getAsString();
			String FPhone = FundObject.get("FPhone").getAsString();
			String FProjectID = FundObject.get("FProjectID").getAsString();
			String Fund = FundObject.get("Fund").getAsString();

			FundsService FundObject1 = new FundsService();

			FundObj.setFundId(FundId);
			FundObj.setFundingAgency(FundingAgency);
			FundObj.setFAddress(FAddress);
			FundObj.setFPhone(FPhone);
			FundObj.setFProjectID(FProjectID);
			FundObj.setFund(Fund);

			String output = FundObject1.updateFunds(FundObj);
			return output;
		}
		
		// Delete API
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteFunds(String FundData) {

			JsonObject FundObject = new JsonParser().parse(FundData).getAsJsonObject();

			String FundId = FundObject.get("FundId").getAsString();

			FundsService FundObject2 = new FundsService();
			FundObj.setFundId(FundId);

			String output = FundObject2.deleteFunds(FundObj);
			return output;
		}
	}
