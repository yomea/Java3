<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MultiImageDialog Examples</title>
<link rel="stylesheet" href="css/themes/default/default.css" />
<script src="js/kindeditor.js"></script>
<script src="js/lang/zh_CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true,
			uploadJson : '/KindEditorSCXZ/uploadImg'
		});

	});
</script>
</head>
<body>
	<textarea name="content" style="width:800px;height:400px;visibility:hidden;">KindEditor</textarea>

</body>
</html>
