<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/webfx/stimulsoft_viewerfx" method="post">
	<input name="stimulsoft_report_key" value="SimpleList.mdc" type="hidden" />
	<input name="properties" value="Viewer.Toolbar.ShowSaveButton=False|Viewer.Toolbar.ShowAboutButton=False" type="hidden" />
	<input name="Variable1" value="Value 1" type="text" />
	<input name="Variable2" value="Value 2" type="text" />
	<input value="GO" type="submit" />
</form>

</body>
</html>