// JavaScript Document
$(document).ready(function() {

	$.ajax({
		url:"/content",
		type:"GET",
		data:{pageNum:0, pageSize:10},
		dataType:"html",
		success: function(d) {
			alert(d);
			$("#main").html(d);
			
		}
		
		
	});
	
	
});