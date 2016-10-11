
public class MultipleChoice extends Question{
	private String choice1;
	private String choice2;
	private String choice3;
	
	

	public MultipleChoice(String question, String answer, String choice1, String choice2, String choice3) {
		super(question, answer);
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		// TODO Auto-generated constructor stub
	}
	
	public String[] getChoices(){
		String[] choices = {this.choice1, this.choice2, this.choice3};
		return  choices;
	}
	
	public String ToString(){
		return "Question: " + this.question + " Answer: " + this.answer + " Choice1: " + this.choice1 + " Choice2: " + this.choice2 + " Choice3: " + this.choice3;
	}	
	
	public String toString(){
		return "Question: " + this.question + " Answer: " + this.answer + " Choice1: " + this.choice1 + " Choice2: " + this.choice2 + " Choice3: " + this.choice3;
	}

}
