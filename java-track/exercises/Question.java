
public class Question {
	

	public String question;
	public String answer;
	
	public Question(String question, String answer){
		this.question = question;
		this.answer = answer;
	}
	
	
	public String getAnswer(){
		return this.answer;
	}
	
	public String getQuestion(){
		return this.question;
	}
	
	public boolean checkAnswer(String answer){
		if (answer == this.getAnswer()){
			return true;
		}
		else{
			return false;
		}
	}
	

	
	public String ToString(){
		return "Question: " + this.question + " Answer: " + this.answer;
	}	
	
	public String toString(){
		return "Question: " + this.question + " Answer: " + this.answer;
	}	
}
