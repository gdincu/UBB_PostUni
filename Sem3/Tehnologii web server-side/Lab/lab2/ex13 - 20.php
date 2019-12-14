<?php
$temp = 3124124;
function verificaparitate(int $temp) {
	if($temp % 2 == 0) {
	return 'true';}
else {return 'false';}}

echo 'ex13/14 -> ',verificaparitate($temp),'<br><br><br>';

function max3(int $t1,$t2,$t3) {
if($t2 > $t1 & $t2 > $t3) return $t2;
if($t3 > $t1 & $t3 > $t2) return $t3;
return $t1;
}
echo 'ex15 -> ',max3(14,17,21),'<br><br><br>';

function sumacifre($temp) {
$lenTemp = strlen($temp);
$i = 0;
$suma = 0;
	while($i < $temp) {			
	$suma = $suma + (int)substr($temp,$i,1);
	$i++;}
return $suma;
}
echo 'ex16 -> ',sumacifre('12563'),'<br><br><br>';

echo 'ex17 -> <br>0<br> 1<br> ';
$x = 0;    
$y = 1; 
$z =0;
while($x+$y < 15)
{    
    $z = $x + $y;    
    echo $z."<br />";         
    $x=$y;       
    $y=$z;     
}   


echo '<br>ex18 -> ',$_SERVER['HTTP_USER_AGENT'],'<br><br><br>';
echo '<br>ex18 -> ',$_SERVER['REMOTE_ADDR'],'<br><br><br>';

function getUserIpAddr(){
    if(!empty($_SERVER['HTTP_CLIENT_IP'])){
        //ip from share internet
        $ip = $_SERVER['HTTP_CLIENT_IP'];
    }elseif(!empty($_SERVER['HTTP_X_FORWARDED_FOR'])){
        //ip pass from proxy
        $ip = $_SERVER['HTTP_X_FORWARDED_FOR'];
    }else{
        $ip = $_SERVER['REMOTE_ADDR'];
    }
    return $ip;
}
echo 'ex19 ->',getUserIpAddr(),'<br><br><br>';

echo 'ex20 -> ',getcwd(),'<br><br><br>','<br><br><br>';


?>