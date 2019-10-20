function OnSubmitReservationForm()
{
   var dateIn = document.getElementById("dateIn").value;
   var dateOut = document.getElementById("dateOut").value;
   document.reservationForm.action="reservation/"+dateIn+"/"+dateOut;
   return true;
}