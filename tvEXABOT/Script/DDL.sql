PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS ExoBot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS IABot;

CREATE TABLE CatalogoTipo (
    idCatalogoTipo     INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre             VARCHAR(30) NOT NULL UNIQUE,
    Descripcion        VARCHAR(90) NOT NULL,
    Estado             VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion      DATETIME DEFAULT (datetime('now','localtime')),
    FechaModificacion  DATETIME
);

CREATE TABLE Catalogo (
    idCatalogo         INTEGER PRIMARY KEY AUTOINCREMENT,
    idCatalogoTipo     INTEGER NOT NULL,
    Nombre             VARCHAR(30) NOT NULL,
    Descripcion        VARCHAR(90) NOT NULL,
    Estado             VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion      DATETIME DEFAULT (datetime('now','localtime')),
    FechaModificacion  DATETIME,
    FOREIGN KEY (idCatalogoTipo) REFERENCES CatalogoTipo(idCatalogoTipo)
);

CREATE TABLE IABot (
    idIABot            INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre             VARCHAR(30) NOT NULL,
    Descripcion        VARCHAR(90) NOT NULL,
    Observacion        TEXT,
    FechaCreacion      DATETIME DEFAULT (datetime('now','localtime')),
    FechaModificacion  DATETIME
);

CREATE TABLE ExoBot (
    idExoBot           INTEGER PRIMARY KEY AUTOINCREMENT,
    idIABot            INTEGER NOT NULL,
    Nombre             TEXT NOT NULL,
    Serie              TEXT NOT NULL,
    FOREIGN KEY (idIABot) REFERENCES IABot(idIABot)
);

CREATE TABLE Persona (
    idPersona               INTEGER PRIMARY KEY AUTOINCREMENT,
    idCatalogoTipoPersona   INTEGER NOT NULL,
    idCatalogoSexo          INTEGER NOT NULL,
    idCatalogoEstadoCivil   INTEGER NOT NULL,
    Cedula                  TEXT NOT NULL UNIQUE,
    Nombre                  TEXT NOT NULL,
    Apellido                TEXT NOT NULL,
    Estado                  VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion           DATETIME DEFAULT (datetime('now','localtime')),
    FechaModifica           DATETIME,
    FOREIGN KEY (IdCatalogoTipoPersona) REFERENCES Catalogo(idCatalogo),
    FOREIGN KEY (IdCatalogoSexo)        REFERENCES Catalogo(idCatalogo),
    FOREIGN KEY (IdCatalogoEstadoCivil) REFERENCES Catalogo(idCatalogo)
);