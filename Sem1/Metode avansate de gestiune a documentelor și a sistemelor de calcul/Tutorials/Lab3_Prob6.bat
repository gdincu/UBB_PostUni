

:: Verifica variabilele una cate una
:director
echo.
echo Introduceti numele unui director:
set /p t1=""
echo.
IF [%t1%]==[] (ECHO Directorul nu a fost definit
goto director)

:subdirector
echo.
echo Introduceti numele unui sub-director:
set /p t2=""
echo.
IF [%t2%]==[] (ECHO Sub-Directorul nu a fost definit
goto subdirector)

md c:\%t1%\%t2%
cd /d C:\%t1%\%t2%