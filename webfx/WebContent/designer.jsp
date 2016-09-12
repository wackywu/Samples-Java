<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ taglib uri="http://stimulsoft.com/designer" prefix="stidesignerfx"%>
<%@ taglib uri="http://stimulsoft.com/viewer" prefix="stiviewerfx"%>

<html>
<head>
<title>Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<%
    final String reportPath = request.getSession().getServletContext().getRealPath("/reports/SimpleList.mrt");	
	Properties props = new Properties();
	props.put("Theme","Office2013");
	request.setAttribute("props", props);
	Map<String, String> variableMap = new HashMap<String, String>();
	variableMap.put("Variable1","variable");
	request.setAttribute("map",variableMap);
	request.setAttribute("props",props);
%>

<body marginheight="0" marginwidth="0">
<stidesignerfx:iframe  report="<%=reportPath%>" width="100%" height="100%" variableStr="Parameter1=30" properties="${props}" />
</body>
</html>