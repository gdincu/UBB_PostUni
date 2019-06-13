//Adaugare EventListener la incarcarea paginii verificarea valorii judetului
window.addEventListener("load", start, false);

//Adaugare EventListener la fiecare selectie de judet
function start(){

/*Ex1
---------------------------------------------------------------------*/
  document.getElementById('judDeAles').addEventListener('change', function(){
  document.getElementById('judetulAles').setAttribute('placeholder',document.getElementById('judDeAles').value);
}, false);
/*
---------------------------------------------------------------------*/
}