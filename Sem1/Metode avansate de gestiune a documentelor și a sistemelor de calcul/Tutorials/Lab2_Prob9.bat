@echo off
(echo Introduceti valoarea unei variabile a : )
set /p a=""
::echo a
echo:

(echo Introduceti valoarea unei variabile b : )
set /p b=""
::echo b
echo:

IF %a% GTR %b% (
echo Cel mai mare numar este %a%
) else (
echo Cel mai mare numar este %b%
)

echo:

IF %a% LSS %b% (
echo Cel mai mic numar este %a%
) else (
echo Cel mai mic numar este %b%
)

