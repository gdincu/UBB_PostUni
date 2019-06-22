//Variabile declarate global
ul  = document.createElement('ul');
var numeId = "id";
var tempId = "";
var pozitie = 0;

//Vectorul de imagini
var Imagini = [
"http://inkscape.org.es/img-inkscape.org.es/theme/aprender-dibujo-vectorial.png",
"https://images.vexels.com/media/users/3/159864/isolated/lists/5c5de56f96435a1c4430ba5d7f2be124-pollito-de-pascua-en-un-icono-de-huevo-roto.png",
"http://www.uidownload.com/files/852/785/248/rabbit-face-front-icon.png",
"http://www.uidownload.com/files/204/761/201/rabbit-facing-left-icon.png"
];

//Adaugare EventListener la incarcarea paginii
window.addEventListener('load',start);

//Functia start
function start(){
document.getElementById('ex5').appendChild(ul);

var li = document.createElement('li');
ul.appendChild(li);

var img = document.createElement('img');
li.appendChild(img);

var atrSrc = document.createAttribute('src');
atrSrc.value = Imagini[pozitie];
img.setAttributeNode(atrSrc);

var widthTemp = document.createAttribute('width');
widthTemp.value = 20;
img.setAttributeNode(widthTemp);

var heightTemp = document.createAttribute('height');
heightTemp.value = 20;
img.setAttributeNode(heightTemp);

var idTemp = document.createAttribute('id');
tempId = numeId + pozitie;
idTemp.value = tempId;
img.setAttributeNode(idTemp);

document.getElementById(tempId).addEventListener('click',adauga);
pozitie++;

for(let i=1;i<=Imagini.length;i++) {
var li1 = document.createElement('li');
ul.appendChild(li1);
}
}

//Varianta ceruta in enunt
function adauga(){
// Iesire daca au fost adaugate toate imaginile din matrice
if(pozitie > Imagini.length-1)
	return;

document.getElementById(tempId).removeAttribute("src");

var atrSrc = document.createAttribute('src');
atrSrc.value = Imagini[pozitie];
document.getElementById(tempId).setAttributeNode(atrSrc);

pozitie++;
}

//Varianta cu incarcarea imaginilor in lisa fara stergerea imaginii initiale
// function adauga(){
// // Iesire daca au fost adaugate toate imaginile din matrice
// if(pozitie > Imagini.length-1)
// 	return;

// var li = document.createElement('li');
// ul.appendChild(li);

// var img = document.createElement('img');
// li.appendChild(img);

// var atrSrc = document.createAttribute('src');
// atrSrc.value = Imagini[pozitie];
// img.setAttributeNode(atrSrc);

// var widthTemp = document.createAttribute('width');
// widthTemp.value = 20;
// img.setAttributeNode(widthTemp);

// var heightTemp = document.createAttribute('height');
// heightTemp.value = 20;
// img.setAttributeNode(heightTemp);

// var idTemp = document.createAttribute('id');
// tempId = numeId + pozitie;
// idTemp.value = tempId;
// img.setAttributeNode(idTemp);


// document.getElementById(tempId).addEventListener('click',adauga);
// pozitie++;
// }