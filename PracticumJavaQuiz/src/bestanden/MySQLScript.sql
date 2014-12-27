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
	AanmaakDatum DATE,
primary key (OpdrachtID)
);


CREATE TABLE TBLQuiz(
	QuizID int,
	Onderwerp varchar(50) NOT NULL,
	Leerjaar int,
	IsTest boolean,
	UniekeDeelname boolean,
	Auteur varchar(50) NOT NULL,
	Status varchar(25) NOT NULL,
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


