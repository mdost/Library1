package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CharityProjects{
	private Date DateModified;
	private String ProjectName;
	private int VolHours;
	private double StaffSal;
	private double MaterialCost;
	private double Overhead;
	private double OtherCosts;
	
	//Setters
	@JsonProperty("DateModified")
	public void setDateModified(Date value){
		this.DateModified = value;
	}
	
	@JsonProperty("StaffSal")
	public void setStaffSal(double value){
		this.StaffSal = value;
	}
	
	@JsonProperty("MaterialCost")
	public void setMaterialCost(double value){
		this.MaterialCost = value;
	}
	
	@JsonProperty("Overhead")
	public void setOverhead(double value){
		this.Overhead = value;
	}
	
	@JsonProperty("OtherCosts")
	public void setOtherCosts(double value){
		this.OtherCosts = value;
	}
	
	@JsonProperty("ProjectName")
	public void setProjectName(String value){
		this.ProjectName = value;
	}
	
	@JsonProperty("VolHours")
	public void setVolHours(int value){
		this.VolHours = value;
	}
	
	//getters
	public double getOtherCosts(){
		return OtherCosts;
	}
	
	public double getOverhead(){
		return Overhead;
	}
	
	public double getMaterialCost(){
		return MaterialCost;
	}
	
	public double getStaffSal(){
		return StaffSal;
	}
	
	public String getProjectName(){
		return ProjectName;
	}
	
	public int getVolHours(){
		return VolHours;
	}
	
	public Date getDateModified(){
		return DateModified;
	}
	
}