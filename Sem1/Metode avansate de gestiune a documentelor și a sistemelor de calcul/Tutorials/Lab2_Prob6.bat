@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Primele cate litere din alfabet trebuie sterse?: )

set /p sters_start=""
::echo sters_start este %sters_start%
echo:

CALL SET todel=%%string1:~0,%sters_start%%%
CALL SET string1=%%string1:%todel%=%%

(echo Ultimele cate litere din alfabet trebuie sterse?: )

set /p sters_final=""
::echo sters_final este %sters_final%
echo:

CALL SET todel1=%%string1:~-%sters_final%%%
CALL SET string1=%%string1:%todel1%=%%

(echo Dupa inlocuire, alfabetul arata in felul urmator: )
echo:

::CALL SET string1=%%string1:%inloc%=%inloc1%%%
echo %string1% 