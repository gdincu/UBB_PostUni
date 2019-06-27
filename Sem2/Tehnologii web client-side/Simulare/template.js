var numeId = "id";

function get_random_color() {
  function c() {
    var hex = Math.floor(Math.random()*256).toString(16);
    return ("0"+String(hex)).substr(-2); // pad with zero
  }
  return "#"+c()+c()+c();
}

window.onload = function() {
	//Creaza un style
	document.getElementsByTagName('head')[0].appendChild(document.createElement('style'));
	document.getElementsByTagName('style')[0].type = 'text/css';
	var css = '.c1 { border: 1px solid black; height: 20vh; position: relative; } nav { position: sticky; top: 0; left: 2vw; margin: 0; background-image: linear-gradient(to left, black , yellow); font-weight: bold; font-size: 10px; height: 30px;} button { float: left; } .genereaza { float: right; }';
	document.getElementsByTagName('style')[0].appendChild(document.createTextNode(css));
	};


function genereaza() {
	
	//Sterge toate elementele curente inainte sa genereze elemente noi
	let index = 0;
	var elements = document.getElementsByTagName('div');
	if(elements.length > 0)
	while (index < elements.length) {
	elements[index].parentNode.removeChild(elements[index])
	index++;	
	} 

	//div container
	document.body.appendChild(document.createElement('div'));
	document.getElementsByTagName('div')[0].setAttribute('class','container');
	
	//div row row-fluid
	document.getElementsByClassName('container')[0].appendChild(document.createElement('div'));
	document.getElementsByTagName('div')[1].setAttribute('class','row row-fluid');
	
	let nrDiv = Number(document.getElementsByTagName('input')[0].value);

	//Creaza 12 div-uri cu clasa c1 si id-ul 'id[pozitie+1]'
	 for(i=0;i<nrDiv;i++) {
		document.getElementsByClassName('row row-fluid')[0].appendChild(document.createElement('div'));
		document.getElementsByTagName('div')[i+2].setAttribute('id',(numeId + (i+1)));
		document.getElementsByTagName('div')[i+2].setAttribute('class','c1 col-xs-1 col-sm-2 col-md-3 col-lg-6');
	}
};	

function coloreaza1() {
	
	let nrDiv = document.getElementsByTagName('div').length - 2;
	
	// Coloreaza div-urile unul cate unu
	 for(let i=0;i<nrDiv;i++) {
	 	
		if((document.getElementsByTagName('div')[i+2].hasAttribute("style")))
			continue;

	 	if(!(document.getElementsByTagName('div')[i+2].hasAttribute("style"))) {
	 		let col = 'background-color:' + get_random_color();
	 		document.getElementsByTagName('div')[i+2].setAttribute('style',col);
	 		return;
	 	}	
	 }
};

function coloreazaToate() {
	
	let nrDiv = document.getElementsByTagName('div').length - 2;
	
	// Coloreaza div-urile unul cate unu
	 for(let i=0;i<nrDiv;i++) {
	 		let col = 'background-color:' + get_random_color();
	 		document.getElementsByTagName('div')[i+2].setAttribute('style',col);
	 }
};

function disco() {
	
	let time = Number(prompt("Intensity level (1-10): "));

	setInterval(function(){ 

let nrDiv = document.getElementsByTagName('div').length - 2;
	
// Coloreaza div-urile unul cate unu
	 for(let i=0;i<nrDiv;i++) {
	 		let col = 'background-color:' + get_random_color();
	 		document.getElementsByTagName('div')[i+2].setAttribute('style',col);
	 }
	}, 1100 - time*100);

};