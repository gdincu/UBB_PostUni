@echo off

set string1="a b c d e f g h i j k l m n o p q r s t u v w x y z"
echo Sirul folosit este: %string1%

for /F "tokens=1-15" %%1 in (%string1%) do (  
  echo %%1
  )
pause