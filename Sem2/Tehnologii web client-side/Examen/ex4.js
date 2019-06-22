//Adaugare EventListener la incarcarea paginii
window.addEventListener("load", start);

//Adaugare EventListener la fiecare selectie de judet
function start(){

  document.getElementById("numeIntrodus").addEventListener('input', function(){
  document.getElementById("salutNume").innerHTML = "Salut " + document.getElementById("numeIntrodus").value;
}, false);

}