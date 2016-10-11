import java.util.ArrayList;
import java.util.Scanner;


public class QuizMenu {

	private ArrayList<Question> questions;
	private Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		QuizMenu rm = new QuizMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 4);
		
	}
	
	public QuizMenu(){
		s = new Scanner(System.in);
		questions = new ArrayList<Question>();
	}
	
	public int startMenu(){
		System.out.println("Welcome to the Quiz Show!");
		System.out.println("1. Create a NEW Question");
		System.out.println("2. Display a list of questions that can be asked");
		System.out.println("3. Quiz SHOW TIME");
		System.out.println("4. EXIT");
		System.out.println("");
		System.out.println("Please select an option: ");
		int selection = s.nextInt();
		while(selection < 0 || selection > 4 || selection != (int)selection){
			System.out.println("Invalid selection, Try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection){
		if(selection == 1){ //create a new question
			createQuestion();
		}
		else if(selection == 2){ //Display questions that can be asked
			displayQuestions();
			
			//need to ask the question
		}
		else if(selection == 3){//Quiz time
			displayQuestions();
			Question r = selectQuestion();
			askQuestion(r);
		}
	}
	
	private void displayQuestions(){
		for(int i = 0; i < questions.size(); i++){
			System.out.println((i+1) + ".)" + questions.get(i).ToString());
		}
	}
	
	private Question selectQuestion(){
		System.out.println("Select a question to answer: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > questions.size() || selection != (int)selection){
			System.out.println("Invalid Selection: ");
			selection = s.nextInt();
		}
		return questions.get(selection-1);
	}
	
	private void askQuestion(Question q){
		System.out.println(q.getQuestion());
		if(q.getType() == false){
			String[] choice = q.getChoices();		
			for (int i = 0; i < 3; i++ ){
				System.out.println(choice[i]);
			}
		}
		String answer = s.next();
		boolean chkans = checkAnswer(q, answer);
		if ( chkans== true){
			System.out.println("You got it Right!!!!!!");
		}
		else{
			System.out.println("WRONG The Correct answer is: " + q.getAnswer());
		}
	}
	

	
	private void createQuestion(){
		String choice1 = "";
		String choice2 = "";
		String choice3 = "";
		System.out.println("What is your Question? ");
		String question = s.next();
		System.out.println("Is this a fill in the blank question? ");
		boolean isFillInBlank = s.nextBoolean();
		while(s.hasNext()){
			
		}
		s.nextBo
//		while(isFillInBlank != true || isFillInBlank != false){
//			System.out.println("Invalid Response");
//			isFillInBlank = s.nextBoolean();
//		}
		System.out.println("What is your question's answer? ");
		String answer = s.next();
		if (isFillInBlank == false){
			System.out.println("What is your first answer choice? ");
			choice1 = s.next();
			System.out.println("What is your second answer choice? ");
			choice2 = s.next();
			System.out.println("What is your third answer choice? ");
			choice3 = s.next();
		}
		
		
		questions.add(new Question(question, isFillInBlank, answer, choice1, choice2, choice3));
		
	}

}
