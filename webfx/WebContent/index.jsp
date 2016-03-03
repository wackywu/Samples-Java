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
	//props.put("Viewer.Toolbar.ShowAboutButton", "False");
	//props.put("Viewer.Toolbar.ShowSaveButton","False");
	request.setAttribute("props", props);
%>

<frameset cols="50%,*">
	<frame src="menu.jsp" name="leftFrame" scrolling="auto"/>
	<stiviewerfx:frame name="mainFrame" report="SimpleList.mdc"  
		bordercolor="" styleClass="" frameborder="1"
		styleId=""	marginheight="" marginwidth=""
		scrolling="auto" style="" title="" properties="${props}"/>
</frameset>

</html>