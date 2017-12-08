
function loginFunction(){
    var formData = new FormData(document.querySelector('form'));

    var entries = formData.entries;

    var wasCorrect = false;
    
    
    if (document.getElementById('username').value === "schmubbles"){
        if (document.getElementById('password').value === "bubbi"){
            wasCorrect = true;            
            window.location.replace("./updateRankings.html");            
        }
    }

    if (wasCorrect === false){
        document.getElementById("failure").innerHTML = "Incorrect credentials";
    }
}