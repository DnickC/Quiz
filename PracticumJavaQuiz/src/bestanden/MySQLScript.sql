DROP TABLE TBLQuizOpdracht;
DROP TABLE TBLOpdrachten;
DROP TABLE TBLQuiz;

CREATE TABLE TBLOpdrachten(
	OpdrachtID int NOT NULL,
	Vraag varchar(500) NOT NULL,
	Antwoorden varchar(500),
	JuisteAntwoord varchar(250) NOT NULL,
	MaxAantalPogingen int,
	MaxAntwoordTijd int,
	AntwoordHints varchar(250),
	Trefwoorden varchar(150),
	MinAantalTrefwoorden int,
	Vraagtype varchar(20) NOT NULL,
	Auteur varchar(50) NOT NULL,
	Categorie varchar(50) NOT NULL,
	AanmaakDatum varchar(12),
primary key (OpdrachtID)
);


CREATE TABLE TBLQuiz(
	QuizID int,
	Onderwerp varchar(50) NOT NULL,
	Leerjaar int,
	IsTest varchar(6),
	UniekeDeelname varchar(6),
	Auteur varchar(50) NOT NULL,
	Status varchar(25) NOT NULL,
	registratieDatum varchar(12),
primary key(QuizID)
);


CREATE TABLE TBLQuizOpdracht( 
	OpdrachtID int, 
	QuizID int,
	MaxScore int, 
primary key (OpdrachtID, QuizID)
);

ALTER TABLE TBLQuizOpdracht
ADD FOREIGN KEY (OpdrachtID) 
REFERENCES TBLOpdrachten(OpdrachtID);


ALTER TABLE TBLQuizOpdracht
ADD FOREIGN KEY (QuizID) 
REFERENCES TBLQuiz(QuizID);


Select * 
From TBLOPDRACHTEN

INSERT INTO TBLQuiz (QuizID,Onderwerp,Leerjaar,IsTest,UniekeDeelname,Auteur,Status,registratieDatum) VALUES (10,'Onderwerpen',1,true,true,'LeraarA','opengesteld','28/12/2014')
INSERT INTO TBLOpdrachten(OpdrachtID,Vraag,Antwoorden,JuisteAntwoord,MaxAantalPogingen,MaxAntwoordTijd,AntwoordHints,Trefwoorden,MinAantalTrefwoorden,Vraagtype,Auteur,Categorie,AanmaakDatum)  VALUES( 1,'vraag','juisteAntwoord',4,20,'hint','standaard','LeraarD','Aardrijkskunde','02/09/2012')