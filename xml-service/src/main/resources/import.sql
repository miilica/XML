INSERT INTO `authorities` (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authorities` (id, name) VALUES (2, 'ROLE_BUYER');
INSERT INTO `authorities` (id, name) VALUES (3, 'ROLE_SELLER');

INSERT INTO `users` (user_type, id, name, surname, username, ucidn, address, city, country, email, phone, password, role, is_admin, last_password_reset_date, enabled) VALUES (0, 1, 'John', 'Doe', 'admin01', '0708991801541', 'Ustanicka 15', 'Novi Sad', 'Srbija', 'admin@rentacar.com', '890102', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', null, true, '2017-10-01 21:58:58', true);

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);