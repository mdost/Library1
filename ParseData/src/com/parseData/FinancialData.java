package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class FinancialData{
	public Date FiscalYear;
	public double PrimaryRevenue;
	public double GiftsNoReceipts;
	public double RevGovernment;
	public double OtherRevenue;
	public double TotalRevenue;
	public double ExpCharitablePrograms;
	public double ExpFundarising;
	public double ExpMgmtAdmin;
	public double ExpTotal;
	public double ProfitLoss;
	public double Cash;
	public double LTI;
	public double OtherAssets;
	public double TotalAssets;
	public double AcctsPayable;
	public double DefRevenue;
	public double OtherLiabilities;
	public double TotalLiabilities;


}