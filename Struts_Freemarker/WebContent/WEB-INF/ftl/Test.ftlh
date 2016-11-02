<#--提供其他的标签库-->
<#--<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld "]>-->
<!DOCTYPE html>
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
<#-- 默认引用了struts的标签库，与在JSP使用差不多，就是把<s:textfield>改成了<@s.textfield> -->
<@s.form>
	<@s.textfield name="username" label="用户名" />
	<@s.textfield name="age" label="年龄" />
	<@s.textfield name="date" label="出生年月" />
	<@s.submit value="提交" />
</@s.form>
 <p>My name is ${username}, I'm ${age} years old, my birthday is ${date?string("yyyy-MM-dd")}</p>
 <p>My name is <@s.property value="%{username}" />, I'm <@s.property value="%{age}" /> years old, my birthday is <@s.date name="%{date}" format="yyyy-MM-dd" /></p>
</body>
</html>