--Crearea TabelA
create table TabelA(
coda int primary key,
a2 int unique,
a3 int
)

--Crearea TabelC
create table TabelC(
codc int primary key,
coda int,
constraint FK_coda foreign key(coda) references TabelA(coda)
)

--Procedura de inserare in TabelA
CREATE PROCEDURE uspInsereazaTabelA (@nrRanduri int)
AS
	DECLARE @coda int = 1;
	DECLARE @a2 int = 2;
	DECLARE @a3 int = 3;;
	DECLARE @i int = 0;
	
	WHILE(@i<@nrRanduri)
		BEGIN
		INSERT INTO TabelA VALUES (@coda,@a2,@a3);
		SET @coda += 1;
		SET @a2 += 1;
		SET @a3 += 1;
		SET @i += 1;
		END;
GO

--Procedura de inserare in TabelC
ALTER PROCEDURE uspInsereazaTabelC (@nrRanduri bigint)
AS
	SET NOCOUNT ON;
	DECLARE @codc int = 1;
	--coda sa fie intre 1 si 5000 - valorile lui coda din TabelA
	DECLARE @coda int = (CAST((RAND() * (5000 - 1)) + 1 AS INT));
	DECLARE @i bigint = 0;
	
		WHILE(@i<@nrRanduri)
		BEGIN
		INSERT INTO TabelC VALUES (@codc,@coda);
		SET @codc += 1;
		SET @coda = (CAST((RAND() * (5000 - 1)) + 1 AS INT));
		SET @i += 1;
		END;
GO

--Inserarea valorilor in cele 2 tabele
[dbo].uspInsereazaTabelA 5000;
[dbo].uspInsereazaTabelC 30000;

--Ex1
/*-----------------------------------------------------------------------------------------------------
Verificati indecsii existenti pe tabelul Ta. Scrieti doua interogari SELECT pe tabelul Ta ale caror
planuri de executie sa contina operatorii clustered index seek si nonclustered index seek.
-----------------------------------------------------------------------------------------------------*/

--Returneaza indecsii existenti pe tabelul Ta
SELECT * FROM sys.indexes a, sys.all_objects b
WHERE a.object_id = b.object_id
AND b.name = 'TabelA';
--SAU
EXECUTE sp_helpindex TabelA

/*Setarea unei primary key creaza automat un index clustered pe coloana respectiva
Setarea unei foreign key creaza automat un index non-clustered pe coloana respectiva*/

--SELECT al carui plan de executie contine operatorii clustered index seek.
SELECT * FROM TabelA
ORDER BY coda

--SELECT al carui plan de executie contine operatorii nonclustered index seek.
SELECT a2 FROM TabelA

--Exemple creare indecsi
CREATE NONCLUSTERED INDEX indName ON TableA a(a.coda);
CREATE CLUSTERED INDEX indName ON TableA a(a.coda);

--Ex2
/*-----------------------------------------------------------------------------------------------------
SELECT pe Ta cu o clauza de forma WHERE a3 = valoare + analiza planul de executie.
Creati un index nonclustered pe coloana a3 util pentru interogare.
Evidentiati schimbarile din planul de executie: operatori, estimated subtree cost pe SELECT
-----------------------------------------------------------------------------------------------------*/
CREATE NONCLUSTERED INDEX indTemp ON TabelA(a3);
DROP INDEX indTemp ON TabelA;

SELECT * FROM TabelA
WHERE a3 = 2000;

--Fara index - 100% pe clustered index din TabelA. Estimated subtree pe SELECT 0.0176709
--Cu index - 50% pe non-clustered din TabelA si 50% pe Clustered din TabelA. Estimated subtree pe SELECT 0.0065704 (x2.69 mai rapid)

--Ex2
/*-----------------------------------------------------------------------------------------------------
Scrieti o interogare SELECT cu INNER JOIN intre Tc si Ta (cheie externa = cheie primara) si o filtrare de forma coloana utilizata in JOIN = valoare. 
Analizati planul de executie. 
Creati un index nonclustered pe coloana care este cheie externa in Tc si analizati din nou planul de executie.
-----------------------------------------------------------------------------------------------------*/
CREATE NONCLUSTERED INDEX indTemp ON TabelC(coda);
DROP INDEX indTemp ON TabelC;

SELECT a.coda,c.codc FROM TabelC c
INNER JOIN TabelA a ON
a.coda = c.coda
WHERE a.coda = 2000;

--Fara index -> 3% pe index clustered din TabelA, 82% pe index clustered din TabelC si 14% pe inner join. Estimated subtree pe SELECT 0.100659
--Cu index -> 50% pe clustered in TabelA, 50% pe non-clustered in TabelC. Estimated subtree pe SELECT 0.0065991 (x15.25 mai rapid)