@echo off

set count1=1
set count2=1

echo.
echo Toate fisierele din subdirectoarele directorului Windows care au o extensie de 3 caractere care incepe cu litera C sunt: 
echo.
FOR /R C:\Windows %%1 in (*.c??) do (
echo !count1!^) %%1
set /a count1+=1
	)
	
echo.
echo Toate fisierele din subdirectoarele directorului Windows care nu au extensie (nu contin caracterul . in denumire) sunt: 
echo.
FOR /R C:\Users\Pavilion\Desktop %%1 in (*.) do (
echo %count1%^) %%1
set /a count1+=1
	)

echo.
pause