@echo off
set string1=abcdefghijklmnopqrstuvwxyz

(echo Introduceti o parte din alfabet, in ordine alfabetica: )

set /p todel=""
::echo todel este %todel%
echo:

(echo Dupa stergera valorii introduse, alfabetul arata in felul urmator: )

CALL SET string1=%%string1:%todel%=%%
echo %string1% 