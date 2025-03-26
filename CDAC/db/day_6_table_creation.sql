Create Table If Not Exists category(
	cid int Primary Key,
     cname varchar(30) not null unique,
     description varchar(100) not null
);

Create Table If Not Exists salesman(
	sid int Primary Key,
     same varchar(30) not null,
     city varchar(15) not null
);

Create Table If Not Exists product(
	id int primary key,
	pname varchar(30) not null,
	qty int not null,
	price float default 20.00,
	cid int,
	sid int,
	Constraint check (qty > 0),
	Constraint fk_cid Foreign Key(cid) References Category(cid)
	on delete set null
	on update cascade,
	Constraint fk_sid Foreign Key(sid) References Salesman(sid)
	on delete set null
	on update cascade
);


INSERT INTO Product VALUES 
(123, "lays", 30, 30.00, 1, 12),
(111, "pepsi", 40, 50.00, 4, 11),
(134, "nachos", 50, 50.00, 1, 12),
(124, "dairy milk", 40, 60.00, 2, 14),
(125, "pringles", 40, 60.00, 1, 14);

INSERT INTO Salesman VALUES
(11, "Rahul", "Pune"),
(12, "Kirti", "Mumbai"),
(13, "Prasad", "Nashik"),
(14, "Arnav", "Amaravati") ;

INSERT INTO Category VALUES
(1, "chips", "very crunchy"),
(2, "chocolate", "very chocolaty"),
(3, "snacks", "yummy"),
(4, "cold drinks", "thanda thanda cool cool") ;


Select * From Product;
Select * From Category;
Select * From Salesman;
