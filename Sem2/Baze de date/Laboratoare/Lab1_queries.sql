/*Ex2 ------------------------------------------*/

SELECT	* 
FROM	Carti a 
WHERE	a.Titlu = 'Festinul ciori'
		AND a.GenId = 3;

UPDATE	Carti
SET		Limba = 'Germana'
WHERE	Titlu = 'Festinul ciori'
		AND GenId = 3;

DELETE FROM Carti 
WHERE		Titlu = 'Festinul ciori'
			AND GenId = 3;

INSERT INTO Carti
VALUES		(4,'Festinul ciori',3,1999,'Romana',1,1);

/*Ex3 ------------------------------------------*/
-- a. o interogare cu operatia de reuniune: cu UNION [ALL] sau OR;
------------------------------------------------------------------
SELECT a.Nume FROM Autori a WHERE a.AutorId IN (
	SELECT b.AutorId FROM AutorCarte b
	UNION
	SELECT c.AnPublicatie FROM Carti c
	);

SELECT		* 
FROM		Autori 
WHERE		AnNastere < 1960
			OR AnNastere >= 1992;
------------------------------------------------------------------
--b. o interogare cu operatia de intersectie: cu INTERSECT sau IN;
------------------------------------------------------------------
SELECT A.CarteId FROM Carti A
INTERSECT
SELECT B.CarteId FROM AutorCarte B
------------------------------------------------------------------
--c. o interogare cu operatia de diferenta: cu EXCEPT sau NOT IN;
------------------------------------------------------------------
SELECT A.AnNastere FROM Autori A
EXCEPT
SELECT B.AnPublicatie FROM Carti B
------------------------------------------------------------------
--d. o interogare cu INNER JOIN si o interogare cu unul dintre operatorii: LEFT JOIN, RIGHT JOIN, FULL JOIN; una dintre interogari va extrage date din trei tabele aflate in relatie many-to-many;
------------------------------------------------------------------
SELECT		a.Nume,
			COUNT(b.AutorId) AS nrCarti
FROM		Autori a
INNER JOIN	AutorCarte b 
ON			b.AutorId = a.AutorId
GROUP BY	a.Nume,b.AutorId;

SELECT		a.Titlu,
			b.CuloareCoperta 
FROM		Carti a
LEFT JOIN   PreturiCoperta b
ON			b.CopertaId = a.CopertaId
GROUP BY	b.CuloareCoperta,
			a.Titlu;
------------------------------------------------------------------
--o interogare care contine o subinterogare in clauza WHERE: cu IN sau EXISTS
------------------------------------------------------------------
SELECT		* 
FROM		Carti a
WHERE		a.Limba IN (
						SELECT	b.Limba
						FROM	Carti b
						WHERE b.AnPublicatie > 1940
						)
------------------------------------------------------------------
--o interogare care contine o subinterogare in clauza FROM;
------------------------------------------------------------------
SELECT		temp.Limba, 
			sum(temp.nrCarti)
FROM		(SELECT		c.Limba,
						a.Nume numeAutor,
						COUNT(c.Limba) nrCarti 
			FROM		Autori a
			INNER JOIN	AutorCarte b 
			ON			b.AutorId = a.AutorId
			INNER JOIN	Carti c 
			ON			c.CarteId = b.CarteId
			GROUP BY	c.Limba,a.Nume
			) temp
GROUP BY	temp.Limba;
------------------------------------------------------------------
--2 interogari cu clauza GROUP BY; una dintre ele va contine si clauza HAVING; se vor folosi cel putin 2 operatori de agregare dintre: COUNT, SUM, AVG, MIN, MAX
------------------------------------------------------------------
SELECT d.Nume numeEditura ,COUNT(a.Nume) nrCarti FROM Autori a
INNER JOIN AutorCarte b ON
b.AutorId = a.AutorId
INNER JOIN Carti c ON
c.CarteId = b.CarteId
INNER JOIN Edituri d ON
d.EdituraId = c.EdituraId
GROUP BY d.Nume,a.Nume
HAVING a.Nume = 'George R R. Martin';
------------------------------------------------------------------
o interogare imbricata cu unul dintre operatorii ANY sau ALL, unde operatorul relational este
din multimea {=, <, <=, >, >=, <>}.
In interogarile de mai sus se vor folosi cel putin o data:
•  expresii aritmetice in clauza SELECT;
•  DISTINCT;
•  ORDER BY;
•  TOP
------------------------------------------------------------------
SELECT top 2 * FROM Carti a
WHERE a.AnPublicatie != ANY (SELECT b.AnNastere FROM Autori b)

SELECT top 2 * FROM Carti a
WHERE a.AnPublicatie = ALL (SELECT b.AnNastere FROM Autori b)
------------------------------------------------------------------
--VIEW
------------------------------------------------------------------
CREATE VIEW tempView AS
SELECT d.Nume numeEditura ,COUNT(a.Nume) nrCarti FROM Autori a
INNER JOIN AutorCarte b ON
b.AutorId = a.AutorId
INNER JOIN Carti c ON
c.CarteId = b.CarteId
INNER JOIN Edituri d ON
d.EdituraId = c.EdituraId
GROUP BY d.Nume,a.Nume
HAVING a.Nume = 'George R R. Martin';

SELECT * FROM tempView;

DROP VIEW tempView;