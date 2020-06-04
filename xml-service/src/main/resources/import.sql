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

INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena) VALUES (1, '0', '1200', false, true, '120000', '100', '4');
INSERT INTO `vozilo` (id, br_sjedista_za_djecu, cijena, coliision_damage_wavier, ima_android, kilometraza, moze_precikm, ocjena) VALUES (2, '2', '2200', true, true, '150000', '200', '3');

INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (1, true, 'Novi Sad', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (2, true, 'Veternik', 1);
INSERT INTO `oglasi` (id, dostupan, mjesto_preuzimanja, vozilo_id) VALUES (3, false, 'Beograd', 1);

