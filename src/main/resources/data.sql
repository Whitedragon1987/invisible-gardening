INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('johan', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'johan@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('johan', 'ROLE_ADMIN');

insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 1, 'Grote kraan', 'Grote kraan voor de grotere werkzaamheden.', 'Graafmachine', '2 meter bij 1,50 meter' , '2021-03-12', '2021-09-12' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 2, 'kraan', 'Kraan voor de normale werkzaamheden.', 'Graafmachine', '1,50 meter bij 1,50 meter' , '2021-04-23', '2021-10-23' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 3, 'Grote trilplaat', 'Grote trilplaat voor de grotere straatwerkzaamheden.', 'Trilplaat', '1 meter bij 1 meter' , '2021-05-23', '2021-11-12' );
insert into machine (id, machine_name, machine_description, machine_type, machine_measurements, machine_last_service, machine_planned_service) VALUES( 4, 'Trilplaat', 'Trilplaat voor de normale straatwerkzaamheden.', 'Trilplaat', '0,60 meter bij 0,60 meter' , '2021-06-22', '2021-11-20' );

insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 1, 'Henk Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'H.verstrate@mail.com', '12-22334824', '135593456', 'Nl10IBAN0231154324');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 2, 'Sjoerd Verstrate', 'Dorpstraat 8', '3312 BA', 'Oordam', 'S.verstrate@mail.com', '12-22334824', '4859302178', 'Nl10IBAN05387778903');
insert into employee (id, name, address, zipcode, city, emailaddress, phone_number, city_service_number, iban_number) VALUES( 3, 'Micheal Verstrate', 'Achterweg 11', '3312 BD', 'Oordam', 'M.verstrate@mail.com', '12-23599824', '457933898', 'Nl10IBAN0658932145');

insert into job (id, job_name, job_description, employee_needed) VALUES( 1, 'Terras aanleggen', 'Nieuw terras aanleggen in uw tuin', false);
insert into job (id, job_name, job_description, employee_needed, employee_id) VALUES( 2, 'Tuinonderhoud', 'Het snoeien, maaien en verfraaien van uw tuin', true,2);
insert into job (id, job_name, job_description, employee_needed, employee_id) VALUES( 3, 'Zwembad aanleggen', 'Nieuw zwembad aanleggen in uw tuin', true,2);

insert into company (id, company_name, company_address, company_zipcode, company_city, company_emailaddress, company_phone_number) VALUES( 1, 'Van Straate', 'Straatweg 1', '3312 BC', 'Oordam', 'vStraate@info.com', '0123-323212');
insert into company (id, company_name, company_address, company_zipcode, company_city, company_emailaddress, company_phone_number) VALUES( 2, 'Van der Ploeg', 'Maximaplein 1', '3312 BJ', 'Oordam', 'vdPloeg@info.com', '0123-899645');

insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number) VALUES( 1, 'Piet', 'Jansen', 'Straatweg 15', '3312 BE', 'Oordam', '12-99989723');
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number, company_id) VALUES( 2, 'Piet', 'Klaasens', 'Hoofdstraat2', '3312 BG', 'Oordam', '12-93458739', 1);
insert into user_data (id, user_firstname, user_lastname, user_address, user_zipcode, user_city, user_phone_number,  company_id) VALUES( 3, 'Jasper', 'Dillemans', 'Straatje 23', '3312 BH', 'Oordam', '12-77789891' , 2);

insert into request (id, user_data_id, machine_id, job_id, request_start_time, request_end_time ) VALUES( 1, 1, 1, 1, '2021-09-12T08:00:00', '2021-09-14T14:00:00');
