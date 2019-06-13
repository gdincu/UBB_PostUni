@echo off
(echo Introduceti un sir de la tastatura : )
set /p string1=""
::(echo Sirul fara spatii arta in felul urmator: )
echo:

::CALL SET string1=%%string1:=%%
::SET string1=%%string1:=%%

set spatiu= 


CALL SET string1=%%string1:%spatiu%=%%

echo %string1% 


