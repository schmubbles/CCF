/**
 * 
 */


$(document).ready(function(){
	$('#signUp').submit(function(){
		$.ajax({
			url:"signup",
			type: "POST",
			dataType: "json",
			data: $("#signUp").serialize(),
			success: function(data){
				
			}
			
			
		});
		return false;
		
		
		
	});
	
	
});