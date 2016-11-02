<!DOCTYPE html>
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
<#list Request.users as user>
 <p>My name is ${user.username}, I'm ${user.age} years old, my birthday is ${user.date?string("yyyy-MM-dd")}</p>
</#list>
</body>
</html>