@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Introduceti o parte din alfabet in ordine alfabetica care urmeaza a fii inlocuita: )

set /p inloc=""
::echo inloc este %inloc%
echo:

(echo Introduceti un string care sa inlocuiasca valoare introdusa anterior: )

set /p inloc1=""
::echo inloc1 este %inloc1%
echo:

(echo Dupa inlocuire, alfabetul arata in felul urmator: )
echo:

CALL SET string1=%%string1:%inloc%=%inloc1%%%
echo %string1% 