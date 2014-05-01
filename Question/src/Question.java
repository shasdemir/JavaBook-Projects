// Represents a question and its answer.

public class Question implements Complexity {
	private String question, answer;
	private int complexityLevel;
	
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
		complexityLevel = 1;
	}
	
	
	public void setComplexity(int complexity) {
		complexityLevel = complexity;		
	}

	
	public int getCompexity() {
		return complexityLevel;
	}

	
	public String getQuestion() {
		return question;
	}
	
	
	public String getAnswer() {
		return answer;
	}
	
	
	public boolean isAnswerCorrect(String candidateAnswer) {
		return answer.equals(candidateAnswer);
	}
	
	
	public String toString() {
		return question + "\n" + answer;
	}
}
