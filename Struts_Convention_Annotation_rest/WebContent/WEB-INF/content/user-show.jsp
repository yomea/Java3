<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="sx"  uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sx:head/>
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$(document.forms[0]).on("submit", function(e) {
			e = e || window.event;
			e.preventDefault();
			var that = this;
			$("#test").load("<%=path %>/hehe",$(that).serialize(), function(response, status, xhr) {
				if(status == "success") {
					alert(response);
					
				}
				
			});
			
		});
		
	})

</script>
</head>
<body>
	<s:form id="hehe">
	<s:textfield label="用户名：" name="username"></s:textfield><br />
	<s:textfield label="年  龄：" name="age"></s:textfield><br />
	<!-- 由于用的不是struts的标签，所以字段校验器失效 -->
	<sx:datetimepicker label="出生年月：" displayFormat="yyyy-MM-dd" name="date"></sx:datetimepicker><br />
	<s:submit label="提交" ></s:submit>
	</s:form>
	<div id="test"></div>
</body>
</html>