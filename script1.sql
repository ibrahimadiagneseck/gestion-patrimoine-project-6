-------------------------------------------------------------------------------------------------------------------------
INSERT INTO "authorities" ("authority_id", "code", "name")
VALUES ('1', 'ADMIN', 'ADMINISTRATEUR'), ('2', 'CSA', 'CHEF SECTION ARMEMENT'), ('3', 'ASA', 'AGENT SECTION ARMEMENT'),
       ('4', 'CSG', 'CHEF SECTION GARAGE'), ('5', 'ASG', 'AGENT SECTION GARAGE'), ('6', 'CSM', 'CHEF SECTION MATÉRIEL'),
       ('7', 'ASM', 'AGENT SECTION MATÉRIEL'), ('8', 'BLM', 'CHEF BLM'), ('9', 'DLF', 'DIRECTEUR DLF');

-------------------------------------------------------------------------------------------------------------------------

CREATE TABLE corps_agent (
    code_corps_agent VARCHAR(3),
    libelle_corps_agent VARCHAR(100),
    PRIMARY KEY (code_corps_agent)
);


INSERT INTO corps_agent (code_corps_agent, libelle_corps_agent)
VALUES ('CP1', 'Corps 1'),
       ('CP2', 'Corps 2'),
       ('CP3', 'Corps 3');


-------------------------------------------------------------------------------------------------------------------------

CREATE TABLE sections (
    code_section VARCHAR(3),
    libelle_section VARCHAR(100),
    PRIMARY KEY (code_section)
);

INSERT INTO sections (code_section, libelle_section)
VALUES 
    ('SA', 'SECTION ARMEMENT'),
    ('SM', 'SECTION MATERIEL'),
    ('SG', 'SECTION GARAGE');

-------------------------------------------------------------------------------------------------------------------------

CREATE TABLE type_unite_douaniere (
    code_type_unite_douaniere VARCHAR(5),
    libelle_type_unite_douaniere VARCHAR(100),
    PRIMARY KEY (code_type_unite_douaniere)
);


INSERT INTO type_unite_douaniere (code_type_unite_douaniere, libelle_type_unite_douaniere)
VALUES ('BUR', 'BUREAU CENTRAL'),
       ('BRI', 'BRIGADE MOBILE');

-------------------------------------------------------------------------------------------------------------------------

CREATE TABLE unite_douaniere (
    code_unite_douaniere VARCHAR(3),
    nom_unite_douaniere VARCHAR(255),
    effectif_unite_douaniere INT,
    nombre_arme INT,
    nombre_automobile INT,
    nombre_materiel INT,
    code_type_unite_douaniere VARCHAR(5),
    PRIMARY KEY (code_unite_douaniere),
    CONSTRAINT FK_unite_douaniere_type_unite_douaniere FOREIGN KEY (code_type_unite_douaniere) REFERENCES type_unite_douaniere(code_type_unite_douaniere)
);


INSERT INTO unite_douaniere (code_unite_douaniere, nom_unite_douaniere, effectif_unite_douaniere, nombre_arme, nombre_automobile, nombre_materiel, code_type_unite_douaniere)
VALUES 
    ('06K', 'BUREAU DE LA LOGISTIQUE ET DE LA MAINTENANCE', 10, 3, 5, 20, 'BUR'),
    ('06Z', 'BUREAU DE LA PROGRAMMATION ET DES FINANCES', 10, 3, 5, 20, 'BUR');


-------------------------------------------------------------------------------------------------------------------------

CREATE TABLE unite_douaniere_sections (
    code_unite_douaniere VARCHAR(3),
    code_section VARCHAR(3),
    PRIMARY KEY (code_unite_douaniere, code_section),
    CONSTRAINT FK_unite_douaniere_sections_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_unite_douaniere_sections_sections FOREIGN KEY (code_section) REFERENCES sections(code_section)
);

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



