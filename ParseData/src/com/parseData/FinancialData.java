package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class FinancialData{
	public Date FiscalYear;
	public String PrimaryRevenue;
	public String GiftsNoReceipts;
	public String RevGovernment;
	public String OtherRevenue;
	public String TotalRevenue;
	public String ExpCharitablePrograms;
	public String ExpFundarising;
	public String ExpMgmtAdmin;
	public String ExpTotal;
	public String ProfitLoss;
	public String Cash;
	public String LTI;
	public String OtherAssets;
	public String TotalAssets;
	public String AcctsPayable;
	public String DefRevenue;
	public String OtherLiabilities;
	public String TotalLiabilities;


}