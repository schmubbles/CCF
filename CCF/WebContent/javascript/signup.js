
$(document).ready(function(){

	loadRegisteredPlayers();

	$('#signupForm').submit(function(event){
		event.preventDefault();

		$.ajax({
			url:"signup",
			type: "POST",
			dataType: "json",
			data: $("#signupForm").serialize(),
			success: function(data){

			}
			
			
		});
		return false;
	});
	
	//loads players who have signed up for the tournament
	function loadRegisteredPlayers(){
		var requestURL = "Servlet?loadRegisteredPlayers";
		$.get(requestURL, function(result, response) {
			$("#playerOrderedList").html("");
			$.each(result, function(index, Player){
				var html = '<li>' + Player.playerTag + '</li>';
				$("#playerOrderedList").append(html);
			});
		});
	}
	
});