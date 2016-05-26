<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head  />
</head>
<body>
<h1>Select date to see your schedule:</h1>
<s:form action="doctor" theme="xhtml">
	<sj:datepicker id="2"  name="selectedDate2"  label="Enter date" timepicker="true" showAnim="slideDown" timepickerFormat="hh:mm"/>
	<s:submit/>
</s:form>

<%
TreeMap<Date, String> dates = (TreeMap<Date, String>) request.getAttribute("sortedDates");
Date currentDate = (Date) request.getAttribute("selectedDate2");
if(currentDate == null){
	currentDate = new Date();
}
%>
<p2>Schedule :</p2> <br>
<select id="dates" name="date">
<%
	for (Map.Entry<Date, String> date : dates.entrySet()) {
			//if(date.getValue().after(selectedDate) && date.getValue().before(selectedDate))
			
				if(date.getKey().getYear() == currentDate.getYear() &&
				date.getKey().getMonth() == currentDate.getMonth() && 
				date.getKey().getDate() == currentDate.getDate()){
%>

<option value="<%=date.getValue()%>">	<%=String.format("%s - %s",date.getKey(), date.getValue())%> 
</option>

<%
				}
			
		}
	
%>
</select>

 

</body>
</html>