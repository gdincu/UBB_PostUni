create table Autori(
	id int primary key,
	nume varchar(20),
	prenume varchar(20),
	email varchar(50)
)

create table Articole(
	idArticol int primary key,
	titlu varchar(100),
	nrPagini int
)

create table AutoriArticole(
	idAutor int,
	idArticol int,
	primary key(idAutor,idArticol),
	constraint FK_Autor foreign key(idAutor) references Autori(id),
	constraint FK_Articol foreign key(idArticol) references Articole(idArticol)
)

create table Participanti(
	id int primary key,
	nume varchar(20),
	prenume varchar(20),
	taxaParticipare int
)

create table Prezentari(
	idArticol int primary key,
	idParticipant int,
	constraint FK_Articol2 foreign key(idArticol) references Articole(idArticol),
	constraint FK_Participant foreign key(idParticipant) references Participanti(id)
)

create table Locatii(
	id int primary key,
	nume varchar(50),
	adresa varchar(100)
)

create table Program(
	idLocatie int,
	sala varchar(10),
	ziua int,
	ora int,
	idArticol int,
	primary key(idLocatie,sala,ziua,ora),
	constraint FK_Locatie foreign key(idLocatie) references Locatii(id),
	constraint FK_Articol3 foreign key(idArticol) references Prezentari(idArticol)
)