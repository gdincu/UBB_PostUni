<?php
echo "Cate numere?";
$x = readline();
$suma=0;

for ($i = 0; $i < $x; $i++)
{
echo"y=";
$y=readline();
if($y > 0)
{
$suma+=$y;
}
}
echo "Suma = $suma";