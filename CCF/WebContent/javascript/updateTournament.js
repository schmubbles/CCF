function addTournament(){
    var date = document.getElementById("tournamentDate").value;
    var embedCode = document.getElementById("embedCode").value;

    var tester = date.concat(embedCode);
    alert(tester);
}
    