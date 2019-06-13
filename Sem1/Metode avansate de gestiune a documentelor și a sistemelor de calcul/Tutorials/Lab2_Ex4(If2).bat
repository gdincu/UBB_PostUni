@echo off 
set /p _department=""
IF DEFINED _department (
ECHO Got the %_department% variable
) ELSE (
Echo Not available
)
