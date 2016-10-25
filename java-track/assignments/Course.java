import java.util.ArrayList;

public class Course {
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private String name;
	private ArrayList<Student> roster;//Student[] roster;
	private int seats;
	private int credits;

	
	
	public Course(String name, int credits, int seats){
		this.name = name;
		this.seats = seats;
		this.roster = new ArrayList<Student>(seats);//Student[seats]
		this.credits = credits;
		Course.courses.add(this);

	}
	
	public static ArrayList<Course> getAllCourses(){
		return Course.courses;
		
	}

			
	public String getName(){
		return this.name;
	}
	
	public int getSeats(){
		return this.seats;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public ArrayList<Student> getRoster(){ //Student[] 
		return this.roster;
	}
		
	public int getRemainingSeats(){
			return this.seats - roster.size();			
	}

	public boolean addStudent(Student one){
		if (this.seats == roster.size() || roster.contains(one)){
			return false;
		}
		else{
			roster.add(new Student(one.getFirstName(), one.getLastName(), one.getStudentID(), one.getCredits(), one.getGPA() ));
			return true;
		}
	}

	public String[] generateRoster(){
		String[] Roster = new String[this.roster.size()];
		for(int i = 0; i < this.roster.size(); i++){
			//System.out.println((i+1) + ".)" + this.roster.get(i).toString());
			Roster[i] = this.roster.get(i).toString();
		}
		return Roster;	
	}

	public double averageGPA(){
		double gpaTotal = 0;
		for (int x = 0; x < this.roster.size(); x++){
			gpaTotal += this.roster.get(x).getGPA();
		}
		//System.out.println(Math.round((gpaTotal / this.roster.size())*1000.00)/1000.00);
		return (Math.round((gpaTotal / this.roster.size())*1000.00)/1000.00);//gpaTotal / this.roster.size();
	}

	public String toString(){
		return this.getName() + " " + this.getCredits() + " " + this.getSeats();
	}

}


	

