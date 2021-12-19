insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number) VALUES( 1002, 'Piet', 'Klaasens', 'Hoofdstraat2', '3312 BG', 'Oordam', '12-93458739');
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number) VALUES(1003, 'Jasper', 'Dillemans', 'Straatje 23', '3312 BH', 'Oordam', '12-77789891');
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number) VALUES(1001, 'Johan', 'van Oosten', 'Dorpsstraat 49', '4451 BB', 'Heinkenszand', '0611847523');

INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('user', 1003, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE, 1003);
INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('admin', 1002, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE, 1002);
INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('johan', 1001, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'johan@test.nl', TRUE, 1001);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_ADMIN');

insert into picture (id, data, name, type ) VALUES ( 1010, 19065, '(speel)tuin.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1001, 19066, 'graven.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1003, 19067, 'kraan.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1004, 19068, 'kraantje.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1011, 19069, 'moderne tuin.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1012, 19070, 'schutting.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1005, 19071, 'shovel.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1008, 19072, 'snoeien.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1007, 19073, 'terrastegels.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1006, 19074, 'trilplaat.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1009, 19075, 'tuinvoorbeeld.jpg', 'image/jpeg');
insert into picture (id, data, name, type ) VALUES ( 1002, 19076, 'zwembad tuin.jpg', 'image/jpeg');

insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service, picture_id) VALUES( 1001, 'Grote kraan', 'Grote kraan voor de grotere werkzaamheden.', 'Graafmachine', '2 meter bij 1,50 meter' , '2021-03-12', '2021-09-12', 1003 );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service, picture_id) VALUES( 1002, 'Kraan', 'Kraan voor de normale werkzaamheden.', 'Graafmachine', '1,50 meter bij 1,50 meter' , '2021-04-23', '2021-10-23', 1004 );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service, picture_id) VALUES( 1003, 'Grote trilplaat', 'Grote trilplaat voor de grotere straatwerkzaamheden.', 'Trilplaat', '1 meter bij 1 meter' , '2021-05-23', '2021-11-12', 1006 );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service, picture_id) VALUES( 1004, 'Shovel', 'Shovel voor de grotere verplaats werkzaamheden.', 'Shovel', '0,60 meter bij 0,60 meter' , '2021-06-22', '2021-11-20', 1005 );

insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1001, 'Henk Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'H.verstrate@mail.com', '12-22334824', '135593456', 'Nl10IBAN0231154324');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1002, 'Sjoerd Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'S.verstrate@mail.com', '12-22334824', '4859302178', 'Nl10IBAN05387778903');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1003, 'Micheal Verstrate', 'Achterweg 11', '3312 BD', 'Oordam', 'M.verstrate@mail.com', '12-23599824', '457933898', 'Nl10IBAN0658932145');

insert into job (id, job_name, job_description, employee_needed, picture_id) VALUES( 1001, 'Terras aanleggen', 'Nieuw terras aanleggen in uw tuin', false, 1007);
insert into job (id, job_name, job_description, employee_needed, employee_id, picture_id) VALUES( 1002, 'Tuinonderhoud', 'Het snoeien, maaien en verfraaien van uw tuin', true, 1002, 1008);
insert into job (id, job_name, job_description, employee_needed, employee_id, picture_id) VALUES( 1003, 'Zwembad aanleggen', 'Nieuw zwembad aanleggen in uw tuin', true, 1002, 1002);

insert into request (id, user_data_id, request_start_time, request_end_time, status ) VALUES( 1001, 1001, '2021-09-12T08:00:00', '2021-09-14T14:00:00', 0);
insert into request (id, user_data_id, request_start_time, request_end_time, status ) VALUES( 1002, 1001, '2021-10-11T08:00:00', '2021-09-14T15:00:00', 0);
insert into request (id, user_data_id, request_start_time, request_end_time, status ) VALUES( 1003, 1001, '2021-10-12T11:00:00', '2021-09-14T16:00:00', 0);
insert into request (id, user_data_id, request_start_time, request_end_time, status ) VALUES( 1004, 1001, '2021-10-14T13:00:00', '2021-09-14T17:00:00', 0);

insert into request_machine(request_id, machine_id) values (1001, 1001);
insert into request_machine(request_id, machine_id) values (1001, 1002);
insert into request_machine(request_id, machine_id) values (1002, 1004);
insert into request_machine(request_id, machine_id) values (1002, 1001);
insert into request_machine(request_id, machine_id) values (1002, 1003);
insert into request_machine(request_id, machine_id) values (1003, 1001);

insert into request_job(request_id, job_id) values (1001, 1001);
insert into request_job(request_id, job_id) values (1001, 1002);
insert into request_job(request_id, job_id) values (1002, 1001);
insert into request_job(request_id, job_id) values (1002, 1003);
insert into request_job(request_id, job_id) values (1004, 1001);
insert into request_job(request_id, job_id) values (1004, 1003);
insert into request_job(request_id, job_id) values (1004, 1002);

insert into review (id, description, name, value, picture_id) VALUES (1001, 'heel mooi eindresultaat', 'Kees Blok', 3, 1009);
insert into review (id, description, name, value, picture_id) VALUES (1002, 'Een mooie speeltuin voor de kinderen aan laten leggen', 'Klaas Oosterhout', 5, 1010);
insert into review (id, description, name, value, picture_id) VALUES (1003, 'De voortuin ziet er weer keurig uit', 'P dingemans', 4, 1011);
insert into review (id, description, name, value, picture_id) VALUES (1004, 'eindelijk privacy en een mooie schutting', 'Julliette van der plasse', 4, 1012);

insert into quote (id, date, description, status, picture_id, user_data_id) VALUES (1001, '2021-11-30T00:00:00','Tuin opnieuw inrichten', 0, 1009, 1002);
insert into quote (id, date, description, status, picture_id, user_data_id) VALUES (1002, '2021-12-28T00:00:00', 'Speeltuin onderhoud', 0, 1010, 1001);
insert into quote (id, date, description, status, picture_id, user_data_id) VALUES (1003, '2022-01-30T00:00:00', 'Conifeerhaag weghalen', 0, 1008, 1003);