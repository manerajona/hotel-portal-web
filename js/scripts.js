function retornarLienzo(x)
{
 var canvas = document.getElementById(x);
 if (canvas.getContext)
 {
 var lienzo = canvas.getContext("2d");
 return lienzo;
 }
 else
 return false;
}
function dibujar()
{
 var lienzo=retornarLienzo("lienzo1");
 if (lienzo)
 {
 lienzo.fillStyle = "rgb(200,0,0)";
 lienzo.fillRect (10, 10, 100, 100);
 }
}
