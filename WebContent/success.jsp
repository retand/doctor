<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="Data.User"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head  />
</head>
<body>
<jsp:useBean id="test" class="org.example.action.ReserveAction" />

<%
	User user = (User) request.getAttribute("user");
	//Map attibutes = ActionContext.getContext().getSession(); "%{#session.user.username}"
%>

<p>Welcome, <s:property value="%{#session.user.firstName}" /> <s:property value="%{#session.user.lastName}" /> </p>
<p>Select date: </p>
<s:form action="reserve" theme="xhtml">
	<sj:datepicker id="1"  name="selectedDate"  label="Enter date" timepicker="true" showAnim="slideDown" timepickerFormat="hh:mm"/>
	<s:textfield label="Reason" key="reason" />
	<s:submit/>
</s:form>

<jsp:include page="result.jsp" flush="true" />

</body>
</html>