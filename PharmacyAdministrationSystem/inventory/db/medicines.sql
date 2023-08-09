create table medicines
(name char(20) primary key not null,
category char(15) not null,
buyingCost decimal(7) not null,
MRP decimal(7) not null,
billNumber char(15),
traderName char(30),
manuMonth char(10),
manuMonthNumber int,
manuYear char(4),
exMonth char(10),
exMonthNumber int,
exYear char(4),
billDate char(2),
billMonth char(10),
billYear char(4),
ammountOfMedicine int not null
);