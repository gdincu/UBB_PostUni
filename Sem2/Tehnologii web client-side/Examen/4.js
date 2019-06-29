function valideaza() {
	var str = document.getElementById('dataCurenta').value;
 	var res = str.match(\d{4}-\d{2}-\d{2});
 	alert(res);
}