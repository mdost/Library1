package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

//@XmlRootElement(name = "provStates")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect
public class ProvState{;
	private GetProvState provState;
	
	//setter
	@JsonProperty("provState")
	public void set(GetProvState provState){
		this.provState = provState;
	}
	
	//getter
	public GetProvState getProvState(){
		return this.provState;
	}
}