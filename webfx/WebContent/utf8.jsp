<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ taglib uri="http://stimulsoft.com/designer" prefix="stidesignerfx"%>
<%@ taglib uri="http://stimulsoft.com/viewer" prefix="stiviewerfx"%>

<html>
<head>
<title>Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body marginheight="0" marginwidth="0">
	test Encoding
	<form action="" method="get">
		<input name="value" value="test" /> <input type="submit" value="GO" />
	</form>

	value =	<b><%=request.getParameter("value")%></b>

	<br><br>If you have problems with the text output national characters, you need to on your server in the file
	<b>server.xml</b> to specify the encoding
	<br>in tag <b>Connector</b> indicate <b>URIEncoding="UTF-8"</b>
	<br><br>for example:
	<code>
	  <br><br>&lt;Connector
	  <b>URIEncoding="UTF-8"</b> connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" /&gt;
    </code>
</html>