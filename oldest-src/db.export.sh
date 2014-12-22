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

database_name='edusysdb'
database_username='edusysuser'
database_host='localhost'

temp_dir="./temp"
current_export_dir=$temp_dir/$year.$month.$day.$day_of_week-$hour.$minute.$second

echo "Local backup dir: $current_export_dir"

full_copy_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.full.copy.sql"
full_inserts_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.full.inserts.sql"
full_column_inserts_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.full.column.inserts.sql"
data_only_copy_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.data.copy.sql"
data_only_inserts_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.data.inserts.sql"
data_only_column_inserts_export_file_name="$database_name-$database_username-$year.$month.$day.$day_of_week-$hour.$minute.$second.data.column.inserts.sql"

mkdir -p $current_export_dir

pg_dump -U $database_username -h $database_host $database_name > $current_export_dir/$full_copy_export_file_name
pg_dump -U $database_username -h $database_host --inserts $database_name > $current_export_dir/$full_inserts_export_file_name
pg_dump -U $database_username -h $database_host --column-inserts $database_name > $current_export_dir/$full_column_inserts_export_file_name
pg_dump -U $database_username -h $database_host --data-only $database_name > $current_export_dir/$data_only_copy_export_file_name
pg_dump -U $database_username -h $database_host --data-only --inserts  $database_name > $current_export_dir/$data_only_inserts_export_file_name
pg_dump -U $database_username -h $database_host --data-only --column-inserts  $database_name > $current_export_dir/$data_only_column_inserts_export_file_name

backup_server_host='10.10.2.25'
backup_server_user='kamran'
backup_path='~/hard2/edusys.backups'

scp -r $current_export_dir $backup_server_user@$backup_server_host:$backup_path

rm -rf $temp_dir
