$(document).ready(function() {

    loadTournaments();

    //accordian function - makes the buttons extend and contract
    $(document).on("click", ".accordian", function (){   
        var acc = document.getElementsByClassName("accordian");
        var i;
        for (i = 0; i < acc.length; ++i){
            acc[i].onclick=function(){
                this.classList.toggle("active");
                var panel = this.nextElementSibling;
                if (panel.style.display === "block"){
                    panel.style.display = "none";
                } else {
                    panel.style.display = "block";
                }
            }
        }
    });

    function loadTournaments(){
        var requestURL = "Servlet?loadTournaments";
        $.get(requestURL, function(result, response){
            $("#tournamentContainer").html("");
            $.each(result, function(index, Tournament){
                var html = '       <div class = "tournamentButton">' + 
                    '<button class = "accordian" onclick = "accordianFunction()" align = "center">' + Tournament.date + '</button>' + 
                    '<div class = "panel" >' +
                        Tournament.embedCode + 
                    '</div>' +
                '</div>';
            
                $("#tournamentContainer").append(html);
            });
        });
    }
});