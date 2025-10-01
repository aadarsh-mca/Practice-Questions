Create Table IF NOT EXISTS Venue_Master (
    Venue_Id varchar(10) primary key,
    Event_Id varchar(10),
    Venue_name varchar(30),
    Location varchar(50),
    Venue_Cost int,
    Food varchar(10),
    Capacity int,
    Wifi varchar(10),
    Description varchar(50),
    Constraint fk_event_id foreign key (Event_Id)
    References Event_Master (Event_Id);
);