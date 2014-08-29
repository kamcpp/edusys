#!/bin/bash

curr_dir=$(pwd)
cd
home_dir=$(pwd)
cd $curr_dir

if [ -f "$home_dir/.this.is.production.server.DO.NOT.REMOVE.THIS.FILE" ]
then
  echo "ERROR: This is PRODUCTION server.";
  exit 1;
fi

if [ -f "$home_dir/.this.is.development.server.DO.NOT.REMOVE.THIS.FILE" ]
then
  echo "PASSED.";
else
  echo "ERROR: No check file is found."
  exit 1
fi


