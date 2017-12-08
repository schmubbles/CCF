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

function deleteList(){
    alert("Delete the list");
}