--Update AnPublicatie from Carti using a CURSOR
SET NOCOUNT ON;

DECLARE		@toDel as smallint = 0;
DECLARE		@pos as smallint;
DECLARE		@temp as smallint;

DECLARE		cursorTemp CURSOR LOCAL  FORWARD_ONLY  
FOR			SELECT	a.CarteId,a.AnPublicatie
			FROM	Carti a;
	
OPEN			cursorTemp
FETCH NEXT FROM cursorTemp 
INTO			@pos,@temp

WHILE			@@FETCH_STATUS = 0
BEGIN 
	SET			@toDel += 1;

	UPDATE		Carti 
	SET			AnPublicatie = @temp - @toDel
	WHERE		CarteId = @pos
				AND AnPublicatie = @temp
	
	FETCH		NEXT FROM cursorTemp 
	INTO		@pos,@temp
END

CLOSE cursorTemp
DEALLOCATE cursorTemp

--Order Carti by Year
SELECT a.AnPublicatie,COUNT(a.AnPublicatie) nrCarti FROM Carti a
GROUP BY a.AnPublicatie
ORDER BY a.AnPublicatie

/*---------------------------------------------------------
Function to return the number of characters and spaces based on the data type
functionName(inputValue,dataType)
---------------------------------------------------------*/
CREATE FUNCTION ufGetNrOfCharacters(	@InputStr	varchar(8000),  --general purpose value
											@Type char(30))				--Data Type
RETURNS varchar(8000) AS
BEGIN  
	DECLARE @ReturnValue  varchar(8000) = 'Error'

    IF LOWER(@Type)='char'
		BEGIN
		SET @ReturnValue = CONCAT('Ignoring spaces: ',LEN(@InputStr));
        RETURN @ReturnValue;
		END

		IF LOWER(@Type)='varchar'
		BEGIN
		SET @ReturnValue = CONCAT('Ignoring spaces: ',LEN(@InputStr),CHAR(10),'With spaces: ',DATALENGTH(@InputStr),' - ',(DATALENGTH(@InputStr) - LEN(@InputStr)),' space(s)');
		RETURN @ReturnValue;
		END

		IF LOWER(@Type)='nvarchar'
		BEGIN
		SET @ReturnValue = CONCAT('Ignoring spaces: ',LEN(@InputStr),' ',CHAR(10),'With spaces: ',DATALENGTH(@InputStr),' - ',(DATALENGTH(@InputStr) - LEN(@InputStr)),' space(s)');
		RETURN @ReturnValue;
		END	  

RETURN @ReturnValue;
END;

/*---------------------------------------------------------
Testing the function
---------------------------------------------------------*/
DECLARE @temp char(10) = 'Sal '
PRINT [dbo].ufGetNrOfCharacters(@temp,'char')

DECLARE @temp varchar(10) = 'Sal '
PRINT [dbo].ufGetNrOfCharacters(@temp,'varchar')

DECLARE @temp nvarchar(10) = 'Sal '
PRINT [dbo].ufGetNrOfCharacters(@temp,'nvarchar')