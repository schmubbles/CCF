$(document).ready(function() {

    loadPlayers();

    //loads subsequent players from database, creates html for each, and inserts them into table
    function loadPlayers() {
        var requestURL = "Servlet?loadPlayers";
        $.get(requestURL, function(result, response){
            $("#playerContainer").html("");
            $each(result, function (index, Player){
                var html = '  <tr>' +
                '<td>' + Player.rankValue + '</td>    '   +              
                '<td>' + Player.playerTag + '</td>' + 
            '</tr>';
            $("#playerContainer").append(html);
            });
        });
    }
});