#!/bin/bash

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

version='0.0.1'
current_dir=$PWD
group=com.mftvanak.edusys
artifact=facade
packaging=jar
target=$group.$artifact

mvn -q -f $current_dir/$target/pom.xml package
mvn -q install:install-file -Dfile=$current_dir/$target/target/$target-$version-SNAPSHOT.$packaging -DgroupId=$group -DartifactId=$artifact -Dversion=$version -Dpackaging=$packaging
