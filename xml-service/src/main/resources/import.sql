INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_KORISNIK');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_SELLER');

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 1, 'John', 'Doe', 'admin01', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'admin@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '2017-10-01 21:58:58', true);

INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 2, 'Nole', 'Nolic', 'user1', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'user1@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 3, 'Djole', 'Djolic', 'user2', 'Ustanicka 15', 'Beograd', 'Srbija', 'user2@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 4, 'Kole', 'Kolic', 'user3', 'Ustanicka 15', 'Nis', 'Srbija', 'user3@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', false);
INSERT INTO `users` (user_type, id, name, surname, username, address, city, country, email, phone, password, is_admin, last_password_reset_date, enabled) VALUES (0, 5, 'Cole', 'Colic', 'user4', 'Ustanicka 15', 'Banja Luka', 'BiH', 'user4@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false, '2017-10-01 21:58:58', true);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 2);

INSERT INTO `agent` (id, adresa, br_oglasa, ime, ime_kompanije, poslovnimb, prezime) VALUES (1, 'Nikole Tesle 15', '1', 'Marko', 'MarkoTrans', 'stagod', 'Markic');
INSERT INTO `agent` (id, adresa, br_oglasa, ime, ime_kompanije, poslovnimb, prezime) VALUES (2, 'Mihajla Pupina 22', '2', 'Jelena', 'JelenaTrans', 'wthevr', 'Jelenic');

INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (1, '0', '1200', false, true, '120000', '100', '4', 1);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (2, '2', '2200', true, true, '150000', '200', '3', 1);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (3, '1', '600', false, false, '270000', '500', '2', 2);
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena, agent_id) VALUES (4, '0', '5000', false, true, '10000', '1000', '5', 2);

INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (1, true, 'Novi Sad', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (2, true, 'Veternik', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (3, false, 'Beograd', 1);

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

