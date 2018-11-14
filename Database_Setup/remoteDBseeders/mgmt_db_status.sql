use mgmt_db;
delete from status where id>1;
-- insert into status (id, name) values (1, 'SUBMITTED');
insert into status (id, name) values (2, 'PROCESSING');
insert into status (id, name) values (3, 'REVIEW');
insert into status (id, name) values (4, 'COMPLETE');
insert into status (id, name) values (5, 'CANCELED');