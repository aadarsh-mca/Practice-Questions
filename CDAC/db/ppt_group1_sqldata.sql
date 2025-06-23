-- Only For Technical Presentation

create database group1;
use group1;

Create Table If Not Exists Department (
	deptno int Primary Key,
     dname varchar(30) Not Null
);

Create Table If Not Exists Employee (
	id int Primary Key,
     name varchar(30) Not Null,
     salary int Not Null,
     deptno int Not Null,
     Constraint fk_deptno Foreign Key(deptno)
     References Department(deptno)
);

Insert Into Department Values 
(10, 'Accounts'),
(20, 'Sales'),
(30, 'Engineer');

Insert Into Employee (id, name, salary, deptno) Values 
(1, 'Alice', 60000, 10),
(2, 'Bob', 55000, 20),
(3, 'Charlie', 70000, 30),
(4, 'Diana', 62000, 10),
(5, 'Evan', 58000, 20),
(6, 'Fiona', 72000, 30);