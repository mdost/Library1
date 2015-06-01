package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataSearchCharity{
	private int totalResults;
	private int totalPages;
	private int onPage;
	private SearchCharities searchResults;
	
	//setter
	@JsonProperty("totalResults")
	public void setTotalResults(int value){
		this.totalResults = value;
	}
	
	@JsonProperty("totalPages")
	public void setTotalPages(int value){
		this.totalPages = value;
	}
	
	@JsonProperty("onPage")
	public void setOnPage(int value){
		this.onPage = value;
	}
	
	@JsonProperty("charities")
	public void setResults(SearchCharities value){
		this.searchResults = value;
	}
	
	//getter
	public int getTotalResults(){
		return totalResults;
	}
	
	public int getTotalPages(){
		return totalPages;
	}
	
	public int getOnPage(){
		return onPage;
	}
	
	public SearchCharities getSearchCharitiesResults(){
		return searchResults;
	}
}