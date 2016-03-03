<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ taglib uri="http://stimulsoft.com/designer" prefix="stidesignerfx"%>
<%@ taglib uri="http://stimulsoft.com/viewer" prefix="stiviewerfx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	
	Properties props = new Properties();
	//props.put("Localizations.Localization", "en.xml");
	//props.put("Viewer.Toolbar.ShowSaveButton","False");
	request.setAttribute("props", props);

	Map<String, String> variableMap = new HashMap<String, String>();
	variableMap.put("FreeCurrency","true");
	request.setAttribute("map",variableMap);

%>

<stiviewerfx:iframe report="test.mrt" variableMap="map"
 	width="100%" height="100%" align="top"
 	styleClass="" frameborder="0" styleId=""
 	marginheight="4" marginwidth="10" name="stiviewerfx"
 	scrolling="no" style="" title="report"/> 	
</body>

</html>