$(document).ready(function(){
   
    loadPlayers();
   
    function saveListOrder() {
        var playerList = [];
        var list = document.getElementsByTagName("li");
        document.getElementById("test").innerHTML = "m";
        for (var x = 0, y = list.length; x < y; ++x) {
            playerList.push(list[x].firstChild.nodeValue);
        }
        playerList.splice(0, 4);//because for some reason three elements are added at first.
        document.getElementById("test").innerHTML = playerList;
    }

    //function when adding player form is called
    $('#addPlayer').submit(function(event){
        event.preventDefault();

        $.ajax({
            url:"addPlayer",
            type:"POST",
            dataType: "json",
            data: $("#addPlayer").serialize(),
            success: function(data){

            }
        });
        loadPlayers();
        return false;
    });

    //function when removing player form is called
    $('#removePlayer').submit(function(event){
        event.preventDefault();

        $.ajax({
            url:"removePlayer",
            type:"POST",
            dataType: "json",
            data: $("#removePlayer").serialize(),
            success: function(data){

            }
        });
        loadPlayers();
        return false;
    });

    //loads subsequent players from database, creates html for each, and inserts them into table
    function loadPlayers() {
        var requestURL = "Servlet?loadPlayers";
        $.get(requestURL, function(result, response){
            $("#playerContainer").html("");
            $each(result, function (index, Player){
                var html = '<li class = "player" draggable="true" ondragenter="dragenter(event)" ondragstart="dragstart(event)"' +
                Player.playerTag + 
                '</li>';
                $("#playerContainer").append(html);
            });
        });
    }
});