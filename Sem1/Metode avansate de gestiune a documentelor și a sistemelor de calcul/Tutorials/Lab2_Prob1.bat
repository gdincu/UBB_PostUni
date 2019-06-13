@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Urmatorul script va afisa primele n caractere din alfabet.)
echo:
(echo n = )
echo:
set /p n=""
echo:
echo %n%
echo:
echo:

CALL SET string1=%%string1:~0,%n%%% 
::SET string1=%%string1:~0,%n%%% 

echo %string1%