#!/bin/bash

database_name='edusysdb';
database_username='edusysuser';
database_password='edusyspass';

function exec_as_postgres() {
  local temp_file='temp.sql.file'
  echo $1 > $temp_file
  psql -U postgres < $temp_file
  rm -rf $temp_file
}

function exec_as_user() {
  local host=$1
  local database=$2
  local username=$3
  local command=$4
  local temp_file='temp.sql.file'

  echo $command > $temp_file
  psql -U $username -h $host -d $database --password < $temp_file
  rm -rf $temp_file
}

exec_as_postgres "drop database $database_name;"
exec_as_postgres "drop user $database_username;"
exec_as_postgres "create database $database_name with encoding = 'UTF8' lc_collate='en_US.utf8' lc_ctype='en_US.utf8';"
exec_as_postgres "create user $database_username encrypted password '$database_password';"
exec_as_postgres "grant all on database $database_name to $database_username;"

create_schemas_command="create schema audit;"
create_schemas_command="$create_schemas_command create schema education;"
create_schemas_command="$create_schemas_command create schema membership;"
create_schemas_command="$create_schemas_command create schema personnel;"
create_schemas_command="$create_schemas_command create schema official;"
create_schemas_command="$create_schemas_command create schema notification;"
create_schemas_command="$create_schemas_command create schema phonebook;"
create_schemas_command="$create_schemas_command create schema cms;"

exec_as_user 'localhost' $database_name $database_username "$create_schemas_command"
