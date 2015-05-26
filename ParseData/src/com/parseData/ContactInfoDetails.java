package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ContactInfoDetails{
	private String NameOfStaff;
	private String Email;
	private String URL;
	private String Phone;
	
	//setters
	@JsonProperty("NameOfStaff")
	public void setNameOfStaff(String value){
		this.NameOfStaff = value;
	}
	
	@JsonProperty("Email")
	public void setEmail(String value){
		this.Email = value;
	}
	
	@JsonProperty("URL")
	public void setURL(String value){
		this.URL = value;
	}
	
	@JsonProperty("Phone")
	public void setPhone(String value){
		this.Phone = value;
	}
	
	//getters
	public String getNameOfStaff(){
		return NameOfStaff;
	}
	
	public String getEmail(){
		return Email;
	}
	
	public String getURL(){
		return URL;
	}
	
	public String getPhone(){
		return Phone;
	}
	
}