#!/bin/bash

./check.server.sh
res=$(echo $?)
if [ $res -eq 1 ]; then
  exit 1
fi

col_counter=1
day_of_week=$(date | cut -d' ' -f$col_counter)

col_counter=$((col_counter + 1))
month=$(date | cut -d' ' -f$col_counter)

col_counter=$((col_counter + 1))
day=$(date | cut -d' ' -f3)
if [ "$day" == "" ]; then
  col_counter=$((col_counter + 1))
  day=$(date | cut -d' ' -f$col_counter)
fi

col_counter=$((col_counter + 1))
hour=$(date | cut -d' ' -f$col_counter | cut -d':' -f1)
minute=$(date | cut -d' ' -f$col_counter | cut -d':' -f2)
second=$(date | cut -d' ' -f$col_counter | cut -d':' -f3)

col_counter=$((col_counter + 2))
year=$(date | cut -d' ' -f$col_counter)

if [ ${#day} == "1" ]; then
  day="O$day";
fi

if [ ${#hour} == "1" ]; then
  hour="0$hour";
fi

if [ ${#minute} == "1" ]; then
  minute="0$minute";
fi

if [ ${#second} == "1" ]; then
  second="0$second";
fi

echo "day of week -> $day_of_week"
echo "month -> $month"
echo "day -> $day"
echo "hour -> $hour"
echo "minute -> $minute"
echo "second -> $second"
echo "year -> $year"

if [ "$year" != "2014" ]; then
  echo 'Error in parsing date ...';
  exit 1;
fi

mkdir -p ./logs
log_file="logs/SCHEDULER.ENGINE.$year.$month.$day.$day_of_week-$hour.$minute.$second.log"

version='0.0.1'
current_dir=$PWD
group=com.mftvanak.edusys
artifact=engine.scheduler
target=$group.$artifact

mvn -f $current_dir/$target/pom.xml exec:java -Dexec.mainClass=com.mftvanak.edusys.engine.scheduler.Starter # > $log_file &

