<?php
$temp = 'asdSDASDfAD!1';
echo 'ex9 -> String-ul initial este: ',$temp,'<br><br>';

echo 'a: ',strtolower($temp),'<br>';
echo 'b: ',strtoupper($temp),'<br>';
echo 'c: ',ucfirst($temp),'<br>';
echo 'd: ',ucwords($temp),'<br><br><br>';

$temp2 = 'www.';
$temp3 = 'www.domeniu.com';
echo 'ex10 -> ',str_replace($temp2,'',$temp3),'<br><br><br>';

echo 'ex11 -> ',trim('0001313123','0'),'<br><br><br>';

$subsir = 'SDA';
echo 'ex12 -> ',str_replace($subsir,'',$temp);
?>