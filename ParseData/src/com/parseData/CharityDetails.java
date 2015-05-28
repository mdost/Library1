package com.parseData;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharityDetails{
	public String CharityName;
	public String CharityOppName;
	public String CharityType;
	public String CharitableStatus;
	public Date DateOfStatus;
	public String MissionStatement;
	public String NumOfStaff;
	public String MajorDonors;
	public String Competitors;
	public String UniqueBlurb;
	public String TotalNumPeopleImpacted;
	public String ExistBlurb;
	public String WhatIsNeeded;
	public String Notes;
	public String CharitySubType;
	public int UpdateStatus;
	public int DonorType;
	public double OperatingBudget;
	public String NumOfVolunteers;
	public String LogoFilename;
	public String Description;
	public String IndividualPrograms;
	public String OperatingBudgetYear1;
	public String OperatingBudgetYear2;
	public String OperatingBudgetYear3;
	public String GovernancePolicies;
	public String PeopleImpactedByOrganization;
	public String PeopleImpactedByPrograms;
	public double TrueCharityValue;
	public String RoleOfVolunteers;
	public String VolunteerTurnoverRate;
	public String PublicPerception;
	public String Keywords;
	public double CostOfFundraising;
	public String PressReleases;
	public String CharitySize;
	public String HasDonorBillOfRights;
	public String HasCodeOfEthicalFundraising;
	public String CharityIntelligenceURL;
	public double RealCharityValue;
	public String CharityAddress;
	public String CharityCity;
	public String CharityProvState;
	public String CharityPostalCode;
	public String CharityCountry;
	public String CharityEmail;
	public String CharityUrl;
	public String CharityPhone1;
	public String CharityPhone2;
	public String CharityFax;
	public String ProgramDescription;
	public String CodeOfFundraising;
	public String KeyIssuesPercent;
	public String KeyIssuesDescrip;
	public String NeedEmerFund;
	public String EmerFundDescrip;
	public String HaveProcess;
	public String ProcessDescrip;
	public String RelatedDoc;
	public String HowOfferingsDiffered;
	public String OfferingsDifferedDescrip;
	public String HaveStrategicPlan;
	public String HaveBoardGovMan;
	public String OverheadExpensesDescription;
	public String OverheadExpensesPercent;
	public double FundraisingCost;
	public double GrossFund;
	public String InKindDonDescrip;
	public String Comments;
	public String ExecutiveDirector;
	public String OrganizationSize;


}