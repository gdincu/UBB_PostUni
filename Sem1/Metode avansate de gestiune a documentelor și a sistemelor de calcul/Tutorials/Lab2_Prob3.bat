@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Urmatorul script va afisa primele n caractere din alfabet.)
echo:
(echo n = )
echo:
set /p n=""
echo:
::echo %n%
::echo:
echo:

(echo Incepand cu pozitia x.)
echo:
(echo x = )
echo:
set /p x=""
echo:

CALL SET string1=%%string1:~%x%,%n%%% 


echo %string1%