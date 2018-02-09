
$(document).ready(function(){
   
    $('.group').hide(); 

    $("#selector").change(function(){
        $('.group').hide();        
        $('#'+$(this).val()).show();
    });

    $('#file-button').click(function(){
        $('#my-file').click();
    });

    $("#fileEnterForm").submit(function(event) {
        alert("sumbit");
    });

    $("#addPlayer").submit(function(){
        $("#playerTable > tbody:last-child").append("<tr><td>" + $("#playerOne").val() + "</td><td>" + $("#playerTwo").val() + "</td></tr>");
        $("#playerOne").val("");
        $("#playerTwo").val("");
        return false;
    });

    $("#addTournament").submit(function(event){
        event.preventDefault();

        
        $.ajax({
            url:"addTournament",
            type:"POST",
            dataType: "json",
            data: $("#addTournament").serialize(),
            success: function(data){

            }
        });
        return false;
    });
});