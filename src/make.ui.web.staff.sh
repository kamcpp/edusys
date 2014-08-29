#!/bin/bash

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

version='0.0.1'
current_dir=$PWD
group=com.mftvanak.edusys
artifact=ui.web.staff
packaging=war
target=$group.$artifact

mvn -q -f $current_dir/$target/pom.xml package
