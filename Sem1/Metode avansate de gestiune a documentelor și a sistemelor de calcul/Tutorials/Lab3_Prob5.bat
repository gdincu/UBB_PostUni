echo off
SETLOCAL

:start1
set "t="
echo.
echo Introduceti numele unui director:
set /p t=""
echo.

IF [%t%]==[] (
ECHO Variabila nu a fost definita
goto start1) else (
md c:\%t%
cd c:\%t%
)
ENDLOCAL


