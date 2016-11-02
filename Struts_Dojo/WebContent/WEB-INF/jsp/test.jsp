<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 注意不要忘记加这个 -->
<sx:head/>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	dojo.event.topic.subscribe("/hehe", function(data, type, request){
		request.cance();//取消发布
		alert("");
		
	} ) 

</script>
</head>
<body>
	<form action="<%=path %>/test_hello">
		test!!!
		<!-- 异步请求提交按钮,会把请求到的内容放到test1与test2 -->
		<sx:submit cssStyle="width:30px; height:30px;background:green;" targets="test1,test2" value="修改" executeScripts="true" notifyTopics="/hehe"></sx:submit>
	</form>
	
	<div id="test1"></div>
	<div id="test2"></div>
	
</body>
</html>