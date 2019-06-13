@echo off
set count=1
set string1"=a b c d e f g h i j k l m n o p q r s t u v w x y z"

for /F "delims=" %%1 in ("%string1%") do (  
echo %%1
echo Introduceti valoarea unei variabilei numarul %count% :
set /A %count%=%count%+1
set /P variabila=""
set %%1 = %variabila%
  )

echo Sirul folosit este: %string1%


REM set /a Scenario1=(%a%*%x%*%x%)+%b%
REM set /a Scenario2=(5*%x%)-7

REM IF %x% EQU 0 (
REM echo 2
REM goto :eof
REM )

REM IF %x% LSS 0 (
REM echo %Scenario1%
REM ) else (
REM echo %Scenario2%
REM )
REM echo Sirul folosit este: %string1%
pause