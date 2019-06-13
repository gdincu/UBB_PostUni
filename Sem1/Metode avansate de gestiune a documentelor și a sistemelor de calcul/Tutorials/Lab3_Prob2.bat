echo off
echo.
echo Fisierele al caror nume incepecu litera M si au extensia .exe din disk-ul C (cautate recursiv) sunt:
echo.
set count=1

SETLOCAL EnableDelayedExpansion 

FOR /R C: %%1 in (M*.exe) do (
echo !count!^) %%1
SET /A count+=1
)

echo.
echo Sunt exact %count% fisiere al caror nume incepecu litera M si au extensia .exe in disk-ul C
echo.

pause