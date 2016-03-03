<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="viewer.jsp">
<input id="FreeCurrency_Name" name="FreeCurrency_Name" Value="" type="hidden">        
	<input id="FreeCurrency" type="checkbox" name="FreeCurrency"/>
	<br>	
	<input id="InUseCurrency_Name"  name="InUseCurrency_Name" Value="" type="hidden">        
	<input id="InUseCurrency"  type="checkbox" name="InUseCurrency" checked="checked" value="true" onchange="this.value = this.checked ? 'true' : 'false'"/>
	<br>
	<input type="submit">
</form>

</body>
</html>