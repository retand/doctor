<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head  />
</head>
<body>
<jsp:useBean id="test" class="org.example.action.ReserveAction" />

<s:form action="reserve" theme="xhtml">
	<sj:datepicker id="2"  name="selectedDate2"  label="Enter date:" timepicker="true"  timepickerFormat="hh:mm"/>
	<s:submit/>
</s:form>
</body>
</html>