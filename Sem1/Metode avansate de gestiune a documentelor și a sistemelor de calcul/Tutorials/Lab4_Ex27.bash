#!/bin/bash

sum=0
prod=1
pozitie=1
sum_ni=0
count_d=0
suma_d=0
media_d=0
sum_6=0
check_F="NU"	
echo Vom verifica daca elementul de pe pozitia p este divizibil cu 4. Introduceti o valoare pentru p:
read alegere

#Conditia de iesire din WHILE
# while [ $1 -ne 0 ]
while [ $1 != 0 ]
do

#Suma elementelor pozitive
if [ $1 -gt 0 ]
then
sum=$(($sum+$1))
fi

#Produsul elementelor pare
if (( $1 % 2 == 0 ))
then
prod=$(($prod*$1))
fi

#Suma elementelor negative de pe pozitii impare
if [ $1 -lt 0 ] && (( $pozitie % 2 != 0 ))
then
sum_ni=$(($sum_ni+$1))
fi

#Media aritmetica a elementelor care dau restul 2 la impartirea cu 5
if (( $1 % 5 == 2 ))
then
count_d=$(($count_d+1))
suma_d=$(($suma_d+$1))
media_d=$(($suma_d/$count_d))
fi

#Numara cate numere sunt mai mici ca 6
if [ $1 -lt 6 ]
then
sum_6=$(($sum_6+1))
fi

#Verifica daca elementul p este divizibil cu 4
if [ $pozitie -eq $alegere ] && (( $1 % 4 == 0 ))
then
check_F="DA"
fi

shift
pozitie=$(($pozitie+1))
done

echo Suma elementelor pozitive este $sum
echo Produsul numerelor pare este $prod
echo Suma elementelor negative pe pozitii impare este $sum_ni
echo Media aritmetia a elementelor care dau restul 2 la impartirea cu 5 este $media_d
echo Avem $sum_6 elemente mai mici decat 6
echo Elementul de pe pozitia $alegere este divizibil cu 4? $check_F
