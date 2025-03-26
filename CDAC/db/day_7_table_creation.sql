Create Table IF NOT EXISTS Vehicle(
	vid int Primary Key,
     vname varchar(20) Not Null,
     price int Not Null
);

Create Table IF NOT EXISTS VehicleCustomer(
	cid int Primary Key,
     cname varchar(30) Not Null,
     address varchar(100)
);

Create Table IF NOT EXISTS VehicleSalesman(
	sid int Primary Key,
     sname varchar(20) Not Null,
     city varchar(15) Not Null
);

Create Table IF NOT EXISTS soldVehicle(
	cid int Not Null,
     vid int Not Null,
     sid int Not Null,
     buyPrice int Not Null,
     Constraint Primary Key(cid, vid, sid),
     Constraint fk_vehicle_cid Foreign Key(cid) 
     References VehicleCustomer(cid)
     On Update cascade,
     Constraint fk_vehicle_vid Foreign Key(vid) 
     References Vehicle(vid)
     On Update cascade,
     Constraint fk_vehicle_sid Foreign Key(sid) 
     References VehicleSalesman(sid)
     On Update cascade
);


Insert Into Vehicle Value
(1, 'Activa', 80000),
(2, 'Santro', 400000),
(3, 'z900', 1100000);

Insert Into VehicleCustomer Value
(1, 'Nilima', 'Pimpri'),
(2, 'Ganesh', 'Pune'),
(3, 'Aadi', 'Delhi');

Insert Into VehicleSalesman Value
(10, 'Rajesh', 'Mumbai'),
(11, 'Seema', 'Pune'),
(13, 'Rakhi', 'Pune');

Insert Into soldVehicle Value
(1, 1, 10, 75000),
(1, 2, 10, 390000 ),
(2, 3, 11, 1000000),
(3, 3, 11, 980000),
(3, 2, 10, 400000);









