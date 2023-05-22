#!/bin/bash

# UNTESTED

BUILD=true
if "$2"=="--nobuild" || "$2"=="-nb"
  BUILD=false
fi

if BUILD==true
  sh ./build.sh
  echo ""
  echo ""
fi

"./bin/$1/a.exe" # change to correct executable name

