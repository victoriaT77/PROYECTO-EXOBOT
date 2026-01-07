-- CATALOGO TIPO
--------------------------------------------------
INSERT INTO CatalogoTipo (Nombre, Descripcion) VALUES
('Tipo Persona',  'Tipos sol, meca,...'),
('Sexo',          'Masculino, Femenino,...'),
('Estado Civil',  'Soltero, Casado, Viudo, Divorciado...'),
('Raza',          'Blanca, Negra, Indigena,...');

--------------------------------------------------
-- CATALOGO
--------------------------------------------------
INSERT INTO Catalogo (idCatalogoTipo, Nombre, Descripcion) VALUES
(1, 'Soldado',      'Tipos de persona para el ejercito'),
(1, 'Mecanico',     'Tipos de persona para mecanica'),
(1, 'Exp Ing.',     'Tipos de persona para ingenieria'),
(1, 'Experto Esp',  'Tipos de persona para estudio'),

(2, 'Masculino',    'Tipo de sexo'),
(2, 'Femenino',     'Tipo de sexo'),
(2, 'Asexual',      'Tipo de sexo'),
(2, 'Hibrido',      'Tipo de sexo'),

(3, 'Soltero',      'Estado civil ecuatoriano'),
(3, 'Casado',       'Estado civil ecuatoriano'),
(3, 'Viudo',        'Estado civil ecuatoriano'),
(3, 'Divorciado',   'Estado civil ecuatoriano'),

(4, 'Blanca',       'Tipo de raza'),
(4, 'Negra',        'Tipo de raza'),
(4, 'Mestiza',      'Tipo de raza'),
(4, 'Indigena',     'Tipo de raza');

--------------------------------------------------
-- IA BOT
--------------------------------------------------
INSERT INTO IABot (Nombre, Descripcion, Observacion) VALUES
('IA-RUSO', 'Inteligencia artificial', 'IA de control');

--------------------------------------------------
-- EXO BOT
--------------------------------------------------
INSERT INTO ExoBot (IdIABot, Nombre, Serie) VALUES
(1, 'exabot1', 'SERIE-001'),
(1, 'exabot2', 'SERIE-002');


INSERT INTO Persona
(idCatalogoTipoPersona, idCatalogoSexo, idCatalogoEstadoCivil, Cedula, Nombre, Apellido)
VALUES
(1, 6, 9,  '0102030405', 'Juan',  'Perez'),
(2, 5, 10, '0203040506', 'Maria', 'Lopez'),
(3, 5, 11, '0304050607', 'Ana',   'Gomez'),
(4, 6, 12, '0405060708', 'Luis',  'Martinez'),
(1, 6, 9,  '0506070809', 'Pepe',  'Ramirez');


