//package persistentie;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Formatter;
//import java.util.List;
//import java.util.Scanner;
//
//import model.Opdracht;
//import model.OpdrachtCatalogus;
//import model.Quiz;
//import model.QuizCatalogus;
//import model.QuizOpdracht;
//
//public class TXTStrategy {
//	
//	private TXTTemplate template;
//	
//	private Formatter output;
//	private PrintWriter writer;
//	
//	private OpdrachtCatalogus oC;
//	private QuizCatalogus qC;
//	private QuizOpdracht qO;
//	
//	private List<Opdracht> opdrachten;
//	private List<Quiz> quizzen;
//	private List<QuizOpdracht> quizOpdrachten;
//	
//	private List<Object> objecten;
//	
//	
//	@Override
//	public void leesOpdrachten() {
//		template.leesFile(opdrachtTxt);
//	}	
//
//	@Override
//	public void schrijfOpdrachten(OpdrachtCatalogus oC) {
//		this.oC = oC;
//		this.opdrachten = oC.getCatalogus();
//		
//        try {
//        	output = new Formatter(opdrachtTxt);
//								
//			for (Opdracht opdracht : opdrachten) {
//				//String lijn = "" + opdracht.getID() + opdracht.getVraag() + opdracht.ge
//			}
//				
//				
//				
//			if (output!=null) {
//				output.close();
//			}
//				
//				
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void leesQuizzen() {
//		template.leesFile(quizTxt);
//	}
//
//	@Override
//	public void schrijfQuizzen(QuizCatalogus qC) {
//		this.qC = qC;
//		this.quizzen = qC.getCatalogus();
//
//		
//		try {
//			writer = new PrintWriter(quizTxt);
//			
//			for (Quiz q : quizzen) {
//				String lijn = "" + 
//				   q.getQuizID() + q.getOnderwerp() + 
//				   q.getLeerjaar() + q.getIsTest() + 
//				   q.getIsUniekeDeelname() + q.getQuizStatus();
//				writer.append(lijn);
//			}
//			
//			if (writer != null) {
//				writer.close();
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
//	@Override
//	public void leesQuizOpdrachten() {
//		template.leesFile(quizOpdrachtTxt);
//	}
//
//	@Override
//	public void schrijfQuizOpdrachten(QuizOpdracht qO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setStrategy(String strategy) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
