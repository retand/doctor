<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Date Picker Result</title>
</head>
<body>


	<%
		Map<Date, String> dates = (Map<Date, String>) request.getAttribute("dates");
		Date selectedDate = (Date) request.getAttribute("selectedDate");
		boolean isDayFound = false;
		boolean isHourFound = false;
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		if (selectedDate != null && dates != null) {
	%>
	<p3>This hour is already reserved.</p3>
	<p3>You see all reserved hours in this date here:</p3>
	<select id="dates" name="date">
		<%
			for (Map.Entry<Date, String> date : dates.entrySet()) {
					//if(date.getValue().after(selectedDate) && date.getValue().before(selectedDate))
					if (selectedDate.getDate() == date.getKey().getDate() &&
					selectedDate.getMonth() == date.getKey().getMonth() && selectedDate.getYear() == date.getKey().getYear()) {
						isDayFound = true;
						
		%>

		<option value="<%=date.getValue()%>">
			<%=ft.format(date.getKey() )%>
		</option>

		<%

					}
				}
			}
		%>
	</select>

</body>
</html>