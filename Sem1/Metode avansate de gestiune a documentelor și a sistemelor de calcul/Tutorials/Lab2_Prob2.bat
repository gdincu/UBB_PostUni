@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Urmatorul script va afisa ultimele n caractere din alfabet.)
echo:
(echo n = )
echo:
set /p n=""
echo:
::echo %n%
::echo:
echo:

CALL SET string1=%%string1:~-%n%%% 


echo %string1%