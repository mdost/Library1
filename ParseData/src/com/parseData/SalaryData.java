package com.parseData;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryData {
	
	//@XmlPath("data/charitySalaries/salaryData")
	private int NumTop10_1_39999;
	private int NumTop10_40K_79999;
	private int NumTop10_80K_119999;
	private int NumTop10_120K_159999;
	private int NumTop10_160K_199999;
	private int NumTop10_200K_249999;
	private int NumTop10_250K_299999;
	private int NumTop10_300K_349999;
	private int NumTop10_350K_Plus;
	private int NumPartTimeEmployees;
	private int TotalCompensationPartTimeEmployees;
	private int TotalCompensationOrganization;
	private GiveAPI error;

	//setters
		@JsonProperty("NumTop10_1_39999")
		public void set_NumTop10_1_39999(int value){
			NumTop10_1_39999= value;
		}
		
		@JsonProperty("NumTop10_40K_79999")
		public void set_NumTop10_40K_79999(int value){
			NumTop10_40K_79999= value;
		}
		
		@JsonProperty("NumTop10_80K_119999")
		public void set_NumTop10_80K_119999(int value){
			NumTop10_80K_119999= value;
		}
		
		@JsonProperty("NumTop10_120K_159999")
		public void set_NumTop10_120K_159999(int value){
			NumTop10_120K_159999= value;
		}
		
		@JsonProperty("NumTop10_160K_199999")
		public void set_NumTop10_160K_199999(int value){
			NumTop10_160K_199999= value;
		}

		@JsonProperty("NumTop10_200K_249999")
		public void set_NumTop10_200K_249999(int value){
			NumTop10_200K_249999= value;
		}
		@JsonProperty("NumTop10_250K_299999")
		public void set_NumTop10_250K_299999(int value){
			NumTop10_250K_299999= value;
		}
		@JsonProperty("NumTop10_300K_349999")
		public void set_NumTop10_300K_349999(int value){
			NumTop10_300K_349999= value;
		}
		@JsonProperty("NumTop10_350K_Plus")
		public void set_NumTop10_350K_Plus(int value){
			NumTop10_350K_Plus= value;
		}
		@JsonProperty("NumPartTimeEmployees")
		public void set_NumPartTimeEmployees(int value){
			NumPartTimeEmployees= value;
		}
		@JsonProperty("TotalCompensationPartTimeEmployees")
		public void set_TotalCompensationPartTimeEmployees(int value){
			TotalCompensationPartTimeEmployees= value;
		}
		@JsonProperty("TotalCompensationOrganization")
		public void set_TotalCompensationOrganization(int value){
			TotalCompensationOrganization= value;
		}
		
		public void setError(GiveAPI value){
			this.error= value;
		}
		
		//getters
		public int get_NumTop10_1_39999(){
			return NumTop10_1_39999;
		}
		
		public int get_NumTop10_40K_79999(){
			return NumTop10_40K_79999;
		}
		
		public int get_NumTop10_80K_119999(){
			return NumTop10_80K_119999;
		}
		
		public int get_NumTop10_120K_159999(){
			return NumTop10_120K_159999;
		}
		
		public int get_NumTop10_160K_199999(){
			return NumTop10_160K_199999;
		}
		
		public int get_NumTop10_200K_249999(){
			return NumTop10_200K_249999;
		}
		
		public int get_NumTop10_250K_299999(){
			return NumTop10_250K_299999;
		}
		
		public int get_NumTop10_300K_349999(){
			return NumTop10_300K_349999;
		}
		
		public int get_NumTop10_350K_Plus(){
			return NumTop10_350K_Plus;
		}
		
		public int get_NumPartTimeEmployees(){
			return NumPartTimeEmployees;
		}
		
		public int get_TotalCompensationPartTimeEmployees(){
			return TotalCompensationPartTimeEmployees;
		}
		
		public int get_TotalCompensationOrganization(){
			return TotalCompensationOrganization;
		}
	
		public GiveAPI getError(){
			return error;
		}
		
		public String toString(){
			String formattedString = "\n\nCharity Salaries\n"+"----------------------------------------------------------------------\nNumber of top 10 salaries in varying ranges from low to high:\n"
									+String.format("%s %20s %20s %20s %20s %20s %20s %20s %10s", "1 to 39999","40K to 79999","80K to 119999","120K to 159999","160K to 199999","200K to 249999","250K to 299999","300K to 349999","350K+\n")
									+ String.format("%5s",get_NumTop10_1_39999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_40K_79999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_80K_119999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_120K_159999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_160K_199999())
									+String.format("%15s"," ")+String.format("%5s",get_NumTop10_200K_249999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_250K_299999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_300K_349999())+String.format("%15s"," ")+String.format("%5s",get_NumTop10_350K_Plus())+"\n\n"
									+ "# of part time employees: "+get_NumPartTimeEmployees()+"\n"+"Total Compensation Part Time Employees: "+get_TotalCompensationPartTimeEmployees()+"\n"+"Total Compensation Organization: "+get_TotalCompensationOrganization()+"\n";
			return formattedString;
		}
}