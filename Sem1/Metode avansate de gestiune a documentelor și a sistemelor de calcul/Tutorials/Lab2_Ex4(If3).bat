::@echo off 
set /p _commission=""
IF DEFINED _commission SET /A _salary=%_salary% + %_commission% 