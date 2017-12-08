$(document).ready(function(){
    
    loadPlayers();

    //this doesn't do anything rn
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

    //deletes list
    $(document).on("click", ".deletePlayerButton", function(){
        var requestURL = "Servlet?deletePlayerList";
        $.get(requestURL, function(result, response){
            
        });
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