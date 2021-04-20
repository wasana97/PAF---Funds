package com.GB.Funds.model;

public class Funds {
	private String FundId;
	private String FundingAgency;
	private String FAddress;
	private String FPhone;
	private String FProjectID;
	private float Fund;
	
	public Funds() {
		
	}
	
	public Funds(String FundId, String FundingAgency, String FAddress, String FPhone, String  FProjectID, Float Fund) {
		super();
		this.FundId = FundId;
		this.FundingAgency = FundingAgency;
		this.FAddress = FAddress;
		this.FPhone = FPhone;
		this.FProjectID = FProjectID;
		this.Fund = Fund;
	}

	public String getFundId() {
		return FundId;
	}

	public void setFundId(String FundId) {
		this.FundId = FundId;
	}

	public String getFundingAgency() {
		return FundingAgency;
	}

	public void setFundingAgency(String FundingAgency) {
		this.FundingAgency = FundingAgency;
	}

	public String getFAddress() {
		return FAddress;
	}

	public void setFAddress(String FAddress) {
		this.FAddress = FAddress;
		
	}

	public String getFPhone() {
		return FPhone;
	}

	public void setFPhone(String FPhone) {
		this.FPhone = FPhone;
	}

	public String getFProjectID() {
		return FProjectID;
	}

	public void setFProjectID(String FProjectID) {
		this.FProjectID = FProjectID;
	}

	public Float getFund() {
		return Fund;
	}

	public void sethFund(float Fund) {
		this.Fund = Fund;
	}



}
