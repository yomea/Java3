<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();
		out.write(application.getInitParameter("key"));
		out.flush();
		
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#button').on("click", function() {
		$('#test').load("<%=path%>/test", {}, function(response,status,xhr) {
			if(status == "success") {
				alert(response);
				
			}
			
		});
		
	});
	
	
});

</script>
</head>
<body>
	${initParam.key }<!-- 拿到context-param的值 -->
	<button id="button">test</button>
	<div id="test">
		
	</div>
</body>
</html>