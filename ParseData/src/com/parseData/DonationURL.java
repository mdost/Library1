package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonationURL{
	private String donationURL;
	private String expires;
	private GiveAPI error;

	//setters
	@JsonProperty("donationURL")
	public void setdonationURL(String value){
		this.donationURL = value;
	}
	
	@JsonProperty("expires")
	public void setexpires(String value){
		this.expires = value;
	}
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	
	//getters
	public GiveAPI getError(){
		return error;
	}
	
	public String getDonationURL(){
		return donationURL;
	}
	
	public String getExpires(){
		return expires;
	}
	
	public String toString(){
		return "DonationURL: "+getDonationURL()+"\nExpires: "+getExpires();
	}
}