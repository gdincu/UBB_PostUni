::@echo off
color A

::Setarea variabilelor
FOR /L %%F IN (1,1,9) DO set %v%%F%=%%F
set %next=x1
set %count=0

::Used to refresh the screen
:inceput
			::cls
			echo.
			echo  %v1% ^| %v2% ^| %v3% 
			echo -----------
			echo  %v4% ^| %v5% ^| %v6% 
			echo -----------
			echo  %v7% ^| %v8% ^| %v9% 
			echo.
			set /a "%count+=1"
			if /i %count% GEQ 10 goto end1
			goto %next%

::AlegereX
:x1
echo X alege un numar de la 1 la 9: 
set /p alegere=
IF "%%v%alegere%%%"=="X" goto x1
IF "%%v%alegere%%%"=="O" goto x1
set v%alegere%=X
set %next=o1
goto check
goto inceput

::AlegereO
:o1
echo O alege un numar de la 1 la 9: 
set /p alegere=
IF "%alegere%"=="X" goto x1
IF "%alegere%"=="O" goto x1
set v%alegere%=O
set %next=x1
goto check
goto inceput

:check
  if "%v1%"=="X" if "%v2%"=="X" if "%v3%"=="X" goto castigx
  if "%v4%"=="X" if "%v5%"=="X" if "%v6%"=="X" goto castigx
  if "%v7%"=="X" if "%v8%"=="X" if "%v9%"=="X" goto castigx
  if "%v1%"=="X" if "%v4%"=="X" if "%v7%"=="X" goto castigx
  if "%v2%"=="X" if "%v5%"=="X" if "%v8%"=="X" goto castigx
  if "%v3%"=="X" if "%v6%"=="X" if "%v9%"=="X" goto castigx
  if "%v1%"=="X" if "%v5%"=="X" if "%v9%"=="X" goto castigx
  if "%v3%"=="X" if "%v5%"=="X" if "%v7%"=="X" goto castigx
  if "%v1%"=="O" if "%v2%"=="O" if "%v3%"=="O" goto castigo
  if "%v4%"=="O" if "%v5%"=="O" if "%v6%"=="O" goto castigo
  if "%v7%"=="O" if "%v8%"=="O" if "%v9%"=="O" goto castigo
  if "%v1%"=="O" if "%v4%"=="O" if "%v7%"=="O" goto castigo
  if "%v2%"=="O" if "%v5%"=="O" if "%v8%"=="O" goto castigo
  if "%v3%"=="O" if "%v6%"=="O" if "%v9%"=="O" goto castigo
  if "%v1%"=="O" if "%v5%"=="O" if "%v9%"=="O" goto castigo
  if "%v3%"=="O" if "%v5%"=="O" if "%v7%"=="O" goto castigo
  goto inceput	
    
:castigx
echo GAME OVER - X a castigat
goto :EOF

:castigo
echo GAME OVER - O a castigat
goto :EOF

:end1 
echo GAME OVER
goto :EOF