//Setarea stilului initial din JS
var style = document.createElement('style');
  style.innerHTML = `
  #deMiscat {
  width: 10px;
  height: 10px;
  background-color: red;
  position: relative;
  }
  `;

document.head.appendChild(style);

var hero = {
        x: 0,
      y: 0
    };

window.addEventListener('keydown', function(event) {

switch(event.keyCode) {
case 37:
hero.x -= 10;
            var z = hero.x;
            var q = z + 10;
document.getElementById("deMiscat").style.left = z + "px";
document.getElementById("deMiscat").style.right = q + "px";
break;

case 38:
hero.y -= 10;
            var p = hero.y;
            var t = p + 10;
document.getElementById("deMiscat").style.top = p + "px";
document.getElementById("deMiscat").style.bottom = t + "px";
break;

case 39:
hero.x += 10;
            var z = hero.x;
            var q = z - 10;
document.getElementById("deMiscat").style.right = z + "px";
document.getElementById("deMiscat").style.left = q + "px";
break;

case 40:
hero.y += 10;
            var g = hero.y;
            var q = g - 10;
document.getElementById("deMiscat").style.bottom = g + "px";
document.getElementById("deMiscat").style.top = q + "px";
break;
}

}, false);