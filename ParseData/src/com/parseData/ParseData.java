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
import java.util.ArrayList;
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
	//private variables
	private volatile static boolean called=false;
	
	public enum CharitySizeEnum{
		LARGE, UNKNOWN, SMALL, MEDIUM, VERYLARGE
	};
	
	public enum CountryEnum{
		CA, US
	};
	
	public enum CurrencyEnum{
		CAD, USD
	};
	
	public enum ProjectType{
		C, P
	};
	
	/**
	 * Returns the value of the variable called. If true-means the getToken was called and successfully retrieved info. 
	 * Otherwise the call was unsuccessful, call getToken again. 
	 * @return boolean
	 */
	public boolean isCalled(){
		return called;
	}
	
	/**
	 * Returns the token for a specific APPID and APPSecret.
	 * Will only be called once on startup, it will provide the token, the user must save that token for further usage. 
	 * If called again, the method will return null.
	 * @param String appid
	 * @param String appsecret
	 * @return String token
	 */
	public synchronized static String getToken(String appid, String appsecret){
		if(called)
			return null;
		
		String url = "https://app.place2give.com/Service.svc/give-api-auth?app_id="+appid+"&app_secret="+appsecret+"&format=json";
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
				called = true;
			}else{
				System.out.println(checkResults.getStatus_code_description());
				token = checkResults.getStatus_code() +" - "+checkResults.getStatus_code_description();
				called=false;
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return token;
		
	}
	
	/**
	 * Verify the token to ensure on startup of the library the method getToken() has been called.
	 * This method does error handling, it check if the token entered is of valid length, non-empty string, and is not null.
	 * If any of these condition above are satisfied the method will return an object of type GiveAPI, where it will contain error-code and error-description. 
	 * @param String token
	 * @return object of type GiveAPI
	 * @throws IOException
	 */
	private static GiveAPI verifyToken(String token) throws IOException{
		GiveAPI error = new GiveAPI();		
		if(called = false){
			error.setstatus_code("204");
			error.setStatus_code_description("Please get token by calling getToken(appid, appsecret)");
			System.exit(0);;
		}else if(token == null || token.contains(" ") || token.length() != 36){
			error.setstatus_code("204");
			error.setStatus_code_description("The token entered was invalid");
		}
		return error;
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
			
			read.close();
		}
		
		return output;
	}
	
	/**
	 * Opens the connection for the given URL and reads the input by using GET request
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
		read.close();
		
		return output;
	}
	
	/**
	 * Opens the connection for the given URL and reads the input by using GET request
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
		output.close();
		
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
		wr.close();
		
		return inReader;
	}
	
	/**
	 * This methods gets the charity salaries for the specific charity (found by registration number), returns an object where it contains all the data. 
	 * If proper parameters are not entered the method will return an error in object of type SalaryData.
	 * The error message which is encapsulated in the object (SalaryData) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String regNum
	 * @return Object of type SalaryData
	 * @throws IOException
	 */
	public static SalaryData getCharitySalaries(String token,String regNum) throws IOException{
		SalaryData data = null ;
		GiveAPI give = new GiveAPI();
		GiveAPI error = verifyToken(token);

		if(error.getStatus_code() != null && !error.getStatus_code().equals("100")){
			data = new SalaryData();
			data.setError(error);
			return data;
		}
		
		if(regNum == null || regNum == ""){
			data = new SalaryData();
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter a registration number.");
			data.setError(give);
			return data;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharitySalaries&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
			
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			data = mapper.readValue(node.get("give-api").get("data").get("charitySalaries").get("salaryData").toString(), SalaryData.class);
			data.setError(checkResults);
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			data = new SalaryData();
			data.setError(checkResults);
		}
	
		return data;
		
	}
	
	/**
	 * Returns the details of a specific charity
	 * If proper parameters are not entered the method will return an error in object of type CharityDetails.
	 * The error message which is encapsulated in the object (CharityDetails) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String regNum
	 * @return object of type CharityDetails
	 * @throws IOException
	 */
	public static CharityDetails getCharityDetails(String token, String regNum) throws IOException{
		CharityDetails details = null ;
		GiveAPI error = verifyToken(token);

		if(error.getStatus_code() != null && !error.getStatus_code().equals("100")){
			details = new CharityDetails();
			details.setError(error);
			return details;
		}
		
		if(regNum == null || regNum.equals("")){
			details = new CharityDetails();
			GiveAPI give = new GiveAPI();
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter a registration number.");
			details.setError(give);
			return details;
		}
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityDetails&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").toString(), CharityDetails.class);
			details.setError(checkResults);
		} else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new CharityDetails();
			details.setError(checkResults);
		}
		return details;
	}
	
	/**
	 * Returns financial details of a specific charity
	 * If proper parameters are not entered the method will return an error in a list of object of type FinancialData. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (FinancialData) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String regNum
	 * @return List<FinancialData>
	 * @throws IOException
	 */
	public static List<FinancialData> getFinancialDetails(String token, String regNum) throws IOException{
		List<FinancialData> details= null;
		List<FinancialData> errorList=new ArrayList<FinancialData>();
		FinancialData fd = new FinancialData();
		GiveAPI error = verifyToken(token);

		if(error.getStatus_code() != null && !error.getStatus_code().equals("100")){
			fd.setError(error);
			errorList.add(fd);
			return errorList;
		}
		
		if(regNum == null || regNum.equals("")){
			GiveAPI give = new GiveAPI();
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter a registration number.");
			fd.setError(give);
			errorList.add(fd);
			return errorList;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getFinancialDetails&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("financialDetails").get("financialData").toString(), typeFactory.constructCollectionType(List.class, FinancialData.class));
			
			for(FinancialData i: details){
				i.setError(checkResults);
			}
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new ArrayList<FinancialData>();
			fd.setError(checkResults);
			details.add(fd);
		}
		
		return details;
	}
	
	/**
	 * Returns a list of available charity types
	 * If proper parameters are not entered the method will return an error in a list of object of type CharityType. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (CharityType) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @return List<CharityType>
	 * @throws IOException
	 */
	public static List<CharityType> getCharityType(String token) throws IOException{
		List<CharityType> details =null;
		
		GiveAPI error = verifyToken(token);
		
		if(error.getStatus_code() != null && !error.getStatus_code().equals("100")){
			details = new ArrayList<CharityType>();
			CharityType ct = new CharityType();
			ct.setError(error);
			details.add(ct);
			return details;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityTypes&token="+token+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("charityTypes").get("charityType").toString(), typeFactory.constructCollectionType(List.class, CharityType.class));
			
			for(CharityType i: details){
				i.setError(checkResults);
			}
		} else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new ArrayList<CharityType>();
			CharityType ct = new CharityType();
			ct.setError(checkResults);
			details.add(ct);
		}
		return details;
	}
	
	/**
	 * Returns a list of provinces or states according to the country entered.
	 * If proper parameters are not entered the method will return an error in a list of object of type ProvState. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (ProvState) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String country
	 * @return List<ProvState>
	 * @throws IOException
	 */
	public static List<ProvState> getProvState(String token, String country) throws IOException{
		List<ProvState> details = null;
		
		List<ProvState> errorList=new ArrayList<ProvState>();
		GiveAPI give = new GiveAPI();
		ProvState p = new ProvState();
		GiveAPI error = verifyToken(token);

		if(error.getStatus_code() != null && !error.getStatus_code().equals("100")){
			p.setError(error);
			errorList.add(p);
			return errorList;
		}
		
		if(country == null || country.equals("")){
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter the parameter country.");
			p.setError(give);
			errorList.add(p);
			return errorList;
		}
		
		country = country.toUpperCase();
		CountryEnum c;
		try{
			c = CountryEnum.valueOf(country);
		}catch(IllegalArgumentException e){
			give.setstatus_code("204");
			give.setStatus_code_description("Invalid country, please enter the correct ID of the country.");
			p.setError(give);
			errorList.add(p);
			return errorList;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getProvState&token="+token+"&Country="+country+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(c != null){
			System.out.println("correct country inpu");
			if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
				details = mapper.readValue(node.get("give-api").get("data").get("proveStates").get("provState").toString(), typeFactory.constructCollectionType(List.class, ProvState.class));
				for(int i=0; i<details.size(); i++){
					details.get(i).setError(checkResults);
				}
			}
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new ArrayList<ProvState>();
			p.setError(checkResults);
			details.add(p);
			
		}
		return details;
	}
	
	/**
	 * Search charities that are active. Returns a list of type object-SearchCharities
	 * Must enter values for token, page number, num per page.
	 * Must enter one of the values for charity size, keyword, or charity type at least.
	 * Entering values for country and provState are optional
	 * All other values that are not set, should be set as null or empty string. 
	 * If proper parameters are not entered the method will return an error in a list of object of type SearchCharities. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (SearchCharities) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String PageNumber
	 * @param String NumPerPage
	 * @param String CharitySize
	 * @param String keyword
	 * @param String CharityType
	 * @param String Country
	 * @param String ProvState
	 * @return List<SearchCharities>
	 * @throws IOException
	 */
	public static List<SearchCharities> searchCharities(String token, String PageNumber, String NumPerPage, String CharitySize, String keyword, String CharityType,String Country, String ProvState) throws IOException{
		List<SearchCharities> details=null;
		List<SearchCharities> errors = new ArrayList<SearchCharities>();
		SearchCharities sc = new SearchCharities();
		GiveAPI give = new GiveAPI();
		
		GiveAPI tokenError = verifyToken(token);

		if(tokenError.getStatus_code() != null && !tokenError.getStatus_code().equals("100")){
			sc.setError(tokenError);
			errors.add(sc);
			return errors;
		}
		
		if((PageNumber ==null) || (NumPerPage ==null) || (PageNumber.equals("")) || (NumPerPage.equals(""))){
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter the page number and number per page.");
			sc.setError(give);
			errors.add(sc);
			return errors;
		} else if((CharitySize ==null) && (keyword ==null) && (CharityType ==null) || (CharitySize.equals("")) && (keyword.equals("")) && (CharityType.equals(""))){
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter one of the following parameters charity size, charity type, or keyword");
			sc.setError(give);
			errors.add(sc);
			return errors;		
		}
		
		String url ="https://app.place2give.com/Service.svc/give-api?action=searchCharities&token="+token+"&PageNumber="+PageNumber+"&NumPerPage="+NumPerPage;
		if(CharitySize != null && !CharitySize.equals("")){
			String size = CharitySize.toUpperCase();
			CharitySizeEnum cse;
			try{
				if(CharitySize.equalsIgnoreCase("VERY LARGE")){
					String[] temp = size.split(" ");
					size = temp[0]+temp[1];
					CharitySize = temp[0]+"%20"+temp[1];
				}
				cse = CharitySizeEnum.valueOf(size);
			}catch(IllegalArgumentException e){
				give.setstatus_code("204");
				give.setStatus_code_description("Invalid charity size, please enter the correct charity size.");
				sc.setError(give);
				errors.add(sc);
				return errors;
			}
			url+= "&CharitySize="+CharitySize.toUpperCase();
		}
		if(keyword != null && !keyword.equals(""))
			url+= "&keyword="+keyword;
		if(CharityType != null && !CharityType.equals(""))
			url+= "&CharityType="+CharityType;
		if(Country != null && !Country.equals("")){
			Country = Country.toUpperCase();
			CountryEnum ce;
			try{
				ce = CountryEnum.valueOf(Country);
			}catch(IllegalArgumentException e){
				give.setstatus_code("204");
				give.setStatus_code_description("Invalid country, please enter the correct ID for country.");
				sc.setError(give);
				errors.add(sc);
				return errors;
			}
			url+= "&Country="+Country;
		}
		if(ProvState != null && !ProvState.equals(""))
			url+= "&ProvState="+ProvState;
		
		url +="&format=json";

		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			DataSearchCharity dsc = mapper.readValue(node.get("give-api").get("data").toString(), DataSearchCharity.class);
			
			if(dsc.getSearchCharitiesResults() != null){
				details = mapper.readValue(node.get("give-api").get("data").get("charities").get("charity").toString(), typeFactory.constructCollectionType(List.class, SearchCharities.class));
				for(SearchCharities i : details){
					i.setTotalPages(dsc.getTotalPages());
					i.setTotalResults(dsc.getTotalResults());
					i.setOnPage(dsc.getOnPage());
					i.setError(checkResults);
				}
			}else{
				give.setstatus_code("200");
				give.setStatus_code_description("No results found for charities");
				sc.setError(give);
				sc.setTotalPages(dsc.getTotalPages());
				sc.setTotalResults(dsc.getTotalResults());
				sc.setOnPage(dsc.getOnPage());
				errors.add(sc);
				return errors;
			}
		}
		else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
	
			sc.setError(checkResults);
			errors.add(sc);
			return errors;
		}
		return details;
	}
	
	/**
	 * Return a list of charity files for a specific charity.
	 * Enter registration number for a specific charity.
	 * If proper parameters are not entered the method will return an error in a list of object of type CharityFiles. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (CharityFiles) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String regNum
	 * @return List<CharityFiles>
	 * @throws IOException
	 */
	public static List<CharityFiles> getCharityFiles(String token, String regNum) throws IOException{
		List<CharityFiles> details = null;
		
		List<CharityFiles> errors = new ArrayList<CharityFiles>();
		CharityFiles cf = new CharityFiles();
		GiveAPI give = new GiveAPI();
		
		GiveAPI tokenError = verifyToken(token);

		if(tokenError.getStatus_code() != null && !tokenError.getStatus_code().equals("100")){
			cf.setError(tokenError);
			errors.add(cf);
			return errors;
		}
		
		if(regNum == null || regNum.equals("")){
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter a registration number.");
			cf.setError(give);
			errors.add(cf);
			return errors;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityFiles&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") && checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("charityFiles").get("file").toString(), typeFactory.constructCollectionType(List.class, CharityFiles.class));
			
			for(CharityFiles i: details){
				i.setError(checkResults);
			}
			
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new ArrayList<CharityFiles>();
			cf.setError(checkResults);
			details.add(cf);
		}
		
		return details;
	}
	
	/**
	 * Returns a list of project information that are specific to a certain charity
	 * Must enter registration number for a specific charity
	 * If proper parameters are not entered the method will return an error in a list of object of type CharityProjects. Always check first element in the list for an error.
	 * The error message which is encapsulated in the object (CharityProjects) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful otherwise an error occurred.
	 * @param String token
	 * @param String regNum
	 * @return List<CharityProjects>
	 * @throws IOException
	 */
	public static List<CharityProjects> getCharityProjects(String token, String regNum) throws IOException{
		List<CharityProjects> details = null ;
		
		List<CharityProjects> errors = new ArrayList<CharityProjects>();
		CharityProjects cp = new CharityProjects();
		GiveAPI give = new GiveAPI();
		
		GiveAPI tokenError = verifyToken(token);

		if(tokenError.getStatus_code() != null && !tokenError.getStatus_code().equals("100")){
			cp.setError(tokenError);
			errors.add(cp);
			return errors;
		}
		
		if(regNum == null || regNum.equals("")){
			give.setstatus_code("204");
			give.setStatus_code_description("Please enter a registration number.");
			cp.setError(give);
			errors.add(cp);
			return errors;
		}
		
		String url = "https://app.place2give.com/Service.svc/give-api?action=getCharityProjects&token="+token+"&regNum="+regNum+"&format=json";
		String reader = readURL_GET(url);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		TypeFactory typeFactory = mapper.getTypeFactory();
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").get("charityProjects").get("project").toString(), typeFactory.constructCollectionType(List.class, CharityProjects.class));
			
			for(CharityProjects i: details){
				i.setError(checkResults);
			}
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new ArrayList<CharityProjects>();
			CharityProjects sc = new CharityProjects();
			sc.setError(checkResults);
			details.add(sc);
		}
		
		return details;
	}
	
	/**
	 * Returns an object of type DonationURL that contains the expiration date and the donationURL.
	 * The donation URL is a unique URL that allows users the ability to make one-time donation
	 * If proper parameters are not entered the method will return an error in object of type DonationURL.
	 * The error message which is encapsulated in the object (DonationURL) should always be checked after calling this method.
	 * If the error is 100 = it means the retrieval was successful, otherwise an error occurred.
	 * @param String token
	 * @param Object of type Info obj
	 * @return object of type DonationURL
	 * @throws IOException
	 */
	public static DonationURL getDonationURL(String token, Info obj) throws IOException{
		DonationURL details = null ;
		DonationURL errors = new DonationURL();
		GiveAPI give = new GiveAPI();
		
		GiveAPI tokenError = verifyToken(token);

		if(tokenError.getStatus_code() != null && !tokenError.getStatus_code().equals("100")){
			errors.setError(tokenError);
			return errors;
		}
		
		String url="https://app.place2give.com/Service.svc/give-api?action=getDonationURL&token="+token;
		
		if(obj.getRegNum() == null || obj.getProjectType() ==null || obj.getBackURL() == null || obj.getRedirectURL() == null || obj.getCurrency() == null || obj.getAmount() == null || obj.getRegNum().equals("") || obj.getProjectType().equals("") || obj.getBackURL().equals("") || obj.getRedirectURL().equals("") || obj.getCurrency().equals("") || obj.getAmount().equals("")){
			System.out.println("One of the parameters were not specefied. Please read the documentation.");
			give.setstatus_code("204");
			give.setStatus_code_description("Invalid parameters, please enter the required the parameters");
			errors.setError(give);
			return errors;
		}else if(obj.getIsAnonymous() == false){
			if(obj.getFirstName() == null || obj.getLastName() == null || obj.getEmail() == null || obj.getAddress()== null || obj.getPostalZip() == null || obj.getProvState()==null || obj.getCity()==null || obj.getCountry()==null || obj.getFirstName().equals("") || obj.getLastName().equals("") || obj.getEmail().equals("") || obj.getAddress().equals("") || obj.getPostalZip().equals("") || obj.getProvState().equals("") || obj.getCity().equals("") || obj.getCountry().equals("")){
				System.out.println("One of the parameters for donor info was not specified. Please check the documentation.");
				give.setstatus_code("204");
				give.setStatus_code_description("Invalid parameters, please enter personal information since the donation is not anonymous.");
				errors.setError(give);
				return errors;
			}
		}else{
			String projectType = obj.getProjectType().toUpperCase();
			String currency = obj.getCurrency().toUpperCase();
			ProjectType pt;
			CountryEnum c;
			CurrencyEnum ce;
			try{
				pt = ProjectType.valueOf(projectType);
				ce = CurrencyEnum.valueOf(currency);
				
				if(obj.getCountry() != null && obj.getCountry() != ""){
					String country = obj.getCountry().toUpperCase();
					c = CountryEnum.valueOf(country);
				}
			}catch(IllegalArgumentException e){
				give.setstatus_code("204");
				give.setStatus_code_description("Invalid projectType, currency, or country, please enter the correct parameters.");
				errors.setError(give);
				return errors;
			}
			
			if(obj.getClientfee() == null || obj.getClientfee().equals(""))
				url += "&regNum="+obj.getRegNum()+"&ProjectType="+obj.getProjectType()+"&BackURL="+obj.getBackURL()+"&RedirectURL="+obj.getRedirectURL()+"&Amount="+obj.getAmount()+"&Currency="+obj.getCurrency()+"&IsAnonymous="+obj.getIsAnonymous()+"&FirstName="+obj.getFirstName()+"&LastName="+obj.getLastName()+"&Address="+obj.getAddress()+"&City="+obj.getCity()+"&ProvState="+obj.getProvState()+"&Country="+obj.getCountry()+"&PostalZip="+obj.getPostalZip()+"&Email="+obj.getEmail()
					+"&Note="+obj.getNote()+"&InHonourOf="+obj.getInHonourOf()+"&InMemorialOf="+obj.getInMemorialOf()+"&format=json";
			else
				url += "&regNum="+obj.getRegNum()+"&ProjectType="+obj.getProjectType()+"&BackURL="+obj.getBackURL()+"&RedirectURL="+obj.getRedirectURL()+"&Amount="+obj.getAmount()+"&Currency="+obj.getCurrency()+"&IsAnonymous="+obj.getIsAnonymous()+"&FirstName="+obj.getFirstName()+"&LastName="+obj.getLastName()+"&Address="+obj.getAddress()+"&City="+obj.getCity()+"&ProvState="+obj.getProvState()+"&Country="+obj.getCountry()+"&PostalZip="+obj.getPostalZip()+"&Email="+obj.getEmail()
				+"&Note="+obj.getNote()+"&InHonourOf="+obj.getInHonourOf()+"&InMemorialOf="+obj.getInMemorialOf()+"&Clientfee="+obj.getClientfee()+"&format=json";
		
		}
		
		String reader = readURL_GET(url);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		JsonNode node = mapper.readTree(reader);
		GiveAPI checkResults = mapper.readValue(node.get("give-api").toString(), GiveAPI.class);
		
		if(checkResults.getStatus_code_description().equalsIgnoreCase("Success") || checkResults.getStatus_code().equals("100")){
			details = mapper.readValue(node.get("give-api").get("data").toString(), DonationURL.class);
			details.setError(checkResults);
		}else{
			System.out.println(checkResults.getStatus_code_description());
			new Exception("Error\nStatus code: "+checkResults.getStatus_code()+"-"+checkResults.getStatus_code_description());
			
			details = new DonationURL();
			details.setError(checkResults);
		}
		
		return details;
	}
}