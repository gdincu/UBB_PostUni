function tableCreate(nrRow,nrCol){

 var body = document.body;
 tbl  = document.createElement('table');

for(var i=0;i<nrRow;i++) {
	var tr = tbl.insertRow();
		for(var j=0;j<nrCol;j++) {
		var td = tr.insertCell();
		td.appendChild(document.createTextNode('Cell'))
		}
	}

	body.appendChild(tbl);
}