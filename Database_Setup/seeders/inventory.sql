use mgmt_db;
truncate inventory;

insert into inventory (id, name, size, price, quantity) values (1, 'SMALL GARBAGE', '48 GALLONS', 44.15, 132);
insert into inventory (id, name, size, price, quantity) values (2, 'MEDIUM GARBAGE', '64 GALLONS', 30.99, 150);
insert into inventory (id, name, size, price, quantity) values (3, 'LARGE GARBAGE', '96 GALLONS', 17.34, 87);
insert into inventory (id, name, size, price, quantity) values (4, 'SMALL RECYCLE', '48 GALLONS', 37.07, 148);
insert into inventory (id, name, size, price, quantity) values (5, 'LARGE RECYCLE', '96 GALLONS', 39.91, 170);
insert into inventory (id, name, size, price, quantity) values (6, 'SMALL ORGANIC', '48 GALLONS', 41.42, 111);
insert into inventory (id, name, size, price, quantity) values (7, 'LARGE ORGANIC', '96 GALLONS', 42.45, 54);
