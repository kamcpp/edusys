#!/bin/bash

current_dir=.

mvn install:install-file -Dfile=$current_dir/sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=3.0 -Dpackaging=jar
