<?php
$x = 1;
$suma=0;

while ($x!=0)
{
$x=readline();
	if ($x%2!=0 && $x<0)
	{
	$suma+=$x;}
}

echo "Suma = $suma";