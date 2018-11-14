use mgmt_db;


insert into status (name) values ('SUBMITTED');
insert into status (name) values ('PROCESSING');
insert into status (name) values ('REVIEW');
insert into status (name) values ('COMPLETE');
insert into status (name) values ('CANCELED');
insert into categories (name) values ( 'CONTAINER');
insert into categories (name) values ( 'SOLID WASTE');
insert into categories (name) values ( 'RECYCLING');
insert into categories (name) values ( 'ORGANICS');
insert into categories (name) values ( 'HAZMAT');
insert into inventory (name, size, price, quantity) values ( 'SMALL GARBAGE', '48 GALLONS', 44.15, 10000);
insert into inventory (name, size, price, quantity) values ( 'MEDIUM GARBAGE', '64 GALLONS', 30.99, 9000);
insert into inventory (name, size, price, quantity) values ( 'LARGE GARBAGE', '96 GALLONS', 17.34, 8000);
insert into inventory (name, size, price, quantity) values ('SMALL RECYCLE', '48 GALLONS', 37.07, 6000);
insert into inventory (name, size, price, quantity) values ( 'LARGE RECYCLE', '96 GALLONS', 39.91, 9500);
insert into inventory (name, size, price, quantity) values ( 'SMALL ORGANIC', '48 GALLONS', 41.42, 3200);
insert into inventory (name, size, price, quantity) values ('LARGE ORGANIC', '96 GALLONS', 42.45, 6100);

insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'twawer0@sogou.com', 'Thadeus', 'Wawer', 'aUD0TchejNw', '814-769-5012', '3441', '4th', 'twawer0', 78247, 2);
insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'rflood1@youku.com', 'Rafaela', 'Flood', 'ZYvKDi', '339-144-2165', '3', 'Westend', 'rflood1', 78261, 2);
insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'pocodihie2@mlb.com', 'Patty', 'O''Codihie', 'vcmq8Um9', '423-130-2381', '7', 'Sommers', 'pocodihie2', 78297, 2);
insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'gcollingworth3@businessweek.com', 'Gaston', 'Collingsworth', '88szkE0', '594-602-8048', '8411', '5th', 'gcollingworth3', 78231, 2);
insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'admin@sawaste.com', 'Admn', 'Istrator', 'pass', '210-602-8067', '8411', '5th', 'admin', 78231, 1);
insert into users (city, email, first_name, last_name, password, phone_number, street_number, street_name, username, zipcode, role_id) values ('San Antonio', 'emp@sawaste.com', 'Emp', 'Loyee', 'pass', '210-602-4548', '3657', '7th', 'emp', 78245, 3);



insert into user_roles (role, user_id) values ( 'ADMIN', 1);
insert into user_roles (role, user_id) values ('USER', 2);
insert into user_roles (role, user_id) values ('EMP', 3);
