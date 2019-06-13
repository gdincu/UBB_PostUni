@echo off
echo.
echo Toate fisierele din disk-ul C care au extensia .com si au maxim 4 caractere in nume sunt: 
echo.
set count1=1
set count2=1
SETLOCAL EnableDelayedExpansion 

FOR /R C: %%1 in (????.com) do (
echo !count1!^) %%1
set /a count1+=1
	)

echo.
echo Toate fisierele din disk-ul C care au extensia .exe si au a doua litera din nume I sunt: 
echo.

FOR /R C: %%1 in (?I*.exe) do (
echo !count2!^) %%1
set /a count2+=1
)
	)