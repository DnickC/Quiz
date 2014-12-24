DROP TABLE TBLOpdrachten
DROP TABLE TBLQuiz
DROP TABLE QuizOpdracht




CREATE TABLE TBLOpdrachten(
	OpdrachtID int NOT NULL,
	Vraag varchar(50) NOT NULL,
	Antwoorden varchar(50),
	JuisteAntwoord varchar(50) NOT NULL,
	MaxAantalPogingen int NOT NULL,
	MaxAntwoordTijd int NOT NULL,
	AntwoordHints varchar(150) NOT NULL,
	Trefwoorden varchar(150),
	MinAantalTrefwoorden int,
	Vraagtype varchar(20) NOT NULL,
	Auteur int NOT NULL,
	Categorie varchar(25) NOT NULL,
	AanmaakDatum DATE,
	QuizOpdracht varchar(),
primary key (OpdrachtID)
)


CREATE TABLE TBLQuiz(
	QuizID int NOT NULL,
	Onderwerp varchar(50) NOT NULL,
	leerjaar int NOT NULL,
	IsTest boolean NOT NULL,
	UniekeDeelname boolean NOT NULL,
	Auteur varchar(50) NOT NULL,
	status varchar(25) NOT NULL,
primary key(QuizID)
)


CREATE TABLE TBLQuizOpdracht( 
	OpdrachtID int NOT NULL, 
	QuizID varchar() NOT NULL,
	MaxScore int NOT NULL, 
primary key (OpdrachtID)
)

