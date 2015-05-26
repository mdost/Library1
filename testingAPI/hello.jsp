<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.parseData.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing ParseData Jar</title>
</head>
<body>
	<h2>Testing Library ParseData.jar</h2>
	<p>
		Please select one of the methods from the list below, you would like to test:<%--br is for new line character, this is for comment--%>
		<br/>
		<table>
		<tr><th>Selection</th><th>Methods</th></tr>
		<form method="get" action="hello.jsp" enctype=text/plain >
		<tr><th><input type="radio" name="method" value="getCharityDetails"></th> <th>getCharityDetails() </th></tr>
		<tr><th><input type="radio" name="method" value="getCharitySalaries"></th> <th> getCharitySalaries() </th></tr>
		<tr><th><input type="radio" name="method" value="getFinancialDetails"></th> <th> getFinancialDetails() </th></tr>
		<tr><th><input type="radio" name="method" value="getCharityType"></th> <th> getCharityType() </th></tr>
		<tr><th><input type="radio" name="method" value="getProvState"></th> <th> getProvState() </th></tr>
		<tr><th><input type="radio" name="method" value="getCharityFiles"></th> <th> getCharityFiles() </th></tr>
		<tr><th><input type="radio" name="method" value="getCharityProjects"></th> <th> getCharityProjects() </th></tr>	
		<tr><th><input type="radio" name="method" value="getDonationURL"></th> <th> getDonationURL() </th></tr>
		<tr><th><input type="radio" name="method" value="searchCharities"></th> <th> searchCharities() </th></tr>
		</table>
		<input type="submit" name="enter" value="Enter">
		</form>
		<% 
			ParseData parser = new ParseData();
			//String token = parser.getToken("dc669d4e-08ee-4455-a253-ba233be22ba7", "c0440e81-8596-4b3c-af3a-aa73a6eb0e4e");
			String token = "7c301047-1c32-4914-8cd7-7350d592d3bb";
			
			String button = request.getParameter("enter");
				
			if(button != null && button.equalsIgnoreCase("enter")){
				String command = request.getParameter("method");
				if(command != null){
					//out.println(command);
					if(command.equalsIgnoreCase("getFinancialDetails")){ %>
					
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="Result.jsp" enctype=text/plain>
						Registration Number <input type="text" name="parameter" id="regNum">
						<input type="hidden" name="hiddenValue" value="getFinancialDetails">
						<input type="submit" name="submit" value="Enter">
						</form>
				<% 	
					}else if(command.equalsIgnoreCase("getCharityDetails")){ %>
						
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="Result.jsp" enctype=text/plain>
						Registration Number <input type="text" name="parameter" id="regNum">
						<input type="hidden" name="hiddenValue" value="getCharityDetails">
						<input type="submit" name="submit" value="Enter">
						</form>
				<% 	
						
					}else if(command.equalsIgnoreCase("getCharitySalaries")){ %>
						
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="Result.jsp" enctype=text/plain>
						Registration Number <input type="text" name="parameter" id="regNum">
						<input type="hidden" name="hiddenValue" value="getCharitySalaries">
						<input type="submit" name="submit" value="Enter">
						</form>
				<% 	
						
					}else if(command.equalsIgnoreCase("getCharityFiles")){ %>
					
					<br/>Please enter the following parameters:<br/>
					<form method="get" action="Result.jsp" enctype=text/plain>
					Registration Number <input type="text" name="parameter" id="regNum">
					<input type="hidden" name="hiddenValue" value="getCharityFiles">
					<input type="submit" name="submit" value="Enter">
					</form>
			<% 	
					
					}else if(command.equalsIgnoreCase("getCharityProjects")){ %>
					
					<br/>Please enter the following parameters:<br/>
					<form method="get" action="Result.jsp" enctype=text/plain>
					Registration Number <input type="text" name="parameter" id="regNum">
					<input type="hidden" name="hiddenValue" value="getCharityProjects">
					<input type="submit" name="submit" value="Enter">
					</form>
			<% 	
					
					}else if(command.equalsIgnoreCase("getDonationURL")){
						//request.setAttribute("hiddenValue", "getDonationURL");
						%>
						
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="getDonationURL.jsp" enctype=text/plain>
						Registration Number <input type="text" name="regNum" ><br/>
						Project Type <input type="text" name="projectType" ><br/>
						Amount $ <input type="text" name="amount" ><br/>
						Currency <input type="text" name="currency" ><br/>
						Back URL <input type="text" name="backURL" ><br/>
						Redirect URL <input type="text" name="redirectURL" ><br/>
						<input type="radio" name="isAnonymous" value="isAnonymous"> Anonymous <br/>
						<em>*If donation is not anonymous, then the personal info is required, otherwise it is optional.</em><br/><br/>
						First Name <input type="text" name="fName" ><br/>
						Last Name <input type="text" name="lName" ><br/>
						Email <input type="text" name="email"><br/>
						Address <input type="text" name="address" ><br/>
						Postal/Zip <input type="text" name="postalZip" ><br/>
						City <input type="text" name="city" ><br/>
						Province/State <input type="text" name="provState" ><br/>
						Country <input type="text" name="country" ><br/>
						<em>*Following info is optional</em><br/><br/>
						
						Client Fee <input type="text" name="clientFee"><br/>
						Client Unique <input type="text" name="clientUnique"><br/>
						Note <input type="text" name="note"><br/>
						In Memorial of <input type="text" name="memorial"><br/>
						In Honour of <input type="text" name="honour"><br/>
						
						<input type="submit" name="submit" value="Enter"><br/>
						</form>
				<% 	
					}else if(command.equalsIgnoreCase("searchCharities")){
%>
						
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="searchCharities.jsp" enctype=text/plain>
						<em>*Following fields are required</em><br/>
						Page # <input type="text" name="pageNum" ><br/>
						Num/page <input type="text" name="numPage" ><br/><br/>
						<em>*One of the following must be filled</em><br/>
						Charity Size <input type="text" name="charitySize" ><br/>
						Keyword <input type="text" name="keyword" ><br/>
						Charity Type <input type="text" name="charityType" ><br/><br/>
						<em>*Following fields are optional</em><br/>
						Country <input type="text" name="country" ><br/>
						Province/State <input type="text" name="provState" ><br/>
						<input type="submit" name="submit" value="Enter"><br/>
						</form>
						
				<%
					}else if(command.equalsIgnoreCase("getCharityType")){
						HttpSession value = request.getSession(false);
						value.setAttribute("hiddenValue", "getCharityType");
						response.sendRedirect("Result.jsp");
					}else if(command.equalsIgnoreCase("getProvState")){ %>
						
						<br/>Please enter the following parameters:<br/>
						<form method="get" action="Result.jsp" enctype=text/plain>
						Country <input type="text" name="parameter" id="country">
						<input type="hidden" name="hiddenValue" value="getProvState">
						<input type="submit" name="submit" value="Enter">
						</form>
				<% 	
					}
				}else{
					out.println("Please select an item from the list shown above.<br/>");
				}
			}
			
			
			
			
			//out.println("Token: "+token);
		%>
	</p>
</body>
</html>