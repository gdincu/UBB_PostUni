@echo off
echo a = 
set /p input1="" 
echo:
echo b = 
set /p input2=""
echo:
set /a sum1=%input1%+%input2%
set /a dif1=%input1%-%input2%
set /a prod1=%input1%*%input2%
set /a cat1=%input1%/%input2%
set /a modulo1=%input1%%%input2%
echo a+b = 
echo %sum1%
echo a-b = 
echo %dif1%
echo a*b = 
echo %prod1%
echo a/b = 
echo %cat1%
echo a%b = 
echo %modulo1%