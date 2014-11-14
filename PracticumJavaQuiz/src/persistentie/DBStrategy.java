package persistentie;

public interface DBStrategy {

	void vulCatalogi();

	void saveCatalogi();
	
	void setStrategy(String strategy);

}
