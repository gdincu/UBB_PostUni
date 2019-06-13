//Adaugare EventListener la incarcarea paginii verificarea valorii judetului
window.addEventListener("load", start, false);

//Adaugare EventListener la fiecare selectie de judet
function start(){
document.getElementById('form1').addEventListener('input',verLitere,false);
document.getElementById('form2').addEventListener('input',verCifre,false);
}

function verLitere() {
	var corect = /^[a-z]+$/;
	if(document.getElementById("form1").value.match(corect))
	document.getElementById("chkForm1").style.backgroundColor = "green";
	else
	document.getElementById("chkForm1").style.backgroundColor = "red";
} 

function verCifre() {
	var corect = /^[0-9]+$/;
	if(document.getElementById("form2").value.match(corect))
	document.getElementById("chkForm2").style.backgroundColor = "green";
	else
	document.getElementById("chkForm2").style.backgroundColor = "red";
} 