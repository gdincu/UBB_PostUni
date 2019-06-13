// Functie pentru a afisa numerele de la 1 la nr. ales
function counter() {
var num = document.getElementById("num").value;
for(let a=1;a<=num;a++)
	console.log(a);
}

// Functie pentru calcularea factorialului
function factorial() {
let num = document.getElementById("fact").value;
let rez=1;
for(let a=2;a<=num;a++)
rez*=a;
alert(num + " Factorial = " + rez);
}

// Functie pentru schimbarea background-ului
function col() {
	let cd = document.getElementById("cul").value;
	document.body.style.backgroundColor = cd;
}

// Functie pentru resetarea background-ului
function colreset() {
	document.body.style.backgroundColor = "transparent";	
}

// Functie pentru afisarea zilei saptamanii
function weekDay() {
	var temp = parseDate(document.getElementById("calendar").value);
	
	var rez;
	if(temp.getDay() == 0)
		rez = 7;
	else rez = temp.getDay();

	// Folosita pentru a afisa o alerta
	alert("Day of the week for " + temp + " is " + rez);
	// Folosita pentru a updata un element in HTML
	document.getElementById("demo").innerHTML = rez;
}

//Functie pentru parsarea unui text intr-o data
function parseDate(from) {
	from = from.replace('T', '').replace(/-/g,'/');
	return new Date(from);
}

// Functie pentru transformarea textului in uppercase
function upp() {
	let temp = document.getElementById("nume").value;
	document.getElementById("upp").innerHTML = temp.toUpperCase();
}

// Functie pentru transformarea textului in lowercase
function low() {
let temp = document.getElementById("nume").value;
	document.getElementById("low").innerHTML = temp.toLowerCase();	
}

function incWidth() {
	let temp = document.getElementById("img1");
	temp.width += 5;
}

function incHeight() {
	let temp = document.getElementById("img1");
	temp.height += 5;
}

function enl() {
	setInterval(incWidth,500);
	setInterval(incHeight,500);
}