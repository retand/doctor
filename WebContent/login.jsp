<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign here!</title>
<sj:head />
</head>
<body>

<center>
	<s:form action="login" theme="simple">
		<s:label>User name:</s:label>
		<s:textfield label="Username" key="userId" />
		<br>
		<s:label>Password:</s:label>
		<s:password label="Password" key="password" />
		<br>
		<div style="display: inline-block; white-space: nowrap;">
			<s:submit method="signUp" value="Sign up" />
			<s:submit method="execute" value="Log in" />
		</div>

	</s:form>
</center>



</body>
</html>