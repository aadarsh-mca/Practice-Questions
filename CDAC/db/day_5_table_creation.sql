-- Run each table creation command one-by-one

Create Table If Not Exists Branch (
	bid int Primary Key,
	bname varchar(30) Not Null Unique,
	city varchar(15) Not Null
);

Create Table If Not Exists Loan (
	lid int Primary Key,
	amtReq int Not Null,
	amtApp int Not Null,
     ldate Date Not Null
);

Create Table If Not Exists Customer (
	cid int Primary Key,
	cname varchar(30) Not Null,
	address varchar(50) Not Null,
     city varchar(15) Not Null
);

Create Table If Not Exists Ternary(
	bid int,
	lid int,
     cid int,
     Primary Key(bid, lid, cid),
     Constraint fk_branch Foreign Key(bid)
     References branch(bid)
     on update cascade,
     Constraint fk_loan Foreign Key(lid)
     References loan(lid)
     on update cascade,
     Constraint fk_cust Foreign Key(cid)
	References customer(cid)
     on delete cascade
     on update cascade
);

-- Insert into BRANCH
INSERT INTO BRANCH (BID, BNAME, CITY) VALUES
(101, 'Aundh', 'Pune'),
(102, 'Deccan', 'Pune'),
(103, 'M.G.ROAD', 'Mumbai'),
(104, 'Kothrud', 'Pune');

-- Insert into CUSTOMER
INSERT INTO CUSTOMER (CID, CNAME, ADDRESS, CITY) VALUES
(201, 'Rahul Sharma', 'Baner Road', 'Pune'),
(202, 'Priya Desai', 'FC Road', 'Pune'),
(203, 'Amit Patil', 'Kothrud', 'Pune'),
(204, 'Neha Kulkarni', 'Andheri', 'Mumbai'),
(205, 'Rajesh Nair', 'Vashi', 'Mumbai');

-- Insert into LOAN_APPLICATION
INSERT INTO LOAN (LID, AMTREQ, AMTAPP, LDATE) VALUES
(301, 500000, 450000, '2024-09-10'),
(302, 300000, 300000, '2024-09-12'),
(303, 700000, 600000, '2024-08-25'),
(304, 250000, 200000, '2024-09-15'),
(305, 400000, 400000, '2024-07-30');

-- Insert into TERNARY (Mapping Customers, Loans, and Branches)
INSERT INTO TERNARY (BID, CID, LID) VALUES
(101, 201, 301),  -- Rahul Sharma applied at Aundh
(102, 202, 302),  -- Priya Desai applied at Deccan
(103, 203, 303),  -- Amit Patil applied at M.G.ROAD
(104, 204, 304),  -- Neha Kulkarni applied at Kothrud
(102, 205, 305);  -- Rajesh Nair applied at Deccan

Select * From branch;
Select * From loan;
Select * From customer;
Select * From ternary;