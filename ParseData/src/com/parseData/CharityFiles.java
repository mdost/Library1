package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharityFiles{
	private int ID;
	private String Name;
	private String Description;
	private Date FileDate;
	private String Type;
	private String DownloadUrl;
	private GiveAPI error;

	//Setters
	@JsonProperty("ID")
	public void setID(int id){
		this.ID = id;
	}
	
	@JsonProperty("Name")
	public void setName(String name){
		this.Name = name;
	}
	
	@JsonProperty("Description")
	public void setDescription(String description){
		this.Description = description;
	}
	
	@JsonProperty("FileDate")
	public void setFileDate(Date fileDate){
		this.FileDate = fileDate;
	}
	
	@JsonProperty("Type")
	public void setType(String type){
		this.Type = type;
	}
	
	@JsonProperty("DownloadUrl")
	public void setDownloadUrl(String DownloadUrl){
		this.DownloadUrl = DownloadUrl;
	}
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	
	//getters
	public int getID(){
		return this.ID;
	}
	
	public Date getFileDate(){
		return this.FileDate;
	}
	
	public String getDownloadUrl(){
		return this.DownloadUrl;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public String getType(){
		return this.Type;
	}
	
	public String getDescription(){
		return this.Description;
	}
	
	public GiveAPI getError(){
		return error;
	}
}