package com.GB.Funds.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.GB.Funds.model.*;
import com.GB.Funds.service.FundsService;
import com.GB.service.FundsService;

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
	}
