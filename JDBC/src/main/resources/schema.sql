create database if not exists st;
use st;
create table if not exists students(
    id int auto_increment primary key ,
    name varchar(30)
);