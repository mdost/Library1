<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parseData.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
</head>
<body>
	<form method="get" action="hello.jsp">
	<input type="submit" name="back" value="Back" >
	</form>
	
	<%
	ParseData parser = new ParseData();
	String token = "7c301047-1c32-4914-8cd7-7350d592d3bb";
	
	String button2= request.getParameter("submit");
	String value = session.getAttribute("hiddenValue").toString();
	out.println("<h1>Result:</h1>");
	if(button2 != null){
		String hiddenValue = request.getParameter("hiddenValue");
		String text = request.getParameter("parameter");

		if(text != null){
			if(hiddenValue.equalsIgnoreCase("getFinancialDetails")){
				List<FinancialData> fd = parser.getFinancialDetails(token, text);
				
				for(FinancialData i : fd){
					out.println(i.FiscalYear+" "+i.ExpTotal+" "+i.DefRevenue+"<br/>");
				}
			}else if(hiddenValue.equalsIgnoreCase("getCharityDetails")){
				CharityDetails cd = parser.getCharityDetails(token, text);
				out.println(cd.CharityName+" "+cd.CharityAddress);
			}else if(hiddenValue.equalsIgnoreCase("getCharitySalaries")){
				SalaryData sd = parser.getCharitySalaries(token, text);
				out.println(sd.toString());
			}else if(hiddenValue.equalsIgnoreCase("getProvState")){
				List<ProvState> ps = parser.getProvState(token, text);
				for(ProvState i: ps){
					out.println(i.getProvState().toString()+"<br/>");
				}
			}else if(hiddenValue.equalsIgnoreCase("getCharityFiles")){
				List<CharityFiles> cf = parser.getCharityFiles(token, text);
				for(CharityFiles i: cf){
					out.println(i.toString()+"<br/>");
				} 
			}else if(hiddenValue.equalsIgnoreCase("getCharityProjects")){
				List<CharityProjects> cp = parser.getCharityProjects(token, text);
				for(CharityProjects i: cp){
					out.println(i.toString()+"<br/>");
				} 
			}
		}
	}else if(value.equalsIgnoreCase("getCharityType")){
		 List<CharityType> ct = parser.getCharityType(token);
		 for(CharityType i : ct){
			 out.println(i.toString()+"<br/>");
		 }
	}else{
		out.println("Please enter the required parameters.");
	}
	
	%>

</body>
</html>