
public class Student {
	//Name (first and last)
	//Student ID
	//Credits
	//GPA
	
	private String firstName;
	private String lastName;
	private int StudentID;
	private int credits;
	private double GPA;
	
	public Student(String firstName,String lastName, int StudentID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.StudentID = StudentID;
		this.credits = 0;
		this.GPA = 0.0;
	}
	
	public Student(String firstName,String lastName, int StudentID, int credits, double GPA){
		this.firstName = firstName;
		this.lastName = lastName;
		this.StudentID = StudentID;
		this.credits = credits;
		this.GPA = GPA;
	}

	public Student(Student one,Student two){
		this.firstName = one.getName();
		this.lastName = two.getName();
		this.StudentID = one.StudentID + two.StudentID;
		this.credits = Math.max(one.getCredits(), two.getCredits());
		this.GPA = (double)((one.GPA + two.GPA)/2);
	}
			
	public String getName(){
		return this.firstName + " " + this.lastName;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public int getStudentID(){
		return this.StudentID;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public double getGPA(){
		return this.GPA;
	}
		
	public String getClassStanding(){
		if (this.credits < 30){
			return "Freshman";
		}
		else if (this.credits >= 30 && this.credits < 60){
			return "Sophomore";
		}
		else if (this.credits >= 60 && this.credits < 90){
			return "Junior";
		}
		else{
			return "Senior";
		}
	}
	
	public void submitGrade(double grade, int credit){
		if (grade < 0 || grade > 4){
			return;
		}
		int curCred = this.credits + credit;
		double curQscore = this.GPA * this.credits;
		this.GPA = Math.round(((curQscore + (grade*credit))/ (curCred))*1000.00 )/1000.00;
		this.credits += credit;
		
	}
	
	public double computeTuition(){
		double yearTuition = 20000.00;
		int semesters = (int)(this.credits/15.0);
		if ((semesters * 15) < this.credits){
			semesters++;
		}
		return (double)(semesters*yearTuition);
	}
	
	public Student createLegacy(Student one){
		return new Student(one, this);
		
	}
	
	public String toString(){
		return this.getName() + " " + this.getStudentID();
	}
}
