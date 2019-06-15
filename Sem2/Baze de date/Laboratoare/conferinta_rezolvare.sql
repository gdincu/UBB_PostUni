-- Tabelele existente
SELECT name 'Nume Tabel' FROM sys.all_objects WHERE type_desc = 'USER_TABLE' AND object_id > 0

--Ex1
SELECT a.nume,a.prenume,COUNT(b.idParticipant) FROM Participanti a
INNER JOIN Prezentari b ON
b.idParticipant = a.id
GROUP BY a.nume,a.prenume,b.idParticipant
HAVING COUNT(b.idParticipant) >= 2;

--Ex2
SELECT a.nume,a.prenume FROM Autori a
INNER JOIN Participanti b ON
b.nume = a.nume AND b.prenume = a.prenume

--Ex3
SELECT a.nume,a.prenume FROM Autori a
WHERE CONCAT(a.nume,a.prenume) NOT IN (SELECT DISTINCT CONCAT(b.nume,b.prenume) FROM Participanti b)

--Ex4
CREATE VIEW artToDel AS
SELECT a.idArticol,a.titlu FROM Articole a
WHERE a.idArticol NOT IN (SELECT b.idArticol FROM Prezentari b)

SELECT * FROM artToDel
DROP VIEW artToDel

--Ex5
SELECT AVG(a.nrPagini) nrMedPag FROM Articole a
INNER JOIN Prezentari b ON
b.idArticol = a.idArticol

--Ex6
SELECT COUNT(a.sala) nrPrezentari FROM Program a
WHERE a.ora >= 10 AND a.sala = '2/I'

--Ex7
SELECT DISTINCT a.taxaParticipare,COUNT(a.taxaParticipare) FROM Participanti a
GROUP BY a.taxaParticipare

--Ex8
SELECT taxaParticipare,suma FROM (SELECT DISTINCT a.taxaParticipare,COUNT(a.taxaParticipare)*a.taxaParticipare suma FROM Participanti a
GROUP BY a.taxaParticipare) AS TEMP
WHERE suma > 800

--Ex9
SELECT a.nume,a.prenume,COUNT(b.idAutor) FROM Autori a
INNER JOIN AutoriArticole b ON
b.idAutor = a.id
INNER JOIN Articole c ON
c.idArticol = b.idArticol
GROUP BY a.nume,a.prenume,b.idAutor
HAVING min(c.nrPagini) >= 10 AND count(b.idAutor) > 1


SELECT * FROM
(SELECT DISTINCT a.nume,a.prenume,COUNT(b.idAutor) nrArticole FROM Autori a
INNER JOIN AutoriArticole b ON
b.idAutor = a.id
INNER JOIN Articole c ON
c.idArticol = b.idArticol
WHERE c.nrPagini >= 10
GROUP BY a.nume,a.prenume) AS TEMP
WHERE nrArticole > 1

--Ex10
SELECT DISTINCT a.idArticol,a.titlu,a.nrPagini FROM Articole a
INNER JOIN AutoriArticole b ON
b.idArticol = a.idArticol
INNER JOIN Autori c ON
c.id = b.idAutor
WHERE a.nrPagini > ANY (SELECT a.nrPagini FROM Articole a
INNER JOIN AutoriArticole b ON
b.idArticol = a.idArticol
INNER JOIN Autori c ON
c.id = b.idAutor
WHERE c.nume = 'Cionta')
ORDER BY a.idArticol

--Ex11
SELECT DISTINCT a.nume,b.sala,COUNT(b.sala) FROM Locatii a
INNER JOIN Program b ON
b.idLocatie = a.id
GROUP BY a.nume,b.sala

--Ex12
SELECT idParticipant,nrPrezentari FROM 
(SELECT a.id idParticipant,COUNT(b.idParticipant) nrPrezentari FROM Participanti a
INNER JOIN Prezentari b ON
b.idParticipant = a.id
GROUP BY a.id,b.idParticipant) AS TEMP
WHERE nrPrezentari > (SELECT MAX(nrPrezentari) FROM (SELECT DISTINCT a.id,COUNT(b.idParticipant) nrPrezentari FROM Participanti a
INNER JOIN Prezentari b ON
b.idParticipant = a.id
WHERE a.taxaParticipare = (SELECT MAX(a.taxaParticipare) FROM Participanti a)
GROUP BY a.id,b.idParticipant) AS TEMP)

SELECT a.id,COUNT(b.idParticipant) nrPrezentari FROM Participanti a
INNER JOIN Prezentari b ON
b.idParticipant = a.id
GROUP BY a.id,b.idParticipant
HAVING COUNT(b.idParticipant) > (	
								SELECT MAX(nrPr) FROM (
								SELECT COUNT(c.id) nrPr FROM Participanti c
								INNER JOIN Prezentari d ON
								d.idParticipant = c.id
								GROUP BY c.taxaParticipare,c.id
								HAVING c.taxaParticipare = (SELECT DISTINCT MAX(taxaParticipare) FROM Participanti)
								)AS TEMP);

--Ex13
SELECT a.id,a.nume,a.prenume,COUNT(b.idParticipant) nrPrezentari FROM Participanti a
INNER JOIN Prezentari b ON
b.idParticipant = a.id
GROUP BY a.id,a.nume,a.prenume, b.idParticipant
HAVING COUNT(b.idParticipant) > (	
								SELECT MAX(nrPr) FROM (
								SELECT COUNT(c.id) nrPr FROM Participanti c
								INNER JOIN Prezentari d ON
								d.idParticipant = c.id
								GROUP BY c.taxaParticipare,c.id
								HAVING c.taxaParticipare = (SELECT DISTINCT MAX(taxaParticipare) FROM Participanti)
								)AS TEMP);
