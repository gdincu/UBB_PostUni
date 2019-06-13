@echo off
SETLOCAL EnableDelayedExpansion 
set count1=1
FOR /R C:\Users %%1 in (s*.l??) do (
echo !count1!^) %%1
set /a count1+=1
	)
ENDLOCAL