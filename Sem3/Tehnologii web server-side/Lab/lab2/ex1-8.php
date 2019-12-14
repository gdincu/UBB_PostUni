<?php
echo '<p><i>ex1 -> "Go\'od morning, Dave,"said HAL</i></p>';

define("PI",3.14);
echo 'ex2 -> Aria cercului (PI*r*r) de r = 3 este: ';
echo (PI*3*3) ;

$PI = pi();
echo '<br>PI = 3 este: ', $PI;



function tempTransform(int $temp) {
	return (5/9)*($temp-32);
}
$temp = 123.457;
echo '<br><br>ex3 -> Temp in F: ',number_format($temp,1),'<br>Temp in C: ',number_format(tempTransform(123.4),1);

$tempText = 'PHP is fun!';
echo '<br><br>ex4 -> Sirul "',$tempText,'" are ',strlen($tempText),' caractere';

$tempText2 = 'WDWWLWWWLDDWDLL';
echo '<br><br>ex5 -> ',substr($tempText2,strpos($tempText2,'WWW')+3,1);

echo '<br><br>ex6 -> ',substr($tempText2,strpos($tempText2,'L')+1,1);

echo '<br><br>ex7 -> ',substr($tempText2,strlen($tempText2)-3);

echo '<br><br>ex8 -> Tomorrow I\'ll learn PHP global variable<br>This is a bad command: del c:\*.*';
?>