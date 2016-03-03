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
	<h2>Designer:</h2>
	<form action="/webfx/stimulsoft_designerfx" method="post">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mrt" type="hidden" />
		<input name="Variable1" value="Value 1" type="text" />
		<input name="Variable2" value="Value 2" type="text" />
		<input value="GO" type="submit" />
	</form>
	<form action="/webfx/stimulsoft_designerfx" method="get">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mrt" type="hidden" />
		<select name="Variable1">
			<option value="Value 1">Value 1</option>
			<option value="Value 2">Value 2</option>
		</select>
		<input type="submit" value="GO">
	</form>
	<form action="/webfx/stimulsoft_designerfx" method="post">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mrt" type="hidden" />
		Value 1 <input type="radio" value="Value 1"	name="Variable1">
		Value 2 <input type="radio" value="Value 2"	name="Variable1">
		<input type="submit" value="GO">
	</form>

	<h2>Viewer:</h2>
	<form action="/webfx/stimulsoft_viewerfx" method="post">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mdc" type="hidden" />
		<input name="Variable1" value="Value 1" type="text" />
		<input name="Variable2" value="Value 2" type="text" />
		<input value="GO" type="submit" />
	</form>
	<form action="/webfx/stimulsoft_viewerfx" method="get">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mdc" type="hidden" />
		<select name="Variable1">
			<option value="Value 1">Value 1</option>
			<option value="Value 2">Value 2</option>
		</select>
		<input type="submit" value="GO">
	</form>
	<form action="/webfx/stimulsoft_viewerfx" method="post">
		<input name="stimulsoft_report_key" value="SimpleListWithVariable.mdc" type="hidden" />
		Value 1 <input type="radio" value="Value 1"	name="Variable1">
		Value 2 <input type="radio" value="Value 2"	name="Variable1">
		<input type="submit" value="GO">
	</form>
</body>

</html>