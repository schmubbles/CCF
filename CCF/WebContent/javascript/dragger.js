function isbefore(a, b) {
    if (a.parentNode == b.parentNode) {
        for (var next = a; next; next = next.previousSibling) {
            if (next === b) { 
                return true;
            }
        }
    }
    return false;
} 

function dragenter(e) {
    if (isbefore(source, e.target)) {
        e.target.parentNode.insertBefore(source, e.target);
    }
    else {
        e.target.parentNode.insertBefore(source, e.target.nextSibling);
    }
}

function dragstart(e) {
    source = e.target;
    e.dataTransfer.effectAllowed = 'move';
}