create database db1;  -- 创建数据库

show databases;

use db1;

select database();

create table student( -- 创建表
	id int ,
    name varchar(20),
    birthday date
);

alter table student add remark varchar(20);

create database if not exists db2;

show databases;

show create database db1;

drop database db2;

select database();

show tables;

show databases;

use constructionCompany;

select database();

create table project(  -- 项目
	id int ,
    name varchar(20) 
);

create table staff(  -- 职工
	id int ,
    name varchar(20) ,
    sex varchar(2) ,
    duty varchar(10)
);

desc staff;

alter table project drop members;

create table duties( -- 职务
	duty varchar(20) ,
    hourlyWageRate int
);

create table hoursOfProject( -- 项目工时表
	idOfProject varchar(20) ,
    idOfStaff varchar(20) ,
    hours int 
);