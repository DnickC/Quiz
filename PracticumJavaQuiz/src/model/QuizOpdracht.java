package model;

public class QuizOpdracht {
	/**
	 * authors :
	 * version 1.0
	 * version 1.1, 22/11/2014; author Jens Van Kets; setters en getters onderwerp en maximumScore toegevoegd
	 */
	
	//private String onderwerp;
	private Quiz quiz;
	private Opdracht opdracht;
	private int maximumScore;
	//private List <QuizOpdracht> quizOpdrachten;
	
//	public QuizOpdracht (String onderwerp, int maximumScore){
//		this.onderwerp = onderwerp;
//		this.maximumScore = maximumScore;
//		quizOpdrachten = new ArrayList<QuizOpdracht>();
//	}
	
	public QuizOpdracht(Quiz quiz, Opdracht opdracht, int maxScore) {
		this.quiz = quiz;
		this.opdracht = opdracht;
		this.maximumScore = maxScore;
	}
//	
	public static void koppelOpdrachtAanQuiz(Quiz quiz, Opdracht opdracht, int maxScore) {
		QuizOpdracht quizOpdracht = new QuizOpdracht(quiz, opdracht, maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
	}
	
	public void ontKoppelOpdrachtVanQuiz(){
		quiz.verwijderQuizOpdracht(this);
		opdracht.verwijderQuizOpdracht(this);
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public Opdracht getOpdracht() {
		return opdracht;
	}	

//	public void setOnderwerp(String onderwerp) {
//		this.onderwerp = onderwerp;
//	}
//	
//	public String getOnderwerp() {
//		return this.onderwerp;
//	}
//	
//	public void setMaximumScore(int maximumScore) {
//		this.maximumScore = maximumScore;
//	}
//	
	public int getMaximumScore() {
		return this.maximumScore;
	}
//	
//	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht){
//		quizOpdrachten.add(quizOpdracht);
//	}
//	
//	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht){
//		quizOpdrachten.remove(quizOpdracht);
//	}
//	
//	public ArrayList <QuizOpdracht> getOpdrachten(){
//		ArrayList <QuizOpdracht> opdrachten = new ArrayList <QuizOpdracht>();
//		int volgnummer = 0;
//		for (QuizOpdracht quizOpdracht :quizOpdrachten){
//			opdrachten.add(quizOpdracht.getOpdracht(volgnummer));
//			volgnummer ++;
//		}
//		return opdrachten;
//	}
//	
//	public QuizOpdracht getOpdracht(int volgnr){
//		return quizOpdrachten.get(volgnr-1);
//	}
}
