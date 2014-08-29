#!/bin/bash

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

if [ "$year" != "2013" ]; then
  echo 'Error in parsing date ...';
  exit 1;
fi

old_sql="./diff/$hour.$month.$day.$day_of_week-$hour.$minute.$second.OLD.sql"
new_sql="./diff/$hour.$month.$day.$day_of_week-$hour.$minute.$second.NEW.sql"
diff_sql="./diff/$hour.$month.$day.$day_of_week-$hour.$minute.$second.DIFF.sql"

pg_dump -s -U edusysuser -h 10.10.2.23 --password edusysdb > $old_sql
pg_dump -s -U edusysuser -h localhost --password edusysdb > $new_sql

apgdiff $old_sql $new_sql > $diff_sql

echo "OLD File:  $old_sql"
echo "NEW File:  $new_sql"
echo "DIFF File: $diff_sql"
