package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CharityType{
	private String type;
	
	@JsonProperty("type")
	public void set(String type){
		this.type = type;
	}
	
	public String get(){
		return type;
	}
}