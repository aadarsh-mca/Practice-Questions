Create Table IF NOT EXISTS emp_allowance(
	empno int primary key,
     ename varchar(30) not null,
     hiredate date,
     experience int, 
     allowance decimal(9,2)
);

Create Table IF NOT EXISTS emp_back (
	`EMPNO` int,
	`ENAME` varchar(20),
	oldsal decimal(9,2),
	newsal decimal(9,2)
);


Create Table IF NOT EXISTS emp_audit (
	empno int,
	ename varchar(30),
	username varchar(50),
	chdate date,
	action varchar(20)
);



Delimiter $$

Drop Function If Exists getExp$$

Create Function getExp(pHiredate Date) returns int
DETERMINISTIC
READS SQL DATA
Begin 
	Declare exp int default 0;

	Set exp = timestampdiff(year, pHiredate, curdate());

	return exp;
End $$


--
-- Without using Cursor
--
Drop Procedure If Exists calc_allowance$$

Create Procedure calc_allowance()
Begin
	Declare Continue Handler
     For 1062
		Select 'Duplicate entry found for Primary Key... \nSo skipping the Insert Query' as 'Exception occurred';

	Insert into emp_allowance (empno, ename, hiredate, experience, allowance)
	Select e.empno, e.ename, e.hiredate, getExp(e.hiredate), (getExp(e.hiredate) * 3)
	From emp as e;
End $$



--
-- Using cursor with Exception Handler
--
Drop Procedure If Exists calc_allowance_cursor_1 $$

Create Procedure calc_allowance_cursor_1()
Begin
	Declare vEmpno int default 0;
	Declare vEname varchar(30) default '';
	Declare vHiredate date default '1900-01-01';
	Declare vExperience int default 0;
	Declare vAllowance decimal default 0.0;

	Declare isCursorEnded int default 0;
     
     Declare allowance_cursor Cursor
	For Select empno, ename, hiredate From emp;
     
	Declare CONTINUE HANDLER 
     For NOT FOUND 
		Set isCursorEnded = 1;
          
	Declare Continue Handler
     For SQLException
		Select 'Duplicate entry found for Primary Key... So skipping the Insert Query' as 'Exception occurred';

	Open allowance_cursor;

	cursor_loop : Loop
		Fetch allowance_cursor Into vEmpno, vEname, vHiredate;

		if isCursorEnded then
			LEAVE cursor_loop;
		end if;

		Set vExperience = getExp(vHiredate);
		Set vAllowance = vExperience * 3;

		Select vEmpno, vEname, vHiredate, vExperience, vAllowance;
          
          Insert Into emp_allowance Value(vEmpno, vEname, vHiredate, vExperience, vAllowance);
	End Loop;

	Close allowance_cursor;
End $$

--
-- Using cursor without Exception Handler
--
Drop Procedure If Exists calc_allowance_cursor_2 $$

Create Procedure calc_allowance_cursor_2()
Begin
	Declare vEmpno int default 0;
	Declare vEname varchar(30) default '';
	Declare vHiredate date default '1900-01-01';
	Declare vExperience int default 0;
	Declare vAllowance decimal default 0.0;
     
     Declare allowance_cursor Cursor
		For Select empno, ename, hiredate From emp;
     
	Declare Continue Handler
     For SQLException
		Select 'Duplicate entry found for Primary Key... So skipping the Insert Query' as 'Exception occurred';

	Open allowance_cursor;

	Fetch allowance_cursor Into vEmpno, vEname, vHiredate; 

	while vEmpno IS NOT NULL do
		Set vExperience = getExp(vHiredate);
		Set vAllowance = vExperience * 3;

		Select vEmpno, vEname, vHiredate, vExperience, vAllowance;
          
          Insert Into emp_allowance Value(vEmpno, vEname, vHiredate, vExperience, vAllowance);

		Fetch allowance_cursor Into vEmpno, vEname, vHiredate;
	End while;

	Close allowance_cursor;
End $$

Delimiter ;