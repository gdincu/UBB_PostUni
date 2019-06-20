/*Script SQL ce creeaza un model relational pentru a reprezenta datele
-------------------------------------------------------------------------------------------*/

CREATE TABLE Invitati (
id int primary key,
nume char(50),
varsta int,
cort int,
constraint FK_Cort foreign key(cort) references Corturi(id)
)

CREATE TABLE Corturi (
id int primary key,
capMax int,
firmaCatering int,
constraint FK_firmaCatering foreign key(firmaCatering) references FirmeCatering(id)
)

CREATE TABLE Formatii (
id int primary key,
nume char(50),
gen char(50),
cost int
)

CREATE TABLE FormatieCort (
idCort int,
idFormatie int,
primary key(idCort,idFormatie),
constraint FK_idCort foreign key (idCort) references Corturi(id),
constraint FK_idFormatie foreign key (idFormatie) references Formatii(id)
)

CREATE TABLE FirmeCatering (
id int primary key,
nume char(50),
adresa char(50),
vegetarian smallint
)


/*Proceduri stocate ce insereaza date random in toate tabelele
-------------------------------------------------------------------------------------------*/

--Procedura ce insereaza in tabelul Invitati
CREATE PROCEDURE uspInsereazaInvitati (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @max int = (select max(id) from Corturi);
	DECLARE @min int = (select min(id) from Corturi);

	DECLARE @tempId int = 1;
	DECLARE @tempNume char(50) = 'Invitat ';
	DECLARE @tempVarsta int = cast(  round( (45 - 18)*rand()+18,0) as integer);
	DECLARE @tempCort int = cast(  round( (@max - @min)*rand()+@min,0) as integer);

	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Invitati VALUES (@tempId,CONCAT(LEFT(@tempNume,LEN(@tempNume)),@tempId),@tempVarsta,@tempCort);
		SET @tempId += 1;
		SET @tempVarsta = cast(  round( (45 - 18)*rand()+18,0) as integer);
		SET @tempCort = cast(  round( (@max - @min)*rand()+@min,0) as integer);
	END
GO
EXEC uspInsereazaInvitati 100;

--Procedura ce insereaza in tabelul Corturi
CREATE PROCEDURE uspInsereazaCorturi (@nrRanduri int)
AS
	SET NOCOUNT ON;

	DECLARE @max int = (select max(id) from FirmeCatering);
	DECLARE @min int = (select min(id) from FirmeCatering);

	DECLARE @tempId int = 1;
	DECLARE @tempCapMax int = cast(  round( (250 - 100)*rand()+100,0) as integer);
	DECLARE @tempFirmaCatering int = cast(  round( (@max - @min)*rand()+@min,0) as integer);

	WHILE @tempId <= @nrRanduri
	BEGIN
		INSERT INTO Corturi VALUES (@tempId,@tempCapMax,@tempFirmaCatering);
		SET @tempId += 1;
		SET @tempCapMax = cast(  round( (250 - 100)*rand()+100,0) as integer);
		SET @tempFirmaCatering = cast(  round( (@max - @min)*rand()+@min,0) as integer);
	END
GO
EXEC uspInsereazaCorturi 15;

--Procedura ce insereaza in tabelul FormatieCort
ALTER PROCEDURE uspInsereazaFormatieCort (@nrRanduri int)
AS

SET NOCOUNT ON;

	DECLARE @maxCort int = (select max(id) from Corturi);
	DECLARE @minCort int = (select min(id) from Corturi);
	DECLARE @maxFormatie int = (select max(id) from Corturi);
	DECLARE @minFormatie int = (select min(id) from Corturi);

DECLARE @tempidCort int = cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);
DECLARE @tempidFormatie	int = cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);

	DECLARE @tempId int = 1;

	WHILE @tempId <= @nrRanduri
	BEGIN

	BEGIN TRY
		INSERT INTO FormatieCort VALUES (@tempidCort,@tempidFormatie);
	END TRY
	BEGIN CATCH
		SET @tempidCort = cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);
		SET @tempidFormatie	= cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);
		INSERT INTO FormatieCort VALUES (@tempidCort,@tempidFormatie);
	END CATCH
	
		SET @tempId += 1;
		SET @tempidCort = cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);
		SET @tempidFormatie	= cast(  round( (@maxCort - @minCort)*rand()+@minCort,0) as integer);
	END	
GO

--Inserare valori
WHILE( (SELECT COUNT(*) FROM FormatieCort) < 100 )
		EXEC [dbo].uspInsereazaFormatieCort 1		
SELECT COUNT(*) FROM FormatieCort
SELECT * FROM FormatieCort
DELETE FROM FormatieCort

--Procedura ce insereaza in tabelul cu formatii
CREATE PROCEDURE uspInsereazaFormatii (@nrRanduri int)
AS
	SET NOCOUNT ON;

	DECLARE @tempId int = 1;
	DECLARE @tempNume char(50) = 'Formatia ';
	DECLARE @tempGen char(50) = 'Genul ';
	DECLARE @tempCost int = 0;

	WHILE @tempId <= @nrRanduri
	BEGIN

		INSERT INTO Formatii VALUES (@tempId,CONCAT(LEFT(@tempNume,LEN(@tempNume)),@tempId),CONCAT(LEFT(@tempGen,LEN(@tempGen)),@tempId),@tempCost);
		
		SET @tempId += 1;
		SET @tempCost = round(RAND()*10 + 35,0);

	END
GO
--Inserare valori
EXEC uspInsereazaFormatieCort 20;

--Procedura ce insereaza in tabelul cu firme de catering
CREATE PROCEDURE uspInsereazaFirmeCatering (@nrRanduri int)
AS
	SET NOCOUNT ON;

	DECLARE @index int = 0;
	DECLARE @tempId int = 1;
	DECLARE @tempNume char(50) = 'Firma ';
	DECLARE @tempAdresa char(50) = 'Adresa ';
	DECLARE @tempVegetarian smallint = 1;

	WHILE @index < @nrRanduri
	BEGIN
		
		INSERT INTO FirmeCatering VALUES (@tempId,CONCAT(LEFT(@tempNume,LEN(@tempNume)),@tempId),CONCAT(LEFT(@tempAdresa,LEN(@tempAdresa)),@tempId),@tempVegetarian);
		
		SET @index += 1;
		SET @tempId += 1;
		SET @tempVegetarian = round(RAND()*1 + 1,0);
	END
GO
--Inserare valori
[dbo].uspInsereazaFirmeCatering 30;

/*View ce afiseaza numele corturilor ale caror concerte o costa pe Izabela peste 200 lei
-------------------------------------------------------------------------------------------*/
CREATE VIEW tempVIEW AS
SELECT a.id "id Cort",SUM(c.cost) "Cost Total" FROM Corturi a
INNER JOIN FormatieCort b ON
b.idCort = a.id
INNER JOIN Formatii c ON
c.id = b.idFormatie
GROUP BY a.id
HAVING SUM(c.cost) > 200;

SELECT * FROM tempVIEW

/*Functie ce returneaza toate id Corturilor in care sunt cel putin C concerte C>=1 si care servesc/sau nu meniu vegetarian)
-------------------------------------------------------------------------------------------*/
CREATE FUNCTION tempFunction (@nrConcerte int, @vegetarian int)
RETURNS TABLE AS
RETURN
SELECT a.id "id Cort",COUNT(b.idCort) "Nr Concerte" FROM Corturi a
INNER JOIN FormatieCort b ON
b.idCort = a.id
INNER JOIN FirmeCatering c ON
c.id = a.firmaCatering
GROUP BY a.id,c.vegetarian
HAVING COUNT(b.idCort) >= @nrConcerte AND c.vegetarian = @vegetarian;

SELECT * FROM tempFunction(2,2);