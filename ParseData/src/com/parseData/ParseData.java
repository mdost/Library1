package com.parseData;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * 
 * @author mariamdost
 *
 */
public class ParseData {
	private volatile static boolean called=false;
	
	/**
	 * Returns the token for a specific APPID and APPSecret.
	 * Will only be called once on startup, it will provide the token, the user must save that token for further uses. 
	 * @param String appid
	 * @param String appsecret
	 * @return String token
	 */
	public synchronized static String getToken(String appid, String appsecret){
		if(called)
			return null;
		
		called = true;
		
		String url = "https://app.place2give.com/Service.svc/give-api-auth?app_id=dc669d4e-08ee-4455-a253-ba233be22ba7&app_secret=c0440e81-8596-4b3c-af3a-aa73a6eb0e4e&format=json";
		String token = null;
		
		try {
			String reader = readURL_GET(url);
			
			ObjectMapper mapper = new ObjectMapper();
//			mapper.setSerializationInclusion(Include.NON_NULL);
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode node = mapper.readTree(reader);
			GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
			
			if(checkResults.getStatus_code_description().contains("Success") || checkResults.getStatus_code().contains("100")){
				token = node.get("give-api").get("data").get("token").asText();
			}else{
				System.out.println(checkResults.getStatus_code_description());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return token;
		
	}
	
	/**
	 * Verify the token to ensure on startup of the library they have called getToken()
	 * @param token
	 * @throws IOException
	 */
	private static void verifyToken(String token) throws IOException{
		if(called = false){
			System.out.println("Please get token by calling getToken(appid, appsecret)");
			System.exit(0);;
		}else if(token == null || token.contains(" ") || token.length() != 36){
			System.out.println("\nThe token entered was invalid.");
			System.exit(0);
		}
	}
	
	/**
	 * Opens the connection to the URL using POST Request
	 * @param String url
	 * @return String data
	 * @throws IOException
	 */
	public static String readURL_POST(String url) throws IOException{
		URL getURL = new URL(url);
		HttpURLConnection connection =(HttpURLConnection) getURL.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/json"); 
		connection.setRequestProperty("charset", "utf-8");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		InputStream inReader = null;
		OutputStream outReader = null;
		
		int status = connection.getResponseCode();
		String output = null;
		
		if(status >= 400 || status < 200){
			System.out.println("HttpURLConnection returned status "+status+" for URL: "+getURL);
			System.exit(0);
		}else{
			byte [] b = url.getBytes();
			DataOutputStream wr = new DataOutputStream( connection.getOutputStream());
			wr.write(b);
			for(int i=0; i<b.length; i++){
//			System.out.println(b[i]);
			}
			
			inReader = connection.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
			//displays the output to the screen.
			int input;
			StringBuffer buffer = new StringBuffer();
			char[] charArray = new char[2000];
				
			while((input = read.read(charArray)) != -1){
				buffer.append(charArray,0, input);
				//System.out.println(input + "\n");
			}
				
			output = buffer.toString();
		}
		
		return output;
	}
	
	/**Opens the connection for the given URL and reads the input by using GET request
	 * @param String url
	 * @return String data
	 * */
	public static String readURL_GET(String url) throws IOException{
		URL getURL = new URL(url);
		URLConnection connect = getURL.openConnection();
		
		int status = ((HttpURLConnection) connect).getResponseCode();
		
		if(status >= 400 || status < 200){
			System.out.println("HttpURLConnection returned status "+status+" for URL: "+getURL);
			System.exit(0);
		}
		
		BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				
		//displays the output to the screen.
		int input;
		StringBuffer buffer = new StringBuffer();
		char[] charArray = new char[2000];
		
		while((input = read.read(charArray)) != -1){
			buffer.append(charArray,0, input);
		}
		
		String output = buffer.toString();
		
		return output;
	}
	
	/**Opens the connection for the given URL and reads the input by using GET request
	 * @param String url
	 * @return String data
	 * */
	public static InputStream openURL_GET(String url) throws IOException{
		URL getURL = new URL(url);
		URLConnection connect = getURL.openConnection();
		int status = ((HttpURLConnection) connect).getResponseCode();
		
		if(status >= 400 || status < 200){
			System.out.println("HttpURLConnection returned status "+status+" for URL: "+getURL);
			System.exit(0);
		}
		
		InputStream output = connect.getInputStream();
				
		return output;
	}
	
	/**
	 * Creates and opens a connection to the given url and returns data using POST request
	 * @param String url
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream openURL_POST(String url) throws IOException{
		URL getURL = new URL(url);
		HttpURLConnection connection =(HttpURLConnection) getURL.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/json"); 
		connection.setRequestProperty("charset", "utf-8");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		InputStream inReader = null;
		OutputStream outReader = null;
		int status = connection.getResponseCode();
		
		if(status >= 400 || status < 200){
			System.out.println("HttpURLConnection returned status "+status+" for URL: "+getURL);
			System.exit(0);
		}
		
		byte [] b = url.getBytes();
		DataOutputStream wr = new DataOutputStream( connection.getOutputStream());
		wr.write(b);
		for(int i=0; i<b.length; i++){
//			System.out.println(b[i]);
		}
		
		inReader = connection.getInputStream();
		
		return inReader;
	}
	
	/**
	 * This methods get the charity salaries for the specific charity (found by registration number), returns an object where it contains all the data. 
	 * In order to use this methods the input URL must have defined the format as JSON. Without defining this, the method will not work.  
	 * @param String token
	 * @param String regNum
	 * @return Object of type SalaryData
	 * @throws IOException
	 */
	public static SalaryData getCharitySalaries(String token,String regNum) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharitySalaries&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		SalaryData data = null ;
		
		if(regNum == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
			
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100"))
			data = mapper.readValue(node.get("give-api").get("data").get("charitySalaries").get("salaryData").toString(), SalaryData.class);
		else{
			System.out.println(checkResults.getStatus_code_description());
		}
	
		return data;
		
	}
	
	/**
	 * Parses data received from the input stream (using readURL)
	 * returns an object of type SalaryData (which contains all results)
	 * The input type must be of the format XML, any other format will not be accepted by this method. 
	 * @param String token
	 * @param String regNum
	 * @return Object of type SalaryData
	 * @throws IOException
	 * @throws JAXBException
	 * @throws XMLStreamException
	 */
	public static SalaryData getCharitySalaries_xml(String token, String regNum) throws IOException, JAXBException, XMLStreamException{
		verifyToken(token);

		String url = "http://app.place2give.com/Service.svc/give-api?action=getCharitySalaries&token="+token+"&regNum="+regNum+"&format=json";
		InputStream inReader = openURL_POST(url);
				
		SalaryData salary = null;
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xmlReader = xif.createXMLStreamReader(inReader);
		
		int tag =0;
		int event;
		for(event = xmlReader.next(); event != XMLStreamReader.END_DOCUMENT; event = xmlReader.next()){
			if(event == XMLStreamReader.START_ELEMENT){
				if(xmlReader.getLocalName() == "salaryData"){
					break;
				}
			}
		}
		
		if(event != XMLStreamReader.END_DOCUMENT){
			JAXBContext context = JAXBContext.newInstance(SalaryData.class);
			Unmarshaller un = context.createUnmarshaller();
			JAXBElement <SalaryData> temp = un.unmarshal(xmlReader, SalaryData.class);
			salary = temp.getValue();
		}
		return salary;
	}
	
	/**
	 * Returns the details of a specific charity
	 * @param token
	 * @param regNum
	 * @return object of type CharityDetails
	 * @throws IOException
	 */
	public static CharityDetails getCharityDetails(String token, String regNum) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityDetails&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		CharityDetails details = null ;
		
		if(regNum == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100"))
			details = mapper.readValue(node.get("give-api").get("data").toString(), CharityDetails.class);
		else{
			System.out.println(checkResults.getStatus_code_description());
		}
		return details;
	}
	
	/**
	 * Returns financial details of a specific charity
	 * @param token
	 * @param regNum
	 * @return List<FinancialData>
	 * @throws IOException
	 */
	public static List<FinancialData> getFinancialDetails(String token, String regNum) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getFinancialDetails&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		List<FinancialData> details= null;
		
		if(regNum == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("financialDetails").get("financialData").toString(), typeFactory.constructCollectionType(List.class, FinancialData.class));
		}else{
			System.out.println(checkResults.getStatus_code_description());
		}
		
		return details;
	}
	
	/**
	 * Returns a list of available charity types
	 * @param token
	 * @return List<CharityType>
	 * @throws IOException
	 */
	public static List<CharityType> getCharityType(String token) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityTypes&token="+token+"&format=json";
		String reader = readURL_GET(url);
		List<CharityType> details =null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100"))
			details = mapper.readValue(node.get("give-api").get("data").get("charityTypes").get("charityType").toString(), typeFactory.constructCollectionType(List.class, CharityType.class));
		else{
			System.out.println(checkResults.getStatus_code_description());
		}
		return details;
	}
	
	/**
	 * Returns a list of provinces or states according to the country entered.
	 * @param token
	 * @param country
	 * @return List<ProvState>
	 * @throws IOException
	 * @throws XMLStreamException
	 * @throws JAXBException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static List<ProvState> getProvState(String token, String country) throws IOException, XMLStreamException, JAXBException, XPathExpressionException, ParserConfigurationException, SAXException{
		verifyToken(token);
//		String url = "https://app.place2give.com/Service.svc/give-api?action=getProvState&token=5d24ce6f-0264-44cd-804d-d2cda34b3577&Country=US&format=json";
		String url = "https://app.place2give.com/Service.svc/give-api?action=getProvState&token="+token+"&Country="+country+"&format=json";
		String reader = readURL_GET(url);
		List<ProvState> details = null;
		
		if(country == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100"))
			details = mapper.readValue(node.get("give-api").get("data").get("proveStates").get("provState").toString(), typeFactory.constructCollectionType(List.class, ProvState.class));
		else{
			System.out.println(checkResults.getStatus_code_description());
		}
		return details;
	}
	
	/**
	 * Search charities that are active
	 * Must enter values for token, page number, num per page.
	 * Must enter one of the values for charity size, keyword, or charity type at least.
	 * Entering values for country and provState are not necessary (but can be entered)
	 * All other values that are not set, please set them to null. 
	 * @param token
	 * @param PageNumber
	 * @param NumPerPage
	 * @param CharitySize
	 * @param keyword
	 * @param CharityType
	 * @param Country
	 * @param ProvState
	 * @return List<SearchCharities>
	 * @throws IOException
	 */
	public static List<SearchCharities> searchCharities(String token, String PageNumber, String NumPerPage, String CharitySize, String keyword, String CharityType,String Country, String ProvState) throws IOException{
		verifyToken(token);
		
		if((PageNumber ==null) ||(NumPerPage ==null) ){
			System.out.println("Please enter the page number and number per page.");
			return null;
		}else if((CharitySize ==null) &&(keyword ==null) && (CharityType ==null) ){
			System.out.println("Please enter one of the following parameters charity size, charity type, or keyword");
			return null;
		}
		
		String url ="https://app.place2give.com/Service.svc/give-api?action=searchCharities&token="+token+"&PageNumber="+PageNumber+"&NumPerPage="+NumPerPage;
		if(CharitySize != null)
			url+= "&CharitySize="+CharitySize;
		if(keyword != null)
			url+= "&keyword="+keyword;
		if(CharityType != null)
			url+= "&CharityType="+CharityType;
		if(Country != null)
			url+= "&Country="+Country;
		if(ProvState != null)
			url+= "&ProvState="+ProvState;
		
		url +="&format=json";
		
		String reader = readURL_GET(url);
		List<SearchCharities> details=null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100"))
			details = mapper.readValue(node.get("give-api").get("data").get("charities").get("charity").toString(), typeFactory.constructCollectionType(List.class, SearchCharities.class));
		else{
			System.out.println(checkResults.getStatus_code_description());
		}
		return details;
	}
	
	/**
	 * Return a list of charity files for a specific charity.
	 * Enter registration number for a specific charity.
	 * If no results are found, the method returns null
	 * @param token
	 * @param regNum
	 * @return List<CharityFiles>
	 * @throws IOException
	 */
	public static List<CharityFiles> getCharityFiles(String token, String regNum) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityFiles&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		List<CharityFiles> details = null;
		
		if(regNum == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") && checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("charityFiles").get("file").toString(), typeFactory.constructCollectionType(List.class, CharityFiles.class));
		}else{
			System.out.println(checkResults.getStatus_code_description());
		}
		
		return details;
	}
	
	/**
	 * Returns a list of project information that are specific to a certain charity
	 * Must enter registration number for a specific charity
	 * @param token
	 * @param regNum
	 * @return List<CharityProjects>
	 * @throws IOException
	 */
	public static List<CharityProjects> getCharityProjects(String token, String regNum) throws IOException{
		verifyToken(token);
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityProjects&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		List<CharityProjects> details = null ;
		
		if(regNum == null){
			System.out.println("Please registration number of a charity.");
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("charityProjects").get("project").toString(), typeFactory.constructCollectionType(List.class, CharityProjects.class));
		}else{
			System.out.println(checkResults.getStatus_code_description());
		}
		
		return details;
	}
	
	/**
	 * Returns an object of type DonationURL that contains the expiration date and the donationURL.
	 * The donation URL is a unique URL that allows users the ability to make one-time donation
	 * @param String token
	 * @param Info obj
	 * @return object of type DonationURL
	 * @throws IOException
	 */
	public static DonationURL getDonationURL(String token, Info obj) throws IOException{
		verifyToken(token);
		String url="https://app.place2give.com/Service.svc/give-api?action=getDonationURL&token="+token;
		
		if(obj.getRegNum() == null || obj.getProjectType() ==null || obj.getBackURL() == null || obj.getRedirectURL() == null || obj.getCurrency() == null || obj.getAmount() == null){
			System.out.println("One of the parameters were not specefied. Please read the documentation.");
			return null;
		}else if(obj.getIsAnonymous() == false){
			if(obj.getFirstName() == null || obj.getLastName() == null || obj.getEmail() == null || obj.getAddress()== null || obj.getPostalZip() == null || obj.getProvState()==null || obj.getCity()==null || obj.getCountry()==null){
				System.out.println("One of the parameters for donor info was not specified. Please check the documentation.");
				return null;
			}
		}else{
			if(obj.getClientfee() == null)
				url += "&regNum="+obj.getRegNum()+"&ProjectType="+obj.getProjectType()+"&BackURL="+obj.getBackURL()+"&RedirectURL="+obj.getRedirectURL()+"&Amount="+obj.getAmount()+"&Currency="+obj.getCurrency()+"&IsAnonymous="+obj.getIsAnonymous()+"&FirstName="+obj.getFirstName()+"&LastName="+obj.getLastName()+"&Address="+obj.getAddress()+"&City="+obj.getCity()+"&ProvState="+obj.getProvState()+"&Country="+obj.getCountry()+"&PostalZip="+obj.getPostalZip()+"&Email="+obj.getEmail()
					+"&Note="+obj.getNote()+"&InHonourOf="+obj.getInHonourOf()+"&InMemorialOf="+obj.getInMemorialOf()+"&format=json";
			else
				url += "&regNum="+obj.getRegNum()+"&ProjectType="+obj.getProjectType()+"&BackURL="+obj.getBackURL()+"&RedirectURL="+obj.getRedirectURL()+"&Amount="+obj.getAmount()+"&Currency="+obj.getCurrency()+"&IsAnonymous="+obj.getIsAnonymous()+"&FirstName="+obj.getFirstName()+"&LastName="+obj.getLastName()+"&Address="+obj.getAddress()+"&City="+obj.getCity()+"&ProvState="+obj.getProvState()+"&Country="+obj.getCountry()+"&PostalZip="+obj.getPostalZip()+"&Email="+obj.getEmail()
				+"&Note="+obj.getNote()+"&InHonourOf="+obj.getInHonourOf()+"&InMemorialOf="+obj.getInMemorialOf()+"&Clientfee="+obj.getClientfee()+"&format=json";
		
		}
		
//		String url = "https://app.place2give.com/Service.svc/give-api?action=getDonationURL&token=5d24ce6f-0264-44cd-804d-d2cda34b3577&regNum=833678840RR0001&ProjectType=C&BackURL=www.google.com&RedirectURL=www.yahoo.com&Amount=10&Currency=CAD&FirstName=Mariam&LastName=Dost&Address=11Candle&City=Calgary&ProvState=AB&PostalZip=T23G&Country=CA&Email=mari@gmail.com&format=json";
		String reader = readURL_GET(url);
		DonationURL details = null ;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").toString(), DonationURL.class);
		}else{
			System.out.println(checkResults.getStatus_code_description());
		}
		
		return details;
	}
}