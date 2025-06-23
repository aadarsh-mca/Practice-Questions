Create Table IF NOT EXISTS emp (
	empno int PRIMARY KEY,
     ename varchar(20),
     job varchar(10),
     mgr int,
     hiredate date,
     sal decimal(7,2),
     comm decimal(7,2),
     deptno int
);

Create Table IF NOT EXISTS dept (
	deptno int primary key auto_increment,
     dname varchar(10)
);

Insert Into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
Values 
(1001, 'Aadi', 'Engineer', NULL, '2025-07-26', 1235.00, NULL, NULL),
(1002, 'Test', NULL, NULL, '2025-03-18', 1000.00, NULL, NULL),
(7369, 'SMITH', 'Sr. Clerk', 7902, '1980-12-17', 1000.00, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 2000.00, 300.00, 30),
(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1562.50, 500.00, 30),
(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 3718.75, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1562.50, 1400.00, 30),
(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 3562.50, NULL, 30),
(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 3062.50, NULL, 10),
(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3750.00, NULL, 20),
(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 6250.00, NULL, 10),
(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1875.00, 0.00, 30),
(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1375.00, NULL, 20),
(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 1187.50, NULL, 30),
(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3750.00, NULL, 20),
(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1625.00, NULL, 10);