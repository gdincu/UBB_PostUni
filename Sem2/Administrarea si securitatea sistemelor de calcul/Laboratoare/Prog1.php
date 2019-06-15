<?php
//Functie de returnare a minimului dintre 3 nr
function f(int $a, int $b, int $c) {
	if($a < $b && $a < $c) return $a;
if($b < $a && $b < $c) return $b;
if($c < $a && $c < $b) return $c;
}

//Functie de returnare a minimului dintre 3 nr
function minim() {
$number = readline("\nNumar de numere: ");
$min = 999999;
$toate = array();
for($d = 0; $d < $number; $d++) {
$toate[$d] = readline("\nNr[" . $d . "]: ");
if($toate[$d] < $min) $min=$toate[$d];
}
return $min;
}

echo "Text : Hello World!\n";

$x = 5+5;
$y = 2*3;
$z = -2;

echo "x : " . $x . "\n";
echo "x + y: " . ($x + $y) . "\n";
echo "Tipul si valoarea lui x: " . var_dump($x);

echo "\nMin dintre x si y este: " . f($x,$y,$y+1);
echo "\nMin dintre x, y si z este: " . f($x,$y,$z) . "\n"; 

// $number = readline("Enter a number: ");
// echo "Numarul citit de la tastatura este: " . $number;

echo "\nMinimul este : " . minim() . "\n\n";


while($z <= 5) {
    echo "The number is: $z \n";
	$z++;
}
	
?>