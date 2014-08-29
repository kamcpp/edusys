#!/bin/bash

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

source properties.inc

version='0.0.1'
current_dir=$PWD
group=com.mftvanak.edusys
artifact=ws.authentication
packaging=war
target=$group.$artifact

cp $current_dir/$target/target/$target-$version-SNAPSHOT.$packaging $publish_dir
