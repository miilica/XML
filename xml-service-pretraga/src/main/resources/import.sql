INSERT INTO `cjenovnik` (id, rad_dan_cijena, subota_cijena, nedelja_cijena, cijena_pokm, cijenacdw, popust) VALUES (1, 120.0, 150.0, 150.0, 30.0, 100.0, 30.0);

INSERT INTO `klasa_automobila` (id, naziv) VALUES (1, 'Karavan');
INSERT INTO `klasa_automobila` (id, naziv) VALUES (2, 'Terenac');
INSERT INTO `klasa_automobila` (id, naziv) VALUES (3, 'City');
INSERT INTO `klasa_automobila` (id, naziv) VALUES (4, 'Limuzina');

INSERT INTO `marka_automobila` (id, naziv_marke, model) VALUES (1, 'Audi', 'A6');
INSERT INTO `marka_automobila` (id, naziv_marke, model) VALUES (2, 'Ferrari', 'F90');
INSERT INTO `marka_automobila` (id, naziv_marke, model) VALUES (3, 'Renault', 'Clio');
INSERT INTO `marka_automobila` (id, naziv_marke, model) VALUES (4, 'Dacia', 'Sandero');

INSERT INTO `tip_goriva` (id, naziv) VALUES (1, 'benzin');
INSERT INTO `tip_goriva` (id, naziv) VALUES (2, 'dizel');
INSERT INTO `tip_goriva` (id, naziv) VALUES (3, 'plin');

INSERT INTO `tip_mjenjaca` (id, naziv) VALUES (1, 'manuelni');
INSERT INTO `tip_mjenjaca` (id, naziv) VALUES (2, 'automatski');
INSERT INTO `tip_mjenjaca` (id, naziv) VALUES (3, 'poluautomatski');

INSERT INTO `vozilo` (id, cijena, kilometraza, moze_precikm, br_sjedista_za_djecu, ima_android, coliision_damage_wavier, marka_automobila_id, tip_goriva_id, tip_mjenjaca_id, klasa_automobila_id) VALUES (1, 100, 15000, 360000, 2, false, true, 1, 1, 1, 2);
INSERT INTO `vozilo` (id, cijena, kilometraza, moze_precikm, br_sjedista_za_djecu, ima_android, coliision_damage_wavier, marka_automobila_id, tip_goriva_id, tip_mjenjaca_id, klasa_automobila_id) VALUES (2, 200, 10000, 300000, 0, false, false, 2, 1, 2, 1);
INSERT INTO `vozilo` (id, cijena, kilometraza, moze_precikm, br_sjedista_za_djecu, ima_android, coliision_damage_wavier, marka_automobila_id, tip_goriva_id, tip_mjenjaca_id, klasa_automobila_id) VALUES (3, 250, 30000, 100000, 1, true, true, 3, 2, 1, 2);

INSERT INTO `oglas` (id, dostupan, mjesto_preuzimanja, oglas_vazi_od, oglas_vazi_do, vozilo_id, cjenovnik_id) VALUES (1, false, 'Foca', '2020-01-01', '2020-01-31', 1, 1);
INSERT INTO `oglas` (id, dostupan, mjesto_preuzimanja, oglas_vazi_od, oglas_vazi_do, vozilo_id, cjenovnik_id) VALUES (2, false, 'Novi Sad', '2020-02-15', '2020-04-25', 2, 1);
INSERT INTO `oglas` (id, dostupan, mjesto_preuzimanja, oglas_vazi_od, oglas_vazi_do, vozilo_id, cjenovnik_id) VALUES (3, true, 'Foca', '2020-03-15', '2020-05-01', 3, 1);