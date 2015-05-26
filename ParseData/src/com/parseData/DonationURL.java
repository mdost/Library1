package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonationURL{
	private String donationURL;
	private String expires;
	
	//setters
	@JsonProperty("donationURL")
	public void setdonationURL(String value){
		this.donationURL = value;
	}
	
	@JsonProperty("expires")
	public void setexpires(String value){
		this.expires = value;
	}
	
	//getters
	public String getDonationURL(){
		return donationURL;
	}
	
	public String getExpires(){
		return expires;
	}
}