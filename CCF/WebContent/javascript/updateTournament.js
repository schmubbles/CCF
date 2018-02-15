
$(document).ready(function(){
   
    $('.group').hide(); //hide all groups at the beginning

    $("#selector").change(function(){//shows which input the user is using
        $('.group').hide();        
        $('#'+$(this).val()).show();
    });

    $('#file-button').click(function(){//opens fileSelect
        $('#my-file').click();
    });

    $("#my-file").change(function(e){//changes fileName visible
        var fileName = $("#my-file").val();
        $("#file-path").text(fileName);
    });

    $("#fileEnterForm").submit(function(event) {//submit a file
        alert("sumbit");
    });

    $("#addPlayer").submit(function(){//add a player table row manually
        $("#playerTable > tbody:last-child").append("<tr><td><input class = \"playerInput\" type = \"text\" value = \"" + $("#playerOne").val() 
            + "\"></td><td><input class = \"playerInput\" type = \"text\" value = \"" + $("#playerTwo").val() 
            + "\"></td></tr>");
        $("#playerOne").val("");
        $("#playerTwo").val("");
        return false;
    });

    $("#playerOneText").click(function(){
        alert("yo");
    });

    $("#playerRemoveButton").click(function(){//removes the last row in the table
        var str = $("#playerTable").html();
        if (str.indexOf("<td>") >= 0){
            $("#playerTable tr:last").remove();
        }
    });

    $("#manualAddTournamentButton").click(function(event){//submit a manual tournament
        event.preventDefault();

        getPlayerList();
        
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

    var getPlayerList = function(){
        var str = "";

        $(".playerInput").each(function(){
            alert(this.val());
//            str += this.val();
        });
        alert(str);
    }
});
