package com.parseData;

public class Info{
	private String regNum;
	private String ProjectType;
	private String BackURL;
	private String RedirectURL;
	
	private String ClientUnique;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String ProvState;
	private String PostalZip;
	private String Country;
	private String Email;
	
	private String Amount;
	private String Clientfee;
	private String Currency;
	private boolean IsAnonymous;
	private String Note;
	private String InMemorialOf;
	private String InHonourOf;
	
	public Info(){
		this(null, null, null,null ,null,null,null,null,null,null,null,null,null,null,null,null,false,null,null,null);
	}
	
	public Info(String regNum, String ProjectType,String BackURL,String RedirectURL,String ClientUnique,
			String FirstName,String LastName,String Address,String City,String ProvState,String PostalZip,
			String Country,String Email, String Amount, String Clientfee,String Currency,boolean IsAnonymous,
			String Note,String InMemorialOf, String InHonourOf){
		
		this.regNum=regNum;
		this.Address=Address;
		this.Amount=Amount;
		this.BackURL=BackURL;
		this.City=City;
		this.Clientfee=Clientfee;
		this.ClientUnique=ClientUnique;
		this.Country=Country;
		this.Currency=Currency;
		this.RedirectURL=RedirectURL;
		this.Email=Email;
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.PostalZip=PostalZip;
		this.ProjectType=ProjectType;
		this.ProvState=ProvState;
		this.InHonourOf=InHonourOf;
		this.InMemorialOf=InMemorialOf;
		this.IsAnonymous=IsAnonymous;
		this.Note = Note;
	}
	
	//Setters
	public void setregNum(String value){
		this.regNum = value;
	}
	public void setProjectType(String value){
		this.ProjectType = value;
	}
	public void setBackURL(String value){
		this.BackURL = value;
	}
	public void setRedirectURL(String value){
		this.RedirectURL = value;
	}
	public void setClientUnique(String value){
		this.ClientUnique = value;
	}
	public void setFirstName(String value){
		this.FirstName = value;
	}
	public void setLastName(String value){
		this.LastName = value;
	}
	public void setAddress(String value){
		this.Address = value;
	}
	public void setCity(String value){
		this.City = value;
	}
	public void setProvState(String value){
		this.ProvState = value;
	}
	public void setPostalZip(String value){
		this.PostalZip = value;
	}
	public void setCountry(String value){
		this.Country = value;
	}
	public void setEmail(String value){
		this.Email = value;
	}
	public void setAmount(String value){
		this.Amount = value;
	}
	public void setClientfee(String value){
		this.Clientfee = value;
	}
	public void setCurrency(String value){
		this.Currency = value;
	}
	public void setIsAnonymous(boolean value){
		this.IsAnonymous = value;
	}
	public void setNote(String value){
		this.Note = value;
	}
	public void setInMemorialOf(String value){
		this.InMemorialOf = value;
	}
	public void setInHonourOf(String value){
		this.InHonourOf = value;
	}
	
	//getters
	public String getRegNum(){
		return regNum;
	}
	
	public String getProjectType(){
		return ProjectType;
	}
	
	public String getBackURL(){
		return BackURL;
	}
	
	public String getRedirectURL(){
		return RedirectURL;
	}
	public String getClientUnique(){
		return ClientUnique; 
	}
	
	public String getFirstName(){
		return FirstName;
	}
	
	public String getLastName(){
		return LastName;
	}
	
	public String getAddress(){
		return Address;
	}
	
	public String getCity(){
		return City;
	}
	
	public String getProvState(){
		return ProvState;
	}
	
	public String getPostalZip(){
		return PostalZip;
	}
	
	public String getCountry(){
		return Country;
	}
	
	public String getEmail(){
		return Email;
	}
	public String getAmount(){
		return Amount; 
	}
	public String getClientfee(){
		return Clientfee;
	}
	
	public String getCurrency(){
		return Currency;
	}
	public boolean getIsAnonymous(){
		return IsAnonymous;
	}
	
	public String getNote(){
		return Note;
	}
	
	public String getInMemorialOf(){
		return InMemorialOf;
	}
	public String getInHonourOf(){
		return InHonourOf;
	}
	
}