<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
</head>
<body>

<s:form action="signUp" theme="xhtml" >

	<s:textfield label="First name" key="firstName"/>
	<s:textfield label="Last name" key="lastName"/>
	<s:textfield label="Username" key="username"/>
	<s:password label="Password" key="password" />
	<s:password label="Reenter password" key="password2" />
	<s:submit/>
</s:form>

</body>
</html>