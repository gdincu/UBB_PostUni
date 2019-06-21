--ex1
CREATE TABLE Cantaret (
id int primary key,
nume char(50),
tara char(50)
)

CREATE TABLE Album (
id int primary key,
titlu char(50),
dataLansare datetime,
casaDiscuri char(50)
)

CREATE TABLE Cantec (
id int primary key,
titlu char(50),
durata int
)

CREATE TABLE CantecCantaret (
idCantec int primary key,
idCantaret int,
constraint FK_idCantec foreign key (idCantec) references Cantec(id),
constraint FK_idCantaret foreign key (idCantaret) references Cantaret(id)
)

CREATE TABLE Concert (
id int primary key,
locatie char(50),
data datetime,
ora int
)

CREATE TABLE ConcertCantaret (
idConcert int primary key,
idCantaret int,
constraint FK_idConcert foreign key (idConcert) references Concert(id),
constraint FK_idCantaret1 foreign key (idCantaret) references Cantaret(id)
)

CREATE TABLE AlbumCantec (
idAlbum int,
idCantec int,
constraint FK_idAlbum foreign key (idAlbum) references Album(id),
constraint FK_idCantec1 foreign key (idCantec) references Cantec(id)
)

--ex2
--Procedura de inserare in Album
CREATE PROCEDURE uspInsereazaAlbum (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	DECLARE @tempTitlu char(50) = 'Titlu ';
	DECLARE @dataLansare datetime = (getdate() - cast(  round( (365 - 7)*rand()+7,0) as integer)); 
	DECLARE @tempcasaDiscuri char(50) = 'Casa Discuri ';

	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Album VALUES (@tempId,CONCAT(LEFT(@tempTitlu,LEN(@tempTitlu)),@tempId),@dataLansare,CONCAT(LEFT(@tempcasaDiscuri,LEN(@tempcasaDiscuri)),@tempId));
		SET @tempId += 1;
		SET @dataLansare = (getdate() - cast(  round( (365 - 7)*rand()+7,0) as integer));
	END
GO
EXEC uspInsereazaAlbum 100;


/*CREATE TABLE AlbumCantec (
idAlbum int,
idCantec int,
constraint FK_idAlbum foreign key (idAlbum) references Album(id),
constraint FK_idCantec1 foreign key (idCantec) references Cantec(id)
)*/

--Procedura de inserare in AlbumCantec
CREATE PROCEDURE uspInsereazaAlbumCantec (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	
	DECLARE @maxIdAlbum int = (select max(id) from Album);
	DECLARE @minIdAlbum int = (select min(id) from Album);
	DECLARE @maxIdCantec int = (select max(id) from Cantec);
	DECLARE @minIdCantec int = (select min(id) from Cantec);

	DECLARE @tempIdAlbum int = cast(  round( (@maxIdAlbum - @minIdAlbum)*rand()+@minIdAlbum,0) as integer);
	DECLARE @tempIdCantec int = cast(  round( (@maxIdCantec - @minIdCantec)*rand()+@minIdCantec,0) as integer);
	
	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO AlbumCantec VALUES (@tempIdAlbum,@tempIdCantec);
		SET @tempId += 1;
		SET @tempIdAlbum = cast(  round( (@maxIdAlbum - @minIdAlbum)*rand()+@minIdAlbum,0) as integer);
		SET @tempIdCantec = cast(  round( (@maxIdCantec - @minIdCantec)*rand()+@minIdCantec,0) as integer);
	END
GO

--Inserare valori
WHILE( (SELECT COUNT(*) FROM AlbumCantec) < 100 )
		EXEC uspInsereazaAlbumCantec 1	

--Procedura de inserare in Cantaret
CREATE PROCEDURE uspInsereazaCantaret (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	DECLARE @tempNume char(50) = 'Cantaret ';
	DECLARE @tempTara char(50) = 'Tara ';

	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Cantaret VALUES (@tempId,CONCAT(LEFT(@tempNume,LEN(@tempNume)),@tempId),CONCAT(LEFT(@tempTara,LEN(@tempTara)),@tempId));
		SET @tempId += 1;
	END
GO
EXEC uspInsereazaCantaret 100;

--Procedura de inserare in Cantec
ALTER PROCEDURE uspInsereazaCantec (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	DECLARE @tempNume char(50) = 'Titlu ';
	DECLARE @tempDurata int = cast(  round( (6 - 2)*rand()+2,0) as integer);

	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Cantec VALUES (@tempId,CONCAT(LEFT(@tempNume,LEN(@tempNume)),@tempId),@tempDurata);
		SET @tempId += 1;
		SET @tempDurata = cast(  round( (6 - 2)*rand()+2,0) as integer);
	END
GO
EXEC uspInsereazaCantec 100;

--Procedura de inserare in Concert
CREATE PROCEDURE uspInsereazaConcert (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	DECLARE @tempLocatie char(50) = 'Locatie ';
	DECLARE @tempData datetime = (getdate() - cast(  round( (365 - 7)*rand()+7,0) as integer));
	DECLARE @tempOra int = cast(  round( (24 - 0)*rand(),0) as integer);


	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Concert VALUES (@tempId,CONCAT(LEFT(@tempLocatie,LEN(@tempLocatie)),@tempId),@tempData,@tempOra);
		SET @tempId += 1;
		SET @tempData = (getdate() - cast(  round( (365 - 7)*rand()+7,0) as integer));
		SET @tempOra = cast(  round( (24 - 0)*rand(),0) as integer);
	END
GO
EXEC uspInsereazaConcert 100;


--Procedura de inserare in ConcertCantaret
CREATE PROCEDURE uspInsereazaConcertCantaret (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @tempId int = 1;

	DECLARE @maxIdConcert int = (select max(id) from Concert);
	DECLARE @minIdConcert int = (select min(id) from Concert);
	DECLARE @maxIdCantaret int = (select max(id) from Cantaret);
	DECLARE @minIdCantaret int = (select min(id) from Cantaret);

	DECLARE @tempIdConcert int = cast(  round( (@maxIdConcert - @minIdConcert)*rand()+@minIdConcert,0) as integer);
	DECLARE @tempIdCantaret int = cast(  round( (@maxIdCantaret - @minIdCantaret)*rand()+@minIdCantaret,0) as integer);


	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO ConcertCantaret VALUES (@tempIdConcert,@tempIdCantaret);
		SET @tempId += 1;
		SET @tempIdConcert = cast(  round( (@maxIdConcert - @minIdConcert)*rand()+@minIdConcert,0) as integer);
		SET @tempIdCantaret = cast(  round( (@maxIdCantaret - @minIdCantaret)*rand()+@minIdCantaret,0) as integer);
	END
GO


--Inserare valori
WHILE( (SELECT COUNT(*) FROM ConcertCantaret) < 100 )
		EXEC uspInsereazaConcertCantaret 1	


--ex3
SELECT a.nume FROM Cantaret a
INNER JOIN ConcertCantaret b ON
b.idCantaret = a.id
INNER JOIN Concert c ON
c.id = b.idConcert
WHERE c.locatie = 'Sala Polivalenta'
AND a.tara = 'Germania';

--ex4
SELECT a.locatie "Locatie",COUNT(a.locatie) "Nr Concerte" FROM Concert a
GROUP BY a.locatie
HAVING COUNT(a.locatie) >= 3;