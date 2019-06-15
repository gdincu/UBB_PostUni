CREATE TABLE Autori (
AutorId smallint primary key,
Nume char(20),
AnNastere smallint
)

CREATE TABLE Genuri (
GenId smallint primary key,
Nume char(30),
Descriere char(30)
)

CREATE TABLE Edituri (
EdituraId smallint primary key,
Nume char(30),
Locatie char(30)
)

CREATE TABLE PreturiCoperta (
CopertaId smallint primary key,
NumeCoperta char(10),
CuloareCoperta char(10),
Pret smallint
)

CREATE TABLE StocCurent (
StocId smallint primary key,
CarteId smallint,
DataCurenta date,
StocDisponibil smallint
)

CREATE TABLE Carti (
CarteId smallint primary key,
Titlu char(30),
GenId smallint,
AnPublicatie smallint,
Limba char(30),
EdituraId smallint,
CopertaId smallint
)

CREATE TABLE AutorCarte (
AutorId smallint,
CarteId smallint,
primary key(AutorId,CarteId),
constraint FK_Autor foreign key(AutorId) references Autori(AutorId),
constraint FK_Carte foreign key(CarteId) references Carti(CarteId)
)