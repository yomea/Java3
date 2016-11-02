<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="commons.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").html("hello world!!!");
		
	});
</script>
</head>
<body>

信息: Starting ProtocolHandler ["ajp-nio-8009"]
十月 28, 2016 4:28:23 下午 org.apache.catalina.startup.Catalina start
信息: Server startup in 3645 ms
<table id="table">

</table>

</body>
</html>