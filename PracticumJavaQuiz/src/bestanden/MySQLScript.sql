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
	Categorie varchar(25) NOT NULL,
	Vraagtype varchar(20) NOT NULL,
	Auteur int NOT NULL,
	AanmaakDatum DATE NOT NULL,
primary key (OpdrachtID)
)

