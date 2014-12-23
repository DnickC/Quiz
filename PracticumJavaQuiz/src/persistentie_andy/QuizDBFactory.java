package persistentie_andy;

public class QuizDBFactory {
	// Singleton
	private static QuizDBFactory instance = null;
	public static QuizDBFactory getInstance(){
		if(instance == null){
			// Lazy loading
			instance = new QuizDBFactory();
		}
		return instance;
	}
	
	// Constructor
	private QuizDBFactory(){
		
	}
	
	public QuizDB MaakDB( String type ) throws Exception{
		switch(
				(type == null)? "" : type.toUpperCase()
				){
			case "TEXT":
			{
				QuizDB db = new TextQuizDB();
				db.Laden();
				return db;
			}
			case "DERBY":
			default:
			{
				QuizDB db = new DerbyQuizDB();
				db.Laden();
				return db;
			}
		}
	}
	
	
	
}
