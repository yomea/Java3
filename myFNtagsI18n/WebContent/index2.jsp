<%@page import="javax.servlet.jsp.jstl.core.Config"%>
<%@page import="javax.servlet.jsp.jstl.fmt.LocalizationContext"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fns" uri="http://com.myFn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
	ResourceBundle resourceBundle = ResourceBundle.getBundle("messages1", new Locale("zh","CN"));
	Config.set(pageContext, Config.FMT_LOCALIZATION_CONTEXT, new LocalizationContext(resourceBundle), PageContext.PAGE_SCOPE);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="hello" value="world!"></c:set>
<c:out value="${hello}"></c:out>
<c:out value="${fns:length(hello)}"></c:out>
<fmt:message key="jj.jj" >
	<fmt:param value="我是污妖王"></fmt:param>
</fmt:message>
<br />

</body>
</html>