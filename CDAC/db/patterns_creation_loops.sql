-- *
-- * *
-- * * *
-- * * * *
-- * * * * *

Delimiter $$
Create Procedure starRightTriangle(IN nRows int)
Begin
	Declare i int default 1;
	Declare j int default 1;
	Declare starStr varchar(200) default '';
	
	while i <= nRows
	do
		Set j = 1;
		
		Repeat
			Set starStr = Concat(starStr, '* ');
			Set j = j+1;
		Until j > i
		End repeat;
		
		if (i IN (0, nRows)) then
			Set starStr = Concat(starStr, '\n');
		else 
			Set starStr = Concat(starStr, '\n  ');
		end if;
		
		Set i = i+1;
	End while;
	
	Select starStr as 'Star Triangle';
End $$
Delimiter ;




-- *
-- ***
-- *****
-- ***
-- *
Delimiter $$
Create Procedure starPyramid(IN nRows int)
Begin
	Declare i int default 1;
	Declare j int default 1;
	Declare nCol int default -1;
	Declare mid int default 1;
	Declare isEven int default 0;
	
	Declare starStr TEXT default '';
	
	if nRows % 2 = 0 then
		Set isEven = 1;
	end if;
	
	Set mid = (nRows / 2);
	
	while i <= mid Do
		Set j = 1;
		Set nCol = nCol + 2;
		
		while j <= nCol Do
			Set starStr = Concat(starStr, '*');
			Set j = j+1;
		end while;
		
		Set starStr = Concat(starStr, CHAR(10), '  ');
		Set i = i+1;
	end while;
	
	if isEven = 1 then
		Set nCol = nCol + 2;
	end if;
	
	while i <= nRows Do
		Set j = 1;
		Set nCol = nCol - 2;
		
		while j <= nCol Do
			Set starStr = Concat(starStr, '*');
			Set j = j+1;
		end while;
		
		if i = nRows then
			Set starStr = Concat(starStr, '\n');
		else 
			Set starStr = Concat(starStr, CHAR(10), '  ');
		end if;
		Set i = i+1;
	end while;


	Select starStr as 'Sideways Star Pyramid';

End $$
Delimiter ;




-- 1010101
-- 10101
-- 101
-- 1
