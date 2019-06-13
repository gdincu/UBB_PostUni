@echo off

cls
echo.
echo         Spanzuratoarea v.1.0 - 2018
echo.
echo Introduceti numele utilizatorului:
set /p nume=""
set numar=%random:~-3%

echo.

for /L %%v in (1,1,5) do (
SETLOCAL EnableDelayedExpansion
echo %nume% ghiceste un numar aleatoriu din 3 cifre:
set /p alegere=""
set count=0
echo.
echo !alegere!
REM if "!alegere!" GTR "%numar%" (echo Prea mare 
REM echo.)
REM if "!alegere!" LSS "%numar%" (echo Prea mic 
REM echo.)
REM if "!alegere!" EQU "%numar%" (echo Ai ghicit 
REM goto :EOF)

set /a "!count!"+=1
echo "!count!"
)
REM echo "Ati irosit %count% incercari! Aveti (5-%count%) incercari ramase"
REM ENDLOCAL
REM )

