/*Lab2 - Ex1*/
-- Functie verificare an nastere
CREATE FUNCTION ufVerificaAnNastere (@an smallint) 
RETURNS smallint AS
BEGIN
	DECLARE @rez smallint;
	IF( (@an > 1900) AND (@an <= YEAR(GETDATE())) )
		SET @rez = @an;
		ELSE 
		SET @rez = 2019;
	
	RETURN @rez;
END;

-- Functie de verificare a locatiei unei edituri
ALTER FUNCTION ufVerificaLocatia (@Loc char(30))
RETURNS char(30) AS
BEGIN
	DECLARE @rez char(30);
	IF( @Loc = '')
		SET @rez = 'Trebuie Setata';
		ELSE
		SET @rez = @Loc;

	RETURN @rez;
END;

--Testare functie
PRINT [dbo].ufVerificaAnNastere(1899);
PRINT [dbo].ufVerificaAnNastere(1999);
PRINT [dbo].ufVerificaLocatia('');
PRINT [dbo].ufVerificaLocatia('SSa');

-- Procedura inserare in 2 tabele
ALTER PROCEDURE uspInsereazaAutorEditura 
(@Nume char(20), @AnNastere smallint, @Nume2 char(30), @Locatie char(30))
AS
	DECLARE @maxIdAutor smallint, @maxIdEditura smallint;
	SET @maxIdAutor = (SELECT max(a.AutorId) FROM Autori a) + 1;
	SET @maxIdEditura = (SELECT max(b.EdituraId) FROM Edituri b) + 1;

	IF( (@Nume = '') AND (@Nume2 = ''))
	RETURN;

	IF( (@Nume = '') AND (@Nume2 != ''))
		INSERT INTO Edituri VALUES(@maxIdEditura,@Nume2,[dbo].ufVerificaLocatia(@Locatie));

	IF( (@Nume != '') AND (@Nume2 = ''))
		INSERT INTO Autori VALUES(@maxIdAutor,@Nume,[dbo].ufVerificaAnNastere(@AnNastere));

	IF( (@Nume != '') AND (@Nume2 != ''))
	BEGIN
	INSERT INTO Autori VALUES(@maxIdAutor,@Nume,[dbo].ufVerificaAnNastere(@AnNastere));
	INSERT INTO Edituri VALUES(@maxIdEditura,@Nume2,@Locatie);
	END
GO



--Testare procedura
[dbo].uspInsereazaAutorEditura 'AutorTest',2000,'EdituraTest','LocatieTest';
DELETE FROM Edituri WHERE EdituraId = 9;
DELETE FROM Autori WHERE AutorId = 10;
[dbo].uspInsereazaAutorEditura 'AutorTemp',0,'EdituraTEst',''
SELECT * FROM Autori
SELECT * FROM Edituri


/*Lab2 - Ex2*/
ALTER VIEW tempView AS
SELECT DISTINCT TOP(SELECT COUNT(*) FROM Carti) a.Titlu Titlu, c.Nume Autor, a.AnPublicatie 'An Publicatie', a.Limba, d.NumeCoperta 'Tip Coperta', d.Pret Pret, e.Descriere Gen  FROM Carti a
INNER JOIN AutorCarte b ON
a.CarteId = b.CarteId
INNER JOIN Autori c ON
c.AutorId = b.AutorId
INNER JOIN PreturiCoperta d ON
d.CopertaId = a.CopertaId
INNER JOIN Genuri e ON
e.GenId = a.GenId
ORDER BY 'An Publicatie'

SELECT * FROM tempView

--Afiseaza toate cartile scrise in romana si publicate din 1995 pana in prezent
SELECT * FROM tempView a WHERE a.[An Publicatie] >= 1995 AND a.Limba = 'romana';
--Afiseaza titlurile si autorii cartilor cu coperta brosata, pret mai mic de 100 de ron si gen = 'Science Fiction'
SELECT * FROM tempView a WHERE a.Pret < 100 AND a.Gen = 'Science Fiction' AND [Tip Coperta] = 'Cartonata';

/*Lab2 - Ex3*/
--Creare tabel pentru loggarea evenimentelor
CREATE TABLE logCarti (Data varchar(10), Ora int,Minut int,TipOperatie char(1),NumeTabel char(20),NrRanduriAfectate int);

--Trigger General
CREATE TRIGGER utCarti
ON Carti
FOR INSERT, UPDATE, DELETE
AS
DECLARE @Date varchar(10) = CONVERT(VARCHAR(10), getdate(), 111);
DECLARE @Ora int = DATEPART(HOUR, GETDATE());
DECLARE @Minut int = DATEPART(MINUTE, GETDATE());
DECLARE @CountInserted int = (SELECT COUNT(*) FROM inserted);
DECLARE @CountDeleted int = (SELECT COUNT(*) FROM deleted);

IF((@CountInserted > 0) AND (@CountDeleted = 0))
	INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'I','Carti',@CountInserted);

IF((@CountInserted = 0) AND (@CountDeleted > 0))
	INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'D','Carti',@CountDeleted);

IF((@CountInserted > 0) AND (@CountDeleted = 0))
	INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'U','Carti',@CountInserted);

--Test Trigger
INSERT INTO Carti VALUES (102,'Test',1,2000,'Romana',8,2);
UPDATE Carti SET AnPublicatie = 2007 WHERE CarteId IN (1,2);

SELECT * FROM logCarti;

--Trigger Insert
CREATE TRIGGER utCartiInsert
ON Carti
FOR INSERT
AS 
DECLARE @Date varchar(10) = CONVERT(VARCHAR(10), getdate(), 111);
DECLARE @Ora int = DATEPART(HOUR, GETDATE());
DECLARE @Minut int = DATEPART(MINUTE, GETDATE());
DECLARE @Count int = (SELECT COUNT(*) FROM inserted);
--rowcount
INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'I','Carti',@Count);

--Trigger Delete
CREATE TRIGGER utCartiDelete
ON Carti
FOR DELETE
AS 
DECLARE @Date varchar(10) = CONVERT(VARCHAR(10), getdate(), 111);
DECLARE @Ora int = DATEPART(HOUR, GETDATE());
DECLARE @Minut int = DATEPART(MINUTE, GETDATE());
DECLARE @Count int = (SELECT COUNT(*) FROM deleted);
INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'D','Carti',@Count);

--Trigger Update
CREATE TRIGGER utCartiUpdate
ON Carti
FOR UPDATE
AS 
DECLARE @Date varchar(10) = CONVERT(VARCHAR(10), getdate(), 111);
DECLARE @Ora int = DATEPART(HOUR, GETDATE());
DECLARE @Minut int = DATEPART(MINUTE, GETDATE());
DECLARE @Count int = (SELECT COUNT(*) FROM deleted);
INSERT INTO logCarti VALUES(@Date,@Ora,@Minut,'U','Carti',@Count);

--Testare triggere
SELECT * FROM logCarti;
SELECT * FROM Carti;
DELETE FROM Carti WHERE CarteId >= 100;
INSERT INTO Carti VALUES (100,'TitluCarte',2,2000,'Romana',2,2), (101,'TitluCarte2',1,2000,'Romana',1,1);
UPDATE Carti SET AnPublicatie = 2200 WHERE CarteId IN (1,2);

/*Lab2 - Ex4*/
ALTER PROCEDURE schimbaAn (@An smallint)
AS
 IF(@An % 2 = 0 )
 UPDATE Carti SET AnPublicatie += 1 WHERE AnPublicatie = @An;
GO

--Afiseaza starea curenta a tabelului 'Carti'
SELECT * FROM Carti

--Cursor pentru a schimba toti anii pari din Carti in ani impari
DECLARE cursorTemp CURSOR FOR
SELECT a.AnPublicatie FROM Carti a;

DECLARE @temp smallint;
OPEN cursorTemp
FETCH NEXT FROM cursorTemp INTO @temp;
WHILE @@FETCH_STATUS = 0  
BEGIN 
	EXEC schimbaAn @temp;
	FETCH NEXT FROM cursorTemp INTO @temp;
END

CLOSE cursorTemp
DEALLOCATE cursorTemp

--Acelasi efect fara cursor
UPDATE Carti SET AnPublicatie += 1 WHERE (AnPublicatie % 2 != 0)
SELECT * FROM Carti


--Extra

-- Cartea cu nr max de Autori
select max(C.temp1) from (select c.Titlu, count(a.AutorId) as temp1 from Carti c
inner join AutorCarte ac on c.CarteId = ac.CarteId
inner join Autori a on a.AutorId = ac.AutorId
group by c.Titlu) C


--o interogare care contine o subinterogare in clauza FROM;
select TOP 3 TEMP.Titlu from (
select a.Titlu, c.Pret from Carti a
inner join PreturiCoperta c on a.CopertaId = c.CopertaId
) AS TEMP

-- Returns all table names, columns and data types for each column ordered by table names
SELECT b.name tableName,a.name colName,c.name dataType FROM sys.columns a 
INNER join sys.all_objects b on
a.object_id = b.object_id
INNER JOIN sys.types c on
a.system_type_id = c.system_type_id
WHERE b.type_desc = 'USER_TABLE'
ORDER BY tableName

-- Returns all 'user tables'
SELECT a.name FROM sys.all_objects a WHERE a.type_desc = 'USER_TABLE'
