@echo off
(echo Introduceti valoarea unei variabile a : )
set /p a=""
::echo a
echo:

(echo Introduceti valoarea unei variabile b : )
set /p b=""
::echo b
echo:

(echo Introduceti valoarea unei variabile x : )
set /p x=""
::echo x
echo:

set /a Scenario1=(%a%*%x%*%x%)+%b%
set /a Scenario2=(5*%x%)-7

IF %x% EQU 0 (
echo 2
goto :eof
)

IF %x% LSS 0 (
echo %Scenario1%
) else (
echo %Scenario2%
)

