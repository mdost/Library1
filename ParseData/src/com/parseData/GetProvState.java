package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class GetProvState{
	private String id;
	private String text;

	//setters
	@JsonProperty("@id")
	public void setID(String value){
		this.id = value;
	}
	
	@JsonProperty("#text")
	public void setText(String value){
		this.text = value;
	}
	
	//getters
	public String getID(){
		return this.id;
	}
	
	public String getText(){
		return this.text;
	}
	
	public String toString(){
		return "ID: "+ getID()+" text: "+getText();
	}
	
}