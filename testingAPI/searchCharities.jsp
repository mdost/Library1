<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parseData.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="hello.jsp">
	<input type="submit" name="back" value="Back" >
	</form>
	<h1>Result:</h1>
	<%
	ParseData parser = new ParseData();
	String token = "7c301047-1c32-4914-8cd7-7350d592d3bb";
	String button = request.getParameter("submit");
	if(button !=null){
		String pageNum = request.getParameter("pageNum");
		String numPage = request.getParameter("numPage");
		String charityType = request.getParameter("charityType");
		String charitySize = request.getParameter("charitySize");
		String keyword = request.getParameter("keyword");
		String country = request.getParameter("country");
		String provState = request.getParameter("provState");

		List<SearchCharities> sc = parser.searchCharities(token, pageNum, numPage, charitySize, keyword, charityType, country, provState);
		if(sc != null){
			for(SearchCharities i: sc){
				out.println(i.toString()+"<br/>");
			}
		}
	}
	
	%>
</body>
</html>