function returnCanvas(x)
{
 var canvas = document.getElementById(x);
 if (canvas.getContext)
 {
 var can = canvas.getContext("2d");
 return can;
 }
 else
 return false;
}
function draw()
{
 var can=returnCanvas("canvas1");
 if (can)
 {
 can.fillStyle = "rgb(200,0,0)";
 can.fillRect (10, 10, 100, 100);
 }
}
