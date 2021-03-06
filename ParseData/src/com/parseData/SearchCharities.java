package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchCharities{
	private String regNum;
	private String Name;
	private String Description;
	private String Type;
	private int TypeID;
	private String ProvState;
	private String City;
	private String Country;
	private String CharitySize;
	private String LogoURL;
	private String OperatingCountry;
	private ContactInfoDetails ContactInfo;
	private GiveAPI error;

	private int totalResults;
	private int totalPages;
	private int onPage;
	
	//setters
	@JsonProperty("regNum")
	public void setregNum(String value){
		this.regNum = value;
	}
	
	@JsonProperty("Name")
	public void setName(String value){
		this.Name = value;
	}
	
	@JsonProperty("Description")
	public void setDescription(String value){
		this.Description = value;
	}
	
	@JsonProperty("Type")
	public void setType(String value){
		this.Type = value;
	}
	
	@JsonProperty("TypeID")
	public void setTypeID(int value){
		this.TypeID = value;
	}
	
	@JsonProperty("ProvState")
	public void setProvState(String value){
		this.ProvState = value;
	}
	
	@JsonProperty("City")
	public void setCity(String value){
		this.City = value;
	}
	
	@JsonProperty("Country")
	public void setCountry(String value){
		this.Country = value;
	}
	
	@JsonProperty("CharitySize")
	public void setCharitySize(String value){
		this.CharitySize = value;
	}
	
	@JsonProperty("LogoURL")
	public void setLogoURL(String value){
		this.LogoURL = value;
	}
	
	@JsonProperty("OperatingCountry")
	public void setOperatingCountry(String value){
		this.OperatingCountry = value;
	}
	
	@JsonProperty("ContactInfo")
	public void setContactInfo(ContactInfoDetails value){
		this.ContactInfo = value;
	}
	
	public void setTotalResults(int value){
		this.totalResults = value;
	}
	
	public void setTotalPages(int value){
		this.totalPages = value;
	}
	
	public void setOnPage(int value){
		this.onPage = value;
	}
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	
	//getters
	public String getregNum(){
		return regNum;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public String getType(){
		return Type;
	}
	
	public int getTypeID(){
		return TypeID;
	}
	
	public String getProvState(){
		return ProvState;
	}
	
	public String getCity(){
		return City;
	}
	
	public String getCountry(){
		return Country;
	}
	
	public String getCharitySize(){
		return CharitySize;
	}
	
	public String getLogoURL(){
		return LogoURL;
	}
	
	public String getOperatingCountry(){
		return OperatingCountry;
	}
	
	public ContactInfoDetails getContactInfoDetails(){
		return ContactInfo;
	}
	
	public int getTotalResults(){
		return totalResults;
	}
	
	public int getTotalPages(){
		return totalPages;
	}
	
	public int getOnPage(){
		return onPage;
	}
	
	public GiveAPI getError(){
		return error;
	}
	
}