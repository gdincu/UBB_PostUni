
window.onload = function ex6() {

	var div1 = document.createElement('div');
	var class1 = document.createAttribute('class');
	class1.value = "first";
	div1.setAttributeNode(class1);
	div1.innerHTML = 'first';
	document.getElementsByTagName('body')[0].appendChild(div1);

	var div2 = document.createElement('div');
	var class2 = document.createAttribute('class');
	class2.value = "second";
	div2.setAttributeNode(class2);
	div2.innerHTML = 'second';
	document.getElementsByTagName('body')[0].appendChild(div2);

	var div3 = document.createElement('div');
	var class3 = document.createAttribute('class');
	class3.value = "inner";
	div3.setAttributeNode(class3);
	div3.innerHTML = 'inner';
	document.getElementsByClassName('first')[0].appendChild(div3);	

	var button1 = document.createElement('button');
	var buttonValue = document.createAttribute('value');	
	buttonValue.value = "Apasa-ma!";
	button1.setAttributeNode(buttonValue);
	button1.innerHTML = 'Apasa-ma';
	document.getElementsByTagName('body')[0].appendChild(button1);
	document.getElementsByTagName('button')[0].addEventListener('click',start);

	var linie = document.createElement('hr');
	document.body.appendChild(linie);
}

function start() {

	var div3 = document.getElementsByClassName('inner')[0];

	document.getElementsByClassName('first')[0].removeChild(div3);		
	document.getElementsByClassName('second')[0].appendChild(div3);		
}