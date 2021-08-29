insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number, has_company) VALUES( 1002, 'Piet', 'Klaasens', 'Hoofdstraat2', '3312 BG', 'Oordam', '12-93458739', false);
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number, has_company) VALUES(1003, 'Jasper', 'Dillemans', 'Straatje 23', '3312 BH', 'Oordam', '12-77789891', true);
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number, has_company) VALUES(1001, 'Johan', 'van Oosten', 'Dorpsstraat 49', '4451 BB', 'Heinkenszand', '0611847523', true);

INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('user', 1003, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE, 1003);
INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('admin', 1002, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE, 1002);
INSERT INTO users (username, id, password, email, enabled, user_data_id) VALUES ('johan', 1001, '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'johan@test.nl', TRUE, 1001);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_ADMIN');

insert into company (id, company_name, company_address, company_zipcode, company_city, company_emailaddress, company_phone_number, user_data_id) VALUES( 1001, 'Van Straate', 'Straatweg 1', '3312 BC', 'Oordam', 'vStraate@info.com', '0123-323212', 1003);
insert into company (id, company_name, company_address, company_zipcode, company_city, company_emailaddress, company_phone_number, user_data_id) VALUES( 1002, 'Van der Ploeg', 'Maximaplein 1', '3312 BJ', 'Oordam', 'vdPloeg@info.com', '0123-899645', 1001);

insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 1001, 'Grote kraan', 'Grote kraan voor de grotere werkzaamheden.', 'Graafmachine', '2 meter bij 1,50 meter' , '2021-03-12', '2021-09-12' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 1002, 'kraan', 'Kraan voor de normale werkzaamheden.', 'Graafmachine', '1,50 meter bij 1,50 meter' , '2021-04-23', '2021-10-23' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 1003, 'Grote trilplaat', 'Grote trilplaat voor de grotere straatwerkzaamheden.', 'Trilplaat', '1 meter bij 1 meter' , '2021-05-23', '2021-11-12' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 1004, 'Trilplaat', 'Trilplaat voor de normale straatwerkzaamheden.', 'Trilplaat', '0,60 meter bij 0,60 meter' , '2021-06-22', '2021-11-20' );

insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1001, 'Henk Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'H.verstrate@mail.com', '12-22334824', '135593456', 'Nl10IBAN0231154324');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1002, 'Sjoerd Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'S.verstrate@mail.com', '12-22334824', '4859302178', 'Nl10IBAN05387778903');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1003, 'Micheal Verstrate', 'Achterweg 11', '3312 BD', 'Oordam', 'M.verstrate@mail.com', '12-23599824', '457933898', 'Nl10IBAN0658932145');

insert into job (id, job_name, job_description, employee_needed) VALUES( 1001, 'Terras aanleggen', 'Nieuw terras aanleggen in uw tuin', false);
insert into job (id, job_name, job_description, employee_needed, employee_id) VALUES( 1002, 'Tuinonderhoud', 'Het snoeien, maaien en verfraaien van uw tuin', true, 1002);
insert into job (id, job_name, job_description, employee_needed, employee_id) VALUES( 1003, 'Zwembad aanleggen', 'Nieuw zwembad aanleggen in uw tuin', true, 1002);



insert into request (id, user_data_id, machine_id, job_id, request_start_time, request_end_time ) VALUES( 1001, 1001, 1001, 1001, '2021-09-12T08:00:00', '2021-09-14T14:00:00');
