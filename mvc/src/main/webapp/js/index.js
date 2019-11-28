function OnSubmitReservationForm()
{
   var dateIn = $('#dateIn').pickadate();
   var fmtIn = dateIn.pickadate('picker').get('select', 'yyyy-mm-dd');
   var dateOut = $('#dateOut').pickadate();
   var fmtOut = dateOut.pickadate('picker').get('select', 'yyyy-mm-dd');
   document.reservationForm.action="reservation/"+fmtIn+"/"+fmtOut;
   return true;
}