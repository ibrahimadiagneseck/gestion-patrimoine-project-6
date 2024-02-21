-------------------------------------------------------------------------------------------------------------------------
INSERT INTO "authorities" ("authority_id", "code", "name")
VALUES ('1', 'ADMIN', 'ADMINISTRATEUR'), ('2', 'CSA', 'CHEF SECTION ARMEMENT'), ('3', 'ASA', 'AGENT SECTION ARMEMENT'),
       ('4', 'CSG', 'CHEF SECTION GARAGE'), ('5', 'ASG', 'AGENT SECTION GARAGE'), ('6', 'CSM', 'CHEF SECTION MATÉRIEL'),
       ('7', 'ASM', 'AGENT SECTION MATÉRIEL'), ('8', 'BLM', 'CHEF BLM'), ('9', 'DLF', 'DIRECTEUR DLF');

-------------------------------------------------------------------------------------------------------------------------

INSERT INTO corps_agent (code_corps_agent, libelle_corps_agent)
VALUES ('CP1', 'Corps 1'),
       ('CP2', 'Corps 2'),
       ('CP3', 'Corps 3');

-------------------------------------------------------------------------------------------------------------------------

INSERT INTO sections (code_section, libelle_section)
VALUES 
    ('SA', 'SECTION ARMEMENT'),
    ('SM', 'SECTION MATERIEL'),
    ('SG', 'SECTION GARAGE');

-------------------------------------------------------------------------------------------------------------------------


INSERT INTO type_unite_douaniere (code_type_unite_douaniere, libelle_type_unite_douaniere)
VALUES ('BUR', 'BUREAU CENTRAL'),
       ('BRI', 'BRIGADE MOBILE');

-------------------------------------------------------------------------------------------------------------------------

INSERT INTO unite_douaniere (code_unite_douaniere, nom_unite_douaniere, effectif_unite_douaniere, nombre_arme, nombre_automobile, nombre_materiel, code_type_unite_douaniere)
VALUES 
    ('06K', 'BUREAU DE LA LOGISTIQUE ET DE LA MAINTENANCE', 10, 3, 5, 20, 'BUR'),
    ('06Z', 'BUREAU DE LA PROGRAMMATION ET DES FINANCES', 10, 3, 5, 20, 'BUR');


-------------------------------------------------------------------------------------------------------------------------


INSERT INTO unite_douaniere_sections (code_unite_douaniere, code_section)
VALUES 
    ('06K', 'SA'),
    ('06K', 'SM'),
    ('06K', 'SG'),
    ('06Z', 'SA'),
    ('06Z', 'SM'),
    ('06Z', 'SG');


-------------------------------------------------------------------------------------------------------------------------

-- MOT DE PASSE : lOJk8OqaH3

INSERT INTO "utilisateur" ("code_corps_agent", "code_section", "code_unite_douaniere", "is_active", "is_not_locked", "code_agent", "matricule_agent", "join_date", "last_login_date", "last_login_date_display", "utilisateur_id", "email", "first_name", "last_name", "mobile", "profile_image_url", "pwd", "role", "user_id") VALUES
('CP1',  'SA',   '06K',   't',    't',    'D2273',    '613693H',  '2024-02-14 02:39:49.275',  NULL,   NULL,   1,  'ibrahima@esp.sn',  'Ibrahima Diagne',  'Seck', '775211787',    NULL,   '$2a$10$wlhYjN7p4EJXUJThwGDIK.Ex0MGUwH2oBeGNDBcYRD0uuk8XcFKNK', 'ROLE_USER', '8706757131');


INSERT INTO "utilisateur" ("code_corps_agent", "code_section", "code_unite_douaniere", "is_active", "is_not_locked", "code_agent", "matricule_agent", "join_date", "last_login_date", "last_login_date_display", "utilisateur_id", "email", "first_name", "last_name", "mobile", "profile_image_url", "pwd", "role", "user_id") VALUES
('CP2',  'SM',   '06K',   't',    't',    'D3485',    '506234B',  '2024-02-14 02:39:49.275',  NULL,   NULL,   2,  'oumou@esp.sn',  'Oumou Hawa',  'Diallo', '774101787',    NULL,   '$2a$10$wlhYjN7p4EJXUJThwGDIK.Ex0MGUwH2oBeGNDBcYRD0uuk8XcFKNK', 'ROLE_USER', '8706757132');


INSERT INTO "utilisateur" ("code_corps_agent", "code_section", "code_unite_douaniere", "is_active", "is_not_locked", "code_agent", "matricule_agent", "join_date", "last_login_date", "last_login_date_display", "utilisateur_id", "email", "first_name", "last_name", "mobile", "profile_image_url", "pwd", "role", "user_id") VALUES
('CP3',  'SG',   '06Z',   't',    't',    'D2814',    '622543E',  '2024-02-14 02:39:49.275',  NULL,   NULL,   3,  'admin@esp.sn',  'Administrateur',  'Admin', '775211787',    NULL,   '$2a$10$wlhYjN7p4EJXUJThwGDIK.Ex0MGUwH2oBeGNDBcYRD0uuk8XcFKNK', 'ROLE_ADMIN', '8706757133');


-------------------------------------------------------------------------------------------------------------------------

INSERT INTO "utilisateur_authority" ("authority_id", "utilisateur_id")
VALUES 
    ('1', '1'), ('4', '1'),
    ('1', '2'), ('8', '2'),
    ('1', '3'), ('9', '3');

-------------------------------------------------------------------------------------------------------------------------















INSERT INTO secteur_activite (code_secteur_activite, libelle_secteur_activite)
VALUES 
    ('IT', 'Technologies de l''information'),
    ('Finance', 'Services financiers'),
    ('Sante', 'Soins de santé'),
    ('Fabrique', 'Fabrication'),
    ('Education', 'Éducation'),
    ('Hotellerie', 'Hôtellerie et restauration'),
    ('Energie', 'Énergie'),
    ('Menuisier', 'Menuisier');



INSERT INTO prestataires (ninea, raison_sociale, numero_telephone, adresse_email, adresse)
VALUES 
    ('005177614', 'cabinet alpha de consultance et de genie-civil-sarl', 123456789, 'email1@example.com', 'Address 1'),
    ('005174222', 'transfert des technologies-sarl', 987654321, 'email2@example.com', 'Address 2'),
    ('005192373', 'entreprise senegalaise de prefabrication-sarl', 555555555, 'email3@example.com', 'Address 3');


INSERT INTO prestataires_secteur (ninea, code_secteur_activite)
VALUES 
    ('005177614', 'IT'),
    ('005174222', 'Finance'),
    ('005192373', 'Sante');



INSERT INTO type_objet (code_type_objet, libelle_type_objet, code_section)
VALUES 
    ('ARMES', 'ARMES ET MUNITIONS', 'SA'),
    ('VEHIC', 'VEHICULES ET MATERIELS ROULANTS', 'SG'),
    ('MATER', 'MATERIELS', 'SM');


INSERT INTO fonction_agent (code_fonction_agent, libelle_fonction_agent)
VALUES ('FCT1', 'Fonction 1'),
       ('FCT2', 'Fonction 2'),
       ('FCT3', 'Fonction 3');




INSERT INTO agent (matricule_agent, code_agent, nom_agent, prenom_agent, numero_telephone_agent, code_fonction_agent, code_unite_douaniere, code_corps_agent)
VALUES 
    ('MAT001', 'AGT01', 'Nom Agent 1', 'Prenom Agent 1', 123456789, 'FCT1', '06K', 'CP1'),
    ('MAT002', 'AGT02', 'Nom Agent 2', 'Prenom Agent 2', 987654321, 'FCT2', '06Z', 'CP2'),
    ('MAT003', 'AGT03', 'Nom Agent 3', 'Prenom Agent 3', 555555555, 'FCT3', '06K', 'CP3');


INSERT INTO bordereau_livraison (identifiant_b_l, numero_b_l, description_b_l, lieu_de_livraison, date_b_l, conformite_b_l, representant_prestataire, code_section, ninea, matricule_agent, date_enregistrement, code_corps_agent)
VALUES 
    ('BLSA202312011043210', '001', 'Description BL 1', 'Lieu 1', '2023-12-01', 'OUI', 'Livreur 1', 'SA', '005177614', 'MAT001', CURRENT_TIMESTAMP, 'CP1'),
    ('BLSM202312021143211', '002', 'Description BL 2', 'Lieu 2', '2023-12-02', 'OUI', 'Livreur 2', 'SM', '005174222', 'MAT002', CURRENT_TIMESTAMP, 'CP2'),
    ('BLSG202312031243213', '003', 'Description BL 3', 'Lieu 3', '2023-12-03', 'NON', 'Livreur 3', 'SG', '005192373', 'MAT003', CURRENT_TIMESTAMP, 'CP3');


INSERT INTO bon_entree (identifiant_b_e, numero_b_e, libelle_bon_entree, date_bon_entree, observation_bon_entree, identifiant_b_l)
VALUES 
    ('BESA202312011043210', '001', 'Libelle BE 1', '2023-12-01', 'Observation 1', 'BLSA202312011043210'),
    ('BESM202312021143211', '002', 'Libelle BE 2', '2023-12-02', 'Observation 2', 'BLSM202312021143211'),
    ('BESG202312031243213', '003', 'Libelle BE 3', '2023-12-03', 'Observation 3', 'BLSG202312031243213');


-- Insertion des données dans la table article_bon_entree
--INSERT INTO article_bon_entree (identifiant_b_e, code_article_bon_entree, code_type_objet, libelle_article_bon_entree, quantite_entree, date_enregistrement, matricule_agent, code_corps_agent)
--VALUES 
   -- ('BESA202312011043210', 'Article 1', 'ARMES', 'Jeep-toyota corolla-155555', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1'),
    --('BESM202312021143211', 'Article 1', 'VEHIC', 'Ford-honda civic-222222', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    --('BESM202312021143211', 'Article 2', 'VEHIC', 'Chevrolet silverado-volkswagen jetta-777777', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    --('BESG202312031243213', 'Article 1', 'ARMES', 'Toyota tacoma-hyundai elantra-888888', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3');



INSERT INTO pays (code_pays, libelle_pays)
VALUES 
('AF', 'Afghanistan'),
('ZA', 'Afrique du Sud'),
('AX', 'Åland, Îles'),
('AL', 'Albanie'),
('DZ', 'Algérie'),
('DE', 'Allemagne'),
('DD', 'Allemagne de l''EST'),
('AD', 'Andorre'),
('AO', 'Angola'),
('AI', 'Anguilla'),
('AQ', 'Antarctique'),
('AG', 'Antigua et Barbuda'),
('AN', 'Antilles néerlandaises'),
('SA', 'Arabie Saoudite'),
('AR', 'Argentine'),
('AM', 'Arménie'),
('AW', 'Aruba'),
('AU', 'Australie'),
('AT', 'Autriche'),
('AZ', 'Azerbaïdjan'),
('BS', 'Bahamas'),
('BH', 'Bahrein'),
('BD', 'Bangladesh'),
('BB', 'Barbade'),
('BY', 'Bélarus'),
('BE', 'Belgique'),
('BZ', 'Bélize'),
('BJ', 'Bénin'),
('BM', 'Bermudes'),
('BT', 'Bhoutan'),
('BO', 'Bolivie (État plurinational de)'),
('BQ', 'Bonaire, Saint-Eustache et Saba'),
('BA', 'Bosnie-Herzégovine'),
('BW', 'Botswana'),
('BV', 'Bouvet, Ile'),
('BR', 'Brésil'),
('BN', 'Brunéi Darussalam'),
('BG', 'Bulgarie'),
('BF', 'Burkina Faso'),
('BI', 'Burundi'),
('CV', 'Cabo Verde'),
('KY', 'Caïmans, Iles'),
('KH', 'Cambodge'),
('CM', 'Cameroun'),
('CA', 'Canada'),
('CL', 'Chili'),
('CN', 'Chine'),
('CX', 'Christmas, île'),
('CY', 'Chypre'),
('CC', 'Cocos/Keeling (Îles)'),
('CO', 'Colombie'),
('KM', 'Comores'),
('CG', 'Congo'),
('CD', 'Congo, République démocratique du'),
('CK', 'Cook, Iles'),
('KR', 'Corée, République de'),
('KP', 'Corée, République populaire démocratique de'),
('CR', 'Costa Rica'),
('CI', 'Côte d''Ivoire'),
('HR', 'Croatie'),
('CU', 'Cuba'),
('CW', 'Curaçao'),
('DK', 'Danemark'),
('DJ', 'Djibouti'),
('DO', 'Dominicaine, République'),
('DM', 'Dominique'),
('EG', 'Egypte'),
('SV', 'El Salvador'),
('AE', 'Emirats arabes unis'),
('EC', 'Equateur'),
('ER', 'Erythrée'),
('ES', 'Espagne'),
('EE', 'Estonie'),
('US', 'Etats-Unis d''Amérique'),
('ET', 'Ethiopie'),
('FK', 'Falkland/Malouines (Îles)'),
('FO', 'Féroé, îles'),
('FJ', 'Fidji'),
('FI', 'Finlande'),
('FR', 'France'),
('GA', 'Gabon'),
('GM', 'Gambie'),
('GE', 'Géorgie'),
('GS', 'Géorgie du sud et les îles Sandwich du sud'),
('GH', 'Ghana'),
('GI', 'Gibraltar'),
('GR', 'Grèce'),
('GD', 'Grenade'),
('GL', 'Groenland'),
('GP', 'Guadeloupe'),
('GU', 'Guam'),
('GT', 'Guatemala'),
('GG', 'Guernesey'),
('GN', 'Guinée'),
('GW', 'Guinée-Bissau'),
('GQ', 'Guinée équatoriale'),
('GY', 'Guyana'),
('GF', 'Guyane française'),
('HT', 'Haïti'),
('HM', 'Heard, Ile et MacDonald, îles'),
('HN', 'Honduras'),
('HK', 'Hong Kong'),
('HU', 'Hongrie'),
('IM', 'Île de Man'),
('UM', 'Îles mineures éloignées des Etats-Unis'),
('VG', 'Îles vierges britanniques'),
('VI', 'Îles vierges des Etats-Unis'),
('IN', 'Inde'),
('IO', 'Indien (Territoire britannique de l''océan)'),
('ID', 'Indonésie'),
('IR', 'Iran, République islamique d'''),
('IQ', 'Iraq'),
('IE', 'Irlande'),
('IS', 'Islande'),
('IL', 'Israël'),
('IT', 'Italie'),
('JM', 'Jamaïque'),
('JP', 'Japon'),
('JE', 'Jersey'),
('JO', 'Jordanie'),
('KZ', 'Kazakhstan'),
('KE', 'Kenya'),
('KG', 'Kirghizistan'),
('KI', 'Kiribati'),
('KW', 'Koweït'),
('LA', 'Lao, République démocratique populaire'),
('LS', 'Lesotho'),
('LV', 'Lettonie'),
('LB', 'Liban'),
('LR', 'Libéria'),
('LY', 'Libye'),
('LI', 'Liechtenstein'),
('LT', 'Lituanie'),
('LU', 'Luxembourg'),
('MO', 'Macao'),
('MK', 'Macédoine, l''ex-République yougoslave de'),
('MG', 'Madagascar'),
('MY', 'Malaisie'),
('MW', 'Malawi'),
('MV', 'Maldives'),
('ML', 'Mali'),
('MT', 'Malte'),
('MP', 'Mariannes du nord, Iles'),
('MA', 'Maroc'),
('MH', 'Marshall, Iles'),
('MQ', 'Martinique'),
('MU', 'Maurice'),
('MR', 'Mauritanie'),
('YT', 'Mayotte'),
('MX', 'Mexique'),
('FM', 'Micronésie, Etats Fédérés de'),
('MD', 'Moldova, République de'),
('MC', 'Monaco'),
('MN', 'Mongolie'),
('ME', 'Monténégro'),
('MS', 'Montserrat'),
('MZ', 'Mozambique'),
('MM', 'Myanmar'),
('NA', 'Namibie'),
('NR', 'Nauru'),
('NP', 'Népal'),
('NI', 'Nicaragua'),
('NE', 'Niger'),
('NG', 'Nigéria'),
('NU', 'Niue'),
('NF', 'Norfolk, Ile'),
('NO', 'Norvège'),
('NC', 'Nouvelle-Calédonie'),
('NZ', 'Nouvelle-Zélande'),
('OM', 'Oman'),
('UG', 'Ouganda'),
('UZ', 'Ouzbékistan'),
('PK', 'Pakistan'),
('PW', 'Palaos'),
('PS', 'Palestine, Etat de'),
('PA', 'Panama'),
('PG', 'Papouasie-Nouvelle-Guinée'),
('PY', 'Paraguay'),
('NL', 'Pays-Bas'),
('XX', 'Pays inconnu'),
('ZZ', 'Pays multiples'),
('PE', 'Pérou'),
('PH', 'Philippines'),
('PN', 'Pitcairn'),
('PL', 'Pologne'),
('PF', 'Polynésie française'),
('PR', 'Porto Rico'),
('PT', 'Portugal'),
('QA', 'Qatar'),
('SY', 'République arabe syrienne'),
('CF', 'République centrafricaine'),
('RE', 'Réunion'),
('RO', 'Roumanie'),
('GB', 'Royaume-Uni de Grande-Bretagne et d''Irlande du Nord'),
('RU', 'Russie, Fédération de'),
('RW', 'Rwanda'),
('EH', 'Sahara occidental'),
('BL', 'Saint-Barthélemy'),
('KN', 'Saint-Kitts-et-Nevis'),
('SM', 'Saint-Marin'),
('MF', 'Saint-Martin (partie française)'),
('SX', 'Saint-Martin (partie néerlandaise)'),
('PM', 'Saint-Pierre-et-Miquelon'),
('VA', 'Saint-Siège'),
('VC', 'Saint-Vincent-et-les-Grenadines'),
('SH', 'Sainte-Hélène, Ascension et Tristan da Cunha'),
('LC', 'Sainte-Lucie'),
('SB', 'Salomon, Iles'),
('WS', 'Samoa'),
('AS', 'Samoa américaines'),
('ST', 'Sao Tomé-et-Principe'),
('SN', 'Sénégal'),
('RS', 'Serbie'),
('SC', 'Seychelles'),
('SL', 'Sierra Leone'),
('SG', 'Singapour'),
('SK', 'Slovaquie'),
('SI', 'Slovénie'),
('SO', 'Somalie'),
('SD', 'Soudan'),
('SS', 'Soudan du Sud'),
('LK', 'Sri Lanka'),
('SE', 'Suède'),
('CH', 'Suisse'),
('SR', 'Suriname'),
('SJ', 'Svalbard et île Jan Mayen'),
('SZ', 'Swaziland'),
('TJ', 'Tadjikistan'),
('TW', 'Taïwan, Province de Chine'),
('TZ', 'Tanzanie, République unie de'),
('TD', 'Tchad'),
('CS', 'Tchécoslovaquie'),
('CZ', 'Tchèque, République'),
('TF', 'Terres australes françaises'),
('TH', 'Thaïlande'),
('TL', 'Timor-Leste'),
('TG', 'Togo'),
('TK', 'Tokelau'),
('TO', 'Tonga'),
('TT', 'Trinité-et-Tobago'),
('TN', 'Tunisie'),
('TM', 'Turkménistan'),
('TC', 'Turks-et-Caïcos (Îles)'),
('TR', 'Turquie'),
('TV', 'Tuvalu'),
('UA', 'Ukraine'),
('SU', 'URSS'),
('UY', 'Uruguay'),
('VU', 'Vanuatu'),
('VE', 'Venezuela (République bolivarienne du)'),
('VN', 'Viet Nam'),
('VD', 'Viet Nam (Sud)'),
('WF', 'Wallis et Futuna'),
('YE', 'Yémen'),
('YU', 'Yougoslavie'),
('ZR', 'Zaïre'),
('ZM', 'Zambie'),
('ZW', 'Zimbabwe');


INSERT INTO type_vehicule (code_type_vehicule, libelle_type_vehicule)
VALUES ('TV1', 'VP'),
       ('TV2', 'PICK-UP'),
       ('TV3', 'BUS'),
       ('TV4', 'CAMIONNETTE'),
       ('TV5', '4x4');


INSERT INTO type_energie (code_type_energie, libelle_type_energie)
VALUES ('ESSENCE', 'ESSENCE'),
       ('GASOIL', 'GASOIL'),
       ('ELECTRIQUE', 'ELECTRIQUE'),
       ('HYBRIDE', 'HYBRIDE');


INSERT INTO marque_vehicule (code_marque, libelle_marque)
VALUES 
    ('ALF', 'Alfa Romeo'),
    ('AST', 'Aston Martin'),
    ('AUD', 'Audi'),
    ('BEN', 'Bentley'),
    ('BMW', 'BMW'),
    ('CAD', 'Cadillac'),
    ('CHE', 'Chevrolet'),
    ('CIT', 'Citroën'),
    ('FIAT', 'Fiat'),
    ('FOR', 'Ford'),
    ('HON', 'Honda'),
    ('HYU', 'Hyundai'),
    ('JAG', 'Jaguar'),
    ('JEE', 'Jeep'),
    ('KIA', 'Kia'),
    ('LAN', 'Land Rover'),
    ('LEX', 'Lexus'),
    ('MAS', 'Maserati'),
    ('MAZ', 'Mazda'),
    ('MCL', 'McLaren'),
    ('MER', 'Mercedes'),
    ('MIN', 'MINI'),
    ('NISS', 'Nissan'),
    ('OPE', 'Opel'),
    ('POR', 'Porsche'),
    ('REN', 'Renault'),
    ('ROL', 'Rolls-Royce'),
    ('SSA', 'SSANGYONG'),
    ('SUB', 'Subaru'),
    ('TES', 'Tesla'),
    ('TOY', 'Toyota'),
    ('VOL', 'Volkswagen'),
    ('VOLV', 'Volvo');


INSERT INTO etat_vehicule (code_etat, libelle_etat)
VALUES 
    ('NEUF', 'NEUF'),
    ('USAGE', 'USAGÉ');



INSERT INTO lieu_stockage_vehicule (code_lieu_vh, libellle_lieu_vh,nombre_limite_stockage_vh)
VALUES ('PKN', 'pikine',50),
       ('CLB', 'colobane',100),
       ('LB6', 'liberté 6',200),
       ('HGY', 'hlm grand yoff',40);


   
    -- Insertion des données dans la table article_bon_entree
INSERT INTO article_bon_entree (identifiant_b_e, code_article_bon_entree, code_type_objet, libelle_article_bon_entree, quantite_entree, date_enregistrement, matricule_agent, code_corps_agent,code_lieu_vh)
VALUES 
    ('BESA202312011043210', 'Article 1', 'ARMES', 'TOYOTA-CAMRY-123456', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1','PKN'),
    ('BESM202312021143211', 'Article 1', 'VEHIC', 'FORD-MUSTANG-789012', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2','CLB'),
    ('BESM202312021143211', 'Article 2', 'VEHIC', 'FORD-ESCAPE-789013', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2','LB6'),
    ('BESG202312031243213', 'Article 1', 'ARMES', 'BMW-X5-345678', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3','HGY');



INSERT INTO vehicule (numero_serie, numero_immatriculation, identifiant_b_e, code_article_bon_entree, modele, code_etat, code_type_energie, code_pays, numero_carte_grise, date_mise_en_circulation, code_type_vehicule, code_marque)
VALUES 
    ('123456', 'ABC123', 'BESA202312011043210', 'Article 1', 'CAMRY', 'NEUF', 'ESSENCE', 'US', 'CG123', '2023-01-01', 'TV1', 'TOY'),
    ('789012', 'XYZ789', 'BESM202312021143211', 'Article 1', 'MUSTANG', 'NEUF', 'GASOIL', 'JP', 'CG789', '2023-02-02', 'TV2', 'FOR'),
    ('789013', 'XYZ789', 'BESM202312021143211', 'Article 2', 'ESCAPE', 'NEUF', 'GASOIL', 'JP', 'CG789', '2023-02-02', 'TV2', 'FOR'),
    ('345678', 'DEF345', 'BESG202312031243213', 'Article 1', 'X5', 'USAGE', 'HYBRIDE', 'FR', 'CG345', '2023-03-03', 'TV3', 'BMW');


INSERT INTO bon_pour (identifiant_b_p, description_b_p, numero_courriel_origine, date_courriel_origine, etat_b_p, object_courriel_origine, numero_arrive_d_l_f, date_arrive_d_l_f, observation_d_l_f, numero_arrive_b_l_m, date_arrive_b_l_m, observation_b_l_m, numero_arrive_section, date_arrive_section, observation_section, code_unite_douaniere, code_section, date_enregistrement, matricule_agent, code_corps_agent) 
VALUES 
    ('BPSG202311121243214', 'Description 1', 123, '2024-01-24', 'Initial', 'Objet 1', 456, '2024-01-25', 'Observation 1', 789, '2024-01-26', 'Observation 1', 101, '2024-01-27', 'Observation 1', '06Z', 'SG', CURRENT_TIMESTAMP, 'MAT001', 'CP1'),
    ('BPSG202311121243215', 'Description 2', 124, '2024-01-25', 'Initial', 'Objet 2', 457, '2024-01-26', 'Observation 1', 790, '2024-01-27', 'Observation 1', 102, '2024-01-28', 'Observation 1', '06Z', 'SG', CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    ('BPSG202311121243216', 'Description 3', 125, '2024-01-26', 'Initial', 'Objet 3', 458, '2024-01-27', 'Observation 1', 791, '2024-01-28', 'Observation 1', 103, '2024-01-29', 'Observation 1', '06K', 'SG', CURRENT_TIMESTAMP, 'MAT003', 'CP3');


INSERT INTO article_bon_pour (identifiant_b_p, code_article_bon_pour, libelle_article_bon_pour, quantite_demandee, code_type_objet, matricule_agent, code_corps_agent) 
VALUES 
    ('BPSG202311121243214', 'Article 1', 'libelle article 1', 10, 'VEHIC', 'MAT001', 'CP1'),
    ('BPSG202311121243215', 'Article 1', 'libelle article 1', 20, 'VEHIC', 'MAT002', 'CP2'),
    ('BPSG202311121243216', 'Article 1', 'libelle article 1', 30, 'VEHIC', 'MAT003', 'CP3');


INSERT INTO bon_de_sortie (identifiant_b_s, numero_b_s, description_b_s, date_b_s, identifiant_b_p, matricule_agent, code_corps_agent) 
VALUES 
    ('BSSG202311121243214', 'BS001', 'Description BS1', '2024-01-24',  'BPSG202311121243214', 'MAT001', 'CP1'),
    ('BSSG202311121243215', 'BS002', 'Description BS2', '2024-01-25',  'BPSG202311121243215', 'MAT002', 'CP2'),
    ('BSSG202311121243216', 'BS003', 'Description BS3', '2024-01-26',  'BPSG202311121243216', 'MAT003', 'CP3');


INSERT INTO article_bon_sortie (identifiant_b_s, code_article_bon_sortie, libelle_article_bon_sortie, quantite_accordee, date_article_bon_sortie, matricule_agent, code_corps_agent) 
VALUES 
    ('BSSG202311121243214', 'Article 1', 'Article BS1', 5, '2024-01-24', 'MAT001', 'CP1'),
    ('BSSG202311121243215', 'Article 1', 'Article BS2', 10, '2024-01-25', 'MAT002', 'CP2'),
    ('BSSG202311121243216', 'Article 1', 'Article BS3', 15, '2024-01-26', 'MAT003', 'CP3');


INSERT INTO dotation_vehicule ( identifiant_d_v, date_dotation, identifiant_b_s, code_article_bon_sortie, matricule_agent, code_corps_agent)  
VALUES 
    ('DVSG202311121243214', '2024-01-24', 'BSSG202311121243214', 'Article 1', 'MAT001', 'CP1'),
    ('DVSG202311121243215', '2024-01-23', 'BSSG202311121243215', 'Article 1', 'MAT002', 'CP2'),
    ('DVSG202311121243216', '2024-01-22', 'BSSG202311121243216', 'Article 1', 'MAT003', 'CP3');



INSERT INTO dotation_vehicule_vehicule ( numero_serie, identifiant_d_v)  
VALUES 
    ( '123456', 'DVSG202311121243214'),
    ( '789012', 'DVSG202311121243215'),
    ( '789013', 'DVSG202311121243216');
