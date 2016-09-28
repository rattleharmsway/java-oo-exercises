import java.util.ArrayList;
import java.util.Scanner;


public class RobotMenu {

	private ArrayList<Robot> robots;
	private Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
		
	}
	
	public RobotMenu(){
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int startMenu(){
		System.out.println("Welcome to the Robot Menu!");
		System.out.println("1. Create a NEW ROBOT");
		System.out.println("2. Display a list of existing robots");
		System.out.println("3. MOVE a robot");
		System.out.println("4. ROTATE a robot");
		System.out.println("5. Compute the DISTANCE BETWEEN two robots");
		System.out.println("6. EXIT");
		System.out.println("Please select an option: ");
		int selection = s.nextInt();
		while(selection < 0 || selection > 6 || selection != (int)selection){
			System.out.println("Invalid selection, Try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection){
		if(selection == 1){
			createRobot();
		}
		else if(selection == 2){
			displayRobots();
		}
		else if(selection == 3){//move a robot
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Please enter the distance to move(this is affected by your robot's speed): ");
			int move = s.nextInt();
			while(move < 1 || move != (int)move){
				System.out.println("Invalid Response: ");
				move = s.nextInt();
			}
			r.move(move);
			System.out.println("Here are the new coordinates of the robot:");
			System.out.println("X: " + r.getX() + " , Y: " + r.getY());
		}
		else if(selection == 4){//rotate a robot
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Please enter the direction to rotate 90 degrees(r or l): ");
			String rotate = s.next();
			while(!(rotate.contains("r")) && !(rotate.contains("l"))){
				System.out.println("Invalid Response: ");
				rotate = s.next();
			}
			r.rotate(rotate);
			System.out.println("Here is the new direction of the robot:");
			System.out.println(r.getOrientation() + " Degrees");
		}
		else if (selection == 5){ //distance between robots
			displayRobots();
			Robot r1 = selectRobot();
			displayRobots();
			Robot r2 = selectRobot();
			System.out.println("The distance between " + r1.getName() + " & " + r2.getName() + " is: " + r1.Distance(r2));		
		}
	}
	
	private void displayRobots(){
		for(int i = 0; i < robots.size(); i++){
			System.out.println((i+1) + ".)" + robots.get(i).ToString());
		}
	}
	
	private Robot selectRobot(){
		System.out.println("Select a robot: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > robots.size() || selection != (int)selection){
			System.out.println("Invalid Selection: ");
			selection = s.nextInt();
		}
		return robots.get(selection-1);
	}
	
	private void createRobot(){
		//name, speed, orientation, x, y
		System.out.println("What is your robot's name? ");
		String name = s.next();
		System.out.println("What is your robot's Speed? ");
		int speed = s.nextInt();
		while(speed < 1){
			System.out.println("Invalid Response");
			speed = s.nextInt();
		}
		
		System.out.println("What is your robot's orientation? ");
		int orientation = s.nextInt();
		while(orientation != 90 && orientation != 180 && orientation != 270 && orientation != 360){
			System.out.println("Invalid Response");
			orientation = s.nextInt();
		}
		
		System.out.println("What is your robot's X cord? ");
		int x = s.nextInt();
		while(x < 1){
			System.out.println("Invalid Response");
			x = s.nextInt();
		}
		
		System.out.println("What is your robot's Y cord? ");
		int y = s.nextInt();
		while(y < 1){
			System.out.println("Invalid Response");
			y = s.nextInt();
		}
		
		robots.add(new Robot(name, speed, orientation, x, y));	
	}

}
