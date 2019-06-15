/*CREATE TABLE logCarti (Data varchar(10), Ora int,Minut int,TipOperatie char(1),NumeTabel char(20),NrRanduriAfectate int);*/

CREATE TABLE Invitati (id smallint,nume char(20),varsta smallint,idCort smallint);
CREATE TABLE Corturi (id smallint,nume char(20),capMax smallint,idCatering smallint);
CREATE TABLE Formatii (id smallint,nume char(20),gen char(20),onorariu smallint,oraStart datetime,oraEnd datetime,idCort smallint);
CREATE TABLE FirmeCatering (id smallint,nume char(20),adresa char(20),vegetarian smallint);

INSERT INTO Invitati VALUES (1,'Nume1',10,1),(2,'Nume2',11,1),(3,'Nume3',9,2),(4,'Nume4',10,2),(5,'Nume5',11,1);
INSERT INTO Corturi VALUES (1,'Cort1',10,1),(2,'Cort2',5,2);
INSERT INTO FirmeCatering VALUES (1,'Firma1','Adresa1',1),(2,'Firma2','Adresa2',0);
INSERT INTO Formatii VALUES (1,'Formatie1','Gen1',300,(getdate()-1),(getdate()+1),1),(2,'Formatie2','Gen2',1000,(getdate()-2),(getdate()+2),2),(3,'Formatie1','Gen1',31000,(getdate()-3),(getdate()+3),2),(4,'Formatie2','Gen2',11000,(getdate()-4),(getdate()+3),1);

--Ex2(a) - un VIEW care sa arate numele corturilor ale caror concerte costa peste 40000
CREATE VIEW tempVIEW AS
SELECT a.nume,SUM(b.onorariu) onorariuTotal FROM Corturi a
INNER JOIN Formatii b ON
b.idCort = a.id
GROUP BY a.nume
HAVING SUM(b.onorariu) > 40000

SELECT * FROM tempVIEW

--Ex2(b) Functie care returneaza toate numerele corturilor unde au fost programate cel putin C concerte (C>=1) si care servesc sau nu meniu vegetarian

ALTER FUNCTION ufVerCort (@nrConcerete smallint,@vegetarian smallint)
RETURNS NVARCHAR(300) AS
BEGIN
	DECLARE @rez NVARCHAR(300);

	IF(@nrConcerete < 1)
		SET @rez = CONCAT(@rez,'Nr. de concerte trebuie sa fie pozitiv; ');
		
	IF(@vegetarian != 1 AND @vegetarian != 0)
		SET @rez = CONCAT(@rez,'Vegetarian trebuie sa fie 0 sau 1;');

	IF(LEN(@rez) > 0) RETURN @rez;

CREATE VIEW tempView2 AS
SELECT nume FROM 
(SELECT a.nume,COUNT(b.idCort) nrConcerte,SUM(c.vegetarian) vegetarian FROM Corturi a
INNER JOIN Formatii b ON
b.idCort = a.id
INNER JOIN FirmeCatering c ON
c.id = a.idCatering
GROUP BY a.nume,b.idCort) AS TEMP
WHERE nrConcerte >= @nrConcerete AND vegetarian >= @vegetarian

DECLARE cursorTemp CURSOR FOR
SELECT a.nume FROM tempView2 a;

DECLARE @temp smallint;
OPEN cursorTemp
FETCH NEXT FROM cursorTemp INTO @temp;
WHILE @@FETCH_STATUS = 0  
BEGIN 
	SET @rez += @temp;
	FETCH NEXT FROM cursorTemp INTO @temp;
END

CLOSE cursorTemp
DEALLOCATE cursorTemp

RETURN @rez;

END;

PRINT ([dbo].ufVerCort(1,5));