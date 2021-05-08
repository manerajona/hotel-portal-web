function filterMessages(event) {
    var filter = event.target.value.toUpperCase();
    var rows = document.querySelector("#tbMessage tbody").rows;

    for (var i = 0; i < rows.length; i++) {
        var c1 = rows[i].cells[0].textContent.toUpperCase();
        var c2 = rows[i].cells[1].textContent.toUpperCase();
        var c3 = rows[i].cells[2].textContent.toUpperCase();
        var c4 = rows[i].cells[3].textContent.toUpperCase();
        var c5 = rows[i].cells[4].textContent.toUpperCase();
        var c6 = rows[i].cells[5].textContent.toUpperCase();
        if ((c1.indexOf(filter) * c2.indexOf(filter) * c3.indexOf(filter) * c4.indexOf(filter) * c5.indexOf(filter) * c6.indexOf(filter)) == 0) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

document.querySelector('#txtMessage').addEventListener('keyup', filterMessages, false);


function filterReservations(event) {
    var filter = event.target.value.toUpperCase();
    var rows = document.querySelector("#tbReservation tbody").rows;

    for (var i = 0; i < rows.length; i++) {
        var c1 = rows[i].cells[0].textContent.toUpperCase();
        var c2 = rows[i].cells[1].textContent.toUpperCase();
        var c3 = rows[i].cells[2].textContent.toUpperCase();
        var c4 = rows[i].cells[3].textContent.toUpperCase();
        var c5 = rows[i].cells[4].textContent.toUpperCase();
        if ((c1.indexOf(filter) * c2.indexOf(filter) * c3.indexOf(filter) * c4.indexOf(filter) * c5.indexOf(filter)) == 0) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

document.querySelector('#txtReservation').addEventListener('keyup', filterReservations, false);

function filterUser(event) {
    var filter = event.target.value.toUpperCase();
    var rows = document.querySelector("#tbUser tbody").rows;

    for (var i = 0; i < rows.length; i++) {
        var c1 = rows[i].cells[0].textContent.toUpperCase();
        var c2 = rows[i].cells[1].textContent.toUpperCase();
        var c3 = rows[i].cells[2].textContent.toUpperCase();
        var c4 = rows[i].cells[3].textContent.toUpperCase();
        var c5 = rows[i].cells[4].textContent.toUpperCase();
        if ((c1.indexOf(filter) * c2.indexOf(filter) * c3.indexOf(filter) * c4.indexOf(filter) * c5.indexOf(filter)) == 0) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

document.querySelector('#txtUser').addEventListener('keyup', filterUser, false);