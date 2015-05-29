package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@XmlRootElement(name = "provStates")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvState{;
	private GetProvState provState;
	private GiveAPI error;
	
	//setter
	@JsonProperty("provState")
	public void setProvState(GetProvState provState){
		this.provState = provState;
	}
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	
	//getter
	public GetProvState getProvState(){
		return this.provState;
	}
	
	public GiveAPI getError(){
		return error;
	}
	
	
}