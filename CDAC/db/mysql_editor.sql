Select empno, ename, sal, deptno, (sal - getSecondLowestSal(deptno)) as diff
From emp
Order By deptno;


Delimiter $$
Create Function getSecondLowestSal(pDeptno int) returns decimal
Deterministic
Reads SQL DATA
Begin
	Declare secondSal decimal default 0.0;

	Select sal into secondSal
	From (
		Select sal, deptno, dense_rank() OVER (Partition By deptno Order By sal) as 'rank'
		From emp
	) as e
	Where e.rank = 2 AND deptno = pDeptno
	Limit 1;

	return secondSal;
End $$
Delimiter ;




Create Table price_change_log(
	bookid int,
	old_price double,
	new_price double,
	curr_user varchar(50),
	timestamp_data timestamp default CURRENT_TIMESTAMP
);

drop trigger IF EXISTS onBookPriceUpdate;

Delimiter $$
Create Trigger onBookPriceUpdate
After Update On book
For Each Row
Begin
	Insert Into price_change_log(bookId, old_price, new_price, curr_user, timestamp_data)
	Values(new.bookId, old.price, new.price, user(), now());
End $$
Delimiter ;

Update book
Set price = 160
Where bookId = 202;


drop Procedure IF EXISTS bookCursor;

Delimiter $$
Create Procedure bookCursor()
Begin
	Declare vBookId int default 0;
	Declare vBookName varchar(30) default '';
	
	Declare isCursorCompleted int default 0;

	Declare display_cursor Cursor 
		For Select bookId, title From book;

	Declare CONTINUE HANDLER For NOT FOUND 
		Set isCursorCompleted = 1;

	OPEN display_cursor;

	loopLabel : Loop
		Fetch display_cursor Into vBookId, vBookName;

		if isCursorCompleted then
			leave loopLabel;
		end if;

		Select vBookId, vBookName;
	End Loop;

	CLOSE display_cursor;
End $$
Delimiter ;




drop Procedure IF EXISTS bookAuthorCursor;

Delimiter $$
Create Procedure bookAuthorCursor()
Begin
	Declare vBookId int default 0;
	Declare vBookName varchar(30) default '';
	Declare vAuthorId int default 0;
	Declare vAuthorName varchar(30) default '';

	Declare isCursorCompleted int default 0;

	Declare display_cursor Cursor 
	For Select b.bookId, b.title, a.authorId, a.authorName
		From book as b
		Inner Join Author as a
		On b.authorId = a.authorId;

	Declare CONTINUE HANDLER For NOT FOUND 
		Set isCursorCompleted = 1;

	OPEN display_cursor;

	loopLabel : Loop
		Fetch display_cursor Into vBookId, vBookName, vAuthorId, vAuthorName;

		if isCursorCompleted then
			leave loopLabel;
		end if;

		Select vBookId, vBookName, vAuthorId, vAuthorName;
	End Loop;

	-- OPEN display_cursor;

	-- Fetch display_cursor Into vBookId, vBookName, vAuthorId, vAuthorName;

	-- while vBookId IS NOT NULL 
	-- Do
	-- 	Select vBookId, vBookName, vAuthorId, vAuthorName;

	-- 	Fetch display_cursor Into vBookId, vBookName, vAuthorId, vAuthorName;
	-- end while;

	CLOSE display_cursor;
End $$
Delimiter ;
