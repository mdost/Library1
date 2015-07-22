package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialData{
	private Date FiscalYear;
	private double PrimaryRevenue;
	private double GiftsNoReceipts;
	private double RevGovernment;
	private double OtherRevenue;
	private double TotalRevenue;
	private double ExpCharitablePrograms;
	private double ExpFundarising;
	private double ExpMgmtAdmin;
	private double ExpTotal;
	private double ProfitLoss;
	private double Cash;
	private double LTI;
	private double OtherAssets;
	private double TotalAssets;
	private double AcctsPayable;
	private double DefRevenue;
	private double OtherLiabilities;
	private double TotalLiabilities;
	
	private GiveAPI error;
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	public GiveAPI getError(){
		return error;
	}
	public Date getFiscalYear() {
		return FiscalYear;
	}
	@JsonProperty("FiscalYear")
	public void setFiscalYear(Date fiscalYear) {
		FiscalYear = fiscalYear;
	}
	public double getPrimaryRevenue() {
		return PrimaryRevenue;
	}
	@JsonProperty("PrimaryRevenue")
	public void setPrimaryRevenue(double primaryRevenue) {
		PrimaryRevenue = primaryRevenue;
	}
	public double getGiftsNoReceipts() {
		return GiftsNoReceipts;
	}
	@JsonProperty("GiftsNoReceipts")
	public void setGiftsNoReceipts(double giftsNoReceipts) {
		GiftsNoReceipts = giftsNoReceipts;
	}
	public double getRevGovernment() {
		return RevGovernment;
	}
	@JsonProperty("RevGovernment")
	public void setRevGovernment(double revGovernment) {
		RevGovernment = revGovernment;
	}
	public double getOtherRevenue() {
		return OtherRevenue;
	}
	@JsonProperty("OtherRevenue")
	public void setOtherRevenue(double otherRevenue) {
		OtherRevenue = otherRevenue;
	}
	public double getTotalRevenue() {
		return TotalRevenue;
	}
	@JsonProperty("TotalRevenue")
	public void setTotalRevenue(double totalRevenue) {
		TotalRevenue = totalRevenue;
	}
	public double getExpCharitablePrograms() {
		return ExpCharitablePrograms;
	}
	@JsonProperty("ExpCharitablePrograms")
	public void setExpCharitablePrograms(double expCharitablePrograms) {
		ExpCharitablePrograms = expCharitablePrograms;
	}
	public double getExpFundarising() {
		return ExpFundarising;
	}
	@JsonProperty("ExpFundarising")
	public void setExpFundarising(double expFundarising) {
		ExpFundarising = expFundarising;
	}
	public double getExpMgmtAdmin() {
		return ExpMgmtAdmin;
	}
	@JsonProperty("ExpMgmtAdmin")
	public void setExpMgmtAdmin(double expMgmtAdmin) {
		ExpMgmtAdmin = expMgmtAdmin;
	}
	public double getExpTotal() {
		return ExpTotal;
	}
	@JsonProperty("ExpTotal")
	public void setExpTotal(double expTotal) {
		ExpTotal = expTotal;
	}
	public double getProfitLoss() {
		return ProfitLoss;
	}
	@JsonProperty("ProfitLoss")
	public void setProfitLoss(double profitLoss) {
		ProfitLoss = profitLoss;
	}
	public double getCash() {
		return Cash;
	}
	@JsonProperty("Cash")
	public void setCash(double cash) {
		Cash = cash;
	}
	public double getLTI() {
		return LTI;
	}
	@JsonProperty("LTI")
	public void setLTI(double lTI) {
		LTI = lTI;
	}
	public double getOtherAssets() {
		return OtherAssets;
	}
	@JsonProperty("OtherAssets")
	public void setOtherAssets(double otherAssets) {
		OtherAssets = otherAssets;
	}
	public double getTotalAssets() {
		return TotalAssets;
	}
	@JsonProperty("TotalAssets")
	public void setTotalAssets(double totalAssets) {
		TotalAssets = totalAssets;
	}
	public double getAcctsPayable() {
		return AcctsPayable;
	}
	@JsonProperty("AcctsPayable")
	public void setAcctsPayable(double acctsPayable) {
		AcctsPayable = acctsPayable;
	}
	public double getDefRevenue() {
		return DefRevenue;
	}
	@JsonProperty("DefRevenue")
	public void setDefRevenue(double defRevenue) {
		DefRevenue = defRevenue;
	}
	public double getOtherLiabilities() {
		return OtherLiabilities;
	}
	@JsonProperty("OtherLiabilities")
	public void setOtherLiabilities(double otherLiabilities) {
		OtherLiabilities = otherLiabilities;
	}
	public double getTotalLiabilities() {
		return TotalLiabilities;
	}
	@JsonProperty("TotalLiabilities")
	public void setTotalLiabilities(double totalLiabilities) {
		TotalLiabilities = totalLiabilities;
	}

}