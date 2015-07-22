package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharityDetails{
	private String CharityName;
	private String CharityOppName;
	private String CharityType;
	private String CharitableStatus;
	private Date DateOfStatus;
	private String MissionStatement;
	private String NumOfStaff;
	private String MajorDonors;
	private String Competitors;
	private String UniqueBlurb;
	private String TotalNumPeopleImpacted;
	private String ExistBlurb;
	private String WhatIsNeeded;
	private String Notes;
	private String CharitySubType;
	private int UpdateStatus;
	private int DonorType;
	private double OperatingBudget;
	private String NumOfVolunteers;
	private String LogoFilename;
	private String Description;
	private String IndividualPrograms;
	private String OperatingBudgetYear1;
	private String OperatingBudgetYear2;
	private String OperatingBudgetYear3;
	private String GovernancePolicies;
	private String PeopleImpactedByOrganization;
	private String PeopleImpactedByPrograms;
	private double TrueCharityValue;
	private String RoleOfVolunteers;
	private String VolunteerTurnoverRate;
	private String privatePerception;
	private String Keywords;
	private double CostOfFundraising;
	private String PressReleases;
	private String CharitySize;
	private String HasDonorBillOfRights;
	private String HasCodeOfEthicalFundraising;
	private String CharityIntelligenceURL;
	private double RealCharityValue;
	private String CharityAddress;
	private String CharityCity;
	private String CharityProvState;
	private String CharityPostalCode;
	private String CharityCountry;
	private String CharityEmail;
	private String CharityUrl;
	private String CharityPhone1;
	private String CharityPhone2;
	private String CharityFax;
	private String ProgramDescription;
	private String CodeOfFundraising;
	private String KeyIssuesPercent;
	private String KeyIssuesDescrip;
	private String NeedEmerFund;
	private String EmerFundDescrip;
	private String HaveProcess;
	private String ProcessDescrip;
	private String RelatedDoc;
	private String HowOfferingsDiffered;
	private String OfferingsDifferedDescrip;
	private String HaveStrategicPlan;
	private String HaveBoardGovMan;
	private String OverheadExpensesDescription;
	private String OverheadExpensesPercent;
	private double FundraisingCost;
	private double GrossFund;
	private String InKindDonDescrip;
	private String Comments;
	private String ExecutiveDirector;
	private String OrganizationSize;
	
	private GiveAPI error;
	
	public void setError(GiveAPI value){
		this.error= value;
	}
	public GiveAPI getError(){
		return error;
	}
	public String getCharityName() {
		return CharityName;
	}
	@JsonProperty("CharityName")
	public void setCharityName(String charityName) {
		CharityName = charityName;
	}
	public String getCharityOppName() {
		return CharityOppName;
	}
	@JsonProperty("CharityOppName")
	public void setCharityOppName(String charityOppName) {
		CharityOppName = charityOppName;
	}
	public String getCharityType() {
		return CharityType;
	}
	@JsonProperty("CharityType")
	public void setCharityType(String charityType) {
		CharityType = charityType;
	}
	public String getCharitableStatus() {
		return CharitableStatus;
	}
	@JsonProperty("CharitableStatus")
	public void setCharitableStatus(String charitableStatus) {
		CharitableStatus = charitableStatus;
	}
	public Date getDateOfStatus() {
		return DateOfStatus;
	}
	@JsonProperty("DateOfStatus")
	public void setDateOfStatus(Date dateOfStatus) {
		DateOfStatus = dateOfStatus;
	}
	public String getMissionStatement() {
		return MissionStatement;
	}
	@JsonProperty("MissionStatement")
	public void setMissionStatement(String missionStatement) {
		MissionStatement = missionStatement;
	}
	public String getNumOfStaff() {
		return NumOfStaff;
	}
	@JsonProperty("NumOfStaff")
	public void setNumOfStaff(String numOfStaff) {
		NumOfStaff = numOfStaff;
	}
	public String getMajorDonors() {
		return MajorDonors;
	}
	@JsonProperty("MajorDonors")
	public void setMajorDonors(String majorDonors) {
		MajorDonors = majorDonors;
	}
	public String getCompetitors() {
		return Competitors;
	}
	@JsonProperty("Competitors")
	public void setCompetitors(String competitors) {
		Competitors = competitors;
	}
	public String getUniqueBlurb() {
		return UniqueBlurb;
	}
	@JsonProperty("UniqueBlurb")
	public void setUniqueBlurb(String uniqueBlurb) {
		UniqueBlurb = uniqueBlurb;
	}
	public String getTotalNumPeopleImpacted() {
		return TotalNumPeopleImpacted;
	}
	@JsonProperty("TotalNumPeopleImpacted")
	public void setTotalNumPeopleImpacted(String totalNumPeopleImpacted) {
		TotalNumPeopleImpacted = totalNumPeopleImpacted;
	}
	public String getExistBlurb() {
		return ExistBlurb;
	}
	@JsonProperty("ExistBlurb")
	public void setExistBlurb(String existBlurb) {
		ExistBlurb = existBlurb;
	}
	public String getWhatIsNeeded() {
		return WhatIsNeeded;
	}
	@JsonProperty("WhatIsNeeded")
	public void setWhatIsNeeded(String whatIsNeeded) {
		WhatIsNeeded = whatIsNeeded;
	}
	public String getNotes() {
		return Notes;
	}
	@JsonProperty("Notes")
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getCharitySubType() {
		return CharitySubType;
	}
	@JsonProperty("CharitySubType")
	public void setCharitySubType(String charitySubType) {
		CharitySubType = charitySubType;
	}
	public int getUpdateStatus() {
		return UpdateStatus;
	}
	@JsonProperty("UpdateStatus")
	public void setUpdateStatus(int updateStatus) {
		UpdateStatus = updateStatus;
	}
	public int getDonorType() {
		return DonorType;
	}
	@JsonProperty("DonorType")
	public void setDonorType(int donorType) {
		DonorType = donorType;
	}
	public double getOperatingBudget() {
		return OperatingBudget;
	}
	@JsonProperty("OperatingBudget")
	public void setOperatingBudget(double operatingBudget) {
		OperatingBudget = operatingBudget;
	}
	public String getNumOfVolunteers() {
		return NumOfVolunteers;
	}
	@JsonProperty("NumOfVolunteers")
	public void setNumOfVolunteers(String numOfVolunteers) {
		NumOfVolunteers = numOfVolunteers;
	}
	public String getLogoFilename() {
		return LogoFilename;
	}
	@JsonProperty("LogoFilename")
	public void setLogoFilename(String logoFilename) {
		LogoFilename = logoFilename;
	}
	public String getDescription() {
		return Description;
	}
	@JsonProperty("Description")
	public void setDescription(String description) {
		Description = description;
	}
	public String getIndividualPrograms() {
		return IndividualPrograms;
	}
	@JsonProperty("IndividualPrograms")
	public void setIndividualPrograms(String individualPrograms) {
		IndividualPrograms = individualPrograms;
	}
	public String getOperatingBudgetYear1() {
		return OperatingBudgetYear1;
	}
	@JsonProperty("OperatingBudgetYear1")
	public void setOperatingBudgetYear1(String operatingBudgetYear1) {
		OperatingBudgetYear1 = operatingBudgetYear1;
	}
	public String getOperatingBudgetYear2() {
		return OperatingBudgetYear2;
	}
	@JsonProperty("OperatingBudgetYear2")
	public void setOperatingBudgetYear2(String operatingBudgetYear2) {
		OperatingBudgetYear2 = operatingBudgetYear2;
	}
	public String getOperatingBudgetYear3() {
		return OperatingBudgetYear3;
	}
	@JsonProperty("OperatingBudgetYear3")
	public void setOperatingBudgetYear3(String operatingBudgetYear3) {
		OperatingBudgetYear3 = operatingBudgetYear3;
	}
	public String getGovernancePolicies() {
		return GovernancePolicies;
	}
	@JsonProperty("GovernancePolicies")
	public void setGovernancePolicies(String governancePolicies) {
		GovernancePolicies = governancePolicies;
	}
	public String getPeopleImpactedByOrganization() {
		return PeopleImpactedByOrganization;
	}
	@JsonProperty("PeopleImpactedByOrganization")
	public void setPeopleImpactedByOrganization(String peopleImpactedByOrganization) {
		PeopleImpactedByOrganization = peopleImpactedByOrganization;
	}
	public String getPeopleImpactedByPrograms() {
		return PeopleImpactedByPrograms;
	}
	@JsonProperty("PeopleImpactedByPrograms")
	public void setPeopleImpactedByPrograms(String peopleImpactedByPrograms) {
		PeopleImpactedByPrograms = peopleImpactedByPrograms;
	}
	public double getTrueCharityValue() {
		return TrueCharityValue;
	}
	@JsonProperty("TrueCharityValue")
	public void setTrueCharityValue(double trueCharityValue) {
		TrueCharityValue = trueCharityValue;
	}
	public String getRoleOfVolunteers() {
		return RoleOfVolunteers;
	}
	@JsonProperty("RoleOfVolunteers")
	public void setRoleOfVolunteers(String roleOfVolunteers) {
		RoleOfVolunteers = roleOfVolunteers;
	}
	public String getVolunteerTurnoverRate() {
		return VolunteerTurnoverRate;
	}
	@JsonProperty("VolunteerTurnoverRate")
	public void setVolunteerTurnoverRate(String volunteerTurnoverRate) {
		VolunteerTurnoverRate = volunteerTurnoverRate;
	}
	public String getPrivatePerception() {
		return privatePerception;
	}
	@JsonProperty("privatePerception")
	public void setPrivatePerception(String privatePerception) {
		this.privatePerception = privatePerception;
	}
	public String getKeywords() {
		return Keywords;
	}
	@JsonProperty("Keywords")
	public void setKeywords(String keywords) {
		Keywords = keywords;
	}
	public double getCostOfFundraising() {
		return CostOfFundraising;
	}
	@JsonProperty("CostOfFundraising")
	public void setCostOfFundraising(double costOfFundraising) {
		CostOfFundraising = costOfFundraising;
	}
	public String getPressReleases() {
		return PressReleases;
	}
	@JsonProperty("PressReleases")
	public void setPressReleases(String pressReleases) {
		PressReleases = pressReleases;
	}
	public String getCharitySize() {
		return CharitySize;
	}
	@JsonProperty("CharitySize")
	public void setCharitySize(String charitySize) {
		CharitySize = charitySize;
	}
	public String getHasDonorBillOfRights() {
		return HasDonorBillOfRights;
	}
	@JsonProperty("HasDonorBillOfRights")
	public void setHasDonorBillOfRights(String hasDonorBillOfRights) {
		HasDonorBillOfRights = hasDonorBillOfRights;
	}
	public String getHasCodeOfEthicalFundraising() {
		return HasCodeOfEthicalFundraising;
	}
	@JsonProperty("HasCodeOfEthicalFundraising")
	public void setHasCodeOfEthicalFundraising(String hasCodeOfEthicalFundraising) {
		HasCodeOfEthicalFundraising = hasCodeOfEthicalFundraising;
	}
	public String getCharityIntelligenceURL() {
		return CharityIntelligenceURL;
	}
	@JsonProperty("CharityIntelligenceURL")
	public void setCharityIntelligenceURL(String charityIntelligenceURL) {
		CharityIntelligenceURL = charityIntelligenceURL;
	}
	public double getRealCharityValue() {
		return RealCharityValue;
	}
	@JsonProperty("RealCharityValue")
	public void setRealCharityValue(double realCharityValue) {
		RealCharityValue = realCharityValue;
	}
	public String getCharityAddress() {
		return CharityAddress;
	}
	@JsonProperty("CharityAddress")
	public void setCharityAddress(String charityAddress) {
		CharityAddress = charityAddress;
	}
	public String getCharityCity() {
		return CharityCity;
	}
	@JsonProperty("CharityCity")
	public void setCharityCity(String charityCity) {
		CharityCity = charityCity;
	}
	public String getCharityProvState() {
		return CharityProvState;
	}
	@JsonProperty("CharityProvState")
	public void setCharityProvState(String charityProvState) {
		CharityProvState = charityProvState;
	}
	public String getCharityPostalCode() {
		return CharityPostalCode;
	}
	@JsonProperty("CharityPostalCode")
	public void setCharityPostalCode(String charityPostalCode) {
		CharityPostalCode = charityPostalCode;
	}
	public String getCharityCountry() {
		return CharityCountry;
	}
	@JsonProperty("CharityCountry")
	public void setCharityCountry(String charityCountry) {
		CharityCountry = charityCountry;
	}
	public String getCharityEmail() {
		return CharityEmail;
	}
	@JsonProperty("CharityEmail")
	public void setCharityEmail(String charityEmail) {
		CharityEmail = charityEmail;
	}
	public String getCharityUrl() {
		return CharityUrl;
	}
	@JsonProperty("CharityUrl")
	public void setCharityUrl(String charityUrl) {
		CharityUrl = charityUrl;
	}
	public String getCharityPhone1() {
		return CharityPhone1;
	}
	@JsonProperty("CharityPhone1")
	public void setCharityPhone1(String charityPhone1) {
		CharityPhone1 = charityPhone1;
	}
	public String getCharityPhone2() {
		return CharityPhone2;
	}
	@JsonProperty("CharityPhone2")
	public void setCharityPhone2(String charityPhone2) {
		CharityPhone2 = charityPhone2;
	}
	public String getCharityFax() {
		return CharityFax;
	}
	@JsonProperty("CharityFax")
	public void setCharityFax(String charityFax) {
		CharityFax = charityFax;
	}
	public String getProgramDescription() {
		return ProgramDescription;
	}
	@JsonProperty("ProgramDescription")
	public void setProgramDescription(String programDescription) {
		ProgramDescription = programDescription;
	}
	public String getCodeOfFundraising() {
		return CodeOfFundraising;
	}
	@JsonProperty("CodeOfFundraising")
	public void setCodeOfFundraising(String codeOfFundraising) {
		CodeOfFundraising = codeOfFundraising;
	}
	public String getKeyIssuesPercent() {
		return KeyIssuesPercent;
	}
	@JsonProperty("KeyIssuesPercent")
	public void setKeyIssuesPercent(String keyIssuesPercent) {
		KeyIssuesPercent = keyIssuesPercent;
	}
	public String getKeyIssuesDescrip() {
		return KeyIssuesDescrip;
	}
	@JsonProperty("KeyIssuesDescrip")
	public void setKeyIssuesDescrip(String keyIssuesDescrip) {
		KeyIssuesDescrip = keyIssuesDescrip;
	}
	public String getNeedEmerFund() {
		return NeedEmerFund;
	}
	@JsonProperty("NeedEmerFund")
	public void setNeedEmerFund(String needEmerFund) {
		NeedEmerFund = needEmerFund;
	}
	public String getEmerFundDescrip() {
		return EmerFundDescrip;
	}
	@JsonProperty("EmerFundDescrip")
	public void setEmerFundDescrip(String emerFundDescrip) {
		EmerFundDescrip = emerFundDescrip;
	}
	public String getHaveProcess() {
		return HaveProcess;
	}
	@JsonProperty("HaveProcess")
	public void setHaveProcess(String haveProcess) {
		HaveProcess = haveProcess;
	}
	public String getProcessDescrip() {
		return ProcessDescrip;
	}
	@JsonProperty("ProcessDescrip")
	public void setProcessDescrip(String processDescrip) {
		ProcessDescrip = processDescrip;
	}
	public String getRelatedDoc() {
		return RelatedDoc;
	}
	@JsonProperty("RelatedDoc")
	public void setRelatedDoc(String relatedDoc) {
		RelatedDoc = relatedDoc;
	}
	public String getHowOfferingsDiffered() {
		return HowOfferingsDiffered;
	}
	@JsonProperty("HowOfferingsDiffered")
	public void setHowOfferingsDiffered(String howOfferingsDiffered) {
		HowOfferingsDiffered = howOfferingsDiffered;
	}
	public String getOfferingsDifferedDescrip() {
		return OfferingsDifferedDescrip;
	}
	@JsonProperty("OfferingsDifferedDescrip")
	public void setOfferingsDifferedDescrip(String offeringsDifferedDescrip) {
		OfferingsDifferedDescrip = offeringsDifferedDescrip;
	}
	public String getHaveStrategicPlan() {
		return HaveStrategicPlan;
	}
	@JsonProperty("HaveStrategicPlan")
	public void setHaveStrategicPlan(String haveStrategicPlan) {
		HaveStrategicPlan = haveStrategicPlan;
	}
	public String getHaveBoardGovMan() {
		return HaveBoardGovMan;
	}
	@JsonProperty("HaveBoardGovMan")
	public void setHaveBoardGovMan(String haveBoardGovMan) {
		HaveBoardGovMan = haveBoardGovMan;
	}
	public String getOverheadExpensesDescription() {
		return OverheadExpensesDescription;
	}
	@JsonProperty("OverheadExpensesDescription")
	public void setOverheadExpensesDescription(String overheadExpensesDescription) {
		OverheadExpensesDescription = overheadExpensesDescription;
	}
	public String getOverheadExpensesPercent() {
		return OverheadExpensesPercent;
	}
	@JsonProperty("OverheadExpensesPercent")
	public void setOverheadExpensesPercent(String overheadExpensesPercent) {
		OverheadExpensesPercent = overheadExpensesPercent;
	}
	public double getFundraisingCost() {
		return FundraisingCost;
	}
	@JsonProperty("FundraisingCost")
	public void setFundraisingCost(double fundraisingCost) {
		FundraisingCost = fundraisingCost;
	}
	public double getGrossFund() {
		return GrossFund;
	}
	@JsonProperty("GrossFund")
	public void setGrossFund(double grossFund) {
		GrossFund = grossFund;
	}
	public String getInKindDonDescrip() {
		return InKindDonDescrip;
	}
	@JsonProperty("InKindDonDescrip")
	public void setInKindDonDescrip(String inKindDonDescrip) {
		InKindDonDescrip = inKindDonDescrip;
	}
	public String getComments() {
		return Comments;
	}
	@JsonProperty("Comments")
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getExecutiveDirector() {
		return ExecutiveDirector;
	}
	@JsonProperty("ExecutiveDirector")
	public void setExecutiveDirector(String executiveDirector) {
		ExecutiveDirector = executiveDirector;
	}
	public String getOrganizationSize() {
		return OrganizationSize;
	}
	@JsonProperty("OrganizationSize")
	public void setOrganizationSize(String organizationSize) {
		OrganizationSize = organizationSize;
	}


}