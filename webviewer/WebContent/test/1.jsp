<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.stimulsoft.webviewer.enums.StiShowMenuMode"%>
<%@page import="com.stimulsoft.webviewer.enums.StiPagesViewMode"%>
<%@page import="com.stimulsoft.webviewer.enums.StiPrintDestination"%>
<%@page import="com.stimulsoft.base.drawing.StiColorEnum"%>
<%@page import="com.stimulsoft.webviewer.enums.StiWebViewerTheme"%>
<%@page import="com.stimulsoft.webviewer.StiWebViewerOptions"%>
<%@page import="com.stimulsoft.report.dictionary.databases.StiJDBCDatabase"%>
<%@page import="com.stimulsoft.report.dictionary.databases.StiXmlDatabase"%>
<%@page import="java.io.File"%>
<%@page import="com.stimulsoft.report.StiSerializeManager"%>
<%@page import="com.stimulsoft.report.StiReport"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://stimulsoft.com/webviewer" prefix="stiwebviewer"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
<title>Stimulsoft Reports for Java</title>
<stiwebviewer:resources />
</head>
<body>
	<h1 align="center">report</h1>
	<%!public StiJDBCDatabase getOleDatabase(String demoDir) {
        	String accessFile = demoDir + "NWIND.MDB";
        	String jdbcUrl = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + accessFile
            	    + ";DriverID=22;READONLY=true}";
        	String jdbcDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        	StiJDBCDatabase oleDatabase = new StiJDBCDatabase("NorthWind", jdbcUrl, jdbcDriver, "", "");
        	return oleDatabase;
    	}%>
    <%
        StiReport report = StiSerializeManager.deserializeReport(new File(
    	     "c:/report/Reports/ParametersDetailedCategories.mrt"));
    	     //"c:/report/Reports/ParametersInvoice.mrt"));
    	     //"c:/ParametersHighlightCondition.mrt"));
    	    //"c:/report/Reports/BookmarksHyperlinks.mrt"));
            StiXmlDatabase xmlDatabase = new StiXmlDatabase("Demo", "c:/report/Data/Demo.xsd",
               "c:/report/Data/Demo.xml");
            StiJDBCDatabase oleDatabase = getOleDatabase("c:/report/Data/");
    	    report.getDictionary().getDatabases().add(xmlDatabase);
    	    report.getDictionary().getDatabases().add(oleDatabase);
    	    report.Render(false);
    	    
    	    StiWebViewerOptions options = new StiWebViewerOptions();
    	    options.setHeight("100%");
    	    options.setRightToLeft(false);
    	    options.setToolbarVisible(true);
    	    options.setPageShowShadow(true);
    	    options.setShowButtonBookmarks(true);
    	    options.setShowCurrentPageControl(true);
    	    options.setScrollbarsMode(false);
    	    
    	    options.setTheme(StiWebViewerTheme.Office2007Blue);
    	    options.setBackColor(StiColorEnum.Green.color());
    	  //  options.setMenuAnimation(false);
    	  //  options.setMenuViewMode(StiWebViewMode.WholeReport);
    	  //  options.setMenuShowMode(StiShowMenuMode.Hover);
    	    options.setViewerID("MvcViewer1");
    	    
    	    
    		pageContext.setAttribute("report", report);
    		pageContext.setAttribute("options", options);
    %>	
<stiwebviewer:webviewer report="${report}" options="${options}"/>
		
		
		
		
</body>
</html>