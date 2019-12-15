function OnSubmitReservationForm()
{
   var dateIn = $('#dateIn').val();
   var dateOut = $('#dateOut').val();
   $('#reservationForm').attr('action', "reservation/"+dateIn+"/"+dateOut);
   return true;
}

function clearMessageFields()
{
    $('#name').val("");
    $('#subject').val("");
    $('#email').val("");
    $('#phone').val("");
    $('#content').val("");
}