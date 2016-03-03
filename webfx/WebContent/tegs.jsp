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
	//props.put("Localizations.Localization", "en.xml");
	//props.put("Viewer.Toolbar.ShowSaveButton","False");
	request.setAttribute("props", props);
%>

<body marginheight="0" marginwidth="0">
	<h2>Sample JSP tag</h2>

	<h2>Designer:</h2>
	<ol>
		<li><stidesignerfx:link text="link jsp teg designer" properties="${props}" /></li>
		<li><stidesignerfx:link text="teg with SimpleList.mrt report" report="SimpleList.mrt" /></li>
		<li><stidesignerfx:link
				text="SimpleListWithVariable.mrt report with parameters"
				report="SimpleListWithVariable.mrt"
				variableStr="Variable1=link&Variable2=var2"/>

		</li>
		<li><stidesignerfx:button value="button jsp teg designer" properties="${props}"/></li>
		<li><stidesignerfx:button value="teg with SimpleList.mrt report" report="SimpleList.mrt"/></li>
		<li><stidesignerfx:button
				value="SimpleListWithVariable.mrt report with parameters" report="SimpleListWithVariable.mrt"
				variableStr="Variable1=button&Variable2=var2" />
		</li>
	</ol>
	<h2>Viewer:</h2>
	<ol>
		<li><stiviewerfx:link text="link jsp teg viewer" properties="${props}"/></li>
		<li><stiviewerfx:link text="teg with SimpleList.mdc report"	report="SimpleList.mdc" /></li>
		<li><stiviewerfx:link
		        text="SimpleListWithVariable.mrt report with parameters"
				report="SimpleListWithVariable.mrt"
				variableStr="Variable1=link&Variable2=var2" />
		</li>
		<li><stiviewerfx:button value="button jsp teg viewer" properties="${props}"/>
		</li>
		<li><stiviewerfx:button value="teg with SimpleList.mdc report" report="SimpleList.mdc" /></li>
		<li><stiviewerfx:button
				value="SimpleListWithVariable.mrt report with parameters"
				report="SimpleListWithVariable.mdc"
				variableStr="Variable1=button&Variable2=var2" /></li>
	</ol>
<br>



<stiviewerfx:iframe report="SimpleListWithVariable.mdc" 
 	width="100%" height="100%" align="top"
 	styleClass="" frameborder="0" styleId=""
 	marginheight="4" marginwidth="10" name="stiviewerfx"
 	scrolling="no" style="" title="отчет"/>


</body>

</html>