INSERT INTO `vehicle_db.authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_KORISNIK');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_AGENT');

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 1, 'John', 'Doe', 'admin01', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'admin@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '2017-10-01 21:58:58', true);

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 2, 'Nole', 'Nolic', 'user1', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'user1@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 3, 'Djole', 'Djolic', 'user2', 'Ustanicka 15', 'Beograd', 'Srbija', 'user2@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 4, 'Kole', 'Kolic', 'user3', 'Ustanicka 15', 'Nis', 'Srbija', 'user3@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 5, 'Bole', 'Bolic', 'user4', 'Ustanicka 15', 'Banja Luka', 'BiH', 'user4@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 6, 'Role', 'Rolic', 'agent1', 'Velikih prodavaca 8', 'Zrenjanin', 'Srbija', 'agent1@rentacar.com', '895102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 7, 'Jelena', 'Jelenic', 'agent2', 'Velikih prodavaca 15', 'Zrenjanin', 'Srbija', 'agent2@rentacar.com', '895102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (7, 3);

INSERT INTO `agent` (id, adresa, br_oglasa, ime, ime_kompanije, poslovnimb, prezime) VALUES (6, 'Nikole Tesle 15', '1', 'Role', 'MarkoTrans', 'stagod', 'Rolic');
INSERT INTO `agent` (id, adresa, br_oglasa, ime, ime_kompanije, poslovnimb, prezime) VALUES (7, 'Mihajla Pupina 22', '2', 'Jelena', 'JelenaTrans', 'wthevr', 'Jelenic');

INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (1, '0', '1200', false, true, '120000', '100', '4', 6);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (2, '2', '2200', true, true, '150000', '200', '3', 6);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (3, '0', '2150', false, false, '250000', '600', '5', 6);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (4, '1', '2250', true, true, '15000', '150', '5', 6);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (5, '1', '600', false, false, '270000', '500', '2', 7);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (6, '0', '5000', false, true, '10000', '1000', '5', 7);

INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (1, true, 'Novi Sad', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (2, true, 'Veternik', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (3, false, 'Beograd', 1);

INSERT INTO `termin_iznajmljivanja` (id, do_kad, od_kad, user_id, vozilo_id) VALUES (1, '2020-06-18 21:58:58', '2020-06-17 21:58:58', 1, 1);
INSERT INTO `termin_iznajmljivanja` (id, do_kad, od_kad, user_id, vozilo_id) VALUES (2, '2020-05-05 21:58:58', '2020-05-17 21:58:58', 1, 2);
INSERT INTO `termin_iznajmljivanja` (id, do_kad, od_kad, user_id, vozilo_id) VALUES (3, '2020-06-20 21:58:58', '2020-06-24 21:58:58', 1, 3);

insert into `tipmjenjaca` (id, naziv) values (1, 'manuelni');
insert into `tipmjenjaca` (id, naziv) values (2, 'automatski');
insert into `tipmjenjaca` (id, naziv) values (3, 'poluautomatski');

insert into `klasaautomobila` (id, naziv) values (1, 'klasa1');
insert into `klasaautomobila` (id, naziv) values (2, 'klasa2');
insert into `klasaautomobila` (id, naziv) values (3, 'klasa3');

insert into `vrstagoriva` (id, naziv) values (1, 'benzin');
insert into `vrstagoriva` (id, naziv) values (2, 'dizel');
insert into `vrstagoriva` (id, naziv) values (3, 'plin');

insert into `markaautomobila` (id, naziv_marke, model) values (1, 'BMW', 'model1');
insert into `markaautomobila` (id, naziv_marke, model) values (2, 'Audi', 'model2');
insert into `markaautomobila` (id, naziv_marke, model) values (3, 'Wolsvagen', 'model3');
