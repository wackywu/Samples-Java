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
	Properties props = new Properties();
	props.put("Localizations.Localization", "en.xml");	
	//props.put("Viewer.Toolbar.ShowSaveButton","False");
	request.setAttribute("props", props);
%>

<%
	Map<String, String> variableMap = new HashMap<String, String>();
	variableMap.put("Variable1","variableMap");
	request.setAttribute("map",variableMap);
%>

<body marginheight="0" marginwidth="0">

<stidesignerfx:iframe  width="100%" height="100%" />


</body>

</html>