INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_KORISNIK');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_SELLER');

INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 1, 'John', 'Doe', 'admin01', '0708991801541', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'admin@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, true, '2017-10-01 21:58:58', true);

INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 2, 'Nole', 'Nolic', 'user1', '0708991801541', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'user1@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 3, 'Djole', 'Djolic', 'user2', '0708991801541', 'Ustanicka 15', 'Beograd', 'Srbija', 'user2@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, false, '2017-10-01 21:58:58', true);
INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 4, 'Kole', 'Kolic', 'user3', '0708991801541', 'Ustanicka 15', 'Nis', 'Srbija', 'user3@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, false, '2017-10-01 21:58:58', false);
INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 5, 'Cole', 'Colic', 'user4', '0708991801541', 'Ustanicka 15', 'Banja Luka', 'BiH', 'user4@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, false, '2017-10-01 21:58:58', true);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 2);