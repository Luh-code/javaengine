@echo off
SET "build=TRUE"
IF /I "%2"=="--nobuild" SET "build=FALSE"
IF /I "%2"=="-nb" SET "build=FALSE"

IF %build%==TRUE CALL :build

SET "completePath=.\bin\%1\HexTest.exe"
%completePath%

EXIT /B 0

:build
CALL ./build.bat
ECHO.
ECHO.
